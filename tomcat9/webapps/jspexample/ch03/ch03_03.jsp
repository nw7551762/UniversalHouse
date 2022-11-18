<%@ page language="java" contentType="text/html; charset=UTF-8"  %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--          這是一個 JSP 的註解                 --%>
<html>
<head>
<link rel='stylesheet' href='<c:url value="/css/styles.css" />'  type="text/css" />
<meta charset="UTF-8">
<title>Hello Again</title>
</head>
<body>
<h3>Hello Again, 大家好</h3>
<br>
<%
java.util.Date d = new java.util.Date();
%>
現在時刻是 <%= d %><br><p/>
明牌為 <%= getLottery() %><br>

<jsp:include page="/commons/previousPage.jsp" />
</body>
</html>
<%!  public String getLottery() {
	return "11  29  31  40  45  46";
}
%>