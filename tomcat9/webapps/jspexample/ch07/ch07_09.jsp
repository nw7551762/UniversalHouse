<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<link rel='stylesheet' href='<c:url value="/css/styles.css" />'  type="text/css" />
<meta charset="UTF-8">	
<title>ServletContext</title>
</head>
<body>
	<h2>getContextPath()與getServletContextName()的比較</h2>
		<p>
			request.getContextPath() = ${rcp}<br> 
			context.getContextPath() = ${ccp}<br> 
			context.getServletContextName() = ${cscn}<br>
		</p>

<p/>
<BR><BR><HR>
<small>&lt;&lt;<a href="index.jsp">回前頁</a>&gt;&gt;</small>
</body>
</body>
</html>