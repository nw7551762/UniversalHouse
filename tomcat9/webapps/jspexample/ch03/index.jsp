<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<link rel='stylesheet' href='<c:url value="/css/styles.css" />'  type="text/css" />
<title>JSP 基本觀念</title>
</head>
<body BGCOLOR="white">
<jsp:include page="/commons/header.jsp" />

<h2 align="center">Ch03  JSP 網頁</h2>
<div align="center">

<table border="1">
  <tr height="80" bgcolor="lightblue" align="center">
    <td  width="350"><p align="left"/>
      <a href="<c:url value='/ch03/ch03_01.jsp' />">第一個JSP網頁</a><br><font face="verdana" size="-2">webapp/ch03/ch03_01.jsp</font></td>
    <td  width="350"><p align="left"/>
      <a href="<c:url value='/ch03/form.jsp' />">執行html的表單(form.jsp)</a><br><font face="verdana" size="-2">webapp/ch03/form.jsp<br>webapp/ch03/ch03_02_sayHello.jsp</font></td>
  </tr>  
  <tr height="80" bgcolor="lightblue" align="center">
    <td  width="350"><p align="left"/>
      <a href="<c:url value='/ch03/ch03_03.jsp' />">JSP網頁的元素</a><br><font face="verdana" size="-2">webapp/ch03/ch03_03.jsp</font></td>
    <td  width="350"><p align="left"/>
      <a href="<c:url value='/ch03/ch03_04.jsp' />">JSP 的註解</a><br><font face="verdana" size="-2">webapp/ch03/ch03_04.jsp</font></td>
  </tr>  
  <tr height="80" bgcolor="lightblue" align="center">
    <td  width="350"><p align="left"/>
      <a href="<c:url value='/ch03/ch03_05.jsp' />">JSP的例外處理</a><br><font face="verdana" size="-2">webapp/ch03/ch03_05.jsp<br>webapp/ch03/error/ExceptionPage.jsp</font></td>
    <td  width="350"><p align="left"/>
      <a href="<c:url value='/ch03/ch03_06.jsp' />">Servlet的例外處理</a><br><font face="verdana" size="-2"><br></font></td>
  </tr>  
  <tr height="80" bgcolor="lightblue" align="center">
  <td  width="350"><p align="left"/>
      <a href="<c:url value='/ch03/ch03_07.jsp' />">包含其他的網頁片段</a><br><font face="verdana" size="-2">webapp/ch03/ch03_07.jsp<br>webapp/ch03/ch03_07_included.jsp</font></td>
    
    <td  width="350"><p align="left"/>
      </td>
  </tr>  
  
</table>
</div>
<hr>
<jsp:include page="/commons/footer.jsp" />
</body>
</html>
