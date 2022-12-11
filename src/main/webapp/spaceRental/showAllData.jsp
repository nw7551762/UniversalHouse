<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>All Data !!</title>
<style>
table {
	border: 2px solid black border-collapse:collapse;
}

td {
	border: 1px solid black
}
</style>
</head>

<body>
	<h1 style="font-weight: fa-border">All Space Rental Data</h1>




	<form action="<c:url value='/queryServlet' />" method="post">
		<p>
			Search By City: <input type="search" name="city" placeholder="關鍵字">
			<input type="submit" name="query" value="search">
		</p>
	</form>
	<br>
	<form action="../spaceRental/insertData.jsp">
		<input type="submit" value="新增場地資料">
	</form>
	<br>
	<div>
		<table>
			<thead>
				<tr>
					<th>No.</th>
					<th>Space</th>
					<th>City</th>
					<th>Address</th>
					<th>Accommodate</th>
					<th>Type</th>
					<th>Unit</th>
					<th>Period_1st.</th>
					<th>Period_2ed</th>
					<th>Facility_1</th>
					<th>Facility_2</th>
					<th>Facility_3</th>
					<th>Facility_4</th>
					<th>Facility_5</th>
					<th>Introduce</th>
					<th>Picture</th>
					<!-- 					<th>Commit</th> -->
				</tr>
			</thead>
			<tbody class="tbody">
				<c:forEach var="spaces" items="${spaces}">
					<tr>
						<td>${spaces.spaceNo}</td>
						<td>${spaces.spaceName}</td>
						<td>${spaces.city}</td>
						<td>${spaces.address}</td>
						<td>${spaces.accommodate}</td>
						<td>${spaces.spaceType}</td>
						<td>${spaces.unit}</td>
						<td>${spaces.period1}</td>
						<td>${spaces.period2}</td>
						<td>${spaces.facility_1}</td>
						<td>${spaces.facility_2}</td>
						<td>${spaces.facility_3}</td>
						<td>${spaces.facility_4}</td>
						<td>${spaces.facility_5}</td>
						<td>${spaces.intro}</td>

						<td><img
							src="<c:url value='/spaceAdmin/showSpaceImgServlet?spaceNo=${spaces.spaceNo}' />"
							width="200px" height="140px"></td>


						<%-- 						<td>${spaces.comm}</td> --%>
						<td>
							<form
								action="<c:url value='/spaceAdmin/updateServlet?spaceNo=${spaces.spaceNo}'/>"
								method="post">
								<input type="submit" value="修改" class="edit">
							</form> <input type="submit" value="刪除" class="delete">
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<p></p>
		<p></p>

	</div>
	<p></p>
	<p></p>
	<script src="https://code.jquery.com/jquery-3.6.1.min.js"></script>
	<script>

    
    	$('tbody').on('click','.delete',function(){
    		let spaceNo = $(this).parent().siblings().eq(0).text();
    		$.ajax({
    			type: "post",
    			url: '<c:url value='/spaceAdmin/deleteServlet'/>',
    			data:{ no :spaceNo} ,
    			
    			success: function () {alert("刪除成功!") },
   			    error: function (thrownError) {alert("刪除失敗")}
    		});
    	})
        </script>



	<a href="<c:url value='/' />">Back To Topic2</a>

	<c:choose>
		<c:when test="${row == 0}">
			<script>alert('OOPS insert UNSUCCESSFUL !!!');</script>
		</c:when>
		<c:when test="${row == 1}">
			<script>alert('${space.spaceName} insert success!!!');</script>
		</c:when>
		<c:otherwise>
		</c:otherwise>
	</c:choose>

</body>
</html>
