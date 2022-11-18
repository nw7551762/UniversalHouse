<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<link rel='stylesheet' href='<c:url value="/css/styles.css" />'  type="text/css" />
<meta charset="UTF-8">
<title>請先付款</title>
</head>
<body>
<div align='center'>
<h2>尚有前帳未清，請先付款後，再行訂購</h2>
<p/>
</div>
<jsp:include page="/commons/previousPage.jsp" />
</body>
</html>