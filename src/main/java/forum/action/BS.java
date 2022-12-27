package forum.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import forum.model.Article;
import forum.service.ArticleService;

@WebServlet("/backSide")
public class BS extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ArticleService articleService = new ArticleService();
		List<Article> articleList = articleService.findAll();
		request.setAttribute("articleList", articleList);
		RequestDispatcher rd = request.getRequestDispatcher("/forum/backSide/frontPage.jsp");
		rd.forward(request, response);
		return;
	}

}
