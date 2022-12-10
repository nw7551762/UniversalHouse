package modify;

import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import javax.sql.rowset.serial.SerialException;

import regist.MemberBean;
import regist.MemberDao;

@MultipartConfig
@WebServlet("/modify/modifyByAd.do")
public class ModifyByAdministratorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request,response);
//		try {
//			processRequest(request,response);
//		} catch (IOException | ServletException | SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request,response);
		//		try {
//			processRequest(request,response);
//		} catch (IOException | ServletException | SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}
	
//	private void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, SerialException, SQLException {
		private String processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		request.setCharacterEncoding("UTF-8");
		System.out.println("in modifyByAd");
		
		String memberId = request.getParameter("memberId");
			try{
				MemberDao dao = new MemberDao();	
			
			
			MemberBean member =  dao.findByMemberId(memberId);
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
			dao.modify(member);
			}catch(Exception e) {
				e.printStackTrace();
			}
			System.out.print("456");
			return "123";
		}
	
	}
   


