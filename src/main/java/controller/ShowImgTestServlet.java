package controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.impl.galleryDaoimpl;
import dao.impl.totalScoreDaoimpl;

import java.sql.Blob;
import java.sql.SQLException;

import model.galleryBean;


//@WebServlet("/TestSuccess.do")
@WebServlet("/ShowImgTestServlet")
public class ShowImgTestServlet extends HttpServlet {
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
//		totalScoreDaoimpl dao = new totalScoreDaoimpl();
//		totalBean total = dao.showImg("A");
//
//		request.setAttribute("total", total);
//		RequestDispatcher rd = request.getRequestDispatcher("/test/TestSuccess.jsp");
//		rd.forward(request, response);
//		return;
		
		galleryDaoimpl dao = new galleryDaoimpl();
		//找照片的Number
	
		String imgNumber = request.getParameter("imageNumber");
	
		galleryBean total = dao.showImg(imgNumber);
	
		Blob blob = total.getTestImg();
	
		try (
				InputStream is =  blob.getBinaryStream();
			OutputStream os = response.getOutputStream();
				) {
			byte[] bytes = new byte[8126];
			int len = 0;
			
			while((len=is.read(bytes)) != -1) {
				os.write(bytes, 0, len);
				os.flush();
			}
			System.out.println(666666);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
