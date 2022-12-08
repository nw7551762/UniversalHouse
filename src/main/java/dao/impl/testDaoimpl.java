package dao.impl;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.Part;
import javax.sql.DataSource;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;




import model.TestBean;


public class testDaoimpl implements dao.testService {

	DataSource ds = null;

	public testDaoimpl() {
		try {
			Context context = new InitialContext();
			ds = (DataSource) context.lookup("java:comp/env/jdbc/MemberDB");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

//	Connection con = ds.getConnection(); 
//	PreparedStatement preState = con.prepareStatement(sql);

	// 更新 重新整理資料
	@Override
	public void deletetestCenter() throws SQLException {
		String sql = "delete from testCenter;";
		Connection con = ds.getConnection();
		PreparedStatement preState = con.prepareStatement(sql);
		int row = preState.executeUpdate();
		System.out.println("重整表格修改:" + row + "筆資料");
		preState.close();

	}

	// 帶入CSV新增資料
	@Override
	public void addIOConnent(List<TestBean> list) throws SQLException {
		String sql = "insert into testCenter values (?,?,?,?,?,?,?,?,?,?)";
//		deletetestCenter();
		Connection con = ds.getConnection();
		PreparedStatement preState = con.prepareStatement(sql);
		for (TestBean test : list) {
//				preState.setInt(1, test.getTestPK());
			preState.setString(1, test.getTestId());
			preState.setString(2, test.getExaminationQuestion());
			preState.setString(3, test.getAnswer());
			preState.setString(4, test.getQuestionBank());
			preState.setString(5, test.getField());
			preState.setString(6, test.getOptions());
			preState.setString(7, test.getOptions2());
			preState.setString(8, test.getOptions3());
			preState.setString(9, test.getOptions4());
			preState.setString(10, test.getFraction());

			int row = preState.executeUpdate();
			System.out.println("新增了 " + row + " 筆");
		}
		preState.close();
	}

// IO讀取資料

	@Override
	public List<TestBean> IOConnent(Part part) throws SQLException {

		try (
//			FileInputStream fis = new FileInputStream(part);
				InputStream in = part.getInputStream();
				InputStreamReader isr = new InputStreamReader(in, "utf-8");
				BufferedReader br = new BufferedReader(isr)) {
//		讀CSV
//		String strng;
//		  while ((strng = br.readLine()) != null)
//		    System.out.println(strng);
//		  } catch (IOException e) {
//			
//			e.printStackTrace();
//		}
			CSVFormat.Builder builder = CSVFormat.Builder.create();
			builder.setHeader("testId", "examinationQuestion", "answer", "questionBank", "field", "options", "options2",
					"options3", "options4", "fraction");
			builder.setSkipHeaderRecord(true);
			Iterable<CSVRecord> records = builder.build().parse(br);
			List<TestBean> m = new ArrayList<>();

			for (CSVRecord record : records) {
				TestBean mem = new TestBean();
//			mem.setTestPK(Integer.valueOf(record.get(1).replace(",", "")));
				mem.setTestId(record.get(0).replace(",", ""));
				mem.setExaminationQuestion(record.get(1).replace(",", ""));
				mem.setAnswer(record.get(2).replace(",", ""));
				mem.setQuestionBank(record.get(3).replace(",", ""));
				mem.setField(record.get(4).replace(",", ""));
				mem.setOptions(record.get(5).replace(",", ""));
				mem.setOptions2(record.get(6).replace(",", ""));
				mem.setOptions3(record.get(7).replace(",", ""));
				mem.setOptions4(record.get(8).replace(",", ""));
				mem.setFraction(record.get(9).replace(",", ""));
				m.add(mem);
			}
			return m;
		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	// ShowAll查詢透過field
	@Override
	public List<TestBean> checkFieldTest(String field) {
		TestBean tb = new TestBean();
		String sql = "SELECT * FROM testCenter WHERE field = ?";
		try (Connection con = ds.getConnection(); PreparedStatement preState = con.prepareStatement(sql)) {
			preState.setString(1, field);
			ResultSet rs = preState.executeQuery();
			List<TestBean> t = new ArrayList<>();
			if (rs != null) {
				while (rs.next()) {
					tb = new TestBean();
					tb.setExaminationQuestion(rs.getString("examinationQuestion"));
					tb.setOptions(rs.getString("options"));
					tb.setOptions2(rs.getString("options2"));
					tb.setOptions3(rs.getString("options3"));
					tb.setOptions4(rs.getString("options4"));
					tb.setField(rs.getString("field"));
					t.add(tb);
				}

			}
			return t;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("TestDaoImpl_Jdbc類別#queryTest()發生例外: " + e.getMessage());
		}

	}
	// 修改
	@Override
	public void modify(String examinationQuestion,String answer,String field,String options,String options2,String options3,String options4,String testId) throws SQLException {
		TestBean testBean = new TestBean();
		String sql = "update testCenter set examinationQuestion = ?, answer = ?, field = ?, options = ?, options2 = ?, options3 = ?, options4 = ? Where testId = ?";
		Connection con = ds.getConnection(); 
		PreparedStatement preState = con.prepareStatement(sql);
//		ResultSet rs = preState.executeQuery();
		preState.setString(1, examinationQuestion);
		preState.setString(2, answer);
		preState.setString(3, field);
		preState.setString(4, options);
		preState.setString(5, options2);
		System.out.println(options2);
		preState.setString(6, options3);
		preState.setString(7, options4);
		preState.setString(8, testId);
		preState.executeUpdate();
		System.out.println("修改完成");
		preState.close();
//		public void updateAddressById(Integer id, String address) throws SQLException {
//			String sql = "update stock set 住址 = ? where 公司代號 = ?";
//			PreparedStatement preState = conn.prepareStatement(sql);
//			preState.setInt(2, id);
//			preState.setString(1, address);
//			preState.executeUpdate();
//			System.out.println("修改完成");
//			preState.close();
//		}
	}
	
	//判斷呼叫的題庫是否跟ShowTestServlet一樣
	public void testEq() {
		
	}
}
