package courseMaintain;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@MultipartConfig
@WebServlet("/queryCourseServlet")
public class queryCourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		CourseDao cDao = new CourseDao();
//		CourseBean courseBean = new CourseBean();

		List<CourseBean> courseList = cDao.getAllCourse();
		req.setAttribute("list", courseList);
		req.getRequestDispatcher("/courseMaintain/queryCourse.jsp").forward(req, resp);
		return;

	}

}
