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
import forum.model.Img;
import forum.service.ArticleService;
import forum.service.ImgService;

@WebServlet("/getOldArticle_BS")
public class BS_GetOldArticle extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String articleId = request.getParameter("articleId");
		ArticleService articleService = new ArticleService();
		ImgService imgService=new ImgService();
		Article article = articleService.findByArticleId(Integer.parseInt(articleId));
		List<Img> imgs=imgService.findByArticleId(Integer.parseInt(articleId));
		
		request.setAttribute("article", article);
		request.setAttribute("imgs", imgs);

		RequestDispatcher rd = request.getRequestDispatcher("/forum/backSide/updateArticle_BS.jsp");
		rd.forward(request, response);
		return;
	}
}
