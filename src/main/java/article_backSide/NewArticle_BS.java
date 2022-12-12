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

import article.*;
import article_blob.GlobalService;
import regist.MemberBean;

@MultipartConfig(location = "", fileSizeThreshold = 5 * 1024 * 1024, maxFileSize = 1024 * 1024
		* 500, maxRequestSize = 1024 * 1024 * 500 * 5)

@WebServlet("/newArticle_BS")
public class NewArticle_BS extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		request.setCharacterEncoding("UTF-8");

		Map<String, String> requestErrorMsg = new HashMap<String, String>();
		Map<String, String> sessionMessageOK = new HashMap<String, String>();
		HttpSession session = request.getSession();
		request.setAttribute("MsgMap", requestErrorMsg);
		session.setAttribute("MsgOK", sessionMessageOK);

		String memberId = "";
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

				if (p.getContentType() == null) {
					if (fldName.equals("memberId")) {
						memberId = value;
					} else if (fldName.equals("topicName")) {
						topicName = value;
					} else if (fldName.equals("content")) {
						content = value;
					} else if (fldName.equals("title")) {
						title = value;
					} else if (fldName.equals("imgName")) {
						imgName = value;
					}

				} else {
					imgName = GlobalService.getFileName(p);
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

		if (!requestErrorMsg.isEmpty()) {
			RequestDispatcher rd = request.getRequestDispatcher("/Forum/BackSide/newArticle.jsp");
			rd.forward(request, response);
			return;
		}

		try {
			ArticleService articleService=new ArticleService();
			MemberBean memberBean=articleService.findBeanByMemberId(memberId);
			Timestamp postTime = new java.sql.Timestamp(System.currentTimeMillis());
			Blob blob = null;
			
			if (is != null) {
				blob = GlobalService.fileToBlob(is, sizeInBytes);
			}

			if(articleService.isExistBytitle(title)) {
				requestErrorMsg.put("errorTitleDup", "注意:文章主題已存在!");
			}
			
			
			ArticleBean articleBean = new ArticleBean(null,memberBean.getMemberPK(), postTime, topicName, title, content,blob);
			try {
				articleService.save(articleBean);
				String id=articleBean.getArticleId().toString();
				request.setAttribute("articleId", id);
				RequestDispatcher rd = request.getRequestDispatcher("/backSide");
				rd.forward(request, response);
				return;

			} catch (Exception e) {
				requestErrorMsg.put("errorIdDup", "注意:文章主題已存在!");
			}

			if (!requestErrorMsg.isEmpty()) {
				RequestDispatcher rd = request.getRequestDispatcher("/Forum/BackSide/newArticle.jsp");
				rd.forward(request, response);
				return;
			}
		} catch (Exception e) {
			e.printStackTrace();
			requestErrorMsg.put("errorIdDup", e.getMessage());
			RequestDispatcher rd = request.getRequestDispatcher("/Forum/BackSide/newArticle.jsp");
			rd.forward(request, response);
		}
	}
}