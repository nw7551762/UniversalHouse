package forum.article.controller;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import forum.model.Article;
import forum.model.Img;
import forum.service.ArticleService;
import forum.service.GlobalService;
import forum.service.ImgService;

@MultipartConfig(location = "", fileSizeThreshold = 5 * 1024 * 1024, maxFileSize = 1024 * 1024
		* 500, maxRequestSize = 1024 * 1024 * 500 * 5)

@WebServlet("/updateArticle")
public class UpdateArticle extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		request.setCharacterEncoding("UTF-8");

		Map<String, String> requestErrorMsg = new HashMap<String, String>();
		Map<String, String> sessionMessageOK = new HashMap<String, String>();
		Map<String, Blob> imgMap = new HashMap<String, Blob>();
		HttpSession session = request.getSession();
		request.setAttribute("MsgMap", requestErrorMsg);
		session.setAttribute("MsgOK", sessionMessageOK);

		String articleId = "";
		String topicName = "";
		String title = "";
		String content = "";
		String imgName = "";
		String status = "";
		Blob blob = null;
		long sizeInBytes = 0;
		InputStream is = null;
		Collection<Part> parts = request.getParts();
		if (parts != null) {
			for (Part p : parts) {
				String formName = p.getName();
				String value = request.getParameter(formName);

				if (p.getContentType() == null) {
					if (formName.equals("articleId")) {
						articleId = value;
					} else if (formName.equals("topicName")) {
						topicName = value;
					} else if (formName.equals("content")) {
						content = value;
					} else if (formName.equals("title")) {
						title = value;
					} else if (formName.equals("imgName")) {
						imgName = value;
					} else if (formName.equals("status")) {
						status = value;
					}

				} else {
					imgName = GlobalService.getFileName(p);
					imgName = GlobalService.adjustFileName(imgName, GlobalService.IMAGE_FILENAME_LENGTH);
					if (imgName != null && imgName.trim().length() > 0) {
						sizeInBytes = p.getSize();
						is = p.getInputStream();

						if (is != null) {
							try {
								blob = GlobalService.fileToBlob(is, sizeInBytes);
								imgMap.put(imgName, blob);
							} catch (IOException | SQLException e) {
								e.printStackTrace();
							}
						}
					}
				}
			}

		} else {
			requestErrorMsg.put("err", "此表單不是上傳檔案的表單");
		}
		String url = "/getOldArticle?articleId=" + articleId;
		if (!requestErrorMsg.isEmpty()) {
			RequestDispatcher rd = request.getRequestDispatcher(url);
			rd.forward(request, response);
			return;
		}

		try {
			ArticleService articleService = new ArticleService();
			Timestamp updateTime = new java.sql.Timestamp(System.currentTimeMillis());
			ImgService imgService = new ImgService();

			if (articleService.findByTitle(title) != null) {
				requestErrorMsg.put("errorTitleDup", "title重複");
			}

			if (is != null) {
				blob = GlobalService.fileToBlob(is, sizeInBytes);
			} else {
				List<Img> imgList = imgService.findByArticleId(Integer.parseInt(articleId));
				for (Img img : imgList) {
					blob = img.getImg();
				}
			}

			if (articleService.findByTitle(title) != null) {
				requestErrorMsg.put("errorTitleDup", "注意:文章主題已存在!");
			}

			if (imgService.findByArticleId(Integer.parseInt(articleId)) != null) {
				imgService.deleteByArticleId(Integer.parseInt(articleId));
			}

			Article article = new Article();
			article.setArticleId(Integer.parseInt(articleId));
			article.setUpdateTime(updateTime);
			article.setTopicName(topicName);
			article.setTitle(title);
			article.setContent(content);
			article.setStatus(status);
			
			articleService.updateById(article);
			imgService.save(article.getArticleId(), imgMap);

			request.setAttribute("articleId", article.getArticleId());

			RequestDispatcher rd = request.getRequestDispatcher("/frontPage");
			rd.forward(request, response);
			return;

		} catch (Exception e) {
			e.printStackTrace();
			requestErrorMsg.put("errorIdDup", e.getMessage());
			RequestDispatcher rd = request.getRequestDispatcher(url);
			rd.forward(request, response);
		}
	}
}