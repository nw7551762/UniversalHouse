package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.impl.testDaoimpl;
import model.TestBean;

@MultipartConfig
@WebServlet("/ModifyTestServlet")
public class ModifyTestServlet extends HttpServlet {
	private static final long serialVersionUID =1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
	private void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		request.setCharacterEncoding("UTF-8");
		
		testDaoimpl testDao = new testDaoimpl();
		String field = request.getParameter("field");
		 List<TestBean> testBeans =  testDao.checkFieldTest2(field);
		request.setAttribute("testBeans", testBeans);
		RequestDispatcher rd = request.getRequestDispatcher("/test/ModifyTest.jsp");
		rd.forward(request, response);
		return;
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
//		try {
//			 
//			 String examinationQuestion = request.getParameter("eq");
//			 String answer = request.getParameter("as");
//			 String field = request.getParameter("fd");
//			 String options = request.getParameter("os");
//			 String options2 = request.getParameter("os2");
//				System.out.println(options2);
//			 String options3 = request.getParameter("os3");
//			 String options4 = request.getParameter("os4");
//			 String testId = request.getParameter("id");
//				System.out.println(testId);
//			 testDaoimpl.modify(examinationQuestion, answer, field, options, options2, options3, options4, testId);
//			 List<TestBean> testBeans =  testDaoimpl.checkFieldTest(testId);
//			 request.setAttribute("testBeans", testBeans);
//				RequestDispatcher rd = request.getRequestDispatcher("/test/ModifyTestSuccess.jsp");
//				rd.forward(request, response);
//				return;
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
	}
}
