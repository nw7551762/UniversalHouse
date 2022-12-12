<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>新增留言</title>

</head>
<body onLoad="setFocusToUserId()">
	<div align='left' id="content">

		<form method="POST" action="<c:url value='/newMessage' />" enctype='multipart/form-data'>
			<c:set var="memberId" value="${cookie['user'].getValue()}" />
			<input type="hidden" name="memberId" value="${memberId}">
			<input type="hidden" name="id" value="${param.articleId}">
			<textarea name="content" placeholder="我覺得..." required></textarea>
			<br> <input type="submit" name="submit" value="發表留言" />
		</form>
	</div>
</body>
</html>