<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<link rel='stylesheet' href='<c:url value="/css/styles.css" />'  type="text/css" />
<meta charset="UTF-8">
<title>EL Demo 2</title>
</head>
<body>
<h2>正確顯示錯誤訊息</h2>
請更正下列錯誤：&nbsp;<br>
<form action="<c:url value='/ch05/ex02/ReadParameters.do' />" method="POST">
姓名:<input type="text" name="customerName" value="${param.customerName}"/>
<font color='red' size='-1'>${errorMSG.NameError}</font><br>

地址:<input type="text" name="address" value="${param.address}"/>
<font color='red' size='-1'>${errorMSG.AddrError}</font><br><P/>

<input type="submit" value="提交"/> <br>
</FORM>
<P/>
<br>
<small>&lt;&lt;<a href="<c:url value='/ch05/index.jsp' />">回第五章首頁</a>&gt;&gt;</small>
</body>
</html>