<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>我的案件</title>
</head>
<body>
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
		</tr>
		</c:forEach>
	</table>
</body>
</html>