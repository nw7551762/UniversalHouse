<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>新增委託項目資料</title>
<style>
fieldset {
	width: 500px;
	margin: auto;
}

.btn {
	width: 500px;
	margin: auto;
	text-align: right;
}

.ins{
	width:350px;
	height:300px;
}

.st1{
	margin:10px;
}

textarea {
            resize: none;
        }
</style>
</head>
<body>
	<form class="t1" action="<c:url value='/myProject/SaveProjectServlet' />"
		method="post" enctype="multipart/form-data">
		<fieldset>
		<div class="st1">
			領域分類：<br>
			<select name="fieldName" id="fieldName">
			<option value="設計">設計</option>
			<option value="資訊">資訊</option>
			<option value="文書">文書</option>
			<option value="影視">影視</option>
			<option value="生活">生活</option>
			<option value="顧問">顧問</option></select><br> 
		</div>
		<div class="st1">
			委託項目名稱：<br><input type="text" name="pj_Name"><br> 
		</div>
		<div class="st1">
			委託項目說明：<br><textarea id="comment1" name="pj_Instruction" cols="40" rows="10"></textarea><br> 
		</div>
		<div class="st1">
			執行地區：<br><input type="text" name="pj_ServerLocation"><br> 
		</div>
		<div class="st1">
			委託項目報價：<br><input type="text" name="pj_Price"><br>
		</div>
		<div class="st1">
			預計完成日：<br><input type="date" name="pj_ExCompletionDate" value="2022-12-01"><br>
		</div>
		</fieldset>
		<br>
		<div class="btn" >
		<input type="submit" value="送出">
		</div>
	</form>
</body>
</html>