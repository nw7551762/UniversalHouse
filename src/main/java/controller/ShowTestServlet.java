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
@MultipartConfig()
@WebServlet("/ShowTestServlet")
public class ShowTestServlet extends HttpServlet  {

	private static final long serialVersionUID = 1L;
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

		 List<TestBean> testBeans =  testDao.checkFieldTest(field);
		request.setAttribute("testBeans", testBeans);
		RequestDispatcher rd = request.getRequestDispatcher("/test/showTestPage.jsp");
		rd.forward(request, response);
		return;
	}
}
