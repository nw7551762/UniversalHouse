<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<link rel='stylesheet' href='<c:url value="/css/styles.css" />'  type="text/css" />
<meta charset="UTF-8">
<title>SendRedirect vs. RequestDispatcher的比較</title>
</head>
<body>
<div align='center'>
<h2>SendRedirect 與 RequestDispatcher的比較</h2>
<br>
<a href="<c:url value='/ch04/ex01/SendRedirect.do' />">產生隨機數字--使用 Send Redirect</a><P/>
<a href="<c:url value='/ch04/ex01/RequestDispatcher.do' />">產生隨機數字--使用 Request Dispatcher</a>
<br><hr><br>
<small>&lt;&lt;<a href="<c:url value='/ch04/index.jsp' />">回第四章首頁</a>&gt;&gt;</small>
</div>
</body>
</html>