package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.rowset.serial.SerialException;

import dao.impl.testDaoimpl;
import model.TestBean;

@MultipartConfig
@WebServlet("/test/TestUpdataServlet")
public class TestUpdataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			processRequest(request, response);
		} catch (IOException | ServletException | SQLException e) {
			e.printStackTrace();
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			processRequest(request, response);
		} catch (IOException | ServletException | SQLException e) {
			e.printStackTrace();
		}

	}

	private void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException, SerialException, SQLException {
		request.setCharacterEncoding("UTF-8");

		String updata = request.getParameter("test");

		testDaoimpl dao = new testDaoimpl();
		TestBean testBean = dao.findByTestId(updata);
		if (!request.getParameter("examinationQuestion").equals("")) {
			testBean.setExaminationQuestion(request.getParameter("examinationQuestion"));
		}

		testBean.setField(request.getParameter("field"));

		if (!request.getParameter("options").equals("")) {
			testBean.setOptions(request.getParameter("options"));
		}
		if (!request.getParameter("options2").equals("")) {
			testBean.setOptions2(request.getParameter("options2"));
		}
		if (!request.getParameter("options3").equals("")) {
			testBean.setOptions3(request.getParameter("options3"));
		}
		if (!request.getParameter("options4").equals("")) {
			testBean.setOptions4(request.getParameter("options4"));
		}

		dao.modifyAllByTestId(testBean);
		request.setAttribute("testBean", testBean);
		RequestDispatcher rd = request.getRequestDispatcher("/test/testUpdataDown.jsp");
		rd.forward(request, response);
		return;

	}

}
