package Update;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Forum.MemberBean;
import Forum.MemberService;

@WebServlet("/getOldDatas")
public class OldDatas extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public OldDatas() {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		MemberService ms = new MemberService();
		int articleId = Integer.parseInt(id);
		MemberBean mb = ms.findById(articleId);
		request.setAttribute("thisMemberBean", mb);

		RequestDispatcher rd = request.getRequestDispatcher("/Forum/update.jsp");
		rd.forward(request, response);
		return;
	}
}
