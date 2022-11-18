<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>報明牌</title>
</head>
<body>
<div align='center'>
<h2>卜籤求明牌</h2>   
${visitName}，您好，<p/>  
您的明牌為：${luckyNumber}
<p>
<a href="<c:url value='/' />" >回首頁</a>
</div>
</body>
</html>