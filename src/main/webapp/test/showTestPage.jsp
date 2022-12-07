<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>

</style>
</head>
<body>
<table>

<c:forEach var="testBean" items="${testBeans}">

<tr>
<td>${testBean.examinationQuestion}</td>
<td>${testBean.options}</td>
<td>${testBean.options2}</td>
<td>${testBean.options3}</td>
<td>${testBean.options4}</td>
</tr>
</c:forEach>

</table>

</body>
</html>