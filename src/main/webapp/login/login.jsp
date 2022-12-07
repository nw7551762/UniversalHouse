<<<<<<< HEAD
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<style>
		.t1 {
	            width:100px;
	            float:left;
	            text-align:right;
	            margin-right: 10px;
	        }
	    
    </style>
	
</head>
<body>
	<c:if test="${ ! empty sessionScope.timeOut }">
		<!-- 表示使用逾時，重新登入 -->
		<c:set var="msg"
			value="${sessionScope.timeOut}</font>" />
	</c:if>
	<Form action="<c:url value='/login.do' />" method="POST" name="loginForm">
		<Table>
				
				<tr><td>${AppName}</td></tr>
				
				<tr><td>${msg}</td></tr>
				
				<tr>
					<td >帳號：</td>
					<td ><input type="text" name="memberId" value="${requestScope.user}${param.userId}"> &nbsp;${ErrorMsgKey.AccountEmptyError}</td>
				</tr>
				<tr>
					<td>密碼：</td>
					<td >
						<input type="password" name="password" value="${requestScope.password}${param.password}"> &nbsp;${ErrorMsgKey.PasswordEmptyError}
					</td>

				</tr>
				<tr> <td>&nbsp;</td></tr>
				<tr>
					<td></td>
					<td align="center" >
						<input type="checkbox" name="rememberMe"
							<c:if test='${requestScope.rememberMe==true}'>
                  				checked='checked'
               				</c:if>
							value="true">記住密碼
					</td>
					
				</tr>
				
				<tr><td>&nbsp;${ErrorMsgKey.LoginError}&nbsp;</td></tr>
				
				<tr><td ><input type="submit" value="提交"></td></tr>
			</Table>
	</Form>
	
</body>
=======
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<style>
		.t1 {
	            width:100px;
	            float:left;
	            text-align:right;
	            margin-right: 10px;
	        }
	    
    </style>
	
</head>
<body>
	<c:if test="${ ! empty sessionScope.timeOut }">
		<!-- 表示使用逾時，重新登入 -->
		<c:set var="msg"
			value="${sessionScope.timeOut}</font>" />
	</c:if>
	<Form action="<c:url value='/login.do' />" method="POST" name="loginForm">
		<Table>
				
				<tr><td>${AppName}</td></tr>
				
				<tr><td>${msg}</td></tr>
				
				<tr>
					<td >帳號：</td>
					<td ><input type="text" name="memberId" value="${requestScope.user}${param.userId}"> &nbsp;${ErrorMsgKey.AccountEmptyError}</td>
				</tr>
				<tr>
					<td>密碼：</td>
					<td >
						<input type="password" name="password" value="${requestScope.password}${param.password}"> &nbsp;${ErrorMsgKey.PasswordEmptyError}
					</td>

				</tr>
				<tr> <td>&nbsp;</td></tr>
				<tr>
					<td></td>
					<td align="center" >
						<input type="checkbox" name="rememberMe"
							<c:if test='${requestScope.rememberMe==true}'>
                  				checked='checked'
               				</c:if>
							value="true">記住密碼
					</td>
					
				</tr>
				
				<tr><td>&nbsp;${ErrorMsgKey.LoginError}&nbsp;</td></tr>
				
				<tr><td ><input type="submit" value="提交"></td></tr>
			</Table>
	</Form>
	
</body>
>>>>>>> zshe
</html>