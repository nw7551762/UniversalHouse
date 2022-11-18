<%@ page session="false" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<HTML>
<HEAD>
<link rel='stylesheet' href='<c:url value="/css/styles.css" />'  type="text/css" />
<meta charset="UTF-8">	
<TITLE>本網頁會包含其他的網頁片段</TITLE>
</HEAD>
<c:set target='${pageContext.request}' property='characterEncoding' value='utf-8' />
<body>
<div align='center'>
<table style='width:600px;' border='1'>
   <tr>
     <td>
       <jsp:include page="ch03_07_heading.jsp" >
         <jsp:param name='visitor' value='張軍亞' />
         <jsp:param name='times' value='200' />
       </jsp:include>
     </td>
   </tr>
   <tr height="300">
     <td>
       <h1>本網頁會包含其他的網頁片段</h1>
       包含方式：<br>
          &lt;jsp:include page="ch03_07_heading.jsp" /&gt;<br>
          &lt;jsp:include page="ch03_07_footing.jsp" /&gt;<br>
     </td>
   </tr>
   <tr>
     <td>
        <jsp:include page="/ch03/ch03_07_footing.jsp" />
	 </td>
   </tr>
</table>
<jsp:include page="/commons/previousPage.jsp" />
</div>
</body>
</html>