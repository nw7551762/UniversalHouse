<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Course Success</title>
</head>
<body>

<c:choose>
<c:when test="${empty course}">新增失敗!</c:when>
<c:otherwise>新增成功!</c:otherwise>


</c:choose>



<div>
<a href="<c:url value='/' />">回首頁</a>
</div>

</body>
</html>