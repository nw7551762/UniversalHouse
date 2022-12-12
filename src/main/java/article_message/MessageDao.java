package article_message;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import regist.*;

public class MessageDao {

	private DataSource ds = null;

	public MessageDao() {
		try {
			Context context = new InitialContext();
			ds = (DataSource) context.lookup("java:comp/env/jdbc/MemberDB");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	public MessageBean saveMessage(MessageBean messageBean) {
		String sql_Insert = "INSERT INTO Message (articleId,authorId,postTime,content) values (? , ? , ? , ?)";
		String sql_Select = "SELECT TOP 1 * FROM Message ORDER BY MessageId DESC";
		try (Connection conn = ds.getConnection();
				PreparedStatement psI = conn.prepareStatement(sql_Insert);
				PreparedStatement psS = conn.prepareStatement(sql_Select);) {

			psI.setInt(1, messageBean.getArticleId());
			psI.setInt(2, messageBean.getAuthorId());
			psI.setTimestamp(3, messageBean.getPostTime());
			psI.setString(4, messageBean.getContent());

			psI.executeUpdate();

			ResultSet rsS = psS.executeQuery();
			if (rsS.next()) {
				messageBean.setMessageId(rsS.getInt(2));
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("save發生例外: " + e.getMessage());
		}
		return messageBean;
	}

	public List<MessageBean> findMessageByArticleId(Integer articleId) {
		MessageBean messageBean = null;
		MessageService messageService=new MessageService();
		List<MessageBean> list = new ArrayList<>();
		String sql = "SELECT * FROM Message WHERE articleId = ?";
		try (Connection conn = ds.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {

			ps.setInt(1, articleId);
			try (ResultSet rs = ps.executeQuery()) {

				while (rs.next()) {
					messageBean = new MessageBean(rs.getInt(1), rs.getInt(2), rs.getInt(3), null, rs.getTimestamp(4),
							rs.getString(5));
					
					MemberBean memberBean=messageService.findBeanByAuthorId(messageBean.getAuthorId());
					messageBean.setAuthorName(memberBean.getName());
					list.add(messageBean);
				}
			}

		} catch (Exception ex) {
			ex.printStackTrace();
			throw new RuntimeException(" " + ex.getMessage());
		}
		return list;
	}

	public void deleteMessageById(Integer articleId) {
		String sql = "DELETE FROM Message WHERE articleId = ?";
		try (Connection conn = ds.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {

			ps.setInt(1, articleId);
			ps.executeUpdate();

		} catch (Exception ex) {
			ex.printStackTrace();
			throw new RuntimeException(" " + ex.getMessage());
		}
	}

	public MemberBean findBeanByMemberId(String memberId) {
		MemberBean memberBean = new MemberBean();
		String sql = "SELECT * FROM Member WHERE memberId = ?";
		try (Connection con = ds.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setString(1, memberId);
			try (ResultSet rs = ps.executeQuery()) {
				if (rs.next()) {
					memberBean.setMemberPK(rs.getInt(1));
					memberBean.setMemberId(rs.getString(2));
					memberBean.setName(rs.getString(3));
					memberBean.setMemberImage(rs.getBlob(10));
				}
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
			throw new RuntimeException("MemberDaoImpl_Jdbc類別#findByMemberIdAndPassword()發生SQL例外: " + ex.getMessage());
		}
		return memberBean;
	}

	public MemberBean findBeanByAuthorId(int authorId) {
		MemberBean MemberBean = new MemberBean();
		String sql = "SELECT * FROM Member WHERE memberPK = ?";
		try (Connection connection = ds.getConnection(); PreparedStatement ps = connection.prepareStatement(sql);) {
			ps.setInt(1, authorId);
			try (ResultSet rs = ps.executeQuery();) {
				if (rs.next()) {
					MemberBean = new MemberBean();
					MemberBean.setMemberPK(rs.getInt("memberPK"));
					MemberBean.setMemberId(rs.getString("memberId"));
					MemberBean.setName(rs.getString("name"));
					MemberBean.setMemberImage(rs.getBlob("MemberImage"));
				}
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
			throw new RuntimeException("MemberDaoImpl_Jdbc類別#queryMember()發生例外: " + ex.getMessage());
		}
		return MemberBean;
	}
	
	public void deleteByMessageId(Integer messageId) {
		String sql = "DELETE FROM Message WHERE messageId = ?";
		try (Connection conn = ds.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {

			ps.setInt(1, messageId);
			ps.executeUpdate();

		} catch (Exception ex) {
			ex.printStackTrace();
			throw new RuntimeException(" " + ex.getMessage());
		}
	}
}