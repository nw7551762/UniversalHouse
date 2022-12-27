<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>新增留言</title>
<c:set var="memberId" value="${cookie['user'].getValue()}" />
</head>
<body>

		<form method="POST" action="<c:url value='/newMessage_BS' />">
		
			<input type="hidden" name="memberId" value="${memberId}"> 
			<input type="hidden" name="articleId" value="${param.articleId}">
			
			<br>
			
			<textarea name="content" placeholder="我覺得..." required></textarea>
			
			<br>
			
			<select name="status">
				<option value="public" selected>公開</option>
				<option value="hidden">隱藏</option>
				<option value="deleted">用戶端刪除</option>
				<option value="banned">封禁</option>
			</select>
						
			<br>
			
			<input type="submit" value="發表" />	
			
		</form>
		
</body>

</html>