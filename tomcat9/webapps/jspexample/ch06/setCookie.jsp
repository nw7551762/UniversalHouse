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
<Form action="setCookie.do" method="POST">
      <p/> 姓名: <input	type="text" name="username" >
      <input type="submit" value="提交">
</Form>
</body>
</html>