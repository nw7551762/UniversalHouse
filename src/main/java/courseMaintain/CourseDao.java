package courseMaintain;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class CourseDao {

	DataSource ds = null;

	public CourseDao() {
		try {
			Context context = new InitialContext();
			ds = (DataSource) context.lookup("java:comp/env/jdbc/MemberDB");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	// 新增
	public void addCourse(CourseBean cb) throws SQLException {
		String sql = "insert into course values (?,?,?,?,?,?,?,?,?,?)";
		try (Connection con = ds.getConnection(); PreparedStatement ps = con.prepareStatement(sql);) {
//			ps.setInt(1, cb.getCourseId());
			ps.setString(1, cb.getCourseName());
			ps.setString(2, cb.getCategory());
			ps.setString(3, cb.getTeacher());
			ps.setInt(4, cb.getPrice());
			ps.setString(5, cb.getCourseType());
			ps.setString(6, cb.getStartDate());
			ps.setString(7, cb.getEndDate());
			ps.setString(8, cb.getStartTime());
			ps.setString(9, cb.getEndTime());
			ps.setBlob(10, cb.getImage());
			ps.executeUpdate();

			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 刪除
	public void deleteById(Integer courseId) {
		String sql = "delete from course where courseId = ?";
		try (Connection con = ds.getConnection(); PreparedStatement ps = con.prepareStatement(sql);) {
			ps.setInt(1, courseId);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 修改
	public int updateById(CourseBean cb) {
		int n = 0;
		String sql = "update course set courseName=?, category=?, teacher=?, price=?, courseType=?, startDate=?, endDate=?, startTime=?, endTime=?, image=? where courseId = ?";

		try (Connection connection = ds.getConnection(); PreparedStatement ps = connection.prepareStatement(sql);) {
			ps.setString(1, cb.getCourseName());
			ps.setString(2, cb.getCategory());
			ps.setString(3, cb.getTeacher());
			ps.setInt(4, cb.getPrice());
			ps.setString(5, cb.getCourseType());
			ps.setString(6, cb.getStartDate());
			ps.setString(7, cb.getEndDate());
			ps.setString(8, cb.getStartTime());
			ps.setString(9, cb.getEndTime());
			ps.setBlob(10, cb.getImage());
			n = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n;
	}

	// 查詢所有getAllCourse
	List<CourseBean> courseList = new ArrayList<CourseBean>();

	public List<CourseBean> getAllCourse() {
		String sql = "select * from course";
		try (Connection connection = ds.getConnection(); PreparedStatement ps = connection.prepareStatement(sql);) {
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				CourseBean c = new CourseBean();
				c.setCourseId(rs.getInt("courseId"));
				c.setCourseName(rs.getString("courseName"));
				c.setCategory(rs.getString("category"));
				c.setTeacher(rs.getString("teacher"));
				c.setPrice(rs.getInt("price"));
				c.setCourseType(rs.getString("courseType"));
				c.setStartDate(rs.getString("startDate"));
				c.setEndDate(rs.getString("endDate"));
				c.setStartTime(rs.getString("startTime"));
				c.setEndTime(rs.getString("endTime"));
				c.setImage(rs.getBlob("image"));
				courseList.add(c);
			}
			rs.close();
			ps.close();

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return courseList;
	}

	// 用ID查詢findById
	public CourseBean findById(Integer courseId) throws SQLException {
		String sql = "SELECT * FROM course WHERE courseId =?";

		try (Connection connection = ds.getConnection(); PreparedStatement ps = connection.prepareStatement(sql);) {
			ps.setInt(1, courseId);

			ResultSet rs = ps.executeQuery();
			CourseBean cb = new CourseBean();
			cb.setCourseId(rs.getInt("courseId"));
			cb.setCourseName(rs.getString("courseName"));
			cb.setCategory(rs.getString("category"));
			cb.setTeacher(rs.getString("teacher"));
			cb.setPrice(rs.getInt("price"));
			cb.setCourseType(rs.getString("courseType"));
			cb.setStartDate(rs.getString("startDate"));
			cb.setEndDate(rs.getString("endDate"));
			cb.setStartTime(rs.getString("startTime"));
			cb.setEndTime(rs.getString("endTime"));
			cb.setImage(rs.getBlob("image"));

			rs.close();
			ps.close();

			return cb;

		}

	}

	// 模糊查詢
	List<CourseBean> findByNameList = new LinkedList<CourseBean>();

	public List<CourseBean> findByNameLike(String courseName) {
		String sql = "select * from course where courseName like ?";
		try (Connection connection = ds.getConnection(); PreparedStatement ps = connection.prepareStatement(sql);) {
			ps.setString(1, "%" + courseName + "%");
			ResultSet rs = ps.executeQuery();

			CourseBean c = new CourseBean();
			while (rs.next()) {
				c.setCourseId(rs.getInt("courseId"));
				c.setCourseName(rs.getString("courseName"));
				c.setCategory(rs.getString("category"));
				c.setTeacher(rs.getString("teacher"));
				c.setPrice(rs.getInt("price"));
				c.setCourseType(rs.getString("courseType"));
				c.setStartDate(rs.getString("startDate"));
				c.setEndDate(rs.getString("endDate"));
				c.setStartTime(rs.getString("startTime"));
				c.setEndTime(rs.getString("endTime"));
				c.setImage(rs.getBlob("image"));
				findByNameList.add(c);
			}

			rs.close();
			ps.close();

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return findByNameList;
	}
}
//    	ps.setString(1, "%" + courseName + "%");
//    	ResultSet rs = ps.executeQuery();
//    	
//    	List<Course> list = new LinkedList<Course>();
//    	
//    	while(rs.next()) {
//    		Course c = new Course();
//    		c.setCourseId(rs.getInt("courseId"));
//			c.setCourseName(rs.getString("courseName"));
//			c.setCategory(rs.getString("category"));
//			c.setTeacher(rs.getString("teacher"));
//			c.setPrice(rs.getInt("price"));
//			c.setCourseType(rs.getString("courseType"));
//			c.setStartDate(rs.getString("startDate"));
//			c.setEndDate(rs.getString("endDate"));
//			c.setStartTime(rs.getString("startTime"));
//			c.setEndTime(rs.getString("endTime"));
//			list.add(c);
//    	}
//    	
//    	rs.close();
//    	preState.close();
//    	
//    	return list;
//
//	}
//
//}
