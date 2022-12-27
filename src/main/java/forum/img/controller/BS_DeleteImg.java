package forum.img.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import forum.service.ImgService;
import forum.service.MessageService;



@WebServlet("/deleteImg_BS")
public class BS_DeleteImg extends HttpServlet {
	private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String articleId=request.getParameter("articleId");
		String imgNo=request.getParameter("imgNo");
		
		ImgService imgService=new ImgService();
		imgService.deleteByAImgNo(Integer.parseInt(imgNo));
		request.setAttribute("articleId", articleId);
		RequestDispatcher rd = request.getRequestDispatcher("/imgDB_BS");
		rd.forward(request, response);
		return;
		
	}

}
