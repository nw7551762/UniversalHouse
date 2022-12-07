<%@ page language="java" contentType="text/html; charset=UTF-8"
<<<<<<< HEAD
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
=======
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
>>>>>>> zshe

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Topic2</title>
<<<<<<< HEAD
</head>
<body>
<h1>Topic2</h1>

<a href="<c:url value='/regist/regist.jsp' />">regist</a><p/>
<a href="<c:url value='/regist/modify.jsp' />">modifyMemberInfo</a><p/>
<a href="<c:url value='/TestDelete' />">testDelete</a><p/>
<a href="<c:url value='/showMemberInfo.do' />">Show Member Informations</a><p/>
<a href="<c:url value='/login/login.jsp' />">Login</a><p/>
<a href="<c:url value='/project/saveProject.jsp' />">Save Project</a><p/>
<a href="<c:url value='/project/showMyProjectServlet' />">Show My Project</a><p/>
<a href="<c:url value='/project/showAllProjectServlet' />">Show All Project</a><p/>


=======
<style>
	.userInfo {
		font-size: 4px;
	}
	</style>

</head>
<body>
	<h1>Topic2</h1>

	<a href="<c:url value='/regist/regist.jsp' />">regist</a>
	<p />
	<a href="<c:url value='/modify/modifyMemberInfo.jsp' />">modifyMemberInfo</a>
	<p />
	<a href="<c:url value='/TestDelete' />">testDelete</a>
	<p />
	<a href="<c:url value='/showMemberInfo/showMemberInfo.do' />">Show Member Informations</a>
	<p />
	<a href="<c:url value='/showMemberInfo/showAllMember.do' />">Show All Member Informations</a>
	<p />
	<a href="<c:url value='/login/login.jsp' />">Login</a>
	<p />
	<a href="<c:url value='/login/logout.jsp' />">Logout</a>
	<p />
<c:choose>
	<c:when test="${!empty LoginOK}">
	<p class="userInfo">User: ${ LoginOK.memberId } </p>
	<p class="userInfo">Last login time: ${ LoginOK.lastLogin }</p>
	</c:when>
</c:choose>
>>>>>>> zshe


</body>
</html>