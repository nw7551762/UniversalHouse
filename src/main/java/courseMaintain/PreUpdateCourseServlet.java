package courseMaintain;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@MultipartConfig
@WebServlet("/PreUpdateCourseServlet")
public class PreUpdateCourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request,response);
	}
	
	private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
		request.setCharacterEncoding("UTF-8");
		String courseId =request.getParameter("courseId");
		CourseDao dao = new CourseDao();
		
			CourseBean cb;
			try {
				cb = dao.findById(Integer.parseInt(courseId));
				request.setAttribute("update", cb);
			} catch (NumberFormatException | SQLException e) {
				e.printStackTrace();
			}
		
		RequestDispatcher rd = request.getRequestDispatcher("/courseMaintain/updateCourse.jsp");
		rd.forward(request, response);
		return;
	}
}
