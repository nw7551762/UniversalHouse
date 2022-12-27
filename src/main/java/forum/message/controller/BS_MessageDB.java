package forum.message.controller;

import java.io.IOException;
import java.util.List;

import forum.model.Article;
import forum.model.Message;
import forum.service.ArticleService;
import forum.service.MessageService;
import member.model.Member;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/messageDB_BS")
public class BS_MessageDB extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Integer articleId;
		if (request.getParameter("articleId") != null) {
			String a = request.getParameter("articleId");
			articleId = Integer.parseInt(a);
		} else {
			articleId = (Integer) request.getAttribute("articleId");
		}

		MessageService messageService = new MessageService();
		ArticleService articleService=new ArticleService();
		Article article=articleService.findByArticleId(articleId);
		List<Message> messages = messageService.findAllByArticleId(articleId);
		request.setAttribute("messages", messages);
		request.setAttribute("article", article);
		

		RequestDispatcher rd = request.getRequestDispatcher("/forum/backSide/messageDB.jsp");
		rd.forward(request, response);
		return;
	}
}