<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div border='1'>
		<table>
			<tr>
				<td><img width='180' height='120' src:"<c:url value='/ch02/sendBinaryData?a=1' />" /></td>
				<td><img width='180' height='120' src:"<c:url value='/ch02/sendBinaryData?a=2' />" /></td>
				<td><img width='180' height='120' src:"<c:url value='/ch02/sendBinaryData?a=3' />" /></td>
			</tr>
			<tr>
				<td><img width='180' height='120' src:"<c:url value='/ch02/sendBinaryData?a=4' />" /></td>
				<td><img width='180' height='120' src:"<c:url value='/ch02/sendBinaryData?a=5' />" /></td>
				<td><img width='180' height='120' src:"<c:url value='/ch02/sendBinaryData?a=6' />" /></td>
			</tr>
		</table>
	</div>

</body>
</html>