package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;

import java.sql.SQLException;
import java.util.List;
import dao.impl.testDaoimpl;
import model.TestBean;

@MultipartConfig()
//@MultipartConfig
@WebServlet({ "/PushTestServlet", "/pushTest.do" })
//@WebServlet("/TestServlet/PushTestServlet")
public class PushTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
	private void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		request.setCharacterEncoding("UTF-8");

		HttpSession session = request.getSession();
//		try {
//			processRequest(request,response);
//		} catch (IOException | ServletException | SQLException e) {
//			e.printStackTrace();
//		}
		Part part = request.getPart("file");
		System.out.println("1");
		try {
			testDaoimpl testDao = new testDaoimpl();

			List<TestBean> ioConnent = testDao.IOConnent(part);
			testDao.addIOConnent(ioConnent);
			System.out.println("1");
			// 印出csv 在 console
//			List<TestBean> ioConnent = testDao.IOConnent(part);
			for (TestBean testBean : ioConnent) {
				System.out.println(testBean.toString());
			}

			request.setAttribute("testCenter", testDao);
			RequestDispatcher rd = request.getRequestDispatcher("/test/showPushTest.jsp");
			rd.forward(request, response);
			return;

		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

//	private void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, SQLException {
//		request.setCharacterEncoding("UTF-8");
//		Connection conn = ConnectionFactory.createMSSQLConnection();
//		TestDao td = new TestDao(conn);
//		TestBean testCenter = new TestBean();
//		//更新表格重新載入CSV, 刪除SQL所有內容 留下table
//		td.addIOConnent(td.IOConnent());
//		request.setAttribute("testCenter", testCenter);
//		RequestDispatcher rd = request.getRequestDispatcher("/test/showPushTest.jsp");
//		rd.forward(request, response);
//		return;
//		
//		
//	}

	}


