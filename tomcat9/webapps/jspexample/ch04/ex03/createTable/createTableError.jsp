<%@ page contentType="text/html; charset=UTF-8"  %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<link rel='stylesheet' href='<c:url value="/css/styles.css" />'  type="text/css" />
<meta charset="UTF-8">
</head>
<body>
<H1>新建表格失敗</H1>
<%-- Report any errors (if any) --%>
<c:if test="${not empty errorMsgs}">
  <p>
  <font color='red'>新建表格時，發生下列錯誤：
   <c:forEach var="message" items="${errorMsgs}">
      <li>${message}</li>
  </c:forEach>
  </font>
  </p>
</c:if>
<br>
<small>&lt;&lt;<a href="<c:url value='/ch04/index.jsp' />">回前頁</a>&gt;&gt;</small>
</body>   
</html>