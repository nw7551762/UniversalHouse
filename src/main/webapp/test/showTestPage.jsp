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
	width: 100%;
}

p, label {
	font: 1rem 'Fira Sans', sans-serif;
}
</style>
</head>
<body>
	<div class="container">
		<form
			action="<c:url value='/TestResultServlet?questionCounts=${testBeans.size()}'/>"
			method="post" enctype="multipart/form-data" id="form">

			姓名:<input type="text" name="name" class="name" required>
			<c:forEach var="testBean" items="${testBeans}" varStatus="vs">
				<fieldset id="tests" name="test">
					<legend>${testBean.examinationQuestion}</legend>

					
					<div>
						<input type="radio" name="${vs.count}" value="1" class="radio1"  required checked>
						<label for="huey">${testBean.options}</label>
					</div>

					<div>
						<input type="radio" name="${vs.count}" value="2" class="radio2"  required>
						<label for="dewey">${testBean.options2}</label>
					</div>



				</fieldset>
			</c:forEach>
			<input type="submit" value="提交" class="bun">
		
		</form>
	</div>
	<script src="https://code.jquery.com/jquery-3.6.1.min.js"></script>
	<script>

		
	$('.bun').on('click', function() {
		var isel = 0;
		for(var i = 0;  i<=$('#form').length ; i++){
			console.log("123")
			if ( $('.radio1')[i].checked ||  $('.radio2')[i].checked && $('.name')!=null)
				isel += 1;
				
		}
		if(isel<1)	{
				alert('您需要完成以下選項，才可提交問卷。.')
				return false;
			}
		
	})
	
	


	} )
	

	</script>
</body>
</html>