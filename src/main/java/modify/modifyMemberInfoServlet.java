package modify;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
<<<<<<< HEAD
=======
import javax.servlet.http.HttpSession;
>>>>>>> zshe
import javax.servlet.http.Part;
import javax.sql.rowset.serial.SerialBlob;


import regist.MemberBean;
import regist.MemberDao;

@MultipartConfig
<<<<<<< HEAD
@WebServlet({ "/modifyMemberInfoServlet", "/modify.do" })
=======
@WebServlet( "/modify/modifyByMember.do" )
>>>>>>> zshe
public class modifyMemberInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			processRequest(request,response);
		} catch (IOException | ServletException | SQLException e) {
			e.printStackTrace();
			
		}
	}
	private void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, SQLException {
		request.setCharacterEncoding("UTF-8");
		
<<<<<<< HEAD
		/*
		還沒寫
		還沒寫
		還沒寫
		*/
		MemberDao dao = new MemberDao();
		MemberBean member = new MemberBean();
		member.setMemberId(request.getParameter("memberId"));
=======
		MemberDao dao = new MemberDao();
		
		HttpSession session = request.getSession();
		
		MemberBean member =  (MemberBean) session.getAttribute("LoginOK");
		
>>>>>>> zshe
		member.setName(request.getParameter("name"));
		member.setPassword(request.getParameter("password"));
		member.setLocation(request.getParameter("location"));
		member.setEmail(request.getParameter("email"));
		member.setPhone(request.getParameter("phone"));
<<<<<<< HEAD
		Date date = new Date();
		member.setRegisterTime(date);
=======
>>>>>>> zshe
		
		Part imgPart = request.getPart("memberImage");
		Blob imgBlob = member.partToBlob(imgPart);
		
		member.setMemberImage(imgBlob);
<<<<<<< HEAD
		dao.save(member);
	
		request.setAttribute("member", member);
		RequestDispatcher rd = request.getRequestDispatcher("/regist/showMemberInfo.jsp");
=======
		dao.modify(member);
	
		request.setAttribute("member", member);
		RequestDispatcher rd = request.getRequestDispatcher("/showMemberInfo/showMemberInfo.jsp");
>>>>>>> zshe
		rd.forward(request, response);
		return;
	}
}
