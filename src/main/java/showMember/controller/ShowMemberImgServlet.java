package showMember.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.model.Member;
import member.model.MemberDao;


/**
 * Servlet implementation class ShowMemberImgServlet
 */
@MultipartConfig
@WebServlet("/ShowMemberImgServlet.do")
public class ShowMemberImgServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
	
	private void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		request.setCharacterEncoding("UTF-8");
		
		
		
		MemberDao dao = new MemberDao();
		String memberId=  request.getParameter("memberId") ;
		Member member =  dao.findByMemberId(memberId);
		Blob blob =  member.getMemberImage();
		try (
				InputStream is =  blob.getBinaryStream();
				OutputStream os = response.getOutputStream();
				){
				byte[] bytes = new byte[8126];
				
				int len = 0;
				
				while ((len = is.read(bytes)) != -1) {
				os.write(bytes, 0, len);
				os.flush();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}

}
