package article;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import article_message.MessageBean;
import article_message.MessageService;
import regist.MemberBean;

@WebServlet("/searchByName")
public class SearchByName extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SearchByName() {
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
		MemberBean memberBean = articleService.findBeanByName(name);
		
		if(memberBean==null) {
			RequestDispatcher rd = request.getRequestDispatcher("/Forum/Article/null.jsp");
			rd.forward(request, response);
		}
		
		if (memberBean.getMemberPK() != null) {
			List<ArticleBean> articleList = articleService.findByAuthor(memberBean.getMemberPK());
		request.setAttribute("articleList", articleList);
	}
		RequestDispatcher rd = request.getRequestDispatcher("/Forum/BackSide/showList.jsp");
		rd.forward(request, response);
		return;

	}

}
