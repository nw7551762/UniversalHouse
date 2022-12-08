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
		<form action="<c:url value='/TestResultServlet?questionCounts=${testBeans.size()}'/>" method="post" enctype="multipart/form-data">

			<c:forEach var="testBean" items="${testBeans}" varStatus="vs">
				<fieldset id="tests" name= "test">
					<legend>${testBean.examinationQuestion}</legend>


					<div>
						<input type="radio" name="${vs.count}"  value="1"> 
						<label for="huey">${testBean.options}</label>
					</div>

					<div>
						<input type="radio" name="${vs.count}" value="2"> 
						<label for="dewey">${testBean.options2}</label>
					</div>



				</fieldset>
			</c:forEach>
			<input type="submit"  value="提交" class="" onclick="">
		</form>
	</div>
	<script src="https://code.jquery.com/jquery-3.6.1.min.js"></script>
	<script>
	$(function(){
		$(.container)
	})

	// on click事件
	
	
	
	
	//pass  form and list.length to servlet 
	//for( int i =1; i<list.length; i++) {
	//		getparam( vscounts)
	//		if(1){
	// 		sum+= points(one)
	//     }else{
	//			sum+= points(two)
	//		}
	//		
	//
	
		/*const test = {
		 examinationQuestion :   "",
		 options :				"";
		 options2 :				"";
		 options3 :				"";
		 options4 :				"";
		
		 };

		 var test1 = Object.creat(test);

		 $('tbody').on('click', 'delete', function(){
		 let 
		 })
		 */
	</script>
</body>
</html>