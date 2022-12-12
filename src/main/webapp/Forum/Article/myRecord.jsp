<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>我的專區</title>

</head>
<body style="background: #EBFFEB;">

	<c:set var="memberId" value="${cookie['user'].getValue()}" />

	<a href="<c:url value='/searchRecord?id=${memberId}' />">我的紀錄</a>
	
<!-- 	<div> -->
<%-- 		<a href="<c:url value='/searchRecord?authorId=${authorId}' />">我的最愛(未完成)</a> --%>
<!-- 	</div> -->
	
	<a href="<c:url value='/FrontPage' />">回首頁</a>
	
</body>

</html>