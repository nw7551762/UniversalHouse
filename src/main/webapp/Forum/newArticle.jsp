<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
	font-size: 10pt;
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

/* #errorMsg { */
/*     position:relative; */
/*     top:0px;  */
/*     left:0px;     */
/* 	color:#FF0000; */
/* 	font-size:0.8em; */
/* } */
</style>
<script type="text/javascript">
	//由<body>的onLoad事件處理函數觸發此函數
	function setFocusToUserId() {
		document.forms[0].mid.focus(); // 將游標放在mid欄位內
	}
</script>
</head>
<body onLoad="setFocusToUserId()">
	<c:set var="funcName" value="REG" scope="session" />
	<!-- 引入共同的頁首 -->
	<div align='center' id="content">

		<form method="POST" action="<c:url value='/newArticle' />"
			enctype='multipart/form-data'>

			<Table
				style="width: 900px; background-color: #E7CDFF; cellspacing: 0; border: 2px solid black;">

				<tr height="16">
					<td colspan='4' style="text-align: center; vertical-align: middle;">
						<div class="error">${errorSaveData}<br>
						</div>
					</td>
				</tr>

				<tr height="52">
					<td style="width: 90px;"><label class="fontSize">帳號：</label><br>&nbsp;
					</td>
					<td style="width: 290px;"><input type='text' name=authorId
						value="${param.authorId}" class="fieldWidth" style="width: 200px;" /><br>&nbsp;
						<font color="red" size="-1">${MsgMap.errorIdEmpty}${MsgMap.errorIdDup}</font>
					</td>
				<tr height="52">
					<td style="width: 90px;"><label class="fontSize">文章主題：</label><br>&nbsp;
					</td>
					<td style="width: 290px;"><input type='text' name=title
						value="${param.title}" class="fieldWidth" style="width: 200px;" /><br>&nbsp;
						<font color="red" size="-1">${MsgMap.errorIdEmpty}${MsgMap.errorIdDup}</font>
					</td>
				<tr height="52">
					<td style="width: 90px;"><label class="fontSize">內容：</label><br>&nbsp;
					</td>
					<td style="width: 290px;"><textarea name=content
							class="fieldWidth" style="width: 200px;"></textarea><br>&nbsp;
						<font color="red" size="-1">${MsgMap.errorIdEmpty}${MsgMap.errorIdDup}</font>
					</td>
				<tr height="52">
					<td style="width: 90px;"><label class="fontSize">領域：</label><br>&nbsp;
					</td>
					<td style="width: 290px;"><select name="topicName"
						class="fieldWidth" style="width: 200px;">
							<option>接案</option>
							<option>學習</option>
							<option>租場</option>
							<option>測驗</option>
					</select> <font color="red" size="-1">${MsgMap.errorIdEmpty}${MsgMap.errorIdDup}</font>
					</td>

					<td><label class="fontSize">圖片：</label><br>&nbsp;</td>
					<td><input name='memberMultipartFile' type='file'
						accept='image/gif, image/jpeg, image/png' /><br>&nbsp;</td>
				</tr>
				<tr height="42">
					<td colspan='4'>
						<div id="btnArea" align="center">
							<input type="submit" name="submit" id="submit" value="儲存" />
						</div>
					</td>
				</tr>
			</Table>
		</form>
		<form method="POST" action="<c:url value='/findById' />">
			<p>查詢文章</p>
			文章編號:<input type="text" name="id" id="id" value="${param.id}"><br>
			<input type="submit" name="submit" id="submit" value="送出" />
		</form>

		<form method="POST" action="<c:url value='/forumList' />">
			<p>查詢發文紀錄</p>
			帳號:<input type="text" name="id" id="id" value="${param.id}"><br>
			<input type="submit" name="submit" id="submit" value="送出" />
		</form>
	</div>
	<div>
		<a href="<c:url value='/FrontPageList' />">回首頁</a>
	</div>
</body>
</html>