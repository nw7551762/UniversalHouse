<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>我的案件</title>
<style>
table{
	width:800px;
	border:1px solid #bebebe;
	text-align:center;
}

tr{
	border:1px solid #bebebe;
}

td{
	border:1px solid #bebebe;
}

th{
	border:1px solid #bebebe;
}
</style>
</head>
<body>
<c:if test="${empty project}">
<h2>查無案件資料</h2>
</c:if>
<c:if test="${not empty project}">
	<table>
		<tr>
			<th>案件分類</th>
			<th>領域分類</th>
			<th>案件名稱</th>
			<th>案件描述</th>
			<th>服務地區</th>
			<th>案件報價</th>
		</tr>
		<c:forEach var="pj" items="${project}" >
		<tr>
			<td>${pj.pjClass}</td>
			<td>${pj.fieldName}</td>
			<td>${pj.pjName}</td>
			<td>${pj.pjInstruction}</td>
			<td>${pj.pjServerLocation}</td>
			<td>${pj.pjPrice}</td>
			<td><input type="button" value="評價" class="evaluation">
				<input type="button" value="修改" class="reviseProject">
				<input type="button" value="刪除" class="delete"></td>
		</tr>
		</c:forEach>
	</table>
</c:if>

<a href="<c:url value='/' />">回首頁</a>
</body>
</html>