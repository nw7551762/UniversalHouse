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
<form action="<c:url value='/DeleteAllServlet'/>" name="field" method="post"
		enctype="multipart/form-data">
		

		<!-- -->


		<button type="submit">送出</button>
	</form>

</body>
</html>