package courseMaintain;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;
import java.sql.Timestamp;

import javax.servlet.http.Part;
import javax.sql.rowset.serial.SerialBlob;
import javax.sql.rowset.serial.SerialException;

public class CourseBean {

	private Integer courseId;
	private String courseName;
	private String category;
	private String teacher;
	private Integer price;
	private String courseType;
	private String startDate;
	private String endDate;
	private String startTime;
	private String endTime;
	private Blob image;
	
	public Blob partToBlob(Part part ) throws IOException, SerialException, SQLException {
		//partImage轉inputstream
		InputStream is =  part.getInputStream();
		long len = part.getSize();
		
		byte[] b = new byte[(int) len];
		//is資料寫入byte矩陣
		is.read(b);
		Blob blob = null;
		//SerialBlob建構子 new一個Blob物件
		blob = new SerialBlob(b);
		
		return blob;
	}
	
	public CourseBean() {
		this.courseId = 0;
		this.courseName ="";
		this.category = "";
		this.teacher = "";
		this.price = 0;
		this.courseType = "";
		this.startDate = "";
		this.endDate = "";
		this.startTime = "";
		this.endTime = "";
		Blob blob =null;
	}



	public CourseBean(Integer courseId, String courseName, String category, String teacher, Integer price,
			String courseType, String startDate, String endDate, String startTime, String endTime) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
		this.category = category;
		this.teacher = teacher;
		this.price = price;
		this.courseType = courseType;
		this.startDate = startDate;
		this.endDate = endDate;
		this.startTime = startTime;
		this.endTime = endTime;
	}

	public CourseBean(Integer courseId, String courseName, String category, String teacher, Integer price,
			String courseType, String startDate, String endDate, String startTime, String endTime, Blob image) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
		this.category = category;
		this.teacher = teacher;
		this.price = price;
		this.courseType = courseType;
		this.startDate = startDate;
		this.endDate = endDate;
		this.startTime = startTime;
		this.endTime = endTime;
		this.image = image;
	}


	public Integer getCourseId() {
		return courseId;
	}



	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}



	public String getCourseName() {
		return courseName;
	}



	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}



	public String getCategory() {
		return category;
	}



	public void setCategory(String category) {
		this.category = category;
	}



	public String getTeacher() {
		return teacher;
	}



	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}



	public Integer getPrice() {
		return price;
	}



	public void setPrice(Integer price) {
		this.price = price;
	}



	public String getCourseType() {
		return courseType;
	}



	public void setCourseType(String courseType) {
		this.courseType = courseType;
	}



	public String getStartDate() {
		return startDate;
	}



	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}



	public String getEndDate() {
		return endDate;
	}



	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}



	public String getStartTime() {
		return startTime;
	}



	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}



	public String getEndTime() {
		return endTime;
	}



	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}



	public Blob getImage() {
		return image;
	}



	public void setImage(Blob image) {
		this.image = image;
	}



	@Override
	public String toString() {
		return "CourseBean [courseId=" + courseId + ", courseName=" + courseName + ", category=" + category
				+ ", teacher=" + teacher + ", price=" + price + ", courseType=" + courseType + ", startDate="
				+ startDate + ", endDate=" + endDate + ", startTime=" + startTime + ", endTime=" + endTime + ", image="
				+ image + "]";
	}
	
	
}
