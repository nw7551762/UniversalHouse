<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
table {
	border: 1px solid black;
	border-collapse: collapse;
	width: 100%;
}
</style>
</head>
<body>
	<div class="container">
		<form>
		<table border='1'>
			<thead>
				<tr>
					<th>name</th>
					<th>fraction</th>
					<th>image</th>
				</tr>
			</thead>

			<tbody class="tbody">
				<c:forEach var="total" items="${totals}">
					<tr>
						<td>${total.memberId}</td>
						<td>${total.fraction}</td>

							<td><input type="button" value="修改" class="toModifyMode">
								<input type="submit" value="刪除" class="delete"></td>
					</tr>
				</c:forEach>
			</tbody>

		</table>
		</form>
	</div>
</body>
</html>