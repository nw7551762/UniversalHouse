<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<c:set var="authorId" value="${cookie['user'].getValue()}" />
<title>論壇</title>

</head>
<body>
	<h1>歡迎來到論壇!! ${authorId}</h1>


	<form method="POST" action="<c:url value='/forum/article/newArticle.jsp' />">
		<input type="submit" value="新增文章" />
	</form>
	
	<form method="POST" action="<c:url value='/findhByNameFQ' />">
		<input type="search" name="name" value="${param.name}" required>
		<input type="submit" value="搜尋作者" />
	</form>

	<form method="POST" action="<c:url value='/showArticle' />">
		文章編號查詢 <input type="search" name="articleId" value="${param.id}"
			required> <input type="submit" value="確認" />
	</form>


	<table>
		<tr>
			<th>文章總覽</th>
		</tr>
		<tr>
			<td><label>領域</label></td>
			<td><label>標題</label></td>
			<td><label>更新時間</label></td>
			<td><label>觀看</label></td>
		</tr>

		<c:forEach var="article" varStatus="stat" items="${articleList}">
			<tr>
				<td>${article.topicName}</td>
				<td>${article.title}</td>
				<td>${article.updateTime}</td>

				<td>
					<form method="POST" action="<c:url value='/showArticle' />">
						<input type="hidden" name="articleId" value="${article.articleId}">
						<input type="submit" value="出發" />
					</form>
				</td>
			</tr>

		</c:forEach>
	</table>
	<a href="<c:url value='/forum/article/myRecord.jsp' />">用戶管理介面</a>
	<a href="<c:url value='/index.jsp' />">回登入頁面</a>
	<a href="<c:url value='/backSide' />">前往後台</a>

</body>

</html>