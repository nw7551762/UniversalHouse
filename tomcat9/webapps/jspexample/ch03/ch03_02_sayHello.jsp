<%@ page language="java" contentType="text/html; charset=UTF-8"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<link rel='stylesheet' href='<c:url value="/css/styles.css" />'  type="text/css" />
<title>理解JSP的原理</title>
</head>
<body>
<h1>
		<%
		int times = 5 ; 
		try { 
		    times=Integer.parseInt(request.getParameter("times"));
		} catch(NumberFormatException e) {
			;
		}
		for (int i = 0; i < times;i++) {
		    out.println(" Hello, World! ");
		    out.println("<br>");
		}
		%>
		</h1>
<p/>
<a href="<c:url value='/ch03/index.jsp' />" ><small>回第三章首頁</small></a>
	</body>
</html>
