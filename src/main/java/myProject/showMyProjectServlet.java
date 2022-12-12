package myProject;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import project.ProjectBean;
import project.ProjectDaoImpl_JDBC;
import regist.MemberBean;

@WebServlet("/myProject/showMyProjectServlet")
public class showMyProjectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req, resp);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	private void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		request.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession();
		ProjectDaoImpl_JDBC dao = new ProjectDaoImpl_JDBC();
		MemberBean member = (MemberBean)session.getAttribute("LoginOK");
		String sql = "";
		if((request.getParameter("findPJName"))=="" || (request.getParameter("findPJName"))==null) {
			sql = "SELECT * FROM project WHERE memberID = \'"+member.getMemberId()+"\' ORDER BY pj_ID DESC";
			}else if((request.getParameter("findPJName"))!="" || (request.getParameter("findPJName"))!=null){
			sql = "SELECT * FROM project WHERE memberID = \'"+member.getMemberId()+"\' AND pj_Name LIKE N\'%" + request.getParameter("findPJName") + "%\' ORDER BY pj_ID DESC";
			}
		
		List<ProjectBean> project = dao.findByID(sql);
		
		request.setAttribute("myProject", project);
		RequestDispatcher rd = request.getRequestDispatcher("/myProject/showMyProject.jsp");
		rd.forward(request, response);
		return;
		
	}
}
