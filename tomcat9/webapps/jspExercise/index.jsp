<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP 課堂作業</title>
</head>
<body>
<h1>JSP 課堂作業</h1>
<a href="<c:url value='/ch01/queryLottery.jsp' />">問單一明牌</a><p/>
<a href="<c:url value='/ch02/SendHtmlServlet?amt=100&type=abc' />">由servlet文字發送資料</a><p/>
<a href="<c:url value='/ch02//SendBinaryData' />">由servlet發送非文字資料</a><p/>
<a href="<c:url value='/ch02/showPictures.jsp' />">由servlet顯示多張圖片</a><p/>
<a href="<c:url value='/ch02/SendRedirect.do' />">sendRedirect</a><p/>
</body>
</html>