package article_message;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import article_message.MessageService;

@WebServlet("/deleteMessage")
public class DeleteMessage extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public DeleteMessage() {}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String articleId=request.getParameter("articleId");
		String messageId=request.getParameter("messageId");
		MessageService messageService = new MessageService();

		messageService.deleteByMessageId(Integer.parseInt(messageId));
		String url="/showArticle_BS?articleId="+articleId;
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
		return;
		
	}

}
