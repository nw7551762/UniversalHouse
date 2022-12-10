<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Save Project Success</title>
</head>
<body>
	<div>
		<c:choose>
			<c:when test="${empty project}">
				<h2>案件新增失敗</h2>
			</c:when>

			<c:otherwise>
				<h2>案件新增成功</h2>
			</c:otherwise>

		</c:choose>
		<a href="<c:url value='/' />">回首頁</a>
	</div>
</body>
</html>