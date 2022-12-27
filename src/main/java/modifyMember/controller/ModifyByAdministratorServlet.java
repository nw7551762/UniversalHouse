package modifyMember.controller;

import java.io.IOException;
import java.sql.Blob;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import member.model.Member;
import member.model.MemberDao;


@MultipartConfig
@WebServlet("/modifyMemberInfo/modifyByAd.do")
public class ModifyByAdministratorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request,response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request,response);
	}
	
	private void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		request.setCharacterEncoding("UTF-8");
		System.out.println("in modifyByAd");
		
		String memberId = request.getParameter("memberId");
			try{
				MemberDao dao = new MemberDao();	
			
			
			Member member =  dao.findByMemberId(memberId);
			////錯了
			if( !request.getParameter("name").equals("") ) {
				member.setName(request.getParameter("name"));
			}
			if( !request.getParameter("password").equals("") ) {
				member.setPassword(request.getParameter("password"));
			}
			if( !request.getParameter("location").equals("") ) {
				member.setLocation(request.getParameter("location"));
			}
			if( !request.getParameter("email").equals("") ) {
				member.setEmail(request.getParameter("email"));
			}
			if( !request.getParameter("phone").equals("") ) {
				member.setPhone(request.getParameter("phone"));
			}
			
			if(  request.getPart("memberImage").getSize()>0  ) {
				Part imgPart = request.getPart("memberImage");
				Blob imgBlob = member.partToBlob(imgPart);
						
				member.setMemberImage(imgBlob);
			}
			dao.update(member);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	
	}
   


