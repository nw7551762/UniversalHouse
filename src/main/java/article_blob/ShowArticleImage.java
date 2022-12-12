package article_blob;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import article.*;
import regist.MemberBean;

@WebServlet("/showArticleImage")
public class ShowArticleImage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		OutputStream os = null;
		InputStream is = null;
		Blob image = null;
		try {
			String aId =request.getParameter("id");
			ArticleService articleService = new ArticleService();
			
			int articleId = Integer.parseInt(aId);
			ArticleBean articleBean = articleService.findById(articleId);

			if (articleBean != null) {
				if(articleBean.getImg() != null) {
					image = articleBean.getImg();
				}
				if (articleBean.getImg() == null) {
					MemberBean memberBean = articleService.findBeanByName("default");
					image=memberBean.getMemberImage();
				}
				is = image.getBinaryStream();
			}

			os = response.getOutputStream();
			int len = 0;
			byte[] bytes = new byte[8192];
			while ((len = is.read(bytes)) != -1) {
				os.write(bytes, 0, len);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
			throw new RuntimeException("發生SQLException: " + ex.getMessage());
		} finally {
			if (is != null)
				is.close();
			if (os != null)
				os.close();
		}
	}
}