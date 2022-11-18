<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<link rel='stylesheet' href='<c:url value="/css/styles.css" />'  type="text/css" />
<meta charset="UTF-8">
<title>查詢明牌(JSP+JavaBean版 )</title>
</head>
<body>
<h1>使用JSP+JavaBean來產生樂透號碼</h1>
<UL>
  <li><a href="BigLottery.jsp">大樂透(六個介於1-49的數字)</a></li>
  <li><a href="MidLottery.jsp">中樂透(六個介於1-42的數字)</a></li>
  <li><a href="SmallLottery.jsp">小樂透(五個介於1-39的數字)</a></li>
  <li><a href="FourStarsLottery.jsp">四星彩(四個可重複，介於0-9的數字)</a></li>   
</UL>
<div align="center">
   <BR><BR>
   <small>&lt;&lt;<a href="<c:url value='/ch05/index.jsp' />">回第五章首頁</a>&gt;&gt;</small>
</div>
</body>
</html>