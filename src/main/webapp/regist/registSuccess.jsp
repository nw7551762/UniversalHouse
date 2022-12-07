<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<<<<<<< HEAD
=======
<style>
	h1{
		color: lightred;
	}
</style>
>>>>>>> zshe
</head>
<body>
	
<c:choose>
   <c:when test="${empty member}">
   		regist fail
   </c:when>
   
   <c:otherwise>
<<<<<<< HEAD
   		${member.name} regist success
=======
   <h1>Regist Success</h1>
   		Welcom User: ${member.name} <br>
>>>>>>> zshe
   </c:otherwise>
  
</c:choose>
<a href="<c:url value='/' />">回首頁</a>
</body>
</html>