<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>留言</title>
</head>

<body>
<h1>文章編號 [${article.articleId}] 的留言</h1>

	<table>
		<tr>
			<th colspan="6">留言資料庫</th>
		</tr>
			<tr>
			<td>作者編號</td>
			<td>最後更新時間</td>
			<td>內文</td>
			<td>修改</td>
			
		</tr>
		
		<c:forEach var="message" varStatus="stat" items="${messages}">
			<tr>
				<td>${message.authorId}</td>
				<td>${message.updateTime}</td>
				<td>${message.content}</td>
				<td>${message.status}</td>
				<td>${message.like}</td>
				<td>${message.dislike}</td>
				
				<td>
					<form method="POST" action="<c:url value='/deleteMessage_BS' />">
						<input type="hidden" name="articleId" value="${article.articleId}"> 
						<input type="hidden" name="messageId" value="${message.messageId}">
						<input type="submit" value="刪除留言">
					</form>
				</td>
				
			</tr>
			
		</c:forEach>
		
	</table>
	
	<jsp:include page="/forum/backSide/newMessage.jsp">
		<jsp:param name="articleId" value="${article.articleId}" />
	</jsp:include>
	
	<a href="<c:url value='/backSide' />">回前頁</a>
	
</body>

</html>