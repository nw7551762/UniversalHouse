<%@ page session="false" isErrorPage="true" pageEncoding="UTF-8" import="java.io.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
  String expTypeFullName
    = exception.getClass().getName();
  String expTypeName
    = expTypeFullName.substring(expTypeFullName.lastIndexOf(".")+1);
  String request_uri
    = (String) request.getAttribute("javax.servlet.error.request_uri");
%>
<html>
<head>
<link rel='stylesheet' href='<c:url value="/css/styles.css" />'  type="text/css" />
<title>JSP Exception Page</title>
</head>
<body BGCOLOR='white'>
<div align='center'>
<table BORDER='1'>
<tr height='160' >
  <td align='center' colspan='2'><br><font size='7' color='red'>發生例外</font><br></td>
</tr>
<tr>
  <td align='center' >
     <img src="<c:url value='/ch03/images/askduke.gif' />" alt='Ask Duke!'>
  </td>
  <td bgcolor='pink' align='center'>
    <font size='6' color='red'><b><%= expTypeName %></B></font>
  </td>
</tr>
<tr>  
  <td colspan='2'><br>
    <b>例外原因：<%= exception.getMessage() %></b><br><br>
    <b>造成例外的請求：<%= request_uri %></b><br><br>
  </td>
</tr>
</table>
<hr>
<a href="<c:url value='/ch03/index.jsp' />">回第三章</a>
</div>
</body>
</html>
