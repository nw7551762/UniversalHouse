<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>  	 
<head>   
<meta charset="UTF-8">
<link rel='stylesheet' href="<c:url value='/css/styles.css' />"  type="text/css" />
<title>JSP 範例</title>   
</head> 
<body>
<jsp:include page="/commons/header.jsp" />	  	
<div align="left">
<h3 align="left">基礎篇 </h3>
<ul >
  <li><a href="<c:url value='/ch01/index.jsp' />" >一、入門</a></li>
  <li><a href="<c:url value='/ch02/index.jsp' />" >二、處理請求與產生回應</a></li>
  <li><a href="<c:url value='/ch03/index.jsp' />" >三、JSP 網頁</a> </li>
  <li><a href="<c:url value='/ch04/index.jsp' />" >四、MVC架構與存取資料庫</a> </li>
  <li><a href="<c:url value='/ch05/index.jsp' />" >五、EL、動作元素與JavaBean</a> </li>
  <li><a href="<c:url value='/ch06/index.jsp' />" >六、Session 與 Cookie</a> </li>  
  <li><a href="<c:url value='/ch07/index.jsp' />" >七、Servlet Servlet Context 生命週期</a> </li>
  <li><a href="<c:url value='/ch08/index.jsp' />" >八、Filter 過濾器</a> </li>
</ul>
</div>
</body>
</html>