<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<link rel='stylesheet' href='<c:url value="/css/styles.css" />'  type="text/css" />
<meta charset="UTF-8">
<title>我們搬新家了</title>
</head>
<body>
<div align='center'>
<h3><font color='blue'>我們搬新家了，您的瀏覽器將在${nSec}秒後自動前往新網址</font></h3>
<br><p/>
<small>&lt;&lt;<a href="<c:url value='/ch02/index.jsp' />">回前頁</a>&gt;&gt;</small>
</div>
</body>
</html>