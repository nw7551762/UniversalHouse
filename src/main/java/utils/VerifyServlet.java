package utils;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import regist.MemberBean;
import regist.MemberDao;

@WebServlet("/utils/VerifyServlet.do")
public class VerifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request,response);
	}
	
	private void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		request.setCharacterEncoding("UTF-8");
		
		MemberDao dao = new MemberDao();
		MemberBean member = dao.findByMemberId( request.getParameter( "memberId" ));
		member.setVerification(1);
		dao.modify(member);
		
		
		RequestDispatcher rd = request.getRequestDispatcher("/regist/verifySuccess.jsp");
		rd.forward(request, response);
		
	}

}