package allProject;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import project.ProjectBean;
import project.ProjectDaoImpl_JDBC;

@WebServlet("/allProject/showServerProjectServlet")
public class showServerProjectServlet extends HttpServlet {
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
		
		ProjectDaoImpl_JDBC dao = new ProjectDaoImpl_JDBC();
		
		String sql = "";
		
		if((request.getParameter("findPJName"))=="" || (request.getParameter("findPJName"))==null) {
		sql = "SELECT * FROM project WHERE pj_Class LIKE N\'%服務%\' ORDER BY pj_ID DESC";
		}else if((request.getParameter("findPJName"))!="" || (request.getParameter("findPJName"))!=null){
		sql = "SELECT * FROM project WHERE pj_Class LIKE N\'%服務%\' AND pj_Name LIKE N\'%" + request.getParameter("findPJName") + "%\' ORDER BY pj_ID DESC";
		}
		List<ProjectBean> allProject = dao.findAllProject(sql);
		request.setAttribute("serverProject", allProject);
		RequestDispatcher rd = request.getRequestDispatcher("/allProject/showServerProject.jsp");
		rd.forward(request, response);
		return;
		
	}
}
