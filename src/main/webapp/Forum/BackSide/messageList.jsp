<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>表單列表</title>
<style type="text/css">
#borderA {
	border: 1px solid black;
}
</style>
</head>
<body style="background: #EBFFEB;">
	<c:set var="funcName" value="ORD" scope="session" />

	<table
		style="margin-left: auto; margin-right: auto; width: 810; background: #F5EBFF; border: 2px solid blue; border-style: outset;">

		<tr id='borderA' height='50'>
			<th id='borderA' colspan="4" align="center">留言紀錄</th>
		</tr>
		<tr id='borderA' height='36'>
			<th id='borderA'>作者編號</th>
			<th id='borderA'>留言編號</th>
			<th id='borderA'>最後更新時間</th>
			<th id='borderA'>標題</th>
		</tr>
		<c:forEach var="anMessageBean" varStatus="stat" items="${MessageList}">
			<tr id='borderA' height='30'>
				<td id='borderA' width="100" align="center"><a
					href="<c:url value='/showArticle_BS?articleId=${anMessageBean.articleId}' />">GO!</a>
				</td>
				<td id='borderA' width="100" align="center">${anMessageBean.articleId}</td>
				<td id='borderA' width="100" align="center">${anMessageBean.postTime}</td>
				<td id='borderA' width="100" align="center">${anMessageBean.topicName}</td>
				<td id='borderA' width="100" align="center">${anMessageBean.title}</td>
				<td id='borderA' width="100" align="center">
					<div>
						<a href="<c:url value='/deleteMessage?articleId=${anForumBean.articleId}' />">刪除</a>
					</div>
				</td>

			</tr>
		</c:forEach>

	</TABLE>
	<div>
		<a href="<c:url value='/FrontPage' />">回首頁</a>
	</div>
</body>
</html>