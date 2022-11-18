<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<link rel='stylesheet' href='<c:url value="/css/styles.css" />'  type="text/css" />
<meta charset="UTF-8">
<title>RequestDispatcher</title>
</head>
<body>
<div align='center'>
<h2>Request Dispatcher</h2>
Controller 所選取的數字為 ${anInteger}
<P/>要按F5重新整理，觀察差異(數字會改變)
<br><br><hr><br>
<small>&lt;&lt;<a href="${header['referer']}">再試一次</a>&gt;&gt;</small>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<small>&lt;&lt;<a href="<c:url value='/ch04/index.jsp' />">回第四章首頁</a>&gt;&gt;</small>
</div>
</body>
</html>