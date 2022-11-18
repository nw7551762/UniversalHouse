<%@ page contentType="text/html; charset=UTF-8"  %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<link rel='stylesheet' href='<c:url value="/css/styles.css" />'  type="text/css" />
<meta charset="UTF-8">
</head>
<body>
<h1>表格新建成功</h1>
<c:if test="${not empty messages}">
  <p>
  <font color='blue'>執行結果：
  <c:forEach var="message" items="${messages}">
         <li>${message}</li>
  </c:forEach>
  </font>
  </p>
</c:if>
<br><br>
請重新啟動伺服器<br><br>
<P/><a href="<c:url value='/ch04/index.jsp' />">回前頁</a>
</body>   
</html>