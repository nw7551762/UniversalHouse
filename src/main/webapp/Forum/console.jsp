<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>文章結果</title>
<style type="text/css">
#paging {
	position: relative;
	left: 120px;
	top: 10px;
}

#pfirst {
	position: relative;
	left: 2px;
	top: 2px;
}

#pprev {
	position: relative;
	left: 2px;
	top: 2px;
}

#pnext {
	position: relative;
	left: 2px;
	top: 2px;
}

#plast {
	position: relative;
	left: 2px;
	top: 2px;
}

#main {
	position: relative;
	top: 5px;
	left: 40px;
	width: 100%;
}

#content {
	width: 820px;
	margin-left: auto;
	margin-right: auto;
}
</style>
</head>
<body style="background: #EBFFEB">
	<div>
		<img height='100' width='80'
			src="<c:url value='/getImg?id=${ForumBean.articleId}' />"><br>
		<h1>${ForumBean.title}</h1>
		<h3>${ForumBean.topicName}</h3>
		<h5>${ForumBean.articleId}-${ForumBean.authorId}-${ForumBean.postTime}</h5>
		<p>${ForumBean.content}</p>
	</div>

	<div>
		<form method="POST"
			action="<c:url value='/delete?id=${ForumBean.articleId}' />">
			<input type="submit" name="submit" id="submit" value="刪除文章" />
		</form>
	</div>
	<br>
	<div>
		<form method="POST"
			action="<c:url value='/getOldDatas?id=${ForumBean.articleId}' />">
			<input type="submit" name="submit" id="submit" value="修改文章" />
		</form>
	</div>


	<table>
		<tr>
			<td colspan="4">留言區</td>
		</tr>
		<c:forEach var="anMessageBean" varStatus="stat" items="${MessageBean}">
			<tr id='borderA' height='30'>
				<td id='borderA' width="100">編號: ${anMessageBean.messageId}</td>
				<td id='borderA' width="100">${anMessageBean.authorId}</td>
				<td id='borderA' width="100">${anMessageBean.postTime}</td>
				<td id='borderA' width="100">${anMessageBean.content}</td>
			</tr>
		</c:forEach>
	</table>
	<jsp:include page="/Message/newMessage.jsp">
		<jsp:param name="articleId" value="${ForumBean.articleId}" />
	</jsp:include>
	<div>
		<a href="<c:url value='/FrontPageList' />">回首頁</a>
	</div>
</body>
</html>
