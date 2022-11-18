<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta charset="UTF-8">
<link rel='stylesheet' href='<c:url value="/css/styles.css" />'  type="text/css" />
<title>EL</title>
</head>
<body> 
<jsp:include page="/commons/header.jsp" />

<h2 align="center">ch05 EL、動作元素與JavaBean</h2> 
<div align="center">

<table border="1">
  <tr height="80" bgcolor="lightblue" align="center">
    <td  width="350"><p align="left"/>
      <a href="<c:url value='/ch05/ELDemo.do' />">屬性物件的種類</a>
      <br><font face="verdana" size="-2">webapp/ch05/ex01/ELDemo.jsp
      <br>ch05.ex01.controller.ELDemo.jave
      <br>ch05.ex01.model.OrderBean.jave</font>
    </td>
    <td  width="350"><p align="left"/>
      <a href="<c:url value='/ch05/ex02/InputData.jsp' />">EL讀取輸入資料</a>
      <br><font face="verdana" size="-2">webapp/ch05/ex02/InputData.jsp
      <br>webapp/ch05/ex02/InputDataSuccess.jsp
      <br>ch05.ex02.controller.ReadParameterServlet.java</font>
    </td>
  </tr>  
  <tr height="80" bgcolor="lightblue" align="center">
    <td  width="350"><p align="left"/>
      <a href="<c:url value='/ch05/ex03/ch05_03.jsp' />">EL運算</a>
      <br><font face="verdana" size="-2">webapp/ch05/ex03/ch05_03.jsp
      <br>webapp/ch05/ex03/ch05_03solution.jsp</font>
    </td>
    <td  width="350"><p align="left"/>
      <a href="<c:url value='/ch05/ex04/ch05_04.jsp' />">JSP+JavaBean</a>
      <br><font face="verdana" size="-2">webapp/ch05/ex04/ch05_04.jsp
      <br>ch05.ex04.controller.ELVersionController.java</font>
    </td>
  </tr>    
  <tr height="80" bgcolor="lightblue" align="center">
    <td  width="350"><p align="left"/>
      <a href="<c:url value='/ch05/ex05/ch05_05.jsp' />">利用JSP+JavaBean來產生樂透號碼</a><br><font face="verdana" size="-2">webapp/ch05/ex05/ch05_05.jsp</font></td>
    <td  width="350"><p align="left"/>
      <a href="<c:url value='/ch05/ex06/ELIgnoredDemo.jsp' />">忽略 EL</a><br><font face="verdana" size="-2">webapp/ch05/ex06/ELIgnoredDemo.jsp</font></td>
  </tr>
  <tr height="80" bgcolor="lightblue" align="center">
    <td  width="350"><p align="left"/>
      <a href="<c:url value='/ch05/ex07/jspInclude01.jsp' />">jsp:include</a><br><font face="verdana" size="-2">webapp/ch05/ex07/jspInclude01.jsp<br>webapp/ch05/ex07/jspInclude02.jsp<br>webapp/ch05/ex07/jspInclude03.jsp<br></font></td>
    <td  width="350"><p align="left"/>
      <a href="<c:url value='/ch05/ex08/jspForward01.jsp' />">jsp:forward</a><br><font face="verdana" size="-2">webapp/ch05/ex08/jspForward01.jsp<br>webapp/ch05/ex08/jspForward02.jsp<br>webapp/ch05/ex08/jspForward03.jsp<br></font></td>
  </tr>       
  <tr height="80" bgcolor="lightblue" align="center">
    <td  width="350"><p align="left"/>
      <a href="<c:url value='/ch05/c_url_Demo.jsp' />">c_url_Demo.jsp</a>
      <br><font face="verdana" size="-2">webapp/ch05/c_url_Demo.jsp</font>
    </td>
    <td  width="350"><p align="left"/>
          <a href="<c:url value='/ch05/c_redirect_Demo.jsp' />">c_redirect_Demo.jsp</a>
          <br><font face="verdana" size="-2">webapp/ch05/c_redirect_Demo.jsp</font>
    </td>
  </tr>    
</table>
</div>
<hr>
<jsp:include page="/commons/footer.jsp" />
</body>
</html>
