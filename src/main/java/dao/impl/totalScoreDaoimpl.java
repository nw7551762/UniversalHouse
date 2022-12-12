package dao.impl;

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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import model.TestBean;
import model.totalBean;

public class totalScoreDaoimpl {
	DataSource ds = null;
	private static Logger log = LoggerFactory.getLogger(totalScoreDaoimpl.class);

	public totalScoreDaoimpl() {
		try {
			Context context = new InitialContext();
			ds = (DataSource) context.lookup("java:comp/env/jdbc/MemberDB");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	// 將分數加進db

//	public void addSumTest(List<totalBean> list) throws SQLException {
//		String sql = "  insert into totalScore (memberId, fraction) values (?,?) ";
//		Connection con = ds.getConnection();
//		PreparedStatement preState = con.prepareStatement(sql);
//		
//		for (totalBean total : list) {
//				preState.setString(1, total.getMemberId());
//		preState.setString(2, total.getFraction());
//		preState.executeUpdate();
//
//		}
//	
//		preState.close();
//	}

	public totalBean addSumTest(String mb, String s) throws SQLException {
		String sql = "  insert into totalScore (memberId, fraction) values (?,?) ";
		Connection con = ds.getConnection();
		PreparedStatement preState = con.prepareStatement(sql);
		totalBean td = new totalBean();
		System.out.println(mb);
		System.out.println(s);
		preState.setString(1, mb);
		preState.setString(2, s);
		preState.executeUpdate();

		preState.close();
		return td;
	}

	// 新增圖片
	public void saveImage(totalBean tb) {
		log.info("新增測驗圖片結果");
		String sql = "insert into totalScore " + "(imageNumber, testImage) " + "values ( ?, ?)";
		try (Connection con = ds.getConnection(); PreparedStatement ps = con.prepareStatement(sql);) {

			ps.setString(1, tb.getImageNumber());
			ps.setBlob(2, tb.getTestImg());
			ps.executeUpdate();
			log.info("saveImage(), 新增成功:ImageBean:" + tb);

		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Class: MemberDaoc#save()發生例外: " + e.getMessage());
		}
	}

	// 全部的分數
//	public List<totalBean> showSumTest() {
//		String sql = "select * FROM totalScore ";
//		try (Connection con = ds.getConnection(); PreparedStatement preState = con.prepareStatement(sql);) {
//			ResultSet rs = preState.executeQuery();
//			List<totalBean> t = new ArrayList<>();
//
//			while (rs.next()) {
//				totalBean td = new totalBean();
//
//				td.setMemberId(rs.getString("memberId"));
//				String id = td.getMemberId();
//				td.setFraction(rs.getString("fraction"));
//				if (id != null) {
//					t.add(td);
//				}
//			}
//			return t;
//
//		} catch (SQLException e) {
//			e.printStackTrace();
//			throw new RuntimeException("TestDaoImpl_Jdbc類別#queryTest()發生例外: " + e.getMessage());
//		}
//	}
	
	public List<totalBean> showSumTest() {
		String sql = "select * FROM totalScore ";
		try (Connection con = ds.getConnection(); PreparedStatement preState = con.prepareStatement(sql);) {
			ResultSet rs = preState.executeQuery();
			List<totalBean> t = new ArrayList<>();

			while (rs.next()) {
				totalBean td = new totalBean();

				td.setMemberId(rs.getString("memberId"));
				String id = td.getMemberId();
				td.setFraction(rs.getString("fraction"));
				td.setImageNumber(rs.getString("imageNumber"));
				td.setTestImg(rs.getBlob("testImage"));
					t.add(td);
				
			}
			return t;

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("TestDaoImpl_Jdbc類別#queryTest()發生例外: " + e.getMessage());
		}
	}

	// 判斷分數對應的圖片
	public void CompareScoreToImg() {
		totalBean tb = null;
		totalScoreDaoimpl dao = new totalScoreDaoimpl();
		List<totalBean> total = dao.showSumTest();
		for (totalBean totalBean : total) {
			String id = totalBean.getMemberId();
			String fraction = totalBean.getFraction();
			int fractions = Integer.parseInt(fraction);

			if (fractions < 94) {
				dao.showImg("A");
			}
		}
		// 取值
		// 判斷分數 決定幾分對應的圖片 分數對應imageNumber
		// 用imageNumber找圖片

//		tb.setTestImg(rs.getBlob("testImage"));
	}

	// 顯示圖片
	public totalBean showImg(String imageNumber) {
		log.info("顯示新增成功的圖片");
		totalBean tb = null;
		String sql = "select * FROM totalScore m WHERE m.imageNumber = ?";
		try (Connection con = ds.getConnection(); PreparedStatement preState = con.prepareStatement(sql)) {
			preState.setString(1, imageNumber);
			ResultSet rs = preState.executeQuery();

			while (rs.next()) {

				System.out.println("xzxzx");
				tb = new totalBean();
				tb.setImageNumber(rs.getString("imageNumber"));
				tb.setTestImg(rs.getBlob("testImage"));
				System.out.println("xzxzx");
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("TestDaoImpl_Jdbc類別#queryTest()發生例外: " + e.getMessage());
		}
		log.info("圖片功能之Dao: 取得圖片, tb=" + tb);
		return tb;
	}

}
