<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>歡迎來到論壇!!</title>
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
p{font-size:22px} 
</style>
</head>
<body style="background: #EBFFEB;">
<h1>歡迎來到論壇!!</h1>
	<c:set var="authorId" value="${cookie['user'].getValue()}" />

	<div>
	<div>
		<a href="<c:url value='/Forum/Article/newArticle.jsp' />"><p>新增文章</p></a>
		</div>
		<form method="POST" action="<c:url value='/searchByFuzzyQuery' />">
			<input type="text" name="Name" value="${param.Name}" required>
			<input type="submit" value="搜尋作者" />
		</form>
		
		<br>

<%-- 		<form method="POST" action="<c:url value='/showArticle' />"> --%>
<%-- 			文章編號查詢 <input type="text" name="articleId" value="${param.id}" --%>
<!-- 				required> <input type="submit" value="確認" /> -->
<!-- 		</form> -->
		
	</div>
	<table>

		<tr id='borderA' height='36'><th colspan="4" align="center">文章總覽</th></tr>

		<tr>
<!-- 			<td id='borderA' align="center">文章編號</td> -->
			<td id='borderA' align="center"><label>領域</label></td>
			<td id='borderA' align="center" width="60%"><label>標題</label></td>
			<td id='borderA' align="center"><label>更新時間</label></td>
			<td id='borderA' align="center"><label>觀看</label></td>
		</tr>

		<c:forEach var="anForumBean" varStatus="stat" items="${articleList}">

			<tr id='borderA' height='30'>
<%-- 				<td id='borderA' width="100" align="center">${anForumBean.articleId}</td> --%>
				<td id='borderA' width="100" align="center">${anForumBean.topicName}</td>
				<td id='borderA' width="100" align="center">${anForumBean.title}</td>
				<td id='borderA' width="100" align="center">${anForumBean.postTime}</td>
				<td id='borderA' width="100" align="center"><a href="<c:url value='/showArticle?articleId=${anForumBean.articleId}' />">出發!</a></td>
			</tr>

		</c:forEach>
	</table>

	<div>
		<br>
		<a href="<c:url value='/Forum/Article/myRecord.jsp' />">用戶管理介面</a>
	</div>	
	<hr>
	<a href="<c:url value='/index.jsp' />">回登入頁面</a>
	<a href="<c:url value='/backSide' />"><p>前往後台</p></a>

</body>

</html>