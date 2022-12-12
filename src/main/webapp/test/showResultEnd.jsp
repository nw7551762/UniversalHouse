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
				
					<tr>
						<td class="memberId">${total.memberId}</td>
						<td class= "score">${total.fraction}</td>
						<td class="image"><img src="<c:url value='/ShowImgForTestResultServlet?fraction=${total.fraction} '/>" alt="no img" width="400px" height="400px"></td>

					</tr>
			
			</tbody>

		</table>
		</form>
	</div>
<a href="<c:url value='/' />" >回首頁</a>
</body>
</html>