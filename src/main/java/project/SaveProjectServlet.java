package project;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import regist.MemberBean;

@MultipartConfig
@WebServlet("/project/SaveProjectServlet")
public class SaveProjectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	private void processRequest(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setCharacterEncoding("UTF-8");

			ProjectDaoImpl_JDBC pjDao = new ProjectDaoImpl_JDBC();
			ProjectBean project = new ProjectBean();
			HttpSession session = request.getSession();
			MemberBean member = (MemberBean)session.getAttribute("LoginOK");

			project.setPjClass("委託");
			project.setFieldName(request.getParameter("fieldName"));
			project.setPjName(request.getParameter("pj_Name"));
			project.setMemberPK(member.getMemberPK());
			project.setPjInstruction(request.getParameter("pj_Instruction"));
			project.setPjServerLocation(request.getParameter("pj_ServerLocation"));
			project.setPjPrice(Integer.parseInt(request.getParameter("pj_Price")));
			Date exCompletionDate = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("pj_ExCompletionDate"));
			project.setPjExCompletionDate(exCompletionDate);
			Date date = new Date();
			project.setPjUploadDate(date);
			project.setPjLastUpdate(date);
			project.setPjStatus("待審核");
			pjDao.saveProject(project);
			request.setAttribute("project", project);
			RequestDispatcher rd = request.getRequestDispatcher("/myProject/saveProjectSuccess.jsp");
			rd.forward(request, response);
			return;
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}