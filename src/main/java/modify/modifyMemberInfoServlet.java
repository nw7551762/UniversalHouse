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
