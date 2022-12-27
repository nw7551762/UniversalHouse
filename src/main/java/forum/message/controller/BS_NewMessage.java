package forum.message.controller;

import java.io.IOException;
import java.sql.Timestamp;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import forum.model.Message;
import forum.service.MessageService;

@WebServlet("/newMessage_BS")
public class BS_NewMessage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		request.setCharacterEncoding("UTF-8");

		String articleId = request.getParameter("articleId");
		String memberId = request.getParameter("memberId");
		String content = request.getParameter("content");
		String status = request.getParameter("status");

		MessageService messageService = new MessageService();
		Message message = new Message();
		Timestamp updateTime = new java.sql.Timestamp(System.currentTimeMillis());

		message.setAuthorId(memberId);
		message.setUpdateTime(updateTime);
		message.setContent(content);
		message.setStatus(status);
		message.setLike(0);
		message.setDislike(0);
		messageService.save(Integer.parseInt(articleId), message);

		request.setAttribute("articleId", articleId);
		RequestDispatcher rd = request.getRequestDispatcher("/messageDB_BS");
		rd.forward(request, response);
		return;
	}

}