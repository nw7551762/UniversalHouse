<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<meta charset="UTF-8">
<html>
<head>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link rel='stylesheet' href='<c:url value="/css/styles.css" />'  type="text/css" />
<title>jspInclude02.jsp</title>
</head>
<body>
<font color="#556655">這是第二頁，準備進入(Include)第三頁</font><br>
<jsp:include page="jspInclude03.jsp"/>
<font color="#556655">這是第二頁，由第三頁返回</font><br>
</body>
</html>