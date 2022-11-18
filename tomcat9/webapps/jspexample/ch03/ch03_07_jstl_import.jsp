<%@ page session="false" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta charset="UTF-8">
<link rel='stylesheet' href='<c:url value="/css/styles.css" />'  type="text/css" />
<title>本網頁會包含其他的網頁片段</title>
</head>
<c:set target='${pageContext.request}' property='characterEncoding' value='utf-8' />
<body>
<div align='center'>
<table style='width:600px;' border='1'>
  <tr><td>
      <c:import url="/ch03/ch03_07_heading.jsp" >
          <c:param name='visitor' value='呂惠芳' />
          <c:param name='times' value='150' />
      </c:import>
   </td></tr>
   <tr height="300"><td>
     <h1>本網頁會包含其他的網頁片段</h1>
     包含方式：<br>
     &lt;c:import url="ch03_07_heading.jsp" /&gt;<br>
     &lt;c:import url="ch03_07_footing.jsp" /&gt;<br>
   </td></tr>
   <tr><td>
       <c:import  url="/ch03/ch03_07_footing.jsp" />
   </td></tr>
</table>
<jsp:include page="/commons/previousPage.jsp" />
</div>
</body>