<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>表單列表</title>
<style type="text/css">
table{
    border-collapse:collapse;
    border:1px solid black;
    background: #F5F5F5; 
    border: 2px solid black; 
    border-style: outset; 
}

#borderA {
	border: 1px solid black;
}
p{
	font-size:22px;
}
</style>
</head>
<body style="background: #EBFFEB;">
<h1>管理系統</h1>
<div>
	<form method="POST" action="<c:url value='/searchByFuzzyQuery_BS' />">
		查詢作者名稱<input type="text" name="Name" value="${param.Name}" required>
		<input type="submit" name="submit" value="確認" />
	</form>
	<br>
	<form method="POST" action="<c:url value='/showArticle_BS2' />">
		文章編號查詢<input type="text" name="articleId" value="${param.id}" required>
		<input type="submit" name="submit" value="確認" />
	</form>
</div>
<br>
	<table>

		<tr id='borderA' height='50'><th id='borderA' colspan="10" align="center">論壇資料庫</th></tr>
		
		<tr id='borderA' height='36'>
			<td id='borderA' width="100" align="center">文章編號</td>
			<td id='borderA' width="100" align="center">作者編號</td>
			<td id='borderA' width="100"  align="center">最後更新時間</td>
			<td id='borderA' width="100"  align="center">領域</td>
			<td id='borderA' width="200"  align="center">標題</td>
			<td id='borderA' width="500"  align="center">內文</td>
			<td id='borderA' width="500"  align="center">圖檔</td>
			<td id='borderA' width="100"  align="center">留言資料庫</td>
			<td id='borderA' width="100"  align="center" colspan="2">修改</td>
		</tr>
		
		<c:forEach var="anForumBean" varStatus="stat" items="${articleList}">
		
			<tr id='borderA' height='30'>
				<td id='borderA' align="center">${anForumBean.articleId}</td>
				<td id='borderA' align="center">${anForumBean.authorId}</td>
				<td id='borderA' align="center">${anForumBean.postTime}</td>
				<td id='borderA' align="center">${anForumBean.topicName}</td>
				<td id='borderA' align="center">${anForumBean.title}</td>
				<td id='borderA' align="center">${anForumBean.content}</td>
				<td id='borderA' align="center"><img height='50' width='50' src="<c:url value='/showArticleImage?id=${anForumBean.articleId} ' />"></td>
				<td id='borderA' align="center"><a href="<c:url value='/showArticle_BS?articleId=${anForumBean.articleId}' />">進入</a></td>
				<td id='borderA' align="center"><a href="<c:url value='/deleteArticle_BS?articleId=${anForumBean.articleId}' />">刪除</a></td>
				<td id='borderA' align="center"><a href="<c:url value='/getOldArticle_BS?articleId=${anForumBean.articleId}' />">修改</a></td>
			</tr>
			
		</c:forEach>
			<tr><td id='borderA' align="center" colspan="9"><a href="<c:url value='/Forum/BackSide/newArticle.jsp' />">新增文章</a></td></tr>
	</table>
	
	<hr><a href="<c:url value='/backSide' />"><p>重新載入</p></a>
	<a href="<c:url value='/FrontPage' />">回論壇首頁</a>
</body>
</html>