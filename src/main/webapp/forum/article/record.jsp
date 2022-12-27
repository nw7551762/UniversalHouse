<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>我的發文紀錄</title>

</head>
<body>

	<table>
		<tr><th>您的發文紀錄</th></tr>
		
		<tr>
			<td>文章編號</td>
			<td>更新時間</td>
			<td>標題</td>
			<td>更新</td>
		</tr>
		
		<c:forEach var="article" varStatus="stat" items="${articles}">
		
			<tr>
				<td>
				<form method="POST" action="<c:url value='/showArticle'/>">
					<input type="hidden" name="articleId" value="${article.articleId}">
					<input type="submit" value="${article.articleId}">
				</form>	
				</td>
				
				<td>${article.updateTime}</td>
				<td>${article.title}</td>
				
				<td>
				
				<form method="POST" action="<c:url value='/deleteArticle'/>">
					<input type="hidden" name="articleId" value="${article.articleId}">
					<input type="submit" value="刪除">
				</form>	

				<form method="POST" action="<c:url value='/getOldArticle'/>">
					<input type="hidden" name="articleId" value="${article.articleId}">
					<input type="submit" value="修改">
				</form>	

		</c:forEach>
		
	</table>

	<a href="<c:url value='/frontPage' />">回首頁</a>
	
</body>
</html>