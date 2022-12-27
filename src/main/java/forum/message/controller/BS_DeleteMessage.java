package forum.message.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import forum.service.MessageService;

@WebServlet("/deleteMessage_BS")
public class BS_DeleteMessage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.doGet(req, resp);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String articleId = request.getParameter("articleId");
		String messageId = request.getParameter("messageId");

		MessageService messageService = new MessageService();
		messageService.deleteByMessageId(Integer.parseInt(messageId));
		
		request.setAttribute("articleId", articleId);
		RequestDispatcher rd = request.getRequestDispatcher("/messageDB_BS");
		rd.forward(request, response);
		return;

	}

}
