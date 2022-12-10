<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>modifyMemberInfo</title>
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
	<c:if test="${ ! empty sessionScope.timeOut }">
		<!-- 表示使用逾時，重新登入 -->
		<c:set var="msg" value="${sessionScope.timeOut}</font>" />
	</c:if>
	<form action="<c:url value='/modify/modifyByMember.do' />"
		method="post" enctype="multipart/form-data">
		<p>
			<label class="t1" for="memberId">memberId:</label>
			${cookie['memberId'].getValue()}
		</p>

		<p>
			<label class="t1" for="name">name:</label> <input type="text"
				name="name" value=" ${LoginOK.name }">
		</p>

		<p>
			<label class="t1" for="password">password:</label> <input type="text"
				name="password" value=" ${LoginOK.password }">
		</p>

		<p>
			<label for="location" class="t1">location:</label> <input type="text"
				name="location" value=" ${LoginOK.location }">
		</p>

		<p>
			<label class="t1" for="email">email:</label> <input type="text"
				name="email" value=" ${LoginOK.email }">
		</p>

		<p>
			<label for="phone" class="t1">phone:</label> <input type="text"
				name="phone" value=" ${LoginOK.phone }">
		</p>

		<p><img src="<c:url value='/ShowMemberImgServlet?memberId=${LoginOK.memberId } '/>"
								alt="no img" width="200px" height="150px">
			<label for="memberImage" class="t1">memberImage:</label> <input
				type="file" name="memberImage" value="${ LoginOK.memberImage }">
		</p>
		<p>
		</p></p>


		<input id="submit" type="submit" value="送出">
	</form>

</body>
</html>