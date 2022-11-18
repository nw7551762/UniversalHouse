<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta charset="UTF-8">
<link rel='stylesheet' href='<c:url value="/css/styles.css" />'  type="text/css" />	
<title>利用表單輸入資料(POST)</title>
</head>
<body>
利用表單輸入資料(POST)                     
<hr>
<form action="<c:url value='/ch02/survey.do' />" method="POST">
      <p/>姓名:  <input type="text" name="userName" value="李大華">
      <p/>EMail: <input type="text" name="eMail"    value="user@ppp.com.tw">
      <p/>電話號碼 <input type="text" name="tel">
      <HR>
      請挑選喜歡的水果:<P/>
      <input TYPE='checkbox' NAME='fruit' VALUE='香蕉'> 香蕉 <br>
      <input TYPE='checkbox' NAME='fruit' VALUE='橘子'> 橘子 <br>
      <input TYPE='checkbox' NAME='fruit' VALUE='蘋果'> 蘋果 <br>
      <input TYPE='checkbox' NAME='fruit' VALUE='西瓜'> 西瓜 <br>
      <input TYPE='checkbox' NAME='fruit' VALUE='梨子'> 梨子 <br><p/>
      <input type="submit" value="提交">
</form>
<br><p/>
<small>&lt;&lt;<a href="<c:url value='/ch02/index.jsp' />">回前頁</a>&gt;&gt;</small>
</body>
</html>
