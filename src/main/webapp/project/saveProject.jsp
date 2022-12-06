<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>新增案件資料</title>
</head>
<body>
<form action="<c:url value='/project/SaveProjectServlet' />" method="post">
案件分類：<input type="text" name="pj_Class"><br>
領域分類：<input type="text" name="fieldName"><br>
案件名稱：<input type="text" name="pj_Name"><br>
會員編號：<input type="text" name="memberPk"><br>
案件說明：<input type="text" name="pj_Instruction"><br>
服務地區：<input type="text" name="pj_ServerLocation"><br>
案件報價：<input type="text" name="pj_Price"><br>
<input type="submit" value="送出"><br>
</form>
</body>
</html>