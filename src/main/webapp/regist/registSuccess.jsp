<<<<<<< HEAD
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
<c:choose>
   <c:when test="${empty member}">
   		regist fail
   </c:when>
   
   <c:otherwise>
   		${member.name} regist success
   </c:otherwise>
  
</c:choose>
<a href="<c:url value='/' />">回首頁</a>
</body>
=======
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	h1{
		color: lightred;
	}
</style>
</head>
<body>
	
<c:choose>
   <c:when test="${empty member}">
   		regist fail
   </c:when>
   
   <c:otherwise>
   <h1>Regist Success</h1>
   		Welcom User: ${member.name} <br>
   </c:otherwise>
  
</c:choose>
<a href="<c:url value='/' />">回首頁</a>
</body>
>>>>>>> 70903c257652f471bee4a0ba774da67e72517659
</html>