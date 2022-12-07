package project;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
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
		String sql = "INSERT INTO project (pj_Class,fieldName,pj_Name,memberPK,pj_Instruction,pj_ServerLocation,pj_Price,pj_ExCompletionDate,pj_ExecutionTime,pj_UploadDate,pj_LastUpdate,pj_Status) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";

		try (Connection connection = ds.getConnection();
				PreparedStatement preState = connection.prepareStatement(sql);) {
			preState.setString(1, bean.getPjClass());
			preState.setString(2, bean.getFieldName());
			preState.setString(3, bean.getPjName());
			preState.setInt(4, bean.getMemberPK());
			preState.setString(5, bean.getPjInstruction());
			preState.setString(6, bean.getPjServerLocation());
			preState.setInt(7, bean.getPjPrice());
			preState.setTimestamp(8, (Timestamp) bean.getPjExCompletionDate());
			preState.setString(9, bean.getPjExecutionTime());
			preState.setTimestamp(10, (Timestamp) bean.getPjUploadDate());
			preState.setTimestamp(11, (Timestamp) bean.getPjLastUpdate());
			preState.setString(12, bean.getPjStatus());
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
		String sql = "UPDATE project SET pj_Class=?, fieldName=?, pj_Name=?, memberPK=?, pj_Instruction=?, pj_ServerLocation=?, pj_Price=?, pj_ExCompletionDate=?, pj_ExecutionTime=?, pj_UploadDate=?, pj_LastUpdate=?, pj_Status=? WHERE pj_ID = ?";

		try (Connection connection = ds.getConnection();
				PreparedStatement preState = connection.prepareStatement(sql);) {
			preState.setString(1, bean.getPjClass());
			preState.setString(2, bean.getFieldName());
			preState.setString(3, bean.getPjName());
			preState.setInt(4, bean.getMemberPK());
			preState.setString(5, bean.getPjInstruction());
			preState.setString(6, bean.getPjServerLocation());
			preState.setInt(7, bean.getPjPrice());
			preState.setTimestamp(8, (Timestamp) bean.getPjExCompletionDate());
			preState.setString(9, bean.getPjExecutionTime());
			preState.setTimestamp(10, (Timestamp) bean.getPjUploadDate());
			preState.setTimestamp(11, (Timestamp) bean.getPjLastUpdate());
			preState.setString(12, bean.getPjStatus());
			preState.setInt(13, bean.getPjID());
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
	public List<ProjectBean> findByID(Integer memberPk) {
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
					if ((rs.getTimestamp("pj_ExCompletionDate")) != null) {
						bean.setPjExCompletionDate(rs.getTimestamp("pj_ExCompletionDate"));
					}
					bean.setPjExecutionTime(rs.getString("pj_ExecutionTime"));
					bean.setPjUploadDate(rs.getTimestamp("pj_UploadDate"));
					bean.setPjLastUpdate(rs.getTimestamp("pj_LastUpdate"));
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
			ResultSet rs = ps.executeQuery();
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
				if ((rs.getTimestamp("pj_ExCompletionDate")) != null) {
					bean.setPjExCompletionDate(rs.getTimestamp("pj_ExCompletionDate"));
				}
				bean.setPjExecutionTime(rs.getString("pj_ExecutionTime"));
				bean.setPjUploadDate(rs.getTimestamp("pj_UploadDate"));
				bean.setPjLastUpdate(rs.getTimestamp("pj_LastUpdate"));
				bean.setPjStatus(rs.getString("pj_Status"));
				allProject.add(bean);

			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return allProject;
	}

}
