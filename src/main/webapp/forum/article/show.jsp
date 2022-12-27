<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>文章結果</title>

</head>
<body>
	<c:set var="loginMemberId" value="${cookie['user'].getValue()}" />
	
	<div>
		<header><h1>${article.title}</h1></header>
		<h5>${article.articleId}-${article.authorId}</h5>
		<div>
		<h3>領域 : ${article.topicName}
		<br>
		作者
		<br>
		<img height="50" width="50" src="<c:url value='/getMemberImage?memberId=${member.memberId} ' />">
		${member.name}
		<br>
		${article.updateTime}</h3>
		<p>讚:${article.like}，不喜歡:${article.dislike}</p>
		</div>
		
		<c:forEach var="img" varStatus="stat" items="${imgs}">
			<img height="50" width="50" src="<c:url value='/getArticleImage?imgNo=${img.imgNo} ' />">
		</c:forEach>
		
		<div>
		<hr><p>${article.content}</p>
		</div>
	</div>
	<hr>
	<table>
		<tr>
			<th>留言</th>
		</tr>

		<c:forEach var="message" varStatus="stat" items="${messages}">
			<tr>
				<td><img height='50' width='50' src="<c:url value='/getMemberImage?memberId=${message.authorId} ' />"></td>
				<td>${message.updateTime}</td>
				<td>${message.content}</td>
			</tr>
		</c:forEach>

	</table>

	<div>
		<jsp:include page="/forum/message/newMessage.jsp">
			<jsp:param name="articleId" value="${article.articleId}" />
		</jsp:include>
	</div>

	<form method="POST" action="<c:url value='/searchRecord'/>">
		<input type="hidden" name="memberId" value="${loginMemberId}">
		<input type="submit" value="我的紀錄">
	</form>	

	<hr><a href="<c:url value='/frontPage' />">回首頁</a>
</body>

</html>