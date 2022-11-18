<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<link rel='stylesheet' href='<c:url value="/css/styles.css" />'  type="text/css" />
<meta charset="UTF-8">
<title>ServletContext起始化參數</title>
</head>
<body>
<div align='center'>
<h1>ServletContext起始化參數</h1>
<br>
透過getServletContext().getInitParameter("adminEmail")方法，<br>
可以讀入定義在<c:out value='<context-param>' />內的起始參數<br>
<hr>
起始參數adminEmail：<font color='red'>${adminEmail}</font><br>
<p/>
<jsp:include page="/commons/previousPage.jsp" />
</div>
</body>
</html>