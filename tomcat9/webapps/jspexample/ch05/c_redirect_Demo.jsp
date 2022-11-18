<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<link rel='stylesheet' href='<c:url value="/css/styles.css" />'  type="text/css" />
<meta charset="UTF-8">
<title>URL</title>
</head>
<body>
redirect標籤標籤會通知瀏覽器對新網址發出請求。如果有必要它會對這個<br>
URL自動進行URL rewriting。<br>
<hr>
<c:redirect url='/ch01/hello.jsp' />
<%-- 
<c:redirect url='http://tw.yahoo.com' />
--%>
<%--
<c:redirect url='hello.jsp' />
--%>
<p/>
<jsp:include page="/commons/previousPage.jsp" />
</body>
</html>