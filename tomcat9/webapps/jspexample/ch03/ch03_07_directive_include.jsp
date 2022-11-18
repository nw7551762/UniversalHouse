<%@ page session="false" pageEncoding="UTF-8" errorPage="/ch03/error/ExceptionPage.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>

<head>
<link rel='stylesheet' href='<c:url value="/css/styles.css" />'  type="text/css" />
<meta charset="UTF-8">
<title>本網頁會包含其他的網頁片段</title>
</head>
  
<body>
<div align='center'>
<table style='width:600px;' border='1'>
   <tr><td><%@ include file="/ch03/ch03_07_heading.jsp" %></td></tr>
   <tr height="300">
     <td><h1>本網頁會包含其他的網頁片段</h1>
         包含方式：<br>
         &lt;%@ include file="ch03_07_heading.jsp" %&gt;<br>
         &lt;%@ include file="ch03_07_footing.jsp" %&gt;<br>
     </td>
   </tr>
   <tr>
     <td>
       <%@ include file="ch03_07_footing.jsp" %>
     </td>
   </tr>
</table>
<jsp:include page="/commons/previousPage.jsp" />
</div>
</body>
</html>
