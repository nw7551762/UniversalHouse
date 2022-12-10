package Message;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;
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

@MultipartConfig(location = "", fileSizeThreshold = 5 * 1024 * 1024, maxFileSize = 1024 * 1024
		* 500, maxRequestSize = 1024 * 1024 * 500 * 5)

@WebServlet("/newMessage")
public class NewMessage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		request.setCharacterEncoding("UTF-8");

		String articleId = request.getParameter("id");
		String authorId = request.getParameter("authorId");
		String content = request.getParameter("content");

		MessageService mss = new MessageService();
		Timestamp postTime = new java.sql.Timestamp(System.currentTimeMillis());
		MessageBean mb = new MessageBean(Integer.parseInt(articleId), null, Integer.parseInt(authorId), postTime,
				content);

		try {
			mss.saveMessage(mb);
			request.setAttribute("id", articleId);
			RequestDispatcher rd = request.getRequestDispatcher("/toConsole");
			rd.forward(request, response);
			return;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}