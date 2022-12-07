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
	margin-right: 10px;
}
</style>
</head>
<body>
    <header>
        <h1>修改</h1>
    </header>
    <form action="<c:url value='/ModifyTestServlet'/>" method="post" enctype="multipart/form-data">
        <table>
            <tr>
                <td>testId <input type="text" name="id"></td>
                <td>examinationQuestion <input type="text" name="eq"></td>
                <td>answer <input type="text" name="as"></td>
                <td>field <input type="text" name="fd"></td>
                <td>options <input type="text" name="os"></td>
                <td>options2 <input type="text" name="os2"></td>
                <td>options3 <input type="text" name="os3"></td>
                <td>options4 <input type="text" name="os4"></td>

            </tr>
        </table>
        <button type="submit">送出</button>
    </form>
</body>
</html>