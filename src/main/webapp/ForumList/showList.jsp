<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>訂單列表</title>
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
			<th id='borderA' colspan="4" align="center">您的發文紀錄</th>
		</tr>
		<tr id='borderA' height='36'>
			<th id='borderA'>文章編號</th>
			<th id='borderA'>發文時間</th>
			<th id='borderA'>標題</th>
			<th id='borderA'>更新</th>

		</tr>
		<c:forEach var="anForumBean" varStatus="stat" items="${ForumList}">
			<TR id='borderA' height='30'>
				<TD id='borderA' width="100" align="center"><a
					href="<c:url value='/findById?id=${anForumBean.articleId}' />">${anForumBean.articleId}</a>
				</TD>
				<TD id='borderA' width="100" align="center">${anForumBean.postTime}</TD>
				<TD id='borderA' width="100" align="center">${anForumBean.title}</TD>
				<TD id='borderA' width="100" align="center">
					<form method="POST"
						action="<c:url value='/delete?id=${anForumBean.articleId}' />">
						<input type="submit" name="submit" id="submit" value="刪除" />
					</form>

					<form method="POST"
						action="<c:url value='/getOldDatas?id=${anForumBean.articleId}' />">
						<input type="submit" name="submit" id="submit" value="修改" />
					</form>

				</TD>
				<TD id='borderA' width="400" align="left">&nbsp;${anOrderBean.shippingAddress}</TD>
			</TR>
		</c:forEach>

	</TABLE>
	<div>
		<a href="<c:url value='/FrontPageList' />">回首頁</a>
	</div>
</body>
</html>