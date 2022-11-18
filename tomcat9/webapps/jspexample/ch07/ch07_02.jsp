<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<link rel='stylesheet' href='<c:url value="/css/styles.css" />'  type="text/css" />
<meta charset="UTF-8">
<title>load-on-startup</title>
</head>
<body>
<div align='center'>
<h1>Tomcat啟動時自動載入(load-on-startup)</h1>
<br>
請觀察『主控台』視窗會有下列訊息：<P/>
<font color='red'>
Servlet Zero is being loaded<BR>
Servlet First is being loaded<BR>
Servlet Second is being loaded<BR>
Servlet Third is being loaded<BR>
</font><p/>
這些訊息是於Tomcat啟動時自動載入Servlet類別時顯示在『主控台』視窗，藉以觀察<br>
load-on-startup所設定之載入先後順序的效果。<p/>
<jsp:include page="/commons/previousPage.jsp" />
</div>
</body>
</html>