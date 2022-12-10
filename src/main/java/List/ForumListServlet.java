package List;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Forum.MemberBean;
import Forum.MemberService;

@WebServlet("/forumList")
public class ForumListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String authorId = request.getParameter("id");
		MemberService ms = new MemberService();
		List<MemberBean> memberList = ms.findByAuthor(Integer.parseInt(authorId));
		if (memberList != null) {
			request.setAttribute("ForumList", memberList);
		}

		RequestDispatcher rd = request.getRequestDispatcher("/ForumList/showList.jsp");
		rd.forward(request, response);
		return;
	}
}
