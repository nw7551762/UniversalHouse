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
<h1>Update Test</h1>
<div id="container">
<!-- scope="session" -->
		<c:set var="test" value="${test}"  />
		<form action="<c:url value='/test/TestUpdataServlet?test=${test.testId}' />" method="post" enctype="multipart/form-data">

		<p>
				<label class="c1" for="testId">${test.testId}</label>
			</p>

			<p>
				<label class="c1" for="examinationQuestion">更改題目</label> <input
					type="text" name="examinationQuestion"
					value="${test.examinationQuestion}"  id ="examinationQuestion">
			</p>
			
			
			<p>
					<label class="c1">更改領域</label>
				<select name="field" value="${test.field}">
					<option value="1">心理測驗</option>
					<option value="2">智力測驗</option>
					<option value="3">魷魚遊戲</option>
					<option value="4">星座測驗</option>
					<option value="5">小小試題</option>
				</select>
			</p>


			<p>
				<label class="c1" for="options">更改選擇題</label> <input
					type="text" name="options"
					value="${test.options}"  id="options">
			</p>

			<p>
				<label class="c1" for="options2">更改選擇題</label> <input
					type="text" name="options2"
					value="${test.options2}"  id="options2">
			</p>

			<p>
				<label class="c1" for="options3">更改分數</label> <input
					type="text" name="options3"
					value="${test.options3}"  id="options3">
			</p>
			
			<p>
				<label class="c1" for="options4">更改分數</label> <input
					type="text" name="options4"
					value="${test.options4}"  id="options4">
			</p>
			

					<input id="submit" type="button" value="儲存" >
					<a href="<c:url value='/' />" >回首頁</a>
			</form>
	</div>
	<script src="https://code.jquery.com/jquery-3.6.1.min.js"></script>
	<script>
	$(function () {
	$( "#examinationQuestion" ).blur(function() {
		 if( $(this).val()=="" &&  $(this).siblings().length <2){
			  $(this).parent().append('<span style="color: red; font-size: 4px; margin-left: 20px">請輸入題目</span>')  
		  }
// 		 ifChangeToSubmit();
	});
	
	$( "#options" ).blur(function() {
		 if( $(this).val()=="" &&  $(this).siblings().length <2){
			  $(this).parent().append('<span style="color: red; font-size: 4px; margin-left: 20px">請輸入選擇題目</span>')  
		  }
// 		 ifChangeToSubmit();
	});
	
	$( "#options2" ).blur(function() {
		 if( $(this).val()=="" &&  $(this).siblings().length <2){
			  $(this).parent().append('<span style="color: red; font-size: 4px; margin-left: 20px">請輸入選擇題目</span>')  
		  }
// 		 ifChangeToSubmit();
	});
	
	$( "#options3" ).blur(function() {
		 if( $(this).val()=="" &&  $(this).siblings().length <2){
			  $(this).parent().append('<span style="color: red; font-size: 4px; margin-left: 20px">請輸入分數</span>')  
		  }

	});
	$( "#options4" ).blur(function() {
		 if( $(this).val()=="" &&  $(this).siblings().length <2){
			  $(this).parent().append('<span style="color: red; font-size: 4px; margin-left: 20px">請輸入分數</span>')  
		  }
		  ifChangeToSubmit();
	});
		 
			$( "#submit" ).click(function() {
				if( !checkAllFilled() ){
					alert('please fill all item') ;
				}
			})
			
			var ifChangeToSubmit = function() {
				checkAllFilled ? 
					$('#submit').removeAttr("type").attr("type", "submit") :
					$('#submit').removeAttr("type").attr("type", "button");
			}
			
			$('form').submit( function() {
				if( !checkAllFilled ){
				    return false;
				}
			})
			
			
			function checkAllFilled(){
				if( $( "#examinationQuestion" ).val()!="" &&  $( "#options" ).val()!="" &&  $( "#options2" ).val()!=""   &&  $( "#options3" ).val()!="" &&  $( "#options4" ).val()!=""  ){
					return true;
				}else{
					return false;
				}
				
			}
		 
		 
	});
	</script>		
</body>
</html>