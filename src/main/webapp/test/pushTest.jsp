<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
.t1 {
	width: 100px;
	float: left;
	text-align: right;
	margin-right: 10px;
}
</style>
</head>
<body>

	<form action="<c:url value='/PushTestServlet'/>" method="post"
		enctype="multipart/form-data">
		

		<!-- -->
		<p>
			<label for="pushCsv" class="t1">存入測驗:</label> <input
				type="file" name="file"><button type="submit">送出</button>
		</p>


			
	</form>

			<a href="<c:url value='/test/PushTestImage.jsp' />">存入照片</a>

<a href="<c:url value='/' />" >回首頁</a>
</body>
</html>