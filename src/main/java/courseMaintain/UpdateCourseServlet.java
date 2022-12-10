package courseMaintain;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/updateCourseServlet")
public class UpdateCourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       


	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		processRequest(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		processRequest(request, response);
	}

	private void processRequest(HttpServletRequest request,HttpServletResponse response) {
		try {
			request.setCharacterEncoding("UTF-8");
			
			int courseId = Integer.parseInt(request.getParameter("courseId"));
			CourseDao dao = new CourseDao();
			CourseBean cb = dao.findById(courseId);
			
			if((request.getParameter("courseName"))!=null) {
				cb.setCourseName(request.getParameter("courseName"));
			}
			if((request.getParameter("category"))!=null) {
				cb.setCategory(request.getParameter("category")); 
			}
			if((request.getParameter("teacher"))!=null) {
				cb.setTeacher(request.getParameter("teacher")); 
			}
			if((request.getParameter("price"))!=null) {
				cb.setPrice(Integer.parseInt(request.getParameter("price")));
			}
			
			if((request.getParameter("courseType"))!= null) {
				cb.setCourseType(request.getParameter("courseType"));
			}
			if((request.getParameter("startDate"))!= null) {
				cb.setStartDate(request.getParameter("startDate"));
			}
			if((request.getParameter("endDate"))!= null) {
				cb.setEndDate(request.getParameter("endDate"));
			}
			if((request.getParameter("startTime"))!= null) {
				cb.setStartTime(request.getParameter("startTime"));
			}
			if((request.getParameter("endTime"))!= null) {
				cb.setEndTime(request.getParameter("endTime"));
			}
//			if((request.getParameter("image"))!= null) {
//				cb.setImage(request.getParameter("image"));
//			}
			dao.updateById(cb);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
//		RequestDispatcher rd = request.getRequestDispatcher("/courseMaintain/updateCourseSuccess.jsp");
//		rd.forward(request, response);
//		return;
	}
	
}
