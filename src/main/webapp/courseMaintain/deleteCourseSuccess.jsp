<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Delete Course Success</title>
</head>
<body>
<div>

<c:choose>
<c:when test="${empty course}">delete successful!</c:when>
<c:otherwise>unsuccessful!</c:otherwise>
</c:choose>
<a href="<c:url value='/' />">回首頁</a>
</div>
</body>
</html>