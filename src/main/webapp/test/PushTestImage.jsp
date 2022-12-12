<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
.t1 {
	width: 100px;
	float: left;
	text-align: right;
}

#submit {
	text-align: right;
}
</style>
</head>
<body>
	<div id="container">
		<form action="<c:url value='/PushTestImage/PushTestImage.do' />" method="post" enctype="multipart/form-data">
			<p>
				<label class="t1" for="imgNumber">圖片編號:</label> <input type="text"
					name="answer">
			</p>


			<p>
				<label class="t1" for="image">image:</label> <input type="file"
					name="image">
			</p>

			<input id="submit" type="submit"  value="送出"> 
<!-- 			<input id="submit" type="submit" value="修改" formaction="/regist/a.do"> -->
<!-- 			<input id="submit" type="submit" value="刪除" formaction="/regist/a.do"> -->
		</form>
	</div>
</body>
</html>