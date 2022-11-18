<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
<link rel='stylesheet' href='<c:url value="/css/styles.css" />'  type="text/css" />
<title>ServletConfig與ServletContext</title>
</head>
<body BGCOLOR="white">
<jsp:include page="/commons/header.jsp" />

<h2 align="center">Ch07 Servlet與ServletContext 的生命週期</h2>
<div align="center">
<table border="1">
  <tr height="80" bgcolor="lightblue" align="center">
    <td  width="350"><p align="left"/>
      
      <a href="<c:url value='/ch07/initParameter.do' />">Servlet起始參數－設定</a>
      <br><font face="verdana" size="-2">ch07.ex01.controller.GetInitParameter.java</font>
    </td>
    <td  width="350"><p align="left"/>
      <a href="<c:url value='/ch07/ch07_02.jsp' />">啟動時自動載入(load-on-startup)</a>
      <br><font face="verdana" size="-2">webapp/ch07/ch07_02.jsp
      <br>ch07.ex02.Anytime.java,&nbsp;First.java
      <br>Second.java&nbsp;與&nbsp;Third.java</font>
    </td>
  </tr>  
  
  <tr height="80" bgcolor="lightblue" align="center">
    <td  width="350"><p align="left"/>
      <a href="<c:url value='/ch07/contextInitParam.do' />">ServletContext 設定起始參數</a>
      <br><font face="verdana" size="-2">webapp/ch07/ch07_03.jsp
      <br>ch07.ex03.view.ContextInitParamServlet.java</font>
    </td>
    <td  width="350"><p align="left"/>
      <a href="<c:url value='/ch07/ch07_04.do' />">使用ServletContextListener</a>
      <br><font face="verdana" size="-2">ch07.ex04.ShowCoffeeList.java
      <br>ch07.ex04.web.ServletContextListenerDemo00.java</font>
    </td>
  </tr>  
</table>
</div>
<hr>
<jsp:include page="/commons/footer.jsp" />
</body>
</html>
