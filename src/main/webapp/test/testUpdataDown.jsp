<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
					<th>examinationQuestion</th>
					<th>field</th>
					<th>options</th>
					<th>options2</th>
					<th>options3</th>
					<th>options4</th>
				</tr>
			</thead>
			
			<tbody class="tbody">

			<form action="" method="post" enctype="multipart/form-data">	
            <tr>
                <td>${testBean.examinationQuestion} </td>
                <td>${testBean.field} </td>
                <td>${testBean.options}</td>
                <td>${testBean.options2}</td>
                <td>${testBean.options3}</td>
                <td>${testBean.options4}</td>
            </tr> 
              </form>

 			
			</tbody>
    </table>

<a href="<c:url value='/' />" >回首頁</a>
</div>
</body>
</html>