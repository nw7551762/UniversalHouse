package project;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/project/showMyProjectServlet")
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
		
		ProjectDaoImpl_JDBC dao = new ProjectDaoImpl_JDBC();
		List<ProjectBean> project = dao.findByID(1);
		
		
		request.setAttribute("project", project);
		RequestDispatcher rd = request.getRequestDispatcher("/project/showMyProject.jsp");
		rd.forward(request, response);
		return;
		
	}
}
