<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<style>
#borderA {
	border: 1px solid;
}
</style>
</head>
<body>
<c:set var="memberId" value="${cookie['user'].getValue()}" />

		<form id="borderA" method="POST" action="<c:url value='/newMessage_BS' />" enctype='multipart/form-data'>
			
			<input type="hidden" name="memberId" value="${memberId}"> 
			<input type="hidden" name="id" value="${param.articleId}">
			<textarea name="content" placeholder="我覺得..." required></textarea>
			<input type="submit" name="submit" value="發表" />
			
		</form>
		
</body>

</html>