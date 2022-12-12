<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert Result</title>
</head>
<body>
<c:choose>
<c:when test="${empty space}">
	<h3>OOPS!!</h3>
	insert UNSUCCESSFUL !!!
</c:when>
<c:otherwise>
   <h2>${space.spaceName}  </h2>	
   <h3>insert success!!!</h3>
   <br>
   <br>
   </c:otherwise>

</c:choose>

<form >


</form>



<a href="<c:url value='/spaceAdmin/showAllSpaceServlet' />">Back To Show All Data</a>
<p></p>
<p></p>
	<a href="<c:url value='/' />">Back To Topic2</a>
</body>
</html>