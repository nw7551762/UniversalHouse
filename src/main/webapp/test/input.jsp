<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form name="insertMemberFormA" 
	action="<c:url value='/BLOB.do'  />" method="POST">
		<table border="1">
			<tr bgcolor='tan'>
				<td height="50" colspan="2" align="center"><input type="submit"
					value="開始測試"></td>
			</tr>
		</table>
	</form>
</body>
</html>