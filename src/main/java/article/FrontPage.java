package article;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/FrontPage")
public class FrontPage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public FrontPage() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ArticleService articleService = new ArticleService();
		List<ArticleBean> articleList = articleService.findAll();
		request.setAttribute("articleList", articleList);
		RequestDispatcher rd = request.getRequestDispatcher("/Forum/frontPage.jsp");
		rd.forward(request, response);
		return;
	}

}
