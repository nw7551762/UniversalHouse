package evaluation;

import java.sql.Connection;
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

public class EvaluationDaoImpl_JDBC implements EvaluationDao {
	DataSource ds = null;

	public EvaluationDaoImpl_JDBC() {
		try {
			Context context = new InitialContext();
			ds = (DataSource) context.lookup("java:comp/env/jdbc/MemberDB");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void saveEvaluation(int pjID, String mbID, String pjMbID, int pjPrice) {
		String sql = "INSERT INTO evaluation (pj_ID, memberID, pj_MemberID, ev_DealPrice) VALUES (?, ?, ?, ?)";

		try (Connection connection = ds.getConnection();
				PreparedStatement preState = connection.prepareStatement(sql);) {
			preState.setInt(1, pjID);
			preState.setString(2, mbID);
			preState.setString(3, pjMbID);
			preState.setInt(4, pjPrice);
			preState.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public int completeProject(EvaluationBean bean) {
		int n = 0;
		String sql = "UPDATE evaluation SET ev_CompletionDate = ? WHERE ev_ID = ?";

		try (Connection connection = ds.getConnection();
				PreparedStatement preState = connection.prepareStatement(sql);) {
			preState.setTimestamp(1, (Timestamp) bean.getEvCompletionDate());
			preState.setInt(2, bean.getEvID());
			n = preState.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n;
	}

	@Override
	public int updateProject(EvaluationBean bean) {
		int n = 0;
		String sql = "UPDATE evaluation SET ev_ClientEV=?, ev_CLientComment=? WHERE ev_ID = ? ";

		try (Connection connection = ds.getConnection();
				PreparedStatement preState = connection.prepareStatement(sql);) {
			preState.setInt(1, bean.getEvClientEV());
			preState.setString(2, bean.getEvClientComment());
			preState.setInt(3, bean.getEvID());
			n = preState.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n;
	}

	@Override
	public EvaluationBean findByID(int evID) {
		EvaluationBean bean = null;
		String sql = "SELECT * FROM evaluation WHERE ev_ID = ?";
		try (Connection connection = ds.getConnection();
				PreparedStatement preState = connection.prepareStatement(sql);) {
			preState.setInt(1, evID);
			try (ResultSet rs = preState.executeQuery();) {
				if (rs.next()) {
					bean = new EvaluationBean();
					bean.setEvID(rs.getInt("ev_ID"));
					bean.setPjID(rs.getInt("pj_ID"));
					bean.setMemberID(rs.getString("memberID"));
					bean.setPjMemberID(rs.getString("pj_memberID"));
					bean.setEvDealPrice(rs.getInt("ev_DealPrice"));
					if ((rs.getDate("ev_CompletionDate")) != null) {
						bean.setEvCompletionDate(rs.getDate("ev_CompletionDate"));
					}
					bean.setEvClientEV(rs.getInt("ev_ClientEV"));
					bean.setEvClientComment(rs.getString("ev_CLientComment"));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bean;
	}

	@Override
	public EvaluationBean findByMember(int projectID, String memberID) {
		EvaluationBean bean = null;
		String sql = "SELECT * FROM evaluation WHERE pj_ID = ? AND memberID = ?";
		try (Connection connection = ds.getConnection();
				PreparedStatement preState = connection.prepareStatement(sql);) {
			preState.setInt(1, projectID);
			preState.setString(2, memberID);
			try (ResultSet rs = preState.executeQuery();) {
				if (rs.next()) {
					bean = new EvaluationBean();
					bean.setEvID(rs.getInt("ev_ID"));
					bean.setPjID(rs.getInt("pj_ID"));
					bean.setMemberID(rs.getString("memberID"));
					bean.setPjMemberID(rs.getString("pj_memberID"));
					bean.setEvDealPrice(rs.getInt("ev_DealPrice"));
					if ((rs.getDate("ev_CompletionDate")) != null) {
						bean.setEvCompletionDate(rs.getDate("ev_CompletionDate"));
					}
					bean.setEvClientEV(rs.getInt("ev_ClientEV"));
					bean.setEvClientComment(rs.getString("ev_CLientComment"));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bean;
	}

	@Override
	public EvaluationBean findByPJMember(int projectID, String pjMemberID) {
		EvaluationBean bean = null;
		String sql = "SELECT * FROM evaluation WHERE pj_ID = ? AND pj_memberID = ?";
		try (Connection connection = ds.getConnection();
				PreparedStatement preState = connection.prepareStatement(sql);) {
			preState.setInt(1, projectID);
			preState.setString(2, pjMemberID);
			try (ResultSet rs = preState.executeQuery();) {
				if (rs.next()) {
					bean = new EvaluationBean();
					bean.setEvID(rs.getInt("ev_ID"));
					bean.setPjID(rs.getInt("pj_ID"));
					bean.setMemberID(rs.getString("memberID"));
					bean.setPjMemberID(rs.getString("pj_memberID"));
					bean.setEvDealPrice(rs.getInt("ev_DealPrice"));
					if ((rs.getDate("ev_CompletionDate")) != null) {
						bean.setEvCompletionDate(rs.getDate("ev_CompletionDate"));
					}
					bean.setEvClientEV(rs.getInt("ev_ClientEV"));
					bean.setEvClientComment(rs.getString("ev_CLientComment"));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bean;
	}

	@Override
	public List<EvaluationBean> findByMember(String memberID) {
		EvaluationBean bean = null;
		List<EvaluationBean> evlist = new ArrayList<>();
		String sql = "SELECT * FROM evaluation WHERE memberID = ?";
		try (Connection connection = ds.getConnection();
				PreparedStatement preState = connection.prepareStatement(sql);) {
			preState.setString(1, memberID);
			try (ResultSet rs = preState.executeQuery();) {
				if (rs.next()) {
					bean = new EvaluationBean();
					bean.setEvID(rs.getInt("ev_ID"));
					bean.setPjID(rs.getInt("pj_ID"));
					bean.setMemberID(rs.getString("memberID"));
					bean.setPjMemberID(rs.getString("pj_memberID"));
					bean.setEvDealPrice(rs.getInt("ev_DealPrice"));
					if ((rs.getDate("ev_CompletionDate")) != null) {
						bean.setEvCompletionDate(rs.getDate("ev_CompletionDate"));
					}
					bean.setEvClientEV(rs.getInt("ev_ClientEV"));
					bean.setEvClientComment(rs.getString("ev_CLientComment"));
					evlist.add(bean);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return evlist;
	}

	@Override
	public List<EvaluationBean> findByPJMember(String pjMemberID) {
		EvaluationBean bean = null;
		List<EvaluationBean> evlist = new ArrayList<>();
		String sql = "SELECT * FROM evaluation WHERE pj_memberID = ?";
		try (Connection connection = ds.getConnection();
				PreparedStatement preState = connection.prepareStatement(sql);) {
			preState.setString(1, pjMemberID);
			try (ResultSet rs = preState.executeQuery();) {
				if (rs.next()) {
					bean = new EvaluationBean();
					bean.setEvID(rs.getInt("ev_ID"));
					bean.setPjID(rs.getInt("pj_ID"));
					bean.setMemberID(rs.getString("memberID"));
					bean.setPjMemberID(rs.getString("pj_memberID"));
					bean.setEvDealPrice(rs.getInt("ev_DealPrice"));
					if ((rs.getDate("ev_CompletionDate")) != null) {
						bean.setEvCompletionDate(rs.getDate("ev_CompletionDate"));
					}
					bean.setEvClientEV(rs.getInt("ev_ClientEV"));
					bean.setEvClientComment(rs.getString("ev_CLientComment"));
					evlist.add(bean);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return evlist;
	}

}
