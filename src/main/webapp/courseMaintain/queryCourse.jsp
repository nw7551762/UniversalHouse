<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>query course</title>
</head>

<body>
	<h1>查詢課程</h1>
	<hr>
	<a href="<c:url value='/maintainIndex.jsp' />">回上一頁</a>
	<hr>
	
	
		<table border="1">
			<tr>
				<th>課程代號</th>
				<th>課程名稱</th>
				<th>類別</th>
				<th>教師</th>
				<th>價錢</th>
				<th>上課形式</th>
				<th>開課日期</th>
				<th>結束日期</th>
				<th>開始時間</th>
				<th>結束時間</th>
				<th>圖片</th>
				<th>操作</tr>
			<c:forEach items="${list}" var="course">
				
					<tr>
						<td>${course.courseId}</td>
						<td>${course.courseName}</td>
						<td>${course.category}</td>
						<td>${course.teacher}</td>
						<td>${course.price}</td>
						<td>${course.courseType}</td>
						<td>${course.startDate}</td>
						<td>${course.endDate}</td>
						<td>${course.startTime}</td>
						<td>${course.endTime}</td>
						<td><img src="${course.image}"></td>
						<td><input type="button" value="修改" id="reviseProject">
				<input type="button" value="刪除" id="delete"></td>

					</tr>
				
			</c:forEach>
		</table>
	
</body>

</html>