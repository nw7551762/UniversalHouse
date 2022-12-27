package forum.img.controller;

import java.io.IOException;
import java.util.List;

import forum.model.Img;
import forum.service.ArticleService;
import forum.service.ImgService;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/imgDB_BS")
public class BS_ImgDB extends HttpServlet {
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
		ArticleService articlesService=new ArticleService();
		
		ImgService imgService=new ImgService();
		List<Img> imgList=imgService.findByArticleId(articleId);
		
		request.setAttribute("imgList", imgList);
		request.setAttribute("article", articlesService.findByArticleId(articleId));
		

		RequestDispatcher rd = request.getRequestDispatcher("/forum/backSide/imgDB.jsp");
		rd.forward(request, response);
		return;
	}
}