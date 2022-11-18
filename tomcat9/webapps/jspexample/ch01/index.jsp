<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html> 
<head>
<meta charset="UTF-8">    
<link rel='stylesheet' href='<c:url value="/css/styles.css" />'  type="text/css" />
<title>動態網頁</title>
</head>
<body> 
<jsp:include page="/commons/header.jsp" />
<h2 align="center">Ch01 入門</h2> 
<div align="center">
  
<table border="1">
  <tr height="52" bgcolor="lightblue" align="center">
    <td  width="350"><p align="left"/>
      <a href="<c:url value='/ch01/sayHelloServlet' />">Hello, World (Servlet 版)</a><BR>
           <font face="verdana" size="-2"> ch01.ex01.HelloWorldServlet.java</font>
    </td>
    <td  width="350"><p align="left"/>
      <a href="<c:url value='/ch01/hello.jsp' />">Hello, World (JSP 版)  </a><BR>
           <font face="verdana" size="-2"> webapp/ch01/hello.jsp</font>
    </td>
  </tr>  
  <tr height="52" bgcolor="lightblue" align="center">
    <td  width="350"><p align="left"/>
      <a href="<c:url value='/ch01/messageServlet' />">動態網頁</a><BR>
           <font face="verdana" size="-2"> ch01.ex03.MessageServlet.java</font>
    </td>
    <td  width="350"><p align="left"/>
      <a href="<c:url value='/ch01/helloAgain.jpg' />">Hello, Again (Servlet 版)</a><BR>
           <font face="verdana" size="-2"> ch01.ex04.HahaServlet.java</font>
    </td>
  </tr>  
</table> 
</div>
<hr>
<jsp:include page="/commons/footer.jsp" />
</body>
</html>
