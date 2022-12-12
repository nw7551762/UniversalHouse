//package model;
//
//import java.io.BufferedReader;
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.InputStreamReader;
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.util.ArrayList;
//import java.util.List;
//
//import javax.naming.Context;
//import javax.naming.InitialContext;
//import javax.naming.NamingException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.Part;
//import javax.sql.DataSource;
//
//import org.apache.commons.csv.CSVFormat;
//import org.apache.commons.csv.CSVRecord;
//
//public class TestDao {
//
//	
//
//	DataSource ds = null;
//
//	public TestDao() {
//		try {
//			Context context = new InitialContext();
//			ds = (DataSource) context.lookup("java:comp/env/jdbc/MemberDB");
//		} catch (NamingException e) {
//			e.printStackTrace();
//		}
//	}
//
//	// 更新 重新整理資料
//	public void deletetestCenter() throws SQLException {
//		String sql = "delete from testCenter;";
//		Connection con = ds.getConnection(); 
//		PreparedStatement preState = con.prepareStatement(sql);
//		int row = preState.executeUpdate();
//		System.out.println("重整表格修改:" + row + "筆資料");
//		preState.close();
//
//	}
//
//	// 帶入CSV新增資料
//	public void addIOConnent(List<TestBean> list) throws SQLException {
//		String sql = "insert into testCenter values (?,?,?,?,?,?,?,?,?,?)";
//		deletetestCenter();
//		Connection con = ds.getConnection(); 
//		PreparedStatement preState = con.prepareStatement(sql);
//		for (TestBean test : list) {
////			preState.setInt(1, test.getTestPK());
//			preState.setString(1, test.getTestId());
//			preState.setString(2, test.getExaminationQuestion());
//			preState.setString(3, test.getAnswer());
//			preState.setString(4, test.getQuestionBank());
//			preState.setString(5, test.getField());
//			preState.setString(6, test.getOptions());
//			preState.setString(7, test.getOptions2());
//			preState.setString(8, test.getOptions3());
//			preState.setString(9, test.getOptions4());
//			preState.setString(10, test.getFraction());
//
//			int row = preState.executeUpdate();
//			System.out.println("新增了 " + row + " 筆");
//		}
//		preState.close();
//	}
//
//	// IO讀取資料
//
//	public List<TestBean> IOConnent(Part part) throws SQLException {
//
//		try (
////				FileInputStream fis = new FileInputStream(part);
//				InputStream in = part.getInputStream();
//				InputStreamReader isr = new InputStreamReader(in, "utf-8");
//				BufferedReader br = new BufferedReader(isr)) {
////			讀CSV
////			String strng;
////			  while ((strng = br.readLine()) != null)
////			    System.out.println(strng);
////			  } catch (IOException e) {
////				
////				e.printStackTrace();
////			}
//			
//			CSVFormat.Builder builder = CSVFormat.Builder.create();
//			builder.setHeader("testId", "examinationQuestion", "answer", "questionBank", "field", "options", "options2",
//					"options3", "options4", "fraction");
//			builder.setSkipHeaderRecord(true);
//			Iterable<CSVRecord> records = builder.build().parse(br);
//			List<TestBean> m = new ArrayList<>();
//			
//			for (CSVRecord record : records) {
//				TestBean mem = new TestBean();
////				mem.setTestPK(Integer.valueOf(record.get(1).replace(",", "")));
//				mem.setTestId(record.get(0).replace(",", ""));
//				mem.setExaminationQuestion(record.get(1).replace(",", ""));
//				mem.setAnswer(record.get(2).replace(",", ""));
//				mem.setQuestionBank(record.get(3).replace(",", ""));
//				mem.setField(record.get(4).replace(",", ""));
//				mem.setOptions(record.get(5).replace(",", ""));
//				mem.setOptions2(record.get(6).replace(",", ""));
//				mem.setOptions3(record.get(7).replace(",", ""));
//				mem.setOptions4(record.get(8).replace(",", ""));
//				mem.setFraction(record.get(9).replace(",", ""));
//				m.add(mem);
//			}
//			return m;
//		} catch (FileNotFoundException e) {
//			throw new RuntimeException(e);
//		} catch (IOException e) {
//			throw new RuntimeException(e);
//		}
//	}
//
//	private static final String SELECT_BY_ID = "SELECT * FROM testCenter";
//
//	public TestBean findByMemberNo(int no) {
//		TestBean member = new TestBean();
//		try (Connection conn = ds.getConnection(); PreparedStatement stmt = conn.prepareStatement(SELECT_BY_ID);
//
//		) {
//			try (ResultSet rset = stmt.executeQuery();) {
//				if (rset.next()) {
//
//					member.setTestId((rset.getString(1)));
//					member.setExaminationQuestion((rset.getString(2)));
//					member.setAnswer((rset.getString(3)));
//					member.setQuestionBank((rset.getString(4)));
//					member.setField((rset.getString(5)));
//					member.setOptions((rset.getString(6)));
//					member.setFraction((rset.getString(7)));
//
//				}
//
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return member;
//	}
//
//}
