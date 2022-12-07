<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>文章列表</title>
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
		<tr id='borderA' height='36'>
			<td rowspan="1">文章總覽</td>
		</tr>
		<tr>
			<td id='borderA'>文章編號</td>
			<td id='borderA'>發文時間</td>
			<td id='borderA'>標題</td>
		</tr>
		<c:forEach var="anForumBean" varStatus="stat" items="${firstPageList}">
			<TR id='borderA' height='30'>
				<TD id='borderA' width="100" align="center"><a
					href="<c:url value='/findById?id=${anForumBean.articleId}' />">${anForumBean.articleId}</a>
				</TD>
				<TD id='borderA' width="100" align="center">${anForumBean.postTime}</TD>
				<TD id='borderA' width="100" align="center">${anForumBean.title}</TD>
			</TR>
		</c:forEach>
	</TABLE>
	<form method="POST" action="<c:url value='/Forum/newArticle.jsp' />">
		<input type="submit" name="submit" id="submit" value="新增文章" />
	</form>
		<form method="POST" action="<c:url value='/Forum/backSide.jsp' />">
		<input type="submit" name="submit" id="submit" value="後台" />
	</form>
</body>
</html>