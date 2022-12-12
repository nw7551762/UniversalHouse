<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>刪除課程</title>
<style>
.t1 {
	width: 120px;
	float: left;
	text-align: right;
	margin-right: 10px;
}
</style>
</head>
<body>
<form action="<c:url value='/DeleteCourseServlet' />" method="post">
	<p>
		<label class="t1" for="courseId">輸入課程代號:</label> <input type="text"
			name="courseId">
	</p>
	<input type="submit" value="送出">
</form>
</body>
</html>