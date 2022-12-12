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
	<form action="<c:url value='/DeleteAllServlet'/>" method="post"
		enctype="multipart/form-data">


		<!-- -->
		<h1>刪除測驗</h1>
		<select name="field">
			<option value="1">心理測驗</option>
			<option value="2">智力測驗</option>
			<option value="3">魷魚遊戲</option>
			<option value="4">星座測驗</option>
			<option value="5">小小試題</option>
		</select>

		<button type="submit">送出</button>
	</form>

</body>
</html>