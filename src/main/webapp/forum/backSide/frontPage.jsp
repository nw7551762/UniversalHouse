<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>表單列表</title>

</head>
<body>
	<h1>管理系統</h1>
	<div>
		<form method="POST" action="<c:url value='/findByNameFQ_BS' />">
			查詢作者名稱<input type="search" name="name" value="${param.name}" required>
			<input type="submit" value="確認" />
		</form>
		
		<br>
		
		<form method="POST" action="<c:url value='/idSerach_BS' />">
			文章編號查詢<input type="search" name="articleId" value="${param.id}" required>
			<input type="submit" value="確認" />
		</form>
		
	</div>
	
	<br>
	
	<table>

		<tr><th>論壇資料庫</th></tr>
		
		<tr>
			<td>文章編號</td>
			<td>作者編號</td>
			<td>最後更新時間</td>
			<td>領域</td>
			<td>標題</td>
			<td>內文</td>
			<td>狀態</td>			
			<td>讚</td>
			<td>爛</td>
			<td>圖檔</td>
			<td>留言資料庫</td>
			<td colspan="2">修改</td>
		</tr>
		
		<c:forEach var="article" varStatus="stat" items="${articleList}">
		
			<tr>
				<td>${article.articleId}</td>
				<td>${article.authorId}</td>
				<td>${article.updateTime}</td>
				<td>${article.topicName}</td>
				<td>${article.title}</td>
				<td>${article.content}</td>
				<td>${article.status}</td>
				<td>${article.like}</td>
				<td>${article.dislike}</td>
				
				
				<td>
					<form method="POST" action="<c:url value='/imgDB_BS' />">
						<input type="hidden" name="articleId" value="${article.articleId}">
						<input type="submit" value="圖片資料庫" />
					</form>
				</td>
				
				<td>
					<form method="POST" action="<c:url value='/messageDB_BS' />">
						<input type="hidden" name="articleId" value="${article.articleId}">
						<input type="submit" value="留言資料庫" />
					</form>
				</td>
				
				<td>
					<form method="POST" action="<c:url value='/deleteArticle_BS' />">
						<input type="hidden" name="articleId" value="${article.articleId}">
						<input type="submit" value="刪除" />
					</form>
					
					<form method="POST" action="<c:url value='/getOldArticle_BS' />">
						<input type="hidden" name="articleId" value="${article.articleId}">
						<input type="submit" value="修改" />
					</form>
				</td>
				
			</tr>
			
		</c:forEach>
			<tr><td colspan="9"><a href="<c:url value='/forum/backSide/newArticle.jsp' />">新增文章</a></td></tr>
	</table>
	
	<a href="<c:url value='/backSide' />">重新載入</a>
	<a href="<c:url value='/frontPage' />">回論壇首頁</a>
	
</body>
</html>