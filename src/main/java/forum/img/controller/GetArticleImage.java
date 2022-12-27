package forum.img.controller;

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
import forum.model.Img;
import forum.service.ImgService;

@WebServlet("/getArticleImage")
public class GetArticleImage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		OutputStream os = null;
		InputStream is = null;
		Blob image = null;

		try {
			
			ImgService imgService = new ImgService();
			String imgNo = request.getParameter("imgNo");
			Img img = imgService.findByImgNo(Integer.parseInt(imgNo));

			image = img.getImg();
			is = image.getBinaryStream();
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