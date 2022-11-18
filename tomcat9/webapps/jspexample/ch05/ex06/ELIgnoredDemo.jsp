<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  isELIgnored="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<link rel='stylesheet' href='<c:url value="/css/styles.css" />'  type="text/css" />
<meta charset="UTF-8">
<title>展示忽略 JSP 文件中的 EL </title>
</head>
<body>
<h1>展示忽略 JSP 文件中的 EL </h1>
太空梭專用螺絲
料號:  ${1 + 2 }
<div align='center'>
<P/>
<a href="<c:url value='/ch05/index.jsp' />">回第五章首頁</a>
</div>
</body>
</html>