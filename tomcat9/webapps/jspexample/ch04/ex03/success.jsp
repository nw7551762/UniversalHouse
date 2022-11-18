<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
<link rel='stylesheet' href='<c:url value="/css/styles.css" />'  type="text/css" />
<meta charset="UTF-8">
<title>MVC</title>
</head>
<body>
<h1>MVC (Database)</h1>
<h3>新增資料至資料庫時，如新增成功, 以success.jsp來顯示本畫面)</h3>
<Font color='blue' >親愛的${ userIdKey }您好，您的輸入資料已經處理完畢</font>
<p/>感謝您加入成為會員，請開始使用本系統<p/>
<small>&lt;&lt;<a href="<c:url value="/ch04/index.jsp" />">回第四章首頁</a>&gt;&gt;</small>
</body>
</html>