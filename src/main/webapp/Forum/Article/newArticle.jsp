<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>新增文章</title>
<style type="text/css">
span.error {
	color: red;
	display: inline-block;
	font-size: 10pt;
}

.error {
	color: red;
	display: inline-block;
	font-size: 25pt;
}

input[type=text] {
	font-size: 12pt;
}

body {
	background-attachment: fixed;
	background-color: #EBFFEB;
	background-repeat: no-repeat;
	background-position: 20px 50px;
}

h1 {
	font-family: "標楷體", "新細明體", sans-serif;
	font-size: 24px;
}

.formBkgnd {
	color: #FFFFFF;
	background-color: #666666;
}

label {
	float: left;
	width: 8em;
	font-weight: bold;
	color: #000000;
	margin-top: 10px;
	margin-bottom: 2px;
	margin-right: 10px;
	text-align: right;
}

br {
	clear: both;
}

.fieldWidth {
	margin-top: 10px;
	margin-bottom: 2px;
	width: 200px;
	background: #F6E497;
	font-size: 1.1em;
}
/* 設定字體大小 */
.fontSize {
	font-size: 1.1em;
}

#main {
	position: relative;
	left: 70px;
	width: 600px;
	height: 543px;
	top: 0px;
	z-index: 2;
	font-size: 0.9em;
}
/* 設定傳送鈕的樣式 */
#submit {
	width: 64px;
	height: 30px;
	font-size: 1.2em color:#FFFFFF;
	margin-right: 1.5em;
	border-width: 2px;
	border-color: #FFEDAF #B2A268 #B2A268 #FFEDAF;
	background: #A9A9A9;
}
/* 設定取消鈕的樣式 */
#cancel {
	width: 64px;
	height: 30px;
	font-size: 1.2em color:#ffffff;
	border-width: 2px;
	border-color: #FFEDAF #B2A268 #B2A268 #FFEDAF;
	background: #a9a9a9;
}
table{
	width: 900px; 
	background-color: #F5F5F5; 
	cellspacing: 0; 
	border: 2px solid black
}
</style>
</head>

<body>
<c:set var="memberId" value="${cookie['user'].getValue()}" />
	<form method="POST" action="<c:url value='/newArticle'/>" enctype='multipart/form-data'>
		<input type="hidden" name="memberId" value="${memberId}">
		
		<table>

			<tr height="16">
				<td colspan="4" style="text-align: center; vertical-align: middle;">
					<div class="error">${errorSaveData}${MsgMap.errorIdEmpty}${MsgMap.errorIdDup}</div>
				</td>
			</tr>	

			<tr height="52">
				<td style="width: 90px;"><label class="fontSize">文章主題：</label></td>
				<td style="width: 290px;"><input type="text" name="title" value="${param.title}" class="fieldWidth" style="width: 200px;" required /></td>
			</tr>

			<tr height="52">
				<td style="width: 90px;"><label class="fontSize">內容：</label></td>
				<td style="width: 290px;"><textarea name="content" class="fieldWidth" style="width: 200px;" required></textarea></td>
			</tr>

			<tr height="52">
				<td style="width: 90px;"><label class="fontSize">領域：</label></td>
				<td style="width: 290px;"><select name="topicName" class="fieldWidth" style="width: 200px;">
						<option>文書</option>
						<option>生活</option>
						<option>設計</option>
						<option>資訊</option>
						<option>影視</option>
						<option>顧問</option>
					</select>
				</td>
			</tr>
				
			<tr height="52">
				<td><label class="fontSize">圖片：</label></td>
				<td><input name='memberMultipartFile' type='file' accept='image/gif, image/jpeg, image/png' /></td>
			</tr>

			<tr height="42">
				<td colspan='4'>
					<input type="submit" value="儲存" /> 
					<input type="reset" value="清除" />
				</td>
			</tr>
			
		</table>
		
	</form>
	
	<a href="<c:url value='/FrontPage' />">回首頁</a>
	
</body>

</html>