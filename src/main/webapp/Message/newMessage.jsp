<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>新增留言</title>

</head>
<body onLoad="setFocusToUserId()">
	<div align='center' id="content">

		<form method="POST"
			action="<c:url value='/newMessage?id=${param.articleId}' />"
			enctype='multipart/form-data'>
			<input type="text" name="authorId" value="110">
			<textarea name="content">我覺得...</textarea>
			<input type="submit" name="submit" value="發表留言" />
		</form>
	</div>
</body>
</html>