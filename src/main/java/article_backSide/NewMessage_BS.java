package article_backSide;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import article_message.*;
import regist.MemberBean;

@MultipartConfig(location = "", fileSizeThreshold = 5 * 1024 * 1024, maxFileSize = 1024 * 1024
		* 500, maxRequestSize = 1024 * 1024 * 500 * 5)

@WebServlet("/newMessage_BS")
public class NewMessage_BS extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		request.setCharacterEncoding("UTF-8");

		String articleId = request.getParameter("id");
		String content = request.getParameter("content");
		String memberId = request.getParameter("memberId");


		System.out.println("--------------------------------");
		System.out.println(articleId);
		System.out.println(content);
		System.out.println(memberId);
		System.out.println("--------------------------------");
		
		MessageService messageService = new MessageService();
		MemberBean memberBean=messageService.findBeanByMemberId(memberId);
	
		Timestamp postTime = new java.sql.Timestamp(System.currentTimeMillis());
		MessageBean messageBean = new MessageBean(Integer.parseInt(articleId), null, memberBean.getMemberPK(),null, postTime,
				content);

		try {
			messageService.saveMessage(messageBean);			
			request.setAttribute("articleId", articleId);
			RequestDispatcher rd = request.getRequestDispatcher("/showArticle_BS");
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