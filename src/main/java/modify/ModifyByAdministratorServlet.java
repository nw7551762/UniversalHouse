package modify;

import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;


import regist.MemberBean;
import regist.MemberDao;


@WebServlet("/modify/modifyByAd.do")
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
		
			try {
				MemberDao dao = new MemberDao();
				
				MemberBean member =  dao.findByMemberId(memberId);
				member.setName(request.getParameter("name"));
				member.setPassword(request.getParameter("password"));
				member.setLocation(request.getParameter("location"));
				member.setEmail(request.getParameter("email"));
				member.setPhone(request.getParameter("phone"));
				
				Part imgPart = request.getPart("memberImage");
				Blob imgBlob = member.partToBlob(imgPart);
				
				member.setMemberImage(imgBlob);
				dao.modify(member);
			
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	
	}
   


