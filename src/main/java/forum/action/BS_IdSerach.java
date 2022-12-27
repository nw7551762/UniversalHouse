package forum.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import forum.model.Article;
import forum.service.ArticleService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/idSerach_BS")
public class BS_IdSerach extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String check = (String) request.getAttribute("articleId");
		if (check == null) {
			check = request.getParameter("articleId");
		}

		for (int i = check.length() - 1; i >= 0; --i) {
			int chr = check.charAt(i);
			if (chr < 48 || chr > 57) {
				RequestDispatcher rd = request.getRequestDispatcher("/forum/backSide/null.jsp");
				rd.forward(request, response);
				return;
			}

		}

		int articleId = Integer.parseInt(check);

		ArticleService articleService = new ArticleService();
		Article article = articleService.findByArticleId(articleId);
		if (article == null) {
			RequestDispatcher rd = request.getRequestDispatcher("/forum/backSide/null.jsp");
			rd.forward(request, response);
			return;
		}

		List<Article> articles = new ArrayList<Article>();
		articles.add(article);
		request.setAttribute("articleList", articles);

		RequestDispatcher rd = request.getRequestDispatcher("/forum/backSide/frontPage.jsp");
		rd.forward(request, response);
		return;
	}
}