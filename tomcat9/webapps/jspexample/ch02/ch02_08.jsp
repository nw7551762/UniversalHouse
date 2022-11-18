<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.Date"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<link rel='stylesheet' href='<c:url value="/css/styles.css" />'  type="text/css" />    
<meta charset="UTF-8">
<title>10秒後自動更新畫面</title>
</head>
<body>
<div align='center'>
您的瀏覽器將在 ${n} 秒後自動更新畫面<BR>
現在時間：${now}<br>
<hr>
<small><a href="<c:url value='/ch02' />">回第二章首頁</a></small>
</div>
</body>
</html>