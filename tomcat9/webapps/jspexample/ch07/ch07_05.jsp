<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
<link rel='stylesheet' href='<c:url value="/css/styles.css" />'  type="text/css" />
<meta charset="UTF-8">
<title>下載Jar檔</title>  
</head>

<body>
<h1>下載檔案</h1>
本範例說明如何經由 Servlet 來『下載』檔案(任何形式的檔案)，在Servlet的 doGet()或doPost()方法內，利用
ServletContext 的 getResourceAsStreram() 來開啟檔案，而不用較差的
FileInputStream() <P/>
<a href="images.jar">下載Jar檔</a> <BR><P/>
<jsp:include page="/commons/previousPage.jsp" />
</body>
</html>