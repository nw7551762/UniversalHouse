<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>文章結果</title>
<style type="text/css">
table {
	border-collapse: collapse;
	border: 1px solid black;
	style ="margin-left: auto;
	margin-right: auto;
	width: 810;
	background: #F5EBFF;
	border: 2px solid blue;
	border-style: outset;
}

#borderA {
	border: 1px solid black;
}
</style>
</head>
<body style="background: #EBFFEB">
	<c:set var="memberId" value="${cookie['user'].getValue()}" />

	<div>
		<header><h1>${articleBean.title}</h1></header>
		<h5>${articleBean.articleId}-${articleBean.authorId}</h5>
		<div style='float:left margin:"10px"'>
		<h3>領域 : ${articleBean.topicName}
		<br>
		作者 : 
		<br>
		<img height='50' width='50' src="<c:url value='/showMemberImage?memberPk=${memberBean.memberPK} ' />">
		${memberBean.name}
		<br>
		${articleBean.postTime}</h3>
		</div>
		<img height='400' width='400' src="<c:url value='/showArticleImage?id=${articleBean.articleId}' />">
		<div>
		<hr><p>${articleBean.content}</p>
		</div>
	</div>
	<hr>
	<table>
		<tr id='borderA'>
			<th colspan="5" align="center">留言</th>
		</tr>

		<c:forEach var="thisBean" varStatus="stat" items="${MessageBean}">
			<tr height='30' align="center">
				<td><img height='50' width='50' src="<c:url value='/showMemberImage?memberPk=${thisBean.authorId} ' />"></td>
				<td width="100" align="center">${thisBean.authorName}</td>
				<td width="100">${thisBean.postTime}</td>
				<td width="400px">${thisBean.content}</td>
			</tr>
		</c:forEach>

	</table>

	<div>
		<jsp:include page="/Forum/Message/newMessage.jsp">
			<jsp:param name="articleId" value="${articleBean.articleId}" />
		</jsp:include>
	</div>

	<%-- 	<form method="POST" action="<c:url value='/modifyFavorite' />"> --%>
	<%-- 		<input type="hidden" name="articleId" value="${articleBean.articleId}"> --%>
	<%-- 		<input type="hidden" name="memberId" value="${memberId}"> --%>
	<!-- 		<input type="submit" value="加入我的最愛"> -->
	<!-- 	</form> -->

	<hr><a href="<c:url value='/FrontPage' />">回首頁</a>
	<c:set var="memberId" value="${cookie['user'].getValue()}" />
	<a href="<c:url value='/searchRecord?id=${memberId}' />">我的紀錄</a>
</body>

</html>