package article_backSide;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import article.*;
import article_message.*;

@WebServlet("/deleteArticle_BS")
public class DeleteArticle_BS extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DeleteArticle_BS() {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String articleId = request.getParameter("articleId");
		ArticleService articleService = new ArticleService();
		MessageService messageService = new MessageService();

		ArticleBean articleBean = articleService.findById(Integer.parseInt(articleId));
		messageService.deleteMessageById(articleBean.getArticleId());
		articleService.deleteById(articleBean.getArticleId());

		RequestDispatcher rd = request.getRequestDispatcher("/backSide");
		rd.forward(request, response);
		return;

	}

}
