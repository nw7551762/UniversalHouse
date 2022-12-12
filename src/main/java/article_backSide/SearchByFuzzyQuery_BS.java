package article_backSide;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import article.*;

@WebServlet("/searchByFuzzyQuery_BS")
public class SearchByFuzzyQuery_BS extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SearchByFuzzyQuery_BS() {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String name = (String) request.getAttribute("Name");
		if (name == null) {
			name = request.getParameter("Name");
		}
		
		ArticleService articleService = new ArticleService();
		articleService.fuzzyQueryBeanByName(name);

		List<ArticleBean> articleList = articleService.fuzzyQueryBeanByName(name);
		if(articleList==null) {
			RequestDispatcher rd = request.getRequestDispatcher("/Forum/BackSide/null.jsp");
			rd.forward(request, response);
		}
		request.setAttribute("articleList", articleList);

		RequestDispatcher rd = request.getRequestDispatcher("/Forum/BackSide/showList.jsp");
		rd.forward(request, response);
		return;

	}

}
