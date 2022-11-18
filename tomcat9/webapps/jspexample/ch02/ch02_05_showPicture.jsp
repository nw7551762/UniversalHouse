<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<link rel='stylesheet' href='<c:url value="/css/styles.css" />'  type="text/css" />
<meta charset="UTF-8">
<title>美美的圖片</title>
</head>
<body Bgcolor="#CCFF99">
<div align='center'>
<table border="1">
<tr><td><img width='576' height='384' SRC="<c:url value='/ch02/ShowPictureServlet' />"></td></tr>
</table> 
<a href="<c:url value='/ch02/ch02_05.jsp' />">回前頁</a>
</div>
</body>
</html>