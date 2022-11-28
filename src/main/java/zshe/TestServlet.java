package zshe;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/TestServlet")
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request,response);
		
	}
	
	private void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		request.setCharacterEncoding("UTF-8");
		MemberDao dao = new MemberDao();
		MemberBean member = dao.findByMemberNo(123);
		System.out.println(member.getNo() );
		request.setAttribute("no", member.getNo());
		RequestDispatcher rd = request.getRequestDispatcher("/zshe/test.jsp");
		rd.forward(request, response);
		return;
		
		
	}
	
	


}
