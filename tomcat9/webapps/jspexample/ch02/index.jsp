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
<div align="center">
<h2>Ch02 請求與回應</h2>
<table border="1">
  <tr height="80" bgcolor="lightblue" align="center">
    <td  width="350"><p align="left"/>
         <a href="<c:url value='/ch02/ch02_01.jsp' />">瀏覽器送出GET命令的時機</a>
         <br><font face="verdana" size="-2">webapp/ch02/ch02_01.jsp</font>
    </td>
    <td  width="350"><p align="left"/>
         <a href="<c:url value='/ch02/ch02_02.jsp' />">瀏覽器送出POST命令的時機</a>
         <br><font face="verdana" size="-2">webapp/ch02/ch02_02.jsp</font>
    </td>
  </tr> 
  <tr height="80" bgcolor="lightblue" align="center">
   <td  width="350"><p align="left"/>
      <a href="<c:url value='/ch02/ch02_03.jsp' />">讀取表單資料(POST) </a>
      <br><font face="verdana" size="-2">webapp/ch02/ch02_03.jsp
      <br>ch02.ex03.controller.ProcessOrder.java
      <br>webapp/ch02/displayCustomerInfo.jsp</font>
    </td>
    <td  width="350"><p align="left"/>
        <a href="<c:url value='/ch02/ch02_04.jsp' />">由Servlet產生文字性回應</a>
        <br><font face="verdana" size="-2">webapp/ch02/ch02_04.jsp
        <br>ch02.ex04.controller.MemberServlet.java</font>
    </td>
  </tr>  
<tr height="80" bgcolor="lightblue" align="center">
    <td width="350"><p align="left"/>
        <a href="<c:url value='/ch02/ch02_05.jsp' />">由Servlet產生非文字性回應</a>
        <br><font face="verdana" size="-2">webapp/ch02/ch02_05.jsp
        <br>webapp/ch02/showPicture.jsp
        <br>ch02.ex05.controller.ShowPictureServlet.java</font> 
    </td>
    <td width="350"><p align="left"/>
        <a href="<c:url value='/ch02/sendRedirect' />">setHeader範例(sendRedirect)</a><br>
        <font face="verdana" size="-2">ch02.ex06.controller.SendRedirect.java
        <br>webapp/ch02/ch02_06_1.jsp,&nbsp;ch02_06_2.jsp
        <br>ch02_06_3.jsp&nbsp;與&nbsp;ch02_06_4.jsp</font>
    </td>
  </tr>    
 
  <tr height="80" bgcolor="lightblue" align="center">
    <td  width="350"><p align="left"/>
         <a href="<c:url value='/ch02/ch02_07.do' />">setHeader範例，我們搬家了</a>
         <br><font face="verdana" size="-2">(客戶端提取)
         <br>ch02.ex07.controller.SetHeader01.java
         </font>
    </td>
    <td  width="350"><p align="left"/>
         <a href="<c:url value='/ch02/ch02_08.do' />">10秒後自動更新畫面</a><br>
         <font face="verdana" size="-2">(客戶端提取)
         <br>ch02.ex08.controller.SetHeader02.java</font> 
         <br>webapp/ch02/ch02_08.jsp</font>
    </td> 
  </tr>
  <tr height="80" bgcolor="lightblue" align="center">
    <td  width="350"><p align="left"/>
      <a href="<c:url value='/ch02/ex09/ShowMessage' />">setHeader範例(不使用 cache)</a><br>
      <font face="verdana" size="-2">
         ch02.ex09.controller.ShowMessage.java<br>
         webapp/ch02/ch02_09.jsp<br>
      </font>
    </td>
    <td  width="350"><p align="left"/>
      <a href="<c:url value='/ch02/ex10/request.do?arg1=value1&name=snoopy' />">與請求有關的資訊</a><br><font face="verdana" size="-2">ch02.ex10.controller.RequestInfo.java</font>
    </td>      
  </tr>
  <tr height="80" bgcolor="lightblue" align="center">
    <td  width="350"><p align="left"/>
      <a href="<c:url value='/ch66/index.jsp' />">瀏覽器如何提出請求</a><br><font face="verdana" size="-2">webapp/ch66/index.jsp</font>
    </td>
    <td  width="350"><p align="left"/>
      <a href="<c:url value='/ch02/ex12/spy.007' />">1.明確的對應關係(/ch02/ex12/spy.007)</a><br><font face="verdana" size="-2">ch02.ex12.controller.ExplicitServlet</font><br>
      <a href="<c:url value='/ch02/ex12/PSY/abula.009' />">2.前置路徑的對應關係(/ch02/ex12/PSY/*)</a><br><font face="verdana" size="-2">ch02.ex12.controller.PrefixServlet</font><br>
      <a href="<c:url value='/ch02/ex12/nono/GangNam_Style.007' />">3.延伸檔名的對應關係(*.007)</a><br><font face="verdana" size="-2">ch02.ex12.controller.ExtensionServlet</font><br>
      4.預設的對應關係(/*)保留給容器用對應關係<br><font face="verdana" size="-2">ch02.ex12.controller.DefaultServlet</font><br>
    </td>      
  </tr>    
</table>
</div>
<hr>
<jsp:include page="/commons/footer.jsp" />
</body>
</html>
