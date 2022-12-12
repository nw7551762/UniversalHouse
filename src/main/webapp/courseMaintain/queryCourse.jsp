<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>課程管理</title>
</head>

<body>
	<h1>課程一覽</h1>
	<hr>
	<a href="<c:url value='/' />">回首頁</a>
	<a href="<c:url value='/courseMaintain/addCourse.jsp' />">新增課程</a>
	<form action="<c:url value='/SearchCourseServlet' />" method="post">
		<p>
			查詢課程: <input type="search" name="courseName" placeholder="關鍵字">
			<input type="submit" name="query" value="search">
		</p>
	</form>
	<hr>
	
		<table border="1">
		<thead>
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
<!-- 				<th>圖片</th> -->
				<th>操作</th>
			</tr>
			</thead>
			<tbody id='tb'>
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
<%-- 						<td><img src="${course.image}"></td> --%>
						<td>
						<form action="<c:url value='/PreUpdateCourseServlet?courseId=${course.courseId}' />" method="post" ">
						<input type="submit" value="修改" >
						</form>
						<input type="button" value="刪除" class="delete">
						</td>
					</tr>	
			</c:forEach>
			</tbody>
		</table>
		<script src="https://code.jquery.com/jquery-3.6.1.min.js"></script>
		<script>
		
// 		course = {
// 				courseId:'',
// 				courseName:'',
// 				category:'',
// 				teacher:'',
// 				price:'',
// 				courseType:',
// 				startDate:'',
// 				endDate:'',
// 				startTime:'',
// 				endTime:'',
// 				image:'',			
// 		};
// 		var course = Object.create(course);
		$('#tb').on('click','.delete',function(){
			let courseId = $(this).parent().siblings().eq(0).text();
			$.ajax({
				type:'post',
				url:'<c:url value='/DeleteCourseServlet'/>',
				data:{
					courseId : courseId,
				},
				success:function(){
					alert("刪除成功")
// 					$.ajax({
// 						type:'post'
// 						url: '<c:url value='/courseMaintain/queryCourseServlet'/>'
// 					});
				},
				error:function(thrownError){
					alert("刪除失敗")
				}
			});
		})
		</script>
</body>

</html>