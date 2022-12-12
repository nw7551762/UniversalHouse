<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>留言</title>
</head>
<style type="text/css">

table{
    border-collapse:collapse;
    border:1px solid black;
    style="margin-left: auto;
    margin-right: auto;
    background: #F5F5F5; 
    border: 2px solid blue; 
    border-style: outset; 
}

#borderA {
	border: 1px solid black;
	text-align="center";
}
</style>
<body style="background: #EBFFEB">
<h1>文章編號 [${articleBean.articleId}] 的留言</h1>
<!-- 	<div> -->
<!-- 		<img height='100' width='80' -->
<%-- 			src="<c:url value='/showArticleImage?id=${articleBean.articleId}' />"><br> --%>
<%-- 		<h1>${articleBean.title}</h1> --%>
<!-- 		<h3> -->
<%-- 			領域 : ${articleBean.topicName}<br>作者 : ${memberBean.name} --%>
<!-- 		</h3> -->
<!-- 		<h5>編號 : -->
<%-- 			${articleBean.articleId}-${articleBean.authorId}-${articleBean.postTime}</h5> --%>
<!-- 		<hr> -->
<%-- 		<p>${articleBean.content}</p> --%>
<!-- 	</div> -->

	<table>
		<tr>
			<th colspan="6">留言資料庫</th>
		</tr>
			<tr id='borderA' height='36'>
			<td id='borderA' align="center" width="100">作者圖片</td>
			<td id='borderA' align="center" width="100">作者編號</td>
			<td id='borderA' align="center" width="100">作者名稱</td>
			<td id='borderA' align="center" width="100">最後更新時間</td>
			<td id='borderA' align="center" width="100">內文</td>
			<td id='borderA' align="center" width="100">修改</td>
			
		</tr>
		
		<c:forEach var="thisBean" varStatus="stat" items="${MessageBean}">
			<tr id='borderA' height='30'>
				<td id='borderA' align="center" width="100"><img height='50' width='50' src="<c:url value='/showMemberImage?memberPk=${thisBean.authorId} ' />"></td>
				<td id='borderA' align="center" width="100">${thisBean.authorId}</td>
				<td id='borderA' align="center" width="100">${thisBean.authorName}</td>
				<td id='borderA' align="center" width="100">${thisBean.postTime}</td>
				<td id='borderA' align="center" width="100">${thisBean.content}</td>
				
				<td id='borderA' align="center" width="100">
					<form method="POST" action="<c:url value='/deleteMessage' />">
						<input type="hidden" name="messageId" value="${thisBean.messageId}">
						<input type="hidden" name="articleId" value="${articleBean.articleId}"> 
						<input type="submit" value="刪除留言">
					</form>
				</td>
				
			</tr>
			
		</c:forEach>
		
	</table>

		<a href="<c:url value='/backSide' />">回前頁</a>
</body>

</html>