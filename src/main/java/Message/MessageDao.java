package Message;

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

	public MessageBean saveMessage(MessageBean mb) {
		String sql_Insert = "INSERT INTO Message (articleId,authorId,postTime,content) values (? , ? , ? , ?)";
		String sql_Select = "SELECT TOP 1 * FROM Message ORDER BY MessageId DESC";
		try (Connection conn = ds.getConnection();
			 PreparedStatement psI = conn.prepareStatement(sql_Insert);
			 PreparedStatement psS = conn.prepareStatement(sql_Select);) {
			
			psI.setInt(1, mb.getArticleId());
			psI.setInt(2, mb.getAuthorId());
			psI.setTimestamp(3, mb.getPostTime());
			psI.setString(4, mb.getContent());

			psI.executeUpdate();

			ResultSet rsS = psS.executeQuery();
			if (rsS.next()) {
				mb.setMessageId(rsS.getInt(2));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("save發生例外: " + e.getMessage());
		}
		return mb;
	}

	public List<MessageBean> findMessageByArticleId(Integer articleId) {
		MessageBean mb = null;
		List<MessageBean> list=new ArrayList<>();
		String sql = "SELECT * FROM Message WHERE articleId = ?";
		try (Connection conn = ds.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {

			ps.setInt(1, articleId);
			try (ResultSet rs = ps.executeQuery()) {

				while (rs.next()) {
					mb = new MessageBean(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getTimestamp(4), rs.getString(5));
					list.add(mb);
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
	
}