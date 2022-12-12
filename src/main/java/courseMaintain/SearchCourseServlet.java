package courseMaintain;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@MultipartConfig
@WebServlet("/SearchCourseServlet")
public class SearchCourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8"); 
		String courseName = request.getParameter("courseName");
		CourseDao dao = new CourseDao();
		List<CourseBean> list;
		list = dao.findByNameLike(courseName);
		request.setAttribute("result", list);
		
		RequestDispatcher rd = request.getRequestDispatcher("/courseMaintain/searchResult.jsp");
		rd.forward(request, response);	
		return;
	}

}
