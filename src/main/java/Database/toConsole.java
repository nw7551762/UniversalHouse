package Database;

import java.io.IOException;
import java.util.List;

import Forum.*;
import Message.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/toConsole")
public class toConsole extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String id = (String) request.getAttribute("id");
		int articleId = Integer.parseInt(id);

		MemberService mbs = new MemberService();
		MemberBean mbb = mbs.findById(articleId);

		MessageService mss = new MessageService();
		List<MessageBean> list = mss.findMessageByArticleId(articleId);

		request.setAttribute("ForumBean", mbb);
		if (list != null) {
			request.setAttribute("MessageBean", list);
		}
		RequestDispatcher rd = request.getRequestDispatcher("/Forum/console.jsp");
		rd.forward(request, response);
		return;
	}
}