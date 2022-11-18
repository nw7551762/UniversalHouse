<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta charset="UTF-8">
<link rel='stylesheet' href='<c:url value="/css/styles.css" />'  type="text/css" />
<title>加入會員</title>
</head>
<body>
<h2>加入會員</h2> 
<form action="<c:url value='/ch02/MemberServlet' />" method="POST"> 
    會員代號:<input type="text" name="userId" size = "10"><P/>
    密碼:<input type="password" name="pswd" size = "20"><P/>
    電郵:<input type="text" name="email" size = "50"><P/>
    性別:<input type="radio" name="gender" value='M'/>男生&nbsp;&nbsp;&nbsp;
         <input type="radio" name="gender" value='F'/>女生<P/>
    
    嗜好:<BR>
  <input type="checkbox" name="hobby" value="swimming">游泳<BR>
  <input type="checkbox" name="hobby" value="programming">程式設計<BR>
  <input type="checkbox" name="hobby" value="music">聽音樂<BR><BR><P/>
         <input type="submit" value="確定"><P/>
</form>
<small>&lt;&lt;<a href="<c:url value='/ch02/index.jsp' />">回前頁</a>&gt;&gt;</small>
</body>
</html>