<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
h1 {
	color: lightred;
}
</style>
</head>
<body onload="window.setInterval(backHome, 1000)">

	<c:choose>
		<c:when test="${empty member}">
   			regist fail
   			
   		</c:when>

		<c:otherwise>
			<h1>Regist Success</h1>
   			<p>Welcom User: ${member.name} </p>
  			
		</c:otherwise>

	</c:choose>
	<div id="ShowBox"></div>
	
	<a href="<c:url value='/' />">回首頁</a>



	<script src="https://code.jquery.com/jquery-3.6.1.min.js"></script>
	<script>
		var i = 5;
		function backHome(){
			i--;
		    document.getElementById('ShowBox').innerText= i+'秒鐘之後返回首頁' ;
		    if (i <= 1) {
				//		window.clearInterval(tm);
						window.location.href = "<c:url value='/index.jsp'/>";
					}
		}
		
	</script>


</body>
</html>