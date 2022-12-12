package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import model.galleryBean;
import model.totalBean;

public class galleryDaoimpl {
	DataSource ds = null;
	private static Logger log = LoggerFactory.getLogger(totalScoreDaoimpl.class);

public galleryDaoimpl() {
	try {
		Context context = new InitialContext();
		ds = (DataSource) context.lookup("java:comp/env/jdbc/MemberDB");
	} catch (NamingException e) {
		e.printStackTrace();
	}
}

// 新增圖片
public void saveImage(galleryBean tb) {
	log.info("新增測驗圖片結果");
	String sql = "insert into gallery " + "(imageNumber, testImage) " + "values ( ?, ?)";
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

// 顯示圖片
public galleryBean showImg(String imageNumber) {
	log.info("顯示新增成功的圖片");
	galleryBean tb = null;
	String sql = "select * FROM gallery m WHERE m.imageNumber = ?";
	try (Connection con = ds.getConnection(); PreparedStatement preState = con.prepareStatement(sql)) {
		preState.setString(1, imageNumber);
		ResultSet rs = preState.executeQuery();

		while (rs.next()) {

			
			tb = new galleryBean();
			tb.setImageNumber(rs.getString("imageNumber"));
			tb.setTestImg(rs.getBlob("testImage"));
		
		}

	} catch (SQLException e) {
		e.printStackTrace();
		throw new RuntimeException("TestDaoImpl_Jdbc類別#queryTest()發生例外: " + e.getMessage());
	}
	log.info("圖片功能之Dao: 取得圖片, tb=" + tb);
	return tb;
}




}
