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
ul{
	list-style: none;
}
li{
	margin: 10px;
}
</style>
</head>
<body>
	<c:if test="${ ! empty sessionScope.timeOut }">
		<!-- 表示使用逾時，重新登入 -->
		<c:set var="msg" value="${sessionScope.timeOut}</font>" />
	</c:if>
	<form action="<c:url value='/modifyMemberInfo/modifyByMember.do' />"
		method="post" enctype="multipart/form-data">
		<ul>
			<li id ="memberId">
				<label for="memberId" class="t1">memberId:</label>
			</li>

			<li id ="name"><label class="t1" for="name">name:</label> <input
				type="text" name="name" value=" ${LoginOK.name }"></li>

			<li id="password"><label class="t1" for="password">password:</label> <input
				type="text" name="password" value=" ${LoginOK.password }"></li>
			<li id="location">
				<label for="location" class="t1">location:</label> <input
					type="text" name="location" value=" ${LoginOK.location }">
			</li>

			<li id="email">
				<label class="t1" for="email">email:</label> <input type="text"
					name="email" value=" ${LoginOK.email }">
			</li>

			<li id="phone">
				<label for="phone" class="t1">phone:</label> <input type="text"
					name="phone" value=" ${LoginOK.phone }">
			</li>

			<li>
				<img
					src="<c:url value='/ShowMemberImgServlet?memberId=${LoginOK.memberId } '/>"
					alt="no img" width="200px" height="150px"> <label
					for="memberImage" class="t1">memberImage:</label> <input
					type="file" name="memberImage" value="${ LoginOK.memberImage }">
			</li>
			<li id ="verification">
				<label for="verification" class="t1">verification:</label>
			</li>
			<li id ="permission">
				<label for="permission" class="t1">permission:</label>
			</li>
			
		</ul>

		<input id="submit" type="submit" value="送出">
	</form>
	 <a href="<c:url value='/' />">回首頁</a>
	<script src="https://code.jquery.com/jquery-3.6.1.min.js"></script>
	<script>
	$(function(){
		$('#verification').append( ${LoginOK.verification });
		$('#permission').append( ${LoginOK.permission });
		
		
		
	})
		
	
	</script>

</body>
</html>