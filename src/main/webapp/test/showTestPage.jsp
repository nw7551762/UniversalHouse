<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
table {
	border: 1px solid black;
	border-collapse: collapse;
	width:100%;
}
</style>
</head>
<body>
	<div class="container">
		<form>
		<!--
			<table border='1'>
				<thead>
					<tr>
						<th>examinationQuestion</th>
						<th>options</th>
						<th>options2</th>
						<th>options3</th>
						<th>options4</th>
						

					</tr>
				</thead>
				  -->
<tbody class = "tbody">
<c:forEach var="testBean" items=" ${testBeans}">

<div class="divCss">
${testBean.examinationQuestion}
    <ol type="A" start="" class="olCss">
        <input class="inputClass" type="checkbox" name="place" value="A" checked="checked"><li class="liRight">${testBean.options}</li>
        <input class="inputClass" type="checkbox" name="place" value="B" checked="checked"><li class="liRight">${testBean.options2}</li>
        <input class="inputClass" type="checkbox" name="place" value="C" checked="checked"><li class="liRight">${testBean.options3}</li>
    </ol>
</div>
<!-- 
<tr>
<td> c</td>
<td><input type="radio">${testBean.options}</td>
<td><input type="radio" >${testBean.options2}</td>
<td>${testBean.options3}</td>
<td>${testBean.options4}</td>
</tr>
-->

</c:forEach>
</tbody>
<!-- </table> -->
</form>
</div>
	<script src="https://code.jquery.com/jquery-3.6.1.min.js"></script>
<script>
const test = {
		examinationQuestion :   "",
		options :				"";
		options2 :				"";
		options3 :				"";
		options4 :				"";
		
};
/*
var test1 = Object.creat(test);

$('tbody').on('click', 'delete', function(){
	let 
})
*/

</script>
</body>
</html>