<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>修改課程</title>
<style>
        .t1 {
            width:100px;
            float:left;
            text-align:right;
            margin-right: 10px;
        }
    </style>
</head>
<body>
<form action="<c:url value='/UpdateCourseServlet' />" method="POST" enctype="multipart/form-data">
 		<p> 
  			<label class="t1" for="courseId">課程代號:</label>
 			<input type="text" name="courseId" value="${update.courseId}"> 
 		</p>

		<p>
			<label class="t1" for="courseName">課程名稱:</label> <input type="text"
				name="courseName" value="${update.courseName}">
		</p>

		<p>
			<label class="t1" for="category">類別:</label> <input type="text"
				name="category"  value="${update.category}">
		</p>

		<p>
			<label class="t1" for="teacher">教師:</label> <input type="text"
				name="teacher" value="${update.teacher}" >
		</p>

		<p>
			<label class="t1" for="price">價錢:</label> <input type="text"
				name="price" value="${update.price}">
		</p>

		<p>
			<label class="t1" for="courseType">上課形式:</label> <input type="text"
				name="courseType" value="${update.courseType}">
		</p>
		<p>
			<label class="t1" for="startDate">開課日期:</label> <input type="text"
				name="startDate" value="${update.startDate}">
		</p>
		<p>
			<label class="t1" for="endDate">結束日期:</label> <input type="text"
				name="endDate" value="${update.endDate}">
		</p>
		<p>
			<label class="t1" for="startTime">開始時間:</label> <input type="text"
				name="startTime" value="${update.startTime}">
		</p>
		<p>
			<label class="t1" for="endTime">結束時間:</label> <input type="text"
				name="endTime" value="${update.endTime}">
		</p>
<!-- 		<p> -->
<!-- 			<label class="t1" for="image">圖片:</label> <input -->
<!-- 				type="file" name="image"> -->
<!-- 		</p> -->


		<input id="submit" type="submit" value="送出">
	</form>
</body>
</html>