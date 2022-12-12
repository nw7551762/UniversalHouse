package article_backSide;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import article.ArticleBean;
import article.ArticleService;

@WebServlet("/getOldArticle_BS")
public class GetOldArticle_BS extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public GetOldArticle_BS() {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String articleId = request.getParameter("articleId");
		ArticleService articleService = new ArticleService();
		ArticleBean articleBean = articleService.findById(Integer.parseInt(articleId));
		request.setAttribute("thisBean", articleBean);

		RequestDispatcher rd = request.getRequestDispatcher("/Forum/BackSide/updateArticle_BS.jsp");
		rd.forward(request, response);
		return;
	}
}
