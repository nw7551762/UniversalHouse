package showMember.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.model.Member;
import member.model.MemberDao;


/**
 * Servlet implementation class ShowAllMember
 */
@WebServlet("/showMember.controller/showAllMember.do")
public class ShowAllMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	private void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		
		MemberDao dao = new MemberDao();
		List<Member> members = dao.findAllMember();
		
		request.setAttribute("members", members);
		RequestDispatcher rd = request.getRequestDispatcher("/member/showMember/showAllMember.jsp");
		rd.forward(request, response);
		return;
	}
}
