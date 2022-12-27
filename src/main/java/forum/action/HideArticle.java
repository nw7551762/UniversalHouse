package forum.action;

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

@WebServlet("/hideArticle")
public class HideArticle extends HttpServlet {
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
		article.setStatus("deleted");
		articleService.updateById(article);

		RequestDispatcher rd = request.getRequestDispatcher("forum/article/deleteSuccessfully.jsp");
		rd.forward(request, response);
		return;

	}

}
