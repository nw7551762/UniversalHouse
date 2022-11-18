<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<link rel='stylesheet' href='<c:url value="/css/styles.css" />'  type="text/css" />
<meta charset="UTF-8">
<title>系統繁忙中</title>
</head>
<body>
<div align='center'>
<h2>系統繁忙中，請稍後再次重新執行本程式</h2>
</div>
<p/>
<jsp:include page="/commons/previousPage.jsp" />
</body>
</html>