package controller;

import java.io.IOException;
import java.util.ArrayList;
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
@WebServlet("/ModifyTestEndServlet")
public class ModifyTestEndServlet extends HttpServlet {
	private static final long serialVersionUID =1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
	private void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		request.setCharacterEncoding("UTF-8");
		String testId = request.getParameter("testIds");

		
		testDaoimpl testDao = new testDaoimpl();
		
		

		TestBean test = testDao.findByTestId(testId);
		
		test.setExaminationQuestion(request.getParameter("examinationQuestion"));
		test.setField(request.getParameter("field"));
		test.setOptions(request.getParameter("options"));
		test.setOptions2(request.getParameter("options2"));
		test.setOptions3(request.getParameter("options3"));
		test.setOptions4(request.getParameter("options4"));
		
		
		System.out.println(test);
		
		request.setAttribute("test", test);
		RequestDispatcher rd = request.getRequestDispatcher("/test/ModifyTestData.jsp");
		rd.forward(request, response);
		return;
//
//		test.setExaminationQuestion(request.getParameter("eq"));
//		test.setField(request.getParameter("fd"));
//		test.setOptions(request.getParameter("os"));
//		test.setOptions2(request.getParameter("os2"));
//		test.setOptions3(request.getParameter("os3"));
//		test.setOptions4(request.getParameter("os4"));
//		
//		testDao.modifyAllByTestId(test);
	}
}
