<<<<<<< HEAD
package modify;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.sql.rowset.serial.SerialBlob;


import regist.MemberBean;
import regist.MemberDao;

@MultipartConfig
@WebServlet({ "/modifyMemberInfoServlet", "/modify.do" })
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
		int memberPk=2;
		
		/*
		還沒寫
		還沒寫
		還沒寫
		*/
		MemberDao dao = new MemberDao();
		MemberBean member = new MemberBean();
		member.setMemberId(request.getParameter("memberId"));
		member.setPassword(request.getParameter("name"));
		member.setPassword(request.getParameter("password"));
		member.setLocation(request.getParameter("location"));
		member.setEmail(request.getParameter("email"));
		member.setPhone(request.getParameter("phone"));
		member.setRegisterTime();
		
		
		Part imgPart = request.getPart("memberImage");
		Blob imgBlob = member.partToBlob(imgPart);
		member.setMemberImage(imgBlob);
		
		dao.save(member);
	
		
		request.setAttribute("member", member);
		RequestDispatcher rd = request.getRequestDispatcher("/regist/showMemberInfo.jsp");
		rd.forward(request, response);
		return;
	}
}
=======
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
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import javax.sql.rowset.serial.SerialBlob;


import regist.MemberBean;
import regist.MemberDao;

@MultipartConfig
@WebServlet( "/modify/modifyByMember.do" )
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
		
		MemberDao dao = new MemberDao();
		
		HttpSession session = request.getSession();
		
		MemberBean member =  (MemberBean) session.getAttribute("LoginOK");
		
		member.setName(request.getParameter("name"));
		member.setPassword(request.getParameter("password"));
		member.setLocation(request.getParameter("location"));
		member.setEmail(request.getParameter("email"));
		member.setPhone(request.getParameter("phone"));
		
		Part imgPart = request.getPart("memberImage");
		Blob imgBlob = member.partToBlob(imgPart);
		
		member.setMemberImage(imgBlob);
		dao.modify(member);
	
		request.setAttribute("member", member);
		RequestDispatcher rd = request.getRequestDispatcher("/showMemberInfo/showMemberInfo.jsp");
		rd.forward(request, response);
		return;
	}
}
>>>>>>> 70903c257652f471bee4a0ba774da67e72517659
