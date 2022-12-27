<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>表單列表</title>

</head>
<body>

	<table>

		<tr><th>搜尋結果</th></tr>
		
		<tr>
			<td id='borderA'>文章呈現</td>
			<td id='borderA'>文章編號</td>
			<td id='borderA'>更新時間</td>
			<td id='borderA'>領域</td>
			<td id='borderA'>標題</td>
		</tr>
		
		<c:forEach var="articleList" varStatus="stat" items="${articleList}">
		
			<tr>
				<td>
				
				<form method="POST" action="<c:url value='/deleteArticle'/>">
					<input type="hidden" name="articleId" value="${articleList.articleId}">
					<input type="submit" value="刪除">
				</form>	
				
				<form method="POST" action="<c:url value='/showArticle'/>">
					<input type="hidden" name="articleId" value="${articleList.articleId}">
					<input type="submit" value="觀看內文">
				</form>	
	
				<td>${articleList.articleId}</td>
				<td>${articleList.updateTime}</td>
				<td>${articleList.topicName}</td>
				<td>${articleList.title}</td>
			</tr>
			
		</c:forEach>
	</table>
	
	<a href="<c:url value='/FrontPage' />">回首頁</a>
</body>

</html>