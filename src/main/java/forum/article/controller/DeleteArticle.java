package forum.article.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import forum.model.Article;
import forum.service.ArticleService;
import forum.service.MessageService;

@WebServlet("/deleteArticle")
public class DeleteArticle extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String articleId = request.getParameter("articleId");
		if(articleId==null) {
			System.out.println("DeleteArticle 的id為空值");
		}
		
		ArticleService articleService = new ArticleService();
		MessageService messageService = new MessageService();

		Article article = articleService.findByArticleId(Integer.parseInt(articleId));
		messageService.deleteByArticleId(article.getArticleId());
		articleService.deleteByArticleId(article.getArticleId());

		RequestDispatcher rd = request.getRequestDispatcher("forum/article/deleteSuccessfully.jsp");
		rd.forward(request, response);
		return;

	}

}
