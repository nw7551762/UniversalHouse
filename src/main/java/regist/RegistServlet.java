<<<<<<< HEAD
package regist;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@MultipartConfig
@WebServlet("/regist/regist.do")
public class RegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request,response);
	}
	
	private void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		request.setCharacterEncoding("UTF-8");
		
		MemberDao dao = new MemberDao();
		MemberBean member = new MemberBean();
		
		if( !dao.existsById(request.getParameter("memberId")) ) {
			
			member.setMemberId(request.getParameter("memberId"));
			member.setName(request.getParameter("name"));
			member.setPassword(request.getParameter("password"));
			member.setEmail(request.getParameter("email"));
			Date date = new Date();
			member.setRegisterTime(date);
			dao.save(member);
			request.setAttribute("member", member);
			RequestDispatcher rd = request.getRequestDispatcher("/regist/registSuccess.jsp");
			rd.forward(request, response);
			return;
			
		}else {
			request.setAttribute("IdExist", "Regist Fail, This ID already exist");
			
			RequestDispatcher rd = request.getRequestDispatcher("/regist/regist.jsp");
			rd.forward(request, response);
			
			return;
			
		}
		
		
		
		
	}
	
	


}
=======
package regist;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@MultipartConfig
@WebServlet("/regist/regist.do")
public class RegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request,response);
	}
	
	private void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		request.setCharacterEncoding("UTF-8");
		
		MemberDao dao = new MemberDao();
		MemberBean member = new MemberBean();
		
		if( !dao.existsById(request.getParameter("memberId")) ) {
			
			member.setMemberId(request.getParameter("memberId"));
			member.setName(request.getParameter("name"));
			member.setPassword(request.getParameter("password"));
			member.setEmail(request.getParameter("email"));
			Date date = new Date();
			member.setRegisterTime(date);
			dao.save(member);
			request.setAttribute("member", member);
			RequestDispatcher rd = request.getRequestDispatcher("/regist/registSuccess.jsp");
			rd.forward(request, response);
			return;
			
		}else {
			request.setAttribute("IdExist", "Regist Fail, This ID already exist");
			
			RequestDispatcher rd = request.getRequestDispatcher("/regist/regist.jsp");
			rd.forward(request, response);
			
			return;
			
		}
		
		
		
		
	}
	
	


}
>>>>>>> 70903c257652f471bee4a0ba774da67e72517659
