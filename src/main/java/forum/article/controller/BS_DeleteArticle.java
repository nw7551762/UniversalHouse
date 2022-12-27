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

@WebServlet("/deleteArticle_BS")
public class BS_DeleteArticle extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String articleId = request.getParameter("articleId");
		ArticleService articleService = new ArticleService();

		Article article = articleService.findByArticleId(Integer.parseInt(articleId));
		articleService.deleteByArticleId(article.getArticleId());

		RequestDispatcher rd = request.getRequestDispatcher("/backSide");
		rd.forward(request, response);
		return;

	}

}
