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

@WebServlet("/DeleteAllServlet")
public class DeleteAllServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			processRequest(request, response);
		} catch (IOException | ServletException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			processRequest(request, response);
		} catch (IOException | ServletException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException, SQLException {
		request.setCharacterEncoding("UTF-8");
		testDaoimpl td = new testDaoimpl();

		String field = request.getParameter("field");

		td.deletetestCenter(field);
		List<TestBean> testBeans = td.checkFieldTest(field);
		request.setAttribute("testBeans", testBeans);
		RequestDispatcher rd = request.getRequestDispatcher("/test/showDeleteSuccess.jsp");
		rd.forward(request, response);
		return;

	}

}
