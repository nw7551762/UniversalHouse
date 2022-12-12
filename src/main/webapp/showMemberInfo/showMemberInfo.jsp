<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
ul {
	list-style: none;
}
table {
	border-collapse: collapse;
	width: 300px;
}
td{
width: 100px;
height: 40px
}

.t1 {
	width: 100px;
	float: left;
	text-align: right;
	margin-right: 10px;
}
</style>
</head>
<body>
	<table >
		<tr><td>memberId</td>
			<td>${member.memberId}</td>
		</tr>
		<tr><td>name</td>
			<td>${member.name}</td>
		</tr>
		<tr><td>password</td>
			<td>${member.password}</td>
		</tr>
		<tr><td>location</td>
			<td>${member.location}</td>
		</tr>
		<tr><td>email</td>
			<td>${member.email}</td>
		</tr>
		<tr><td>phone</td>
			<td>${member.phone}</td>
		</tr>
		<tr><td>registerTime</td>
			<td>${member.registerTime}</td>
		</tr>
		<tr><td>verification</td>
			<td id="verification"></td>
		</tr>
		<tr><td>permission</td>
			<td id="permission">${member.permission}</td>
		</tr>
		<tr><td><img
		src="<c:url value='/ShowMemberImgServlet?memberId=${member.memberId} '/>"
		alt="no img" width="400px" height="400px"></td>
			
		</tr>
	
	</table>


	
	<a href="<c:url value='/' />">回首頁</a>


	<script src="https://code.jquery.com/jquery-3.6.1.min.js"></script>
	<script>
	$(function(){
		
		${LoginOK.verification }==0 ?
			$('#verification').html( '<a href="<c:url value='/regist/regServlet.do?memberId=${member.memberId}' />">發送驗證信</a>' ):
			$('#verification').append( '已驗證');
		
		${LoginOK.permission }==0 ?
			$('#permission').append( 'OO會員' ):
			$('#permission').append( 'xx會員' );
		
		
		
	})
		
	
	</script>

</body>
</html>