package jia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
	public void saveEvaluation(EvaluationBean bean) {
		String sql = "INSERT INTO evaluation (pj_ID, member_ID, ev_DealPrice, ev_CompletionDate, ev_ClientEV, ev_CLientComment) VALUES (?, ?, ?, ?, ?, ?)";

		try (Connection connection = ds.getConnection();
				PreparedStatement preState = connection.prepareStatement(sql);) {
			preState.setInt(1, bean.getPjID());
			preState.setInt(2, bean.getMemberID());
			preState.setInt(3, bean.getEvDealPrice());
			preState.setDate(4, bean.getEvCompletionDate());
			preState.setInt(5, bean.getEvClientEV());
			preState.setString(6, bean.getEvClientComment());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public int updateProject(EvaluationBean bean) {
		int n = 0;
		String sql = "UPDATE evaluation SET ev_DealPrice=?, ev_CompletionDate=?, ev_ClientEV=?, ev_CLientComment=? WHERE pj_ID=? AND member_ID=?";

		try (Connection connection = ds.getConnection();
				PreparedStatement preState = connection.prepareStatement(sql);) {
			preState.setInt(1, bean.getEvDealPrice());
			preState.setDate(2, bean.getEvCompletionDate());
			preState.setInt(3, bean.getEvClientEV());
			preState.setString(4, bean.getEvClientComment());
			preState.setInt(5, bean.getPjID());
			preState.setInt(6, bean.getMemberID());
			n = preState.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n;
	}

	@Override
	public EvaluationBean findByID(int projectID, int memberID) {
		EvaluationBean bean = null;
		String sql = "SELECT * FROM evaluation WHERE pj_ID = ? AND member_ID = ?";
		try(Connection connection = ds.getConnection();
			PreparedStatement preState = connection.prepareStatement(sql);){
			preState.setInt(1, projectID);
			preState.setInt(2, memberID);
			try(ResultSet rs = preState.executeQuery();){
				if(rs.next()) {
					bean = new EvaluationBean();
					bean.setPjID(rs.getInt("pj_ID"));
					bean.setMemberID(rs.getInt("member_ID"));
					bean.setEvDealPrice(rs.getInt("ev_DealPrice"));
					bean.setEvCompletionDate(rs.getDate("ev_CompletionDate"));
					bean.setEvClientEV(rs.getInt("ev_ClientEV"));
					bean.setEvClientComment(rs.getString("ev_CLientComment"));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bean;
	}

}
