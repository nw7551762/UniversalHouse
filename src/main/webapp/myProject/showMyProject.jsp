<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>我的所有案件</title>
<style>
.t1{
	width:1400px;
	margin:auto;
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
	<table class="t1">
		<tr>
			<th>案件分類</th>
			<th>領域分類</th>
			<th>案件名稱</th>
			<th>案件描述</th>
			<th>服務地區</th>
			<th>案件報價</th>
			<th>預計完成日</th>
			<th>執行時間</th>
			<th>上傳日期</th>
			<th>最後更新日期</th>
			<th>案件狀態</th>
			<th>功能</th>
		</tr>
		<c:forEach var="pj" items="${project}" >
		<tr>
			<td>${pj.pjClass}</td>
			<td>${pj.fieldName}</td>
			<td>${pj.pjName}</td>
			<td>${pj.pjInstruction}</td>
			<td>${pj.pjServerLocation}</td>
			<td>${pj.pjPrice}</td>
			<td>${pj.pjExCompletionDate}</td>
			<td>${pj.pjExecutionTime}</td>
			<td>${pj.pjUploadDate}</td>
			<td>${pj.pjLastUpdate}</td>
			<td>${pj.pjStatus}</td>
			<td><input type="button" value="評價" class="evaluation">
				<input type="button" value="修改" class="reviseProject">
				<input type="button" value="刪除" class="delete"></td>
		</tr>
		</c:forEach>
	</table>
</c:if>

<div class="t1"><a href="<c:url value='/' />">回首頁</a></div>
</body>
</html>