<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>表單列表</title>
<style type="text/css">

table {
	border-collapse: collapse;
	border: 1px solid black;
	background: #F5EBFF;
	border: 2px solid blue;
	border-style: outset;
}

#borderA {
	border: 1px solid black;
}

</style>
</head>
<body style="background: #EBFFEB;">

	<table>

		<tr height='50'><th id='borderA' colspan="6" align="center">搜尋結果</th></tr>
		
		<tr height='36'>
			<td id='borderA'>文章呈現</td>
			<td id='borderA'>文章編號</td>
			<td id='borderA'>更新時間</td>
			<td id='borderA'>領域</td>
			<td id='borderA'>標題</td>
		</tr>
		
		<c:forEach var="anForumBean" varStatus="stat" items="${articleList}">
		
			<tr id='borderA' height='30'>
				<td id='borderA' width="100" align="center"><a href="<c:url value='/showArticle?articleId=${anForumBean.articleId}' />">觀看內文</a></td>
				<td id='borderA' width="100" align="center">${anForumBean.articleId}</td>
				<td id='borderA' width="100" align="center">${anForumBean.postTime}</td>
				<td id='borderA' width="100" align="center">${anForumBean.topicName}</td>
				<td id='borderA' width="500px" align="center">${anForumBean.title}</td>
			</tr>
			
		</c:forEach>
	</table>
	
	<a href="<c:url value='/FrontPage' />">回首頁</a>
</body>

</html>