package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.impl.totalScoreDaoimpl;
import model.totalBean;



@MultipartConfig()
@WebServlet("/ShowTestOverServlet.do")
public class ShowTestOverServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
	private void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		request.setCharacterEncoding("UTF-8");
		
		totalScoreDaoimpl totalDao = new totalScoreDaoimpl();
//		String imgView = request.getParameter("");
		List<totalBean> total = totalDao.showSumTest();
		
		request.setAttribute("totals", total);
		RequestDispatcher rd = request.getRequestDispatcher("/test/showTestResult.jsp");
		rd.forward(request, response);
		return;
	}
}
