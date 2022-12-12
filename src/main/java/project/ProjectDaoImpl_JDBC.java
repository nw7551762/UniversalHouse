package project;

import java.lang.invoke.StringConcatFactory;
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
		String sql = "INSERT INTO project (pj_Class,fieldName,pj_Name,memberID,pj_Instruction,pj_ServerLocation,pj_Price,pj_ExCompletionDate,pj_ExecutionTime,pj_UploadDate,pj_LastUpdate,pj_Status) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";

		try (Connection connection = ds.getConnection();
				PreparedStatement preState = connection.prepareStatement(sql);) {
			preState.setString(1, bean.getPjClass());
			preState.setString(2, bean.getFieldName());
			preState.setString(3, bean.getPjName());
			preState.setString(4, bean.getMemberID());
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
		String sql = "UPDATE project SET fieldName=?, pj_Name=?, pj_Instruction=?, pj_ServerLocation=?, pj_Price=?, pj_ExCompletionDate=?, pj_ExecutionTime=?, pj_LastUpdate=?, pj_Status=? WHERE pj_ID = ?";

		try (Connection connection = ds.getConnection();
				PreparedStatement preState = connection.prepareStatement(sql);) {
			preState.setString(1, bean.getFieldName());
			preState.setString(2, bean.getPjName());
			preState.setString(3, bean.getPjInstruction());
			preState.setString(4, bean.getPjServerLocation());
			preState.setInt(5, bean.getPjPrice());
			preState.setTimestamp(6, (Timestamp) bean.getPjExCompletionDate());
			preState.setString(7, bean.getPjExecutionTime());
			preState.setTimestamp(8, (Timestamp) bean.getPjLastUpdate());
			preState.setString(9, bean.getPjStatus());
			preState.setInt(10, bean.getPjID());
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
	public List<ProjectBean> findByID(String sql) {
		ProjectBean bean = null;
		List<ProjectBean> projectList = new ArrayList<>();

		try (Connection connection = ds.getConnection(); PreparedStatement ps = connection.prepareStatement(sql);) {
			try (ResultSet rs = ps.executeQuery();) {
				while (rs.next()) {
					bean = new ProjectBean();
					bean.setPjID(rs.getInt("pj_ID"));
					bean.setPjClass(rs.getString("pj_Class"));
					bean.setFieldName(rs.getString("fieldName"));
					bean.setPjName(rs.getString("pj_Name"));
					bean.setMemberID(rs.getString("memberID"));
					bean.setPjInstruction(rs.getString("pj_Instruction"));
					bean.setPjServerLocation(rs.getString("pj_ServerLocation"));
					bean.setPjPrice(rs.getInt("pj_Price"));
					if ((rs.getTimestamp("pj_ExCompletionDate")) != null) {
						bean.setPjExCompletionDate(rs.getTimestamp("pj_ExCompletionDate"));
					}
					bean.setPjExecutionTime(rs.getString("pj_ExecutionTime"));
					if ((rs.getTimestamp("pj_UploadDate")) != null) {
						bean.setPjUploadDate(rs.getTimestamp("pj_UploadDate"));
					}
					if ((rs.getTimestamp("pj_LastUpdate")) != null) {
						bean.setPjLastUpdate(rs.getTimestamp("pj_LastUpdate"));
					}
					bean.setPjStatus(rs.getString("pj_Status"));
					projectList.add(bean);
				}
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return projectList;
	}

	@Override
	public ProjectBean findBypjID(Integer projectID) {
		ProjectBean bean = null;
		String sql = "SELECT * FROM project WHERE pj_ID =?";

		try (Connection connection = ds.getConnection(); PreparedStatement ps = connection.prepareStatement(sql);) {
			ps.setInt(1, projectID);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				bean = new ProjectBean();
				bean.setPjID(rs.getInt("pj_ID"));
				bean.setPjClass(rs.getString("pj_Class"));
				bean.setFieldName(rs.getString("fieldName"));
				bean.setPjName(rs.getString("pj_Name"));
				bean.setMemberID(rs.getString("memberID"));
				bean.setPjInstruction(rs.getString("pj_Instruction"));
				bean.setPjServerLocation(rs.getString("pj_ServerLocation"));
				bean.setPjPrice(rs.getInt("pj_Price"));
				if ((rs.getTimestamp("pj_ExCompletionDate")) != null) {
					bean.setPjExCompletionDate(rs.getTimestamp("pj_ExCompletionDate"));
				}
				bean.setPjExecutionTime(rs.getString("pj_ExecutionTime"));
				if ((rs.getTimestamp("pj_UploadDate")) != null) {
					bean.setPjUploadDate(rs.getTimestamp("pj_UploadDate"));
				}
				if ((rs.getTimestamp("pj_LastUpdate")) != null) {
					bean.setPjLastUpdate(rs.getTimestamp("pj_LastUpdate"));
				}
				bean.setPjStatus(rs.getString("pj_Status"));
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return bean;
	}

	@Override
	public List<ProjectBean> findByClass(String pjClass) {
		ProjectBean bean = null;
		String sql = "SELECT * FROM project WHERE pj_Class=?";
		List<ProjectBean> pjList = new ArrayList<>();
		try (Connection connection = ds.getConnection(); PreparedStatement ps = connection.prepareStatement(sql);) {
			ps.setString(1, pjClass);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				bean = new ProjectBean();
				bean.setPjID(rs.getInt("pj_ID"));
				bean.setPjClass(rs.getString("pj_Class"));
				bean.setFieldName(rs.getString("fieldName"));
				bean.setPjName(rs.getString("pj_Name"));
				bean.setMemberID(rs.getString("memberID"));
				bean.setPjInstruction(rs.getString("pj_Instruction"));
				bean.setPjServerLocation(rs.getString("pj_ServerLocation"));
				bean.setPjPrice(rs.getInt("pj_Price"));
				if ((rs.getTimestamp("pj_ExCompletionDate")) != null) {
					bean.setPjExCompletionDate(rs.getTimestamp("pj_ExCompletionDate"));
				}
				bean.setPjExecutionTime(rs.getString("pj_ExecutionTime"));
				if ((rs.getTimestamp("pj_UploadDate")) != null) {
					bean.setPjUploadDate(rs.getTimestamp("pj_UploadDate"));
				}
				if ((rs.getTimestamp("pj_LastUpdate")) != null) {
					bean.setPjLastUpdate(rs.getTimestamp("pj_LastUpdate"));
				}
				bean.setPjStatus(rs.getString("pj_Status"));
				pjList.add(bean);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pjList;
	}

	@Override
	public List<ProjectBean> findAllProject(String sql) {
		ProjectBean bean = null;
		List<ProjectBean> allProject = new ArrayList<>();

		try (Connection connection = ds.getConnection(); PreparedStatement ps = connection.prepareStatement(sql);) {
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				bean = new ProjectBean();
				bean.setPjID(rs.getInt("pj_ID"));
				bean.setPjClass(rs.getString("pj_Class"));
				bean.setFieldName(rs.getString("fieldName"));
				bean.setPjName(rs.getString("pj_Name"));
				bean.setMemberID(rs.getString("memberID"));
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
