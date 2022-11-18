<%@ page session="false" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>

<head>
<link rel='stylesheet' href='<c:url value="/css/styles.css" />'  type="text/css" />
<meta charset="UTF-8">
<title>例外處理</title>
</head>

<body>
<h2>例外處理</h2>
<table style='width:900px;' border='1'>
  <tr>
     <td>程式發生ServletException</td><td><a href="<c:url value='/ch03/MyErrorProneServlet' />">使用 MyErrorProneServlet</a></td>
  </tr>
  <tr>
     <td>不存在的資源</td><td><a href='NotFound.jsp'>不存在的網頁</a></td>
  </tr>
  <tr>
     <td>程式發生RuntimeException</td><td><a href="<c:url value='/ch03/RuntimeExceptionServlet' />">使用 RuntimeExceptionServlet</a></td>
  </tr>
</table>
<p/>
<small>
<a href="<c:url value='/ch03/index.jsp' />">回第三章首頁</a>
</small>
</body>
</html>
