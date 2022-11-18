<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<link rel='stylesheet' href='<c:url value="/css/styles.css" />'  type="text/css" />
<meta charset="UTF-8">
<title>jspForward03.jsp</title>
</head>
<body>
<font color="#0000FF">這是第三頁，也是最後一頁</font><br>
<font color="#0000FF">這是第三頁，準備返回第二頁</font><br>
<br><br><br>
<div align="center">
  <small>&lt;&lt;<a href="<c:url value='/ch05/index.jsp' />">回第五章首頁(03)</a>&gt;&gt;</small>
</div>
</body>
</html>