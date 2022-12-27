package forum.message.controller;

import java.io.IOException;
import java.sql.Timestamp;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import forum.model.Message;
import forum.service.MessageService;
@MultipartConfig(location = "", fileSizeThreshold = 5 * 1024 * 1024, maxFileSize = 1024 * 1024
* 500, maxRequestSize = 1024 * 1024 * 500 * 5)
@WebServlet("/newMessage")
public class NewMessage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String content = request.getParameter("content");
		String memberId = request.getParameter("memberId");
		String articleId = request.getParameter("articleId");

		MessageService messageService = new MessageService();

		Timestamp updateTime = new java.sql.Timestamp(System.currentTimeMillis());
		Message message=new Message();
		message.setAuthorId(memberId);
		message.setUpdateTime(updateTime);
		message.setContent(content);
		message.setStatus("public");
		message.setLike(0);
		message.setDislike(0);
		
		messageService.save(Integer.parseInt(articleId), message);
		request.setAttribute("articleId", articleId);
		RequestDispatcher rd = request.getRequestDispatcher("/showArticle");
		rd.forward(request, response);
		return;
	}

}
