<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>showAllMember</title>
<style>
	table {
		border: 1px solid black;
	}
</style>
</head>
<body>
	<div class="container">

		<table>
			<thead>
				<tr>
					<th>memberId</th>
					<th>name</th>
					<th>password</th>
					<th>location</th>
					<th>email</th>
					<th>phone</th>
					<th>memberImage</th>
				</tr>
			</thead>

			<tbody>
				<tr>
					<td>${member.memberId}</td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
				<tr>
					<td></td>
				</tr>
			</tbody>



		</table>



	</div>


	<script src="https://code.jquery.com/jquery-3.6.1.min.js"></script>
	<script>
		
	</script>
</body>
</html>