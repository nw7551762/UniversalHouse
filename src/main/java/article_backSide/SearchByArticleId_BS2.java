package article_backSide;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import article.*;
import article_message.*;
import regist.MemberBean;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/showArticle_BS2")
public class SearchByArticleId_BS2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String articleIdString = (String) request.getAttribute("articleId");
		if (articleIdString == null) {
			articleIdString =request.getParameter("articleId");
		}
		
		for (int i = articleIdString.length()-1;i>= 0; --i ) {
			int chr = articleIdString.charAt(i);
			if (chr < 48 || chr > 57) {
				RequestDispatcher rd = request.getRequestDispatcher("/Forum/BackSide/null.jsp");
				rd.forward(request, response);
				return;
			}

		}
		
		int articleId = Integer.parseInt(articleIdString);

		ArticleService articleService = new ArticleService();
		ArticleBean articleBean = articleService.findById(articleId);
		if (articleBean == null) {
			RequestDispatcher rd = request.getRequestDispatcher("/Forum/BackSide/null.jsp");
			rd.forward(request, response);
			return;
		}
		List<ArticleBean> onlyOneList=new ArrayList<>();
		onlyOneList.add(articleBean);
		
		request.setAttribute("articleList", onlyOneList);
		
		RequestDispatcher rd = request.getRequestDispatcher("/Forum/BackSide/showList.jsp");
		rd.forward(request, response);
		return;
	}
}