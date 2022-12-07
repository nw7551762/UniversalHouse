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
	<form action="<c:url value='/modify.do' />" method="post"
		enctype="multipart/form-data">
		<p>
			<label class="t1" for="memberId">memberId:</label> <input type="text"
				name="memberId">
		</p>

		<p>
			<label class="t1" for="name">name:</label> <input type="text"
				name="name">
		</p>

		<p>
			<label class="t1" for="password">password:</label> <input type="text"
				name="password">
		</p>

		<p>
			<label for="location" class="t1">location:</label> <input type="text"
				name="location">
		</p>

		<p>
			<label class="t1" for="email">email:</label> <input type="text"
				name="email">
		</p>

		<p>
			<label for="phone" class="t1">phone:</label> <input type="text"
				name="phone">
		</p>

		<!-- -->
		<p>
			<label for="memberImage" class="t1">memberImage:</label> <input
				type="file" name="memberImage">
		</p>


		<input id="submit" type="submit" value="送出">
	</form>



</body>
</html>