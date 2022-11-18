<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<link rel='stylesheet' href='<c:url value="/css/styles.css" />'  type="text/css" />
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>${pageContext.request.method} 版</h2>
親愛的${customer.name}, 您好<p/>
您的Email為${customer.email}<P/> 
您的電話為${customer.tel}<P/>
<c:choose>
   <c:when test="${empty customer.fruits}" >
       您未挑選水果
   </c:when>
   <c:otherwise >
       您挑選的水果有
       <c:forEach var="fruit" items="${customer.fruits}"> 
          <c:out value="${fruit}" />
       </c:forEach>
   </c:otherwise>
</c:choose>
&nbsp;
<HR>
<div align="center">
<jsp:include page="/commons/segmentch02.jsp"/>
</div>
</body>
</html>