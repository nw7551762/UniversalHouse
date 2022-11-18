<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>查詢名牌</title>
</head>
<body>
<div align='center'>
<h2>查詢名牌</h2> 
<form action="<c:url value='/ch01/LotteryServlet' />" method="POST"> 
    訪客姓名:<input type="text" name="visitor" size = "10"><p/>
         <input type="submit" value="確定"><p/>
</form>
<p>
<a href="<c:url value='/' />" >回首頁</a>
</div>
</body>
</html>

	