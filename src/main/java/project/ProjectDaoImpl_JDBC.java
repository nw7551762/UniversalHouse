package project;

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

public class ProjectDaoImpl_JDBC implements ProjectDao {
	DataSource ds = null;

	public ProjectDaoImpl_JDBC() {
		try {
			Context context = new InitialContext();
			ds = (DataSource) context.lookup("java:comp/env/jdbc/MemberDB");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	// 新增案件
	@Override
	public void saveProject(ProjectBean bean) {
		String sql = "INSERT INTO project (pj_Class,fieldName,pj_Name,memberPK,pj_Instruction,pj_ServerLocation,pj_Price,pj_ExCompletionDate,pj_UploadDate,pj_LastUpdate,pj_Status) VALUES (?,?,?,?,?,?,?,?,?,?,?)";

		try (Connection connection = ds.getConnection();
				PreparedStatement preState = connection.prepareStatement(sql);) {
			preState.setString(1, bean.getPjClass());
			preState.setString(2, bean.getFieldName());
			preState.setString(3, bean.getPjName());
			preState.setInt(4, bean.getMemberPK());
			preState.setString(5, bean.getPjInstruction());
			preState.setString(6, bean.getPjServerLocation());
			preState.setInt(7, bean.getPjPrice());
			preState.setDate(8, bean.getPjExCompletionDate());
			preState.setDate(9, bean.getPjUploadDate());
			preState.setDate(10, bean.getPjLastUpdate());
			preState.setString(11, bean.getPjStatus());
			preState.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteByID(int projectID) {
		String sql = "DELETE FROM project WHERE pj_ID = ?";
		try (Connection connection = ds.getConnection();
				PreparedStatement preState = connection.prepareStatement(sql);) {
			preState.setInt(1, projectID);
			preState.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public int updateProject(ProjectBean bean) {
		int n = 0;
		String sql = "UPDATE project SET pj_Class=?, fieldName=?, pj_Name=?, memberPK=?, pj_Instruction=?, pj_ServerLocation=?, pj_Price=?, pj_ExCompletionDate=?, pj_UploadDate=?, pj_LastUpdate=?, pj_Status=? WHERE pj_ID = ?";

		try (Connection connection = ds.getConnection();
				PreparedStatement preState = connection.prepareStatement(sql);) {
			preState.setString(1, bean.getPjClass());
			preState.setString(2, bean.getFieldName());
			preState.setString(3, bean.getPjName());
			preState.setInt(4, bean.getMemberPK());
			preState.setString(5, bean.getPjInstruction());
			preState.setString(6, bean.getPjServerLocation());
			preState.setInt(7, bean.getPjPrice());
			preState.setDate(8, bean.getPjExCompletionDate());
			preState.setDate(9, bean.getPjUploadDate());
			preState.setDate(10, bean.getPjLastUpdate());
			preState.setString(11, bean.getPjStatus());
			preState.setInt(12, bean.getPjID());
			n = preState.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n;
	}

	@Override
	public void updateProject(ProjectBean bean, long sizeImgType) {

	}

	@Override
	public List<ProjectBean> findByID(int memberPk) {
		ProjectBean bean = null;
		String sql = "SELECT * FROM project WHERE memberPK =?";
		List<ProjectBean> allMyProject = new ArrayList<>();

		try (Connection connection = ds.getConnection(); PreparedStatement ps = connection.prepareStatement(sql);) {
			ps.setInt(1, memberPk);
			try (ResultSet rs = ps.executeQuery();) {
				while (rs.next()) {
					bean = new ProjectBean();
					bean.setPjID(rs.getInt("pj_ID"));
					bean.setPjClass(rs.getString("pj_Class"));
					bean.setFieldName(rs.getString("fieldName"));
					bean.setPjName(rs.getString("pj_Name"));
					bean.setMemberPK(rs.getInt("memberPK"));
					bean.setPjInstruction(rs.getString("pj_Instruction"));
					bean.setPjServerLocation(rs.getString("pj_ServerLocation"));
					bean.setPjPrice(rs.getInt("pj_Price"));
					bean.setPjExCompletionDate(rs.getDate("pj_ExCompletionDate"));
					bean.setPjUploadDate(rs.getDate("pj_UploadDate"));
					bean.setPjLastUpdate(rs.getDate("pj_LastUpdate"));
					bean.setPjStatus(rs.getString("pj_Status"));
					allMyProject.add(bean);
				}
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return allMyProject;
	}

	@Override
	public List<ProjectBean> findAllProject() {
		ProjectBean bean = null;
		String sql = "SELECT * FROM project";
		List<ProjectBean> allProject = new ArrayList<>();

		try (Connection connection = ds.getConnection(); PreparedStatement ps = connection.prepareStatement(sql);) {
			try (ResultSet rs = ps.executeQuery();) {
				while (rs.next()) {
					bean = new ProjectBean();
					bean.setPjID(rs.getInt("pj_ID"));
					bean.setPjClass(rs.getString("pj_Class"));
					bean.setFieldName(rs.getString("fieldName"));
					bean.setPjName(rs.getString("pj_Name"));
					bean.setMemberPK(rs.getInt("memberPK"));
					bean.setPjInstruction(rs.getString("pj_Instruction"));
					bean.setPjServerLocation(rs.getString("pj_ServerLocation"));
					bean.setPjPrice(rs.getInt("pj_Price"));
					bean.setPjExCompletionDate(rs.getDate("pj_ExCompletionDate"));
					bean.setPjUploadDate(rs.getDate("pj_UploadDate"));
					bean.setPjLastUpdate(rs.getDate("pj_LastUpdate"));
					bean.setPjStatus(rs.getString("pj_Status"));
					allProject.add(bean);
				}
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return allProject;
	}

	
}
