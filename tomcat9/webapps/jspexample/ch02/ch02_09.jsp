<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta charset="UTF-8">	
<link rel='stylesheet' href='<c:url value="/css/styles.css" />'  type="text/css" />
<title>要求瀏覽器不要Cache回應</title>
<style type="text/css">
table, th, td {
  border: 1px solid;
}
</style>
</head>
<body>
<div align='center'>
<table>
   <tr><th>Cache回應之範例展示(JQuery)</th></tr>  
</table>
<hr>
<div id="currentTime">目前時間為...</div>
<p />
<table border='1'>
   <tbody>
      <tr><td>瀏覽器</td><td>${browser}</td></tr>
      <tr><td>訊息</td><td>${msg}</td></tr>
      <tr><td>現在時間</td><td>${timeNow}</td></tr>
   </tbody>
</table>
<p />

<small>&lt;&lt;<a href="<c:url value='/ch02/index.jsp' />">回前頁</a>&gt;&gt;</small>
</div>
</body>
</html>