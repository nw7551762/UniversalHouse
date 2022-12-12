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
import javax.servlet.http.HttpSession;

import dao.impl.totalScoreDaoimpl;
import model.totalBean;
import regist.MemberBean;
import regist.MemberDao;

@MultipartConfig()
@WebServlet("/ShowTestOverServlet.do")
public class ShowTestOverServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	private void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		request.setCharacterEncoding("UTF-8");

		HttpSession session = request.getSession();

		session.getAttribute("LoginOK");

		totalScoreDaoimpl dao = new totalScoreDaoimpl();
//		String imgView = request.getParameter("");
		List<totalBean> total = dao.showSumTest();

		request.setAttribute("totals", total);
		RequestDispatcher rd = request.getRequestDispatcher("/test/showTestResult.jsp");
		rd.forward(request, response);
		return;
	}
}
