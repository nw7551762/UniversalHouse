<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link rel='stylesheet' href='<c:url value="/css/styles.css" />'  type="text/css" />
<meta charset="UTF-8">
<title>ch07_Listener:CoffeeBean data</title>
</head>
<body>
	<div align="center">
		<h3>Coffee List</h3>
		<table border="1">
		<tr bgcolor="#CCCCFF">
			<td width='120' align="center">代號</td>
			<td width='300' align="center">咖啡名稱</td>
			<td width='100' align="center">價格</td>
			<td width='100' align="center">折扣</td>
		</tr>
		<c:forEach var="cafe" items="${applicationScope.COFFEE_LIST}" varStatus="vs">
			<c:choose>
				<c:when test="${vs.count%2==0}">
					<c:set var="showcolor" value="#eedd82" />
        		</c:when>
				<c:otherwise>
					<c:set var="showcolor" value="#ffffcc" />
				</c:otherwise>
			</c:choose>

					<tr bgcolor="${showcolor}">
						<td align="center">${cafe.coffeeCode}</td>
						<td align="center">${cafe.coffeeName}</td>
						<td align="right">${cafe.price}</td>
						<td align="right">${cafe.discount}</td>
					</tr>
		</c:forEach>
				</table>
		<jsp:include page="/commons/previousPage.jsp" />
	</div>

</body>
</html>