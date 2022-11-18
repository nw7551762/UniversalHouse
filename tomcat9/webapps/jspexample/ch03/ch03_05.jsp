<%@ page session="false" pageEncoding="UTF-8" errorPage="/ch03/error/ExceptionPage.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
<link rel='stylesheet' href='<c:url value="/css/styles.css" />'  type="text/css" />
<title>本網頁可能含有例外</title>
</head>
<body BGCOLOR='white'>
<ol>
<%
   for ( int i=10; i > -10; i-- ) {
      out.println("<li>100 / " + i + "=" +  100/i + "</li>");
   }
%>
</ol>
</body>
</html>
