package courseMaintain;

import java.sql.SQLException;
import java.util.List;

public class CourseService {

	private CourseDao cDao = new CourseDao();
	
//	查詢所有課程
	public List<CourseBean> getAllCourse(){
		 return cDao.getAllCourse();	
	}
}
