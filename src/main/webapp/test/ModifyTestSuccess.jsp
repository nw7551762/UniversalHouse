<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
body {
    font-size: 17px;
    font-family: Arial, Helvetica, sans-serif;
    background-color: #fff;
}

header {
    background-color: black;
    color: lightgreen;
    /* 內距 */
    padding: 20px;
    text-align: center;
}

.container {
    width: 90%;
    /* 外距 */
    margin: auto;
    padding: 10px;
}
</style>
</head>
<body>
<table>

<c:forEach var="testBean" items="${testBeans}">

<tr>
<td>${testBean.testId}</td>
<td>${testBean.answer}</td>
<td>${testBean.field}</td>
<td>${testBean.examinationQuestion}</td>
<td>${testBean.options}</td>
<td>${testBean.options2}</td>
<td>${testBean.options3}</td>
<td>${testBean.options4}</td>
</tr>
</c:forEach>

</table>
    <div class="container">

    </div>
</body>
</html>