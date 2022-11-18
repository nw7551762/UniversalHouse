<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<link rel='stylesheet' href='<c:url value="/css/styles.css" />'  type="text/css" />
<meta charset="UTF-8">
<title>放在不同範圍內的屬性物件</title>
</head>
<body>
<div align='center'>
<h2>放在不同範圍內的屬性物件</h2>
<br>
請求範圍內的屬性物件 A：<font color='red'>${requestIdStringA}</font><br>
請求範圍內的屬性物件 B：<font color='red'>${requestIdStringB}</font><br>
<hr>
Session範圍內的屬性物件 A：<font color='blue'>${sessionIdStringA}</font><br>
Session範圍內的屬性物件 B：<font color='blue'>${sessionIdStringB}</font><br>
<hr>
應用系統範圍內的屬性物件 A：<font color='green'>${applicationIdStringA}</font><br>
應用系統範圍內的屬性物件 B：<font color='green'>${applicationIdStringB}</font><br>
<br><hr><br>
<small>&lt;&lt;<a href="<c:url value='/ch04/index.jsp' />">回第四章首頁</a>&gt;&gt;</small>
</div>
</body>
</html>