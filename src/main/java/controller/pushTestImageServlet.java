package controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.sql.rowset.serial.SerialException;

import java.sql.Blob;
import java.sql.SQLException;

import dao.impl.testDaoimpl;
import model.TestBean;

@MultipartConfig
@WebServlet("/PushTestImage/PushTestImage.do")
public class pushTestImageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

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
		
		testDaoimpl tDao = new testDaoimpl();
		TestBean test = new TestBean();
		test.setAnswer(request.getParameter("answer"));
		test.setQuestionBank(request.getParameter("questionbank"));
		Part imgPart = request.getPart("image");
		System.out.println(imgPart);
		Blob imgBlob = test.partToBlob(imgPart);
		test.setTestImage(imgBlob);
		tDao.saveImage(test);
		
		RequestDispatcher rd = request.getRequestDispatcher("/test/TestSuccess.jsp");
		rd.forward(request, response);
	}
}
