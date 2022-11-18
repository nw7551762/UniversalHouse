<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<link rel='stylesheet' href='<c:url value="/css/styles.css" />'  type="text/css" />
<meta charset="UTF-8">
<title>樂透明牌</title>
</head>
<body>
<div align='center'>
<h2>本範例說明如何設定Servlet的起始參數</h2>

起始參數 discount：${discount}<br><p/>
起始參數 VAT：${VAT}<br><p/>

<hr>
<small>&lt;&lt;<a href="<c:url value='/ch07/index.jsp' />" >回前頁</a>&gt;&gt;</small>
</div>
</body>
</html>