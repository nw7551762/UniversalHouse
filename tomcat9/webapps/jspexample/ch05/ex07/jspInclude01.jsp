<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<link rel='stylesheet' href='<c:url value="/css/styles.css" />'  type="text/css" />
<meta charset="UTF-8">
<title>jspInclude01.jsp</title>
</head>
<body>
<font color="#FF0000">這是第一頁，準備進入(Include)第二頁</font><br>
<jsp:include page="jspInclude02.jsp"/>
<font color="#FF0000">這是第一頁，由第二頁返回</font><br>
<br><br><br>
<div align='center'>
  <small>&lt;&lt;<a href="<c:url value='/ch05/index.jsp' />">回第五章首頁(01)</a>&gt;&gt;</small>
</div>
</body>
</html>