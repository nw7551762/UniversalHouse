<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>新增留言</title>
<c:set var="memberId" value="${cookie['user'].getValue()}" />

</head>
<body>


<form method="POST" action="<c:url value='/newMessage' />">

	<input type="hidden" name="memberId" value="${memberId}">
	<input type="hidden" name="articleId" value="${param.articleId}">
	<textarea name="content" placeholder="我覺得..." required></textarea>
	<input type="submit" value="發表留言" />
</form>

</body>

</html>