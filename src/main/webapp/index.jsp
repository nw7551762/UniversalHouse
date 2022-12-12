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
	<a href="<c:url value='/modifyMemberInfo/modifyMemberInfo.jsp' />">modifyMemberInfo</a>
	<p />
	<a href="<c:url value='/showMemberInfo/showMemberInfo.do' />">Show
		Member Informations</a>
	<p />
	<a href="<c:url value='/showMemberInfo/showAllMember.do' />">Show
		All Member Informations</a>
	<p />
	<a href="<c:url value='/login/login.jsp' />">Login</a>
	<p />
	<a href="<c:url value='/login/logout.jsp' />">Logout</a>
	<p />
	<hr>
	<a href="<c:url value='/FrontPage' />">論壇</a>
	<p />
	<c:choose>
		<c:when test="${!empty LoginOK}">
			<p class="userInfo">User: ${ LoginOK.memberId }</p>
			<p class="userInfo">Last login time: ${ LoginOK.lastLogin }</p>
		</c:when>
	</c:choose>

	<hr>
	<a href="<c:url value='/spaceAdmin/showAllSpaceServlet' />">Space
		Rental</a>
	<p />
	<hr>
	
		<a href="<c:url value='/allProject/showServerProjectServlet' />">想找人才</a>
	<p/>
	<a href="<c:url value='/evaluation/ShowEvaluationServlet' />">我委託的項目</a>
	<p/>
	<a href="<c:url value='/evaluation/ShowMyEvaluationServlet' />">被委託的項目及評價</a>
	<p/>
	<a href="<c:url value='/myProject/saveProject.jsp' />">新增委託案件</a>
	<p />
	<a href="<c:url value='/myProject/saveServerProject.jsp' />">新增服務案件</a>
	<p/>
	<a href="<c:url value='/myProject/showMyProjectServlet' />">查詢我提出的案件</a>
<!-- 	<p/> -->
<%-- 	<a href="<c:url value='/allProject/showProjectServlet' />">我想接案</a> --%>
	<p/>
	<a href="<c:url value='/allProject/showAllProjectServlet' />">管理所有案件</a>
	
	<hr>
	
	

	<a href="<c:url value='/test/pushTest.jsp' />">存入試題</a>
	<p />
	<a href="<c:url value='/test/showTest.jsp' />">載入試題</a>
	<p />
	<a href="<c:url value='/test/DeleteAllTest.jsp' />">刪除試題</a>
	<p />
	<a href="<c:url value='/test/ModifyTestSelect.jsp' />">修改試題</a>
	<p />
	<a href="<c:url value='/ShowTestOverServlet.do' />">測驗成績</a>
	<hr>
	<a href="<c:url value='/queryCourseServlet' />">課程管理</a>
</body>
</html>