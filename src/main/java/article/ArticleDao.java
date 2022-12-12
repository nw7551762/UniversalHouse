package article;

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

import regist.MemberBean;

public class ArticleDao {

	private DataSource ds = null;

	public ArticleDao() {
		try {
			Context context = new InitialContext();
			ds = (DataSource) context.lookup("java:comp/env/jdbc/MemberDB");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	public ArticleBean save(ArticleBean articleBean) {
		String sql1 = "INSERT INTO Forum (authorId, postTime, topicName, title, content,img) values (?, ?, ?, ?, ?, ?)";
		String sql2 = "SELECT articleId FROM Forum WHERE title = ?";
		try (Connection conn = ds.getConnection();
				PreparedStatement ps1 = conn.prepareStatement(sql1);
				PreparedStatement ps2 = conn.prepareStatement(sql2);) {

			ps1.setInt(1, articleBean.getAuthorId());
			ps1.setTimestamp(2, articleBean.getPostTime());
			ps1.setString(3, articleBean.getTopicName());
			ps1.setString(4, articleBean.getTitle());
			ps1.setString(5, articleBean.getContent());
			ps1.setBlob(6, articleBean.getImg());
			ps1.executeUpdate();

			ps2.setString(1, articleBean.getTitle());
			ResultSet rs = ps2.executeQuery();

			if (rs.next()) {
				articleBean.setArticleId(rs.getInt(1));
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("MemberDao類別#saveMember()發生例外: " + e.getMessage());
		}
		return articleBean;
	}

	public ArticleBean findById(Integer articleId) {
		ArticleBean mb = null;

		String sql = "SELECT * FROM Forum WHERE articleId = ?";
		try (Connection conn = ds.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {

			ps.setInt(1, articleId);
			try (ResultSet rs = ps.executeQuery()) {

				if (rs.next()) {
					mb = new ArticleBean(rs.getInt(1), rs.getInt(2), rs.getTimestamp(3), rs.getString(4),
							rs.getString(5), rs.getString(6), rs.getBlob(7));
				}
			}

		} catch (Exception ex) {
			ex.printStackTrace();
			throw new RuntimeException("findById" + ex.getMessage());
		}
		return mb;
	}

	public void deleteById(Integer articleId) {
		String sql = "DELETE FROM Forum WHERE articleId = ?";
		try (Connection conn = ds.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {

			ps.setInt(1, articleId);
			ps.executeUpdate();

		} catch (Exception ex) {
			ex.printStackTrace();
			throw new RuntimeException("deleteById" + ex.getMessage());
		}
	}

	public void updateById(ArticleBean articleBean) {
		String sql = " UPDATE Forum SET " + " postTime= ?," + " topicName = ?," + " title = ?," + " content = ?,"
				+ " img = ? " + " WHERE articleId= ?";

		try (Connection conn = ds.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setTimestamp(1, articleBean.getPostTime());
			ps.setString(2, articleBean.getTopicName());
			ps.setString(3, articleBean.getTitle());
			ps.setString(4, articleBean.getContent());
			ps.setBlob(5, articleBean.getImg());
			ps.setInt(6, articleBean.getArticleId());
			ps.executeUpdate();

		} catch (Exception ex) {
			ex.printStackTrace();
			throw new RuntimeException("updateById" + ex.getMessage());
		}
	}

	public List<ArticleBean> findByAuthor(Integer authorId) {

		List<ArticleBean> list = new ArrayList<ArticleBean>();
		ArticleService ms = new ArticleService();
		String sql = "SELECT articleId FROM Forum WHERE authorId = ? ORDER BY postTime DESC";
		try (Connection con = ds.getConnection(); PreparedStatement ps = con.prepareStatement(sql);) {
			ps.setInt(1, authorId);
			try (ResultSet rs = ps.executeQuery();) {
				while (rs.next()) {
					int articleId = rs.getInt(1);
					list.add(ms.findById(articleId));
				}
			}
		} catch (SQLException ex) {
			throw new RuntimeException("findByAuthor" + ex.getMessage());
		}
		return list;
	}

	public List<ArticleBean> findAll() {
		ArticleBean mb = null;
		List<ArticleBean> articleList = new ArrayList<>();
		String sql = "SELECT * FROM Forum";
		try (Connection conn = ds.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {

			try (ResultSet rs = ps.executeQuery()) {

				while (rs.next()) {
					mb = new ArticleBean(rs.getInt(1), rs.getInt(2), rs.getTimestamp(3), rs.getString(4),
							rs.getString(5), rs.getString(6), rs.getBlob(7));
					articleList.add(mb);
				}
			}

		} catch (Exception ex) {
			ex.printStackTrace();
			throw new RuntimeException("findAll" + ex.getMessage());
		}
		return articleList;
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
			throw new RuntimeException("findBeanByMemberId發生SQL例外: " + ex.getMessage());
		}
		return memberBean;
	}

	public MemberBean findBeanByName(String name) {
		MemberBean MemberBean = new MemberBean();
		String sql = "SELECT * FROM Member WHERE name = ?";
		try (Connection connection = ds.getConnection(); PreparedStatement ps = connection.prepareStatement(sql);) {
			ps.setString(1, name);
			try (ResultSet rs = ps.executeQuery();) {
				if (rs.next()) {
					MemberBean = new MemberBean();
					MemberBean.setMemberPK(rs.getInt("memberPK"));
					MemberBean.setMemberId(rs.getString("memberId"));
					MemberBean.setMemberImage(rs.getBlob("MemberImage"));
				}
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
			throw new RuntimeException("findBeanByName發生例外: " + ex.getMessage());
		}
		return MemberBean;
	}

	public List<ArticleBean> fuzzyQueryBeanByName(String name) {
		List<ArticleBean> articleList=null;
		String sql = "SELECT memberPK FROM Member WHERE name LIKE ?";
		try (Connection connection = ds.getConnection(); PreparedStatement ps = connection.prepareStatement(sql);) {
			ps.setString(1, "%"+name+"%");
			try (ResultSet rs = ps.executeQuery();) {
				while (rs.next()) {
					int memberPK=rs.getInt(1);
					ArticleService articleService=new ArticleService();
					articleList=articleService.findByAuthor(memberPK);
				}
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
			throw new RuntimeException("fuzzyQueryBeanByName發生例外: " + ex.getMessage());
		}
		return articleList;
	}
	
	public MemberBean findMemberBeanByAuthorId(Integer authorId) {
		String sql = "SELECT * FROM Member WHERE memberPk=?";
		MemberBean memberBean=new MemberBean();
		try (Connection connection = ds.getConnection(); PreparedStatement ps = connection.prepareStatement(sql);) {
			ps.setInt(1,authorId);
			try (ResultSet rs = ps.executeQuery();) {			
				if (rs.next()) {
					memberBean.setMemberPK(rs.getInt(1));
					memberBean.setMemberId(rs.getString(2));
					memberBean.setName(rs.getString(3));
					memberBean.setMemberImage(rs.getBlob(10));
				}
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
			throw new RuntimeException("fuzzyQueryBeanByName發生例外: " + ex.getMessage());
		}
		return memberBean;
	}
	
	public boolean isExistBytitle(String title) {
		String sql = "SELECT * FROM Forum WHERE title=?";
		try (Connection connection = ds.getConnection(); PreparedStatement ps = connection.prepareStatement(sql);) {
			ps.setString(1,title);
			try (ResultSet rs = ps.executeQuery()) {			
				if(rs!=null) {
					return false;
				}
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
			throw new RuntimeException("isExistBytitle發生例外: " + ex.getMessage());
		}
		return true;
	}
}
