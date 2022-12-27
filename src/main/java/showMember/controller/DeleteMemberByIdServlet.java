package showMember.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.model.MemberDao;


@WebServlet("/deleteMember.do")
public class DeleteMemberByIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request,response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request,response);
	}
	
	private void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		request.setCharacterEncoding("UTF-8");
		System.out.println("in testdelete");
		MemberDao dao = new MemberDao();
		
		String memberId = request.getParameter("memberId");
			
			try {
				Integer memberPk =  dao.findByMemberId(memberId).getMemberPk();
				dao.deleteByMemberPk(memberPk);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	
	}
   


