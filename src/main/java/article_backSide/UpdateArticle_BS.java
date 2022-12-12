package article_backSide;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.HashMap;
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

import article.ArticleBean;
import article.ArticleService;
import article_blob.GlobalService;

@MultipartConfig(location = "", fileSizeThreshold = 5 * 1024 * 1024, maxFileSize = 1024 * 1024
		* 500, maxRequestSize = 1024 * 1024 * 500 * 5)

@WebServlet("/updateArticle_BS")
public class UpdateArticle_BS extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		request.setCharacterEncoding("UTF-8");

		Map<String, String> requestErrorMsg = new HashMap<String, String>();
		Map<String, String> sessionMessageOK = new HashMap<String, String>();
		HttpSession session = request.getSession();
		request.setAttribute("MsgMap", requestErrorMsg);
		session.setAttribute("MsgOK", sessionMessageOK);
		
		String articleId="";
		String authorId = "";
		String topicName = "";
		String title = "";
		String content = "";
		String imgName = "";
		long sizeInBytes = 0;
		InputStream is = null;
		Collection<Part> parts = request.getParts();
		if (parts != null) {
			for (Part p : parts) {
				String fldName = p.getName();
				String value = request.getParameter(fldName);

				// 1. 讀取使用者輸入資料
				if (p.getContentType() == null) {
					if (fldName.equals("authorId")) {
						authorId = value;
					} else if (fldName.equals("articleId")) {
						articleId = value;
					}else if (fldName.equals("topicName")) {
						topicName = value;
					} else if (fldName.equals("content")) {
						content = value;
					} else if (fldName.equals("title")) {
						title = value;
					} else if (fldName.equals("imgName")) {
						imgName = value;
					}

				} else {
					// 取出圖片檔的檔名
					imgName = GlobalService.getFileName(p);
					// 調整圖片檔檔名的長度，需要檔名中的附檔名，所以調整主檔名以免檔名太長無法寫入表格
					imgName = GlobalService.adjustFileName(imgName, GlobalService.IMAGE_FILENAME_LENGTH);
					if (imgName != null && imgName.trim().length() > 0) {
						sizeInBytes = p.getSize();
						is = p.getInputStream();
					}
				}
			}

		} else {
			requestErrorMsg.put("err", "此表單不是上傳檔案的表單");
		}
		String url="/getOldArticle_BS?articleId="+articleId;
		if (!requestErrorMsg.isEmpty()) {
			// 導向原來輸入資料的畫面，這次會顯示錯誤訊息
			RequestDispatcher rd = request.getRequestDispatcher(url);
			rd.forward(request, response);
			return;
		}
		
		try {
			ArticleService articleService = new ArticleService();
			
			if(articleService.isExistBytitle(title)) {
				requestErrorMsg.put("errorTitleDup", "title重複");
			}
			
			Timestamp postTime = new java.sql.Timestamp(System.currentTimeMillis());
			Blob blob = null;
			if (is != null) {
				blob = GlobalService.fileToBlob(is, sizeInBytes);
			}
			else {
				ArticleBean oldMb=articleService.findById(Integer.parseInt(articleId));
				blob=oldMb.getImg();
			}
			
			if(articleService.isExistBytitle(title)) {
				requestErrorMsg.put("errorTitleDup", "注意:文章主題已存在!");
			}
			
			ArticleBean articleBean = new ArticleBean(Integer.parseInt(articleId), Integer.parseInt(authorId), postTime, topicName, title, content,blob);
			try {
				articleService.updateById(articleBean);
				String articleIdString=articleBean.getArticleId().toString();
				request.setAttribute("articleId", articleIdString);

				RequestDispatcher rd = request.getRequestDispatcher("/backSide");
				rd.forward(request, response);
				return;

			} catch (Exception e) {
				requestErrorMsg.put("errorIdDup", "注意:文章主題已存在!");
			}

			if (!requestErrorMsg.isEmpty()) {
				RequestDispatcher rd = request.getRequestDispatcher(url);
				rd.forward(request, response);
				return;
			}
		} catch (Exception e) {
			e.printStackTrace();
			requestErrorMsg.put("errorIdDup", e.getMessage());
			RequestDispatcher rd = request.getRequestDispatcher(url);
			rd.forward(request, response);
		}
	}
}