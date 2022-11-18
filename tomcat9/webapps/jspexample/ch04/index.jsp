<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<link rel='stylesheet' href='<c:url value="/css/styles.css" />'  type="text/css" />
<meta charset="UTF-8">
<title>MVC架構</title>
</head>
<body BGCOLOR="white">
<jsp:include page="/commons/header.jsp" />

<h2 align="center">Ch04 MVC架構與存取資料庫</h2>
<div align="center">

<table border="1">
  <tr height="80" bgcolor="lightblue" align="center">
     <td  width="350"><p align="left"/>
       <a href="<c:url value='/ch04/ex01/ch04_01.jsp' />">SendRedirect與RequestDispatcher</a><BR>
          <font face="verdana" size="-2">webapp/ch04/ex01/ch04_01.jsp<BR>
          webapp/ch04/ex01/rd.jsp<BR>
          webapp/ch04/ex01/sr.jsp<BR>
          ch04.ex01.controller.SendRedirectDemo.java<BR>
          ch04.ex01.controller.RequestDispatcherDemo.java</font>
     </td>
     <td  width="350"><p align="left"/>
  	   <a href=" <c:url value='/ch04/ex02/DemoAttributeController' />">放在不同範圍內的屬性物件</a><BR>
          <font face="verdana" size="-2">webapp/ch04/ex02/showAttributes.jsp<br>
                ch04.ex02.controller.DemoAttributeController.java</font><br><br>
          
       <a href=" <c:url value='/ch04/ex02/showAttributes.jsp' />">直接拜訪showAttributes.jsp網頁</a><BR>
           <font face="verdana" size="-2">webapp/ch04/ex02/showAttributes.jsp<BR></font>
     </td>
  </tr>
  <tr height="80" bgcolor="lightblue" align="center">
    <td  width="350"><p align="left">
    
      <a href="<c:url value='/ch04/ex03/ch04_memberForm.jsp' />">新增會員資料(Database)</a><BR><font face="verdana" size="-2">webapp/ch04/ex03/ch04_ex03_mvc_V4.jsp<BR>webapp/ch04/ex03/*.jsp<BR>ch04.ex03.controller.*.java<BR>ch04.ex03.model.*.java</font></td>
    <td  width="350"><p align="left">
      <a href="<c:url value='/ch04/ex04/queryAllMembers.do' />">查詢會員資料(Database)</a><BR><font face="verdana" size="-2">webapp/ch04/ex04/showAllMembers.jsp<BR>ch04.ex04.controller.QueryAllMembers.java</font></td>
  </tr>   
</table>
<hr>
<font color='red'>必須於網址列輸入 http://localhost:8080/jspexample/createtable建立表格</font>
</div>
<jsp:include page="/commons/footer.jsp" />
</body>
</html>
