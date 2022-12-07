package showMemberInfo;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import regist.MemberBean;
import regist.MemberDao;

@WebServlet("/showMemberInfo/showMemberInfo.do")
public class ShowMemberInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
	
	private void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		request.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession();
		
		MemberDao dao = new MemberDao();
		MemberBean member = (MemberBean) session.getAttribute("LoginOK") ;
		
		
		request.setAttribute("member", member);
		RequestDispatcher rd = request.getRequestDispatcher("/showMemberInfo/showMemberInfo.jsp");
		rd.forward(request, response);
		return;
		
	}

}
