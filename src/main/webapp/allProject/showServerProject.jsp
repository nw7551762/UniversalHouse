<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>所有委託案件</title>
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
<form>
<c:if test="${ empty allProject}">
<div class="t1">
<h2>查無委託案件資料</h2>
</div>
</c:if>
<c:if test="${not empty allProject}">
	<table class="t1">
	<thead>
		<tr>
			<th>領域分類</th>
			<th>案件名稱</th>
			<th>會員編號</th>
			<th>服務地區</th>
			<th>案件報價</th>
			<th>上傳日期</th>
			<th>功能</th>
		</tr>
		</thead>
		<tbody id='tb'>
		<c:forEach var="pj" items="${project}" >
		<tr>
			<td>${pj.fieldName}</td>
			<td>${pj.pjName}</td>
			<td>${pj.memberID}</td>
			<td>${pj.pjServerLocation}</td>
			<td>${pj.pjPrice}</td>
			<td>${pj.pjUploadDate}</td>
			<td><input type="button" value="查看詳情" id="detail">
				<input type="submit" value="邀請報價" id="quotation"></td>
		</tr>
		</c:forEach>
		</tbody>
	</table>
</c:if>
</form>

<div  class="t1"><a href="<c:url value='/' />">回首頁</a></div>

<script src="https://code.jquery.com/jquery-3.6.1.min.js"></script>
<script>
</script>
</body>
</html>