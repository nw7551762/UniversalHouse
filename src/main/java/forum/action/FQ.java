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

@WebServlet("/findhByNameFQ")
public class FQ extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public FQ() {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String name = (String) request.getAttribute("name");
		if (name == null) {
			name = request.getParameter("name");
		}
		
		ArticleService articleService = new ArticleService();

		List<Article> articleList = articleService.findByName_FQ(name);
		if(articleList==null) {
			RequestDispatcher rd = request.getRequestDispatcher("/forum/article/null.jsp");
			rd.forward(request, response);
		}
		request.setAttribute("articleList", articleList);

		RequestDispatcher rd = request.getRequestDispatcher("/forum/article/showList.jsp");
		rd.forward(request, response);
		return;

	}

}
