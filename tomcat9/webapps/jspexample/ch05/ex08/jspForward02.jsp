<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<link rel='stylesheet' href='<c:url value="/css/styles.css" />'  type="text/css" />
<meta charset="UTF-8">
<title>jspForward02.jsp</title>
</head>
<body>
<font color="#556655">這是第二頁，準備進入(Forward)第三頁</font><br>
<jsp:forward page="jspForward03.jsp"/>
<font color="#556655">這是第二頁，由第三頁返回</font><br>
<br><br><br>
<div align="center">
  <small>&lt;&lt;<a href="<c:url value='/ch05/index.jsp' />">回第五章首頁(02)</a>&gt;&gt;</small>
</div>
</body>
</html>