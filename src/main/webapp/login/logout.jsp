<<<<<<< HEAD
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登出</title>
</head>
<body>
<!-- 先將使用者名稱取出 -->
<c:set var="memberName" value="${ LoginOK.name }" scope='request'/>
<!-- 移除放在session物件內的屬性物件 -->
<%
	session.invalidate();
%>


<%-- 重建一個全新的Session物件   --%>
${pageContext.request.session}
<%-- 由ThanksForComing.jsp準備感謝訊息   --%>
<jsp:include page="ThanksForComing.jsp"  />

<c:redirect url="/index.jsp"/>
</body> 
=======
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登出</title>
</head>
<body>
<!-- 先將使用者名稱取出 -->
<c:set var="memberName" value="${ LoginOK.name }" scope='request'/>
<!-- 移除放在session物件內的屬性物件 -->
<%
	session.invalidate();
%>


<%-- 重建一個全新的Session物件   --%>
${pageContext.request.session}
<%-- 由ThanksForComing.jsp準備感謝訊息   --%>
<jsp:include page="ThanksForComing.jsp"  />

<c:redirect url="/index.jsp"/>
</body> 
>>>>>>> zshe
</html>