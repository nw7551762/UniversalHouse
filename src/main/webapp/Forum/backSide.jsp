<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>文章列表</title>
<style type="text/css">
#borderA {
	border: 1px solid black;
}
</style>
</head>
<body>
	<form method="POST" action="<c:url value='/forumList' />">
		作者ID<input type="text" name="id"> <input type="submit"
			name="submit" id="submit" value="文章總覽" />
	</form>
</body>
</html>