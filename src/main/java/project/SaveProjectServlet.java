package project;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

			ProjectBean project = new ProjectBean();
			ProjectDaoImpl_JDBC dao = new ProjectDaoImpl_JDBC();

			project.setPjClass(request.getParameter("pj_Class"));
			project.setFieldName(request.getParameter("fieldName"));
			project.setPjName(request.getParameter("pj_Name"));
			project.setMemberPk(Integer.parseInt(request.getParameter("memberPk")));
			project.setPjInstruction(request.getParameter("pj_Instruction"));
			project.setPjServerLocation(request.getParameter("pj_ServerLocation"));
			project.setPjPrice(Integer.parseInt(request.getParameter("pj_Price")));
			dao.saveProject(project);
			request.setAttribute("project", project);
			RequestDispatcher rd = request.getRequestDispatcher("/project/saveProjectSuccess.jsp");
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
		}
	}
}
