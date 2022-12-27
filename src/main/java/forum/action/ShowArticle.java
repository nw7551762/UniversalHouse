package forum.action;

import java.io.IOException;
import java.util.List;

import forum.model.Article;
import forum.model.Img;
import forum.model.Message;
import forum.service.ArticleService;
import forum.service.ImgService;
import forum.service.MessageService;
import member.model.Member;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/showArticle")
public class ShowArticle extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer articleId;
		if (request.getParameter("articleId") != null) {
			String a = request.getParameter("articleId");
			articleId = Integer.parseInt(a);
		} else {
			articleId = (Integer) request.getAttribute("articleId");
		}

		ArticleService articleService = new ArticleService();
		MessageService messageService = new MessageService();
		ImgService imgService = new ImgService();

		List<Img> imgs = imgService.findByArticleId(articleId);
		Article article = articleService.findByArticleId(articleId);

		if (article == null) {
			RequestDispatcher rd = request.getRequestDispatcher("/forum/article/null.jsp");
			rd.forward(request, response);
			return;
		}

		Member member = articleService.findMemberByMemberId(article.getAuthorId());
		List<Message> messages = messageService.findPublicByArticleId(articleId);

		request.setAttribute("article", article);
		request.setAttribute("member", member);

		if (messages != null) {
			request.setAttribute("messages", messages);
		}

		if (imgs != null) {
			request.setAttribute("imgs", imgs);
		}

		RequestDispatcher rd = request.getRequestDispatcher("/forum/article/show.jsp");
		rd.forward(request, response);
		return;
	}
}