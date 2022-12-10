package Forum;

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

public class MemberDao {

	private DataSource ds = null;

	public MemberDao() {
		try {
			Context context = new InitialContext();
			ds = (DataSource) context.lookup("java:comp/env/jdbc/MemberDB");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	public void createTable() {
		String sql1 = " CREATE TABLE Forum("
					+ "	articleId INT PRIMARY KEY IDENTITY(100,1),"
					+ "	authorId INT,"
					+ "	postTime DATE ,"
					+ "	topicName VARCHAR(10) ,"
					+ "	title VARCHAR(50)  UNIQUE,"
					+ "	content NVARCHAR(MAX),"
					+ "	imgName VARCHAR(50),"
					+ "	img IMAGE);";

		try (Connection conn = ds.getConnection(); PreparedStatement ps1 = conn.prepareStatement(sql1);) {

			ps1.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("CREATE發生例外: " + e.getMessage());
		}
	}

	public void dropTable() {
		String sql1 = " DROP TABLE Forum";
					
		try (Connection conn = ds.getConnection();
				PreparedStatement ps1 = conn.prepareStatement(sql1);) {

			ps1.executeUpdate();
			

		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("DROP發生例外: " + e.getMessage());
		}
	}

	public MemberBean save(MemberBean mb) {
		String sql1 = "INSERT INTO Forum (authorId, postTime, topicName, title, content,imgName,img) values (?, ?, ?, ?, ?, ?, ?)";
		String sql2 = "SELECT articleId FROM Forum WHERE title = ?";
		try (Connection conn = ds.getConnection();
				PreparedStatement ps1 = conn.prepareStatement(sql1);
				PreparedStatement ps2 = conn.prepareStatement(sql2);) {

			ps1.setInt(1, mb.getAuthorId());
			ps1.setTimestamp(2, mb.getPostTime());
			ps1.setString(3, mb.getTopicName());
			ps1.setString(4, mb.getTitle());
			ps1.setString(5, mb.getContent());
			ps1.setString(6, mb.getImgName());
			ps1.setBlob(7, mb.getImg());
			ps1.executeUpdate();

			ps2.setString(1, mb.getTitle());
			ResultSet rs = ps2.executeQuery();

			if (rs.next()) {
				mb.setArticleId(rs.getInt(1));
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("MemberDao類別#saveMember()發生例外: " + e.getMessage());
		}
		return mb;
	}

	public MemberBean findById(Integer articleId) {
		MemberBean mb = null;

		String sql = "SELECT * FROM Forum WHERE articleId = ?";
		try (Connection conn = ds.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {

			ps.setInt(1, articleId);
			try (ResultSet rs = ps.executeQuery()) {
				
				if (rs.next()) {
					mb = new MemberBean(rs.getInt(1), rs.getInt(2), rs.getTimestamp(3), rs.getString(4),
							rs.getString(5), rs.getString(6), rs.getString(7), rs.getBlob(8));
				}
			}

		} catch (Exception ex) {
			ex.printStackTrace();
			throw new RuntimeException(" " + ex.getMessage());
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
			throw new RuntimeException(" " + ex.getMessage());
		}
	}

	public void updateById(MemberBean mb) {
		String sql = " UPDATE Forum " + " SET " + " postTime= ?," + " topicName = ?," + " title = ?," + " content = ?,"
				+ " imgName = ?," + " img = ? " + " WHERE articleId= ?";

		try (Connection conn = ds.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setTimestamp(1, mb.getPostTime());
			ps.setString(2, mb.getTopicName());
			ps.setString(3, mb.getTitle());
			ps.setString(4, mb.getContent());
			ps.setString(5, mb.getImgName());
			ps.setBlob(6, mb.getImg());
			ps.setInt(7, mb.getArticleId());
			ps.executeUpdate();

		} catch (Exception ex) {
			ex.printStackTrace();
			throw new RuntimeException(" " + ex.getMessage());
		}
	}

	public List<MemberBean> findByAuthor(Integer authorId) {

		List<MemberBean> list = new ArrayList<MemberBean>();
		MemberService ms = new MemberService();
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
			throw new RuntimeException(ex);
		}
		return list;
	}
	
	public List<MemberBean> findAll() {
		MemberBean mb = null;
		List<MemberBean> Memberlist=new ArrayList<>();
		String sql = "SELECT * FROM Forum";
		try (Connection conn = ds.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {

			try (ResultSet rs = ps.executeQuery()) {
				
				while (rs.next()) {
					mb = new MemberBean(rs.getInt(1), rs.getInt(2), rs.getTimestamp(3), rs.getString(4),
							rs.getString(5), rs.getString(6), rs.getString(7), rs.getBlob(8));
					Memberlist.add(mb);
				}
			}

		} catch (Exception ex) {
			ex.printStackTrace();
			throw new RuntimeException(" " + ex.getMessage());
		}
		return Memberlist;
	}
}
