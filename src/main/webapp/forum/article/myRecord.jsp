<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>我的專區</title>

</head>
<body>

	<c:set var="authorId" value="${cookie['user'].getValue()}" />

	<form method="POST" action="<c:url value='/searchRecord'/>">
		<input type="hidden" name="memberId" value="${authorId}">
		<input type="submit" value="我的紀錄">
	</form>	
	
	<a href="<c:url value='/frontPage' />">回首頁</a>
	
</body>

</html>