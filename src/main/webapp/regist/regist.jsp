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
        }
        #submit{
        	text-align:right;
        }
        
    </style>
    <script>
		
	</script>
</head>
<body>
	
	<div id="container">
		<h1 style="color: red;">${IdExist}</h1>
        <form action="<c:url value='/regist/regist.do' />" method="post" enctype="multipart/form-data" >
            <p>
                <label class="t1" for="memberId">memberId:</label>
                <input type="text" name="memberId" id="memberId">
            </p>
            
            <p>
                <label class="t1" for="name">name:</label>
                <input type="text" name="name" id="name">
            </p>
           
            <p>
                <label for="password" class="t1">password:</label>
                <input type="text" name="password" id="password">
            </p>
           
            <p>
                <label for="email" class="t1">email:</label>
                <input type="text" name="email" id="email">
            </p>
            
            <input id="submit" type="button" value="送出">
        </form>
    </div>
    
    
    <script src="https://code.jquery.com/jquery-3.6.1.min.js"></script>
	<script>
		$(function () {
			
			$( "#memberId" ).blur(function() {
			  if( $(this).val()=="" &&  $(this).siblings().length <2){
				  $(this).parent().append('<span class="errorMsg" style="color: red; font-size: 4px; margin-left: 20px">請輸入ID</span>')  
			  }else if( $(this).val()!="" ){
				  $(this).parent().children('span').remove();
			  }
			  ifChangeToSubmit();
			});
			$( "#name" ).blur(function() {
				 console.log($(this).siblings().length)
				  if( $(this).val()=="" && $(this).siblings().length <2){
					  $(this).parent().append('<span class="errorMsg" style="color: red; font-size: 4px; margin-left: 20px">請輸入姓名</span>')   
				  }else if( $(this).val()!="" ) {
					  $(this).parent().children('span').remove();
				  }
				  ifChangeToSubmit();
				});
			
			$( "#password" ).blur(function() {
				  if( $(this).val()=="" && $(this).siblings().length <2 ){
					  $(this).parent().append('<span class="errorMsg" style="color: red; font-size: 4px; margin-left: 20px">請輸入密碼</span>')    
				  }else if(  $(this).val()!="" && varifyPassword()){
					  $(this).parent().children('span').remove();
				  }else if( $(this).val()!="" && !varifyPassword()  ){
					  $(this).parent().children('span').remove();
					  $(this).parent().append('<span class="errorMsg" style="color: red; font-size: 4px; margin-left: 20px">密碼應至少包含 8 個字元，包括至少一個大寫字母和一個小寫字母、一個特殊字元和一個數字</span>')
				  }
				  ifChangeToSubmit();
				});
			
			function varifyPassword(){
				let password =  $( "#password" ).val();
				if (password.match(/[a-z]/g) && password.match(/[A-Z]/g) && password.match(/[0-9]/g) && 
		                password.match(/[^a-zA-Z\d]/g) && password.length >= 8){
					return true;
				}else{
					return false;
				}
			}
			
			$( "#email" ).blur(function() {
				  if( $(this).val()=="" && $(this).siblings().length <2 ){
					  $(this).parent().append('<span class="errorMsg" style="color: red; font-size: 4px; margin-left: 20px">請輸入email</span>')  
				  } else if(  $(this).val()!="" ) {
					  $(this).parent().children('span').remove();
				  }
				  ifChangeToSubmit();	
				});
			
			var ifChangeToSubmit = function() {
				( checkAllFilled() && varifyPassword() ) ? 
					$('#submit').removeAttr("type").attr("type", "submit") :
					$('#submit').removeAttr("type").attr("type", "button");
			}
			
			$( "#submit" ).click(function() {
				if( !checkAllFilled() || !varifyPassword() ){
					alert('please fill all item') ;
				}
			})
			
			$('form').submit( function() {
				if( !checkAllFilled ){
				    return false;
				}
			})
			
			
			function checkAllFilled(){
				if( $( "#memberId" ).val()!="" &&  $( "#name" ).val()!="" &&  $( "#password" ).val()!=""   &&  $( "#email" ).val()!=""  ){
					return true;
				}else{
					return false;
				}
				
			}
			 
			
	    });
	
	
		
	
	
	
	</script>
    
</body>
</html>