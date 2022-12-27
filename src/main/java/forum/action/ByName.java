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
import member.model.Member;

@WebServlet("/searchByName")
public class ByName extends HttpServlet {
	private static final long serialVersionUID = 1L;

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
		Member member = articleService.findMemberByName(name);

		if (member == null) {
			RequestDispatcher rd = request.getRequestDispatcher("/Forum/Article/null.jsp");
			rd.forward(request, response);
		}

		if (member.getMemberId() != null) {
			List<Article> articleList = articleService.findAllByMemberId(member.getMemberId());
			request.setAttribute("articleList", articleList);
		}
		RequestDispatcher rd = request.getRequestDispatcher("/Forum/BackSide/showList.jsp");
		rd.forward(request, response);
		return;

	}

}
