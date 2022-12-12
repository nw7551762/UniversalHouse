package article_backSide;

import java.io.IOException;
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

@WebServlet("/showArticle_BS")
public class SearchByArticleId_BS extends HttpServlet {
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
				RequestDispatcher rd = request.getRequestDispatcher("/Forum/Article/null.jsp");
				rd.forward(request, response);
				return;
			}

		}
		
		int articleId = Integer.parseInt(articleIdString);

		ArticleService articleService = new ArticleService();
		MessageService messageService = new MessageService();
		ArticleBean articleBean = articleService.findById(articleId);
		if (articleBean == null) {
			RequestDispatcher rd = request.getRequestDispatcher("/Forum/Article/null.jsp");
			rd.forward(request, response);
			return;
		}
		MemberBean memberBean=articleService.findMemberBeanByAuthorId(articleBean.getAuthorId());
		List<MessageBean> messageList = messageService.findMessageByArticleId(articleId);

		request.setAttribute("memberBean", memberBean);
		request.setAttribute("articleBean", articleBean);
		
		if(memberBean==null) {
			RequestDispatcher rd = request.getRequestDispatcher("/Forum/Article/null.jsp");
			rd.forward(request, response);
			return;
		}
		
		if (messageList != null) {
			request.setAttribute("MessageBean", messageList);
		}
		RequestDispatcher rd = request.getRequestDispatcher("/Forum/BackSide/show.jsp");
		rd.forward(request, response);
		return;
	}
}