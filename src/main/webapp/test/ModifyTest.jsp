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
	<div class="container">
		 
		<table border='1'>
    			<thead>
				<tr>
<!-- 					<th>testId</th> -->
					<th>examinationQuestion</th>
					<th>field</th>
					<th>options</th>
					<th>options2</th>
					<th>options3</th>
					<th>options4</th>
				</tr>
			</thead>
			
			<tbody class="tbody">
			<c:forEach var="testBean" items="${testBeans}"> 
			<form action="<c:url value='/ModifyTestEndServlet?testIds=${testBean.testId}'/>" method="post" enctype="multipart/form-data">
            <tr>
<%--             <td>${testBean.testId} <input type="" name="${testBean.testId} " ></td> --%>
                <td name="${testBean.examinationQuestion}">${testBean.examinationQuestion} </td>
                <td name="${testBean.field}">${testBean.field}</td>
                <td name="${testBean.options}">${testBean.options}</td>
                <td name="${testBean.options2}">${testBean.options2}</td>
                <td name="${testBean.options3}">${testBean.options3}</td>
                <td name="${testBean.options4}">${testBean.options4}</td>
            	<td><input type="submit"  value="修改" class="toModifyMode" name="${testBean.testId}" >
								
            </tr> 
               </form>
            </c:forEach>
 			
			</tbody>
			<a href="<c:url value='/' />" >回首頁</a>
    </table>

    </div>
</body>
</html>