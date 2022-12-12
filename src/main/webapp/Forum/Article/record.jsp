<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>我的發文紀錄</title>
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
<body style="background: #EBFFEB;">

	<table>
		<tr id='borderA' height='50'><th id='borderA' colspan="5" align="center">您的發文紀錄</th></tr>
		
		<tr id='borderA' height='36'>
			<td id='borderA' align="center">文章編號</td>
			<td id='borderA' align="center">更新時間</td>
			<td id='borderA' align="center">標題</td>
			<td id='borderA' align="center" colspan="2">更新</td>
		</tr>
		
		<c:forEach var="thisList" varStatus="stat" items="${BeanList}">
		
			<tr id='borderA' height='30'>
				<td id='borderA' width="100" align="center"><a href="<c:url value='/showArticle?articleId=${thisList.articleId}' />">${thisList.articleId}</a></td>
				<td id='borderA' width="100" align="center">${thisList.postTime}</td>
				<td id='borderA' width="100" align="center">${thisList.title}</td>
				<td id='borderA' width="50" align="center"><a href="<c:url value='/deleteArticle?id=${thisList.articleId}' />">刪除</a></td>	
				<td id='borderA' width="50" align="center"><a href="<c:url value='/getOldArticle?id=${thisList.articleId}' />">修改</a></td>

		</c:forEach>
		
	</table>

	<a href="<c:url value='/FrontPage' />">回首頁</a>
	
</body>
</html>