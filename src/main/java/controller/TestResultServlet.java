package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import dao.impl.testDaoimpl;

@MultipartConfig
@WebServlet("/TestResultServlet")
public class TestResultServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  

	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
	private void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		request.setCharacterEncoding("UTF-8");
		
//		testDaoimpl testDao = new testDaoimpl();
//		ArrayList<Object> testResult = new ArrayList<>();
//		String questionCounts = request.getParameter("questionCounts");
//		questionCounts
		try {
//			testDaoimpl testDao = new testDaoimpl();
//			testDao.checkFieldTest(getServletInfo())
			
			
			for (int i = 1; i < 100; i++) {
				String s = Integer.toString(i);
				String inputRadio = request.getParameter(s);
			System.out.println(inputRadio);	
			
			}
		
//			request.setAttribute("testBeans", testBeans);
//			RequestDispatcher rd = request.getRequestDispatcher("/test/ModifyTestSuccess.jsp");
//			rd.forward(request, response);
//			return;
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
	}

}
