package article_message;

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

import regist.MemberBean;

@MultipartConfig(location = "", fileSizeThreshold = 5 * 1024 * 1024, maxFileSize = 1024 * 1024
		* 500, maxRequestSize = 1024 * 1024 * 500 * 5)

@WebServlet("/newMessage")
public class NewMessage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		request.setCharacterEncoding("UTF-8");

		String articleId = request.getParameter("id");
		String content = request.getParameter("content");
		String memberId = request.getParameter("memberId");
		MessageService messageService = new MessageService();
		MemberBean memberBean=messageService.findBeanByMemberId(memberId);
	
		Timestamp postTime = new java.sql.Timestamp(System.currentTimeMillis());
		MessageBean messageBean = new MessageBean(Integer.parseInt(articleId), null, memberBean.getMemberPK(),null, postTime,
				content);

		try {
			messageService.saveMessage(messageBean);			
			request.setAttribute("articleId", articleId);
			RequestDispatcher rd = request.getRequestDispatcher("/showArticle");
			rd.forward(request, response);
			return;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		doPost(request, response);
	}
}