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
<c:when test="${empty course}">unsuccessful</c:when>
<c:otherwise>add successful!</c:otherwise>


</c:choose>



<div>
<a href="<c:url value='/' />">回首頁</a>
</div>

</body>
</html>