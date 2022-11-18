<%@ page contentType="text/html; charset=UTF-8" session="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>  
<head>
<link rel='stylesheet' href='<c:url value="/css/styles.css" />'  type="text/css" />
<meta charset="UTF-8">
<title>Filter</title>
</head>

<body bgcolor='white'>

<!-- Page Heading -->
<table border='1' style="width: 100%">
<tr bgcolor='#CCCCFF' align='center' height='20'>
  <td><h3>Filter Demo</h3></td>
</tr>
</table>
<h3>Filter功能展示</h3>
<ol>
<li>
Filter與Servlet的執行順序:<br>
&nbsp;&nbsp;<a href="<c:url value='/ch08/SingleFilterServlet' />">單一Filter監控的Servlet</a><br>
&nbsp;&nbsp;<a href="<c:url value='/ch08/TargetServlet' />">多個Filter監控的Servlet</a><p/>
<li>
執行程式時間&nbsp;&nbsp;${TimeElapse}<br>
&nbsp;&nbsp;<a href="<c:url value='/ch04/ex04/queryAllMembers.do' />">/ch04/ex04/queryAllMembers.do</a><p/>
 
</ol>
<hr>
<c:remove var='TimeElapse' scope='session'/>
<jsp:include page="/commons/footer.jsp" />
</body>
</html>
