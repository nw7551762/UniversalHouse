<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Query Data !!</title>

<style>
table{ 
border:2px solid black 
border-collapse:collapse; 
}
td{ 
border:1px solid black 
} 
</style>

</head>



<body>
<h1 style="font-weight: fa-border">Query Result</h1>
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
					<th>Period 1st.</th>
					<th>Period 2ed</th>
					<th>Facility 1</th>
					<th>Facility 2</th>
					<th>Facility 3</th>
					<th>Facility 4</th>
					<th>Facility 5</th>
					<th>Introduce</th>
					<th>Picture</th>
<!-- 				<th>Commit</th> -->
				</tr>
			</thead>
			<tbody class="tbody">
				<c:forEach var="spaces" items="${Qresult}">
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
<%-- 					<td>${spaces.comm}</td> --%>
						
						<td>
						<img src="<c:url value='/spaceAdmin/showSpaceImgServlet?spaceNo=${spaces.spaceNo}' />"  width="200px" height="140px">
						</td>
						
						
						<td>
						<form action="<c:url value='/spaceAdmin/updateServlet?spaceNo=${spaces.spaceNo}' />" method="post">
						<input type="submit" value="修改" class="edit"> 
						</form>
						<input type="submit" value="刪除" class="delete">
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
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
    			
    			success: function () {alert("response success") },
   			    error: function (thrownError) {alert("response error")}
    		});
    	})
        </script>
        
  <form action="<c:url value='/spaceAdmin/showAllSpaceServlet' />">
	<input type="submit" value="回前頁" >
  </form>
	<p></p>
<p></p>
	<a href="<c:url value='/' />">Back To Topic2</a>
	

	
</body>
</html>