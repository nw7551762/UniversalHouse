package regist;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@MultipartConfig
@WebServlet("/regist/regServlet.do")
public class RegServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	MemberDao dao = new MemberDao();

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        doPost(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
        out.println("<HTML>");
        out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
        out.println("  <BODY>");

        String name = request.getParameter("name");
        String pwd = request.getParameter("pwd");
        String email = request.getParameter("email");

        MemberBean user = new MemberBean();
        user.setName(name);
        user.setPassword(pwd);
        user.setEmail(email);

        user = dao.findByMemberId("bbb");

		if (user != null) {
		    // 發激活郵件
		    new utils.SendMailThread(user).run();
		    out.println("您已經成功註冊，請到郵箱中激活");
		} else {
		    out.println("註冊失敗");
		}

        out.println("  </BODY>");
        out.println("</HTML>");
        out.flush();
        out.close();
    }

}