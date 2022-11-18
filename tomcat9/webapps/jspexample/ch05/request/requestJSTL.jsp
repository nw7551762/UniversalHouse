<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="UTF-8">
<link rel='stylesheet' href='<c:url value="/css/styles.css" />'  type="text/css" />
<title>Request Information Example(JSTL)</title>
</head>
<body>
<h3>Request Information Example(EL版)</h3>
<h3>本畫面由JSP網頁產生</h3>
<P/>Request URI: ${pageContext.request.requestURI}
<P/>QueryString: ${pageContext.request.queryString}
<P/>Context Path: ${pageContext.request.contextPath}
<P/>Servlet Path: ${pageContext.request.servletPath}
<P/>SessionId: ${pageContext.request.requestedSessionId}
<P/>Method: ${pageContext.request.method}
<P/>Protocol: ${pageContext.request.protocol}
<P/>Remote Address: ${pageContext.request.remoteAddr}
<div align='center'>
<HR><small>&lt;&lt;<a href="<c:url value='/ch02/index.jsp' />" >回第二章首頁</a>&gt;&gt;</small>
</div>
</body>
</html>