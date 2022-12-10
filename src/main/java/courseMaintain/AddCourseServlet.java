package courseMaintain;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import regist.MemberBean;
import regist.MemberDao;

@MultipartConfig
@WebServlet("/AddCourseServlet")
public class AddCourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}


	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
//		resp.setCharacterEncoding("UTF-8");
//		resp.setContentType("text/html;charset=utf-8"); 
//        PrintWriter printWriter = resp.getWriter();
        
        CourseDao cdao = new CourseDao();
		CourseBean course = new CourseBean();
		
//		if(!req.getParameter("courseId").equals("")) {
//			course.setCourseId(Integer.parseInt(req.getParameter("courseId")));
//		};
		course.setCourseName(req.getParameter("courseName"));
		course.setCategory(req.getParameter("category"));
		course.setTeacher(req.getParameter("teacher"));
		if(!req.getParameter("price").equals("")){
			course.setPrice(Integer.parseInt(req.getParameter("price")));
		};
		course.setCourseType(req.getParameter("courseType"));
		course.setStartDate(req.getParameter("startDate"));
		course.setEndDate(req.getParameter("endDate"));
		course.setStartTime(req.getParameter("startTime"));
		course.setEndTime(req.getParameter("endTime"));
		//course.setImage(req.getParameter("image"));
		try {
			cdao.addCourse(course);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		req.setAttribute("course", course);
		RequestDispatcher rd = req.getRequestDispatcher("/courseMaintain/addCourseSuccess.jsp");
		rd.forward(req, resp);
		return;
	}

}
