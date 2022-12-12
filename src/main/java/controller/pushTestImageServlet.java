
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

import dao.impl.galleryDaoimpl;

import model.galleryBean;


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
		
	
		
		galleryDaoimpl tDao = new galleryDaoimpl();
		galleryBean test = new galleryBean();
		test.setImageNumber(request.getParameter("answer"));
		Part imgPart = request.getPart("image");
		Blob imgBlob = test.partToBlob(imgPart);
		test.setTestImg(imgBlob);
		tDao.saveImage(test);
//		String s = request.getParameter("answer");
//		 totalBean simg = tDao.showImg(s);
		
		request.setAttribute("test", test);
		RequestDispatcher rd = request.getRequestDispatcher("/test/TestSuccess.jsp");
		rd.forward(request, response);
		return;
	}
}
