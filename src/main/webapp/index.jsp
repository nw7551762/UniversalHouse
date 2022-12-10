<<<<<<< HEAD
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Topic2</title>
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
	<a href="<c:url value='/myProject/saveProject.jsp' />">新增委託案件</a>
	<p/>
	<p />
	<a href="<c:url value='/myProject/saveServerProject.jsp' />">新增服務案件</a>
	<p/>
	<a href="<c:url value='/project/showMyProjectServlet' />">查詢我的案件</a>
	<p/>
	<a href="<c:url value='/project/showAllProjectServlet' />">管理所有案件</a>
	<p/>
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


</body>
=======
<<<<<<< HEAD
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>暫定</title>
</head>
<h1>暫定超連結</h1>
<body>
	<form method="POST" action="<c:url value='/FrontPageList' />">
		<input type="submit" name="submit" id="submit" value="進入" />
	</form>
</body>
=======
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Topic2</title>
</head>
<body>
<h1>Topic2</h1>

<a href="<c:url value='/regist/regist.jsp' />">regist</a><p/>
<a href="<c:url value='/regist/modify.jsp' />">modifyMemberInfo</a><p/>
<a href="<c:url value='/TestDelete' />">testDelete</a><p/>
<a href="<c:url value='/showMemberInfo.do' />">Show Member Informations</a><p/>
<a href="<c:url value='/login/login.jsp' />">Login</a><p/>




</body>
>>>>>>> 7c2b4442b8837557d158dfdab26b714abf8ba016
>>>>>>> 6e3bd7841ec3b12addc6d5f002d088634e49c7c8
</html>