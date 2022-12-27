package Regist.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;

import member.model.Member;
import member.model.MemberDao;

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
		Member member = new Member();
		
		if( !dao.existsById(request.getParameter("memberId")) ) {
			if(  !request.getParameter("memberId").equals("") && (request.getParameter("memberId") instanceof String) ) {
				member.setMemberId(  request.getParameter("memberId"));
			}
			
			member.setName(request.getParameter("name"));
			member.setPassword(request.getParameter("password"));
			member.setEmail(request.getParameter("email"));
			member.setRegisterTime();
			member.setMemberId(request.getParameter("memberId"));
			dao.save(member);
			request.setAttribute("member", member);
		
			RequestDispatcher rd = request.getRequestDispatcher("/member/regist/registSuccess.jsp");
			rd.forward(request, response);
			
			
		}else {
			request.setAttribute("IdExist", "Regist Fail, This ID already exist");
			
			RequestDispatcher rd = request.getRequestDispatcher("/regist/regist.jsp");
			rd.forward(request, response);	
			
			return;
			
		}

		
	}
	
	


	}
