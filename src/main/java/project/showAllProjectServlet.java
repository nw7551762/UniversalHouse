package project;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/project/showAllProjectServlet")
public class showAllProjectServlet extends HttpServlet {
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
		
		List<ProjectBean> allProject = dao.findAllProject();
		
		request.setAttribute("allProject", allProject);
		RequestDispatcher rd = request.getRequestDispatcher("/allProject/showAllProject.jsp");
		rd.forward(request, response);
		return;
		
	}
}
