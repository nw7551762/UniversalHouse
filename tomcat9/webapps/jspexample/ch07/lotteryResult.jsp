<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<html>
<head>
<link rel='stylesheet' href='<c:url value="/css/styles.css" />'  type="text/css" />
<meta charset="UTF-8">
<title>樂透名牌</title>
</head>
<body>
<h1>${title}</h1>
<h3> 
<font color='#FF0000' >
<c:forEach var="number"  items="${numberArray}" > 
   ${ number }&nbsp;
</c:forEach>
</font>
</h3>
<br/>
<p/>
<HR>
<div align="center">
  <small>&lt;&lt;<a href="${header['referer']}">再試一次</a>&gt;&gt;</small>
</div>
</body>
</html>