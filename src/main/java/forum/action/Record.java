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

@WebServlet("/searchRecord")
public class Record extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String memberId = request.getParameter("memberId");
		ArticleService articleService = new ArticleService();
		Member member = articleService.findMemberByMemberId(memberId);

		List<Article> articles = articleService.findAllByMemberId(member.getMemberId());

		request.setAttribute("articles", articles);

		RequestDispatcher rd = request.getRequestDispatcher("/forum/article/record.jsp");
		rd.forward(request, response);
		return;

	}

}
