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
				  $(this).parent().append('<span style="color: red; font-size: 4px; margin-left: 20px">請輸入ID</span>')  
			  }
			  ifChangeToSubmit();
			});
			$( "#name" ).blur(function() {
				  if( $(this).val()=="" && $(this).siblings().length <2){
					  $(this).parent().append('<span style="color: red; font-size: 4px; margin-left: 20px">請輸入姓名</span>')   
				  }
				  ifChangeToSubmit();
				});
			$( "#password" ).blur(function() {
				  if( $(this).val()=="" && $(this).siblings().length <2 ){
					  $(this).parent().append('<span style="color: red; font-size: 4px; margin-left: 20px">請輸入密碼</span>')    
				  }
				  ifChangeToSubmit();				  
				});
			$( "#email" ).blur(function() {
				  if( $(this).val()=="" && $(this).siblings().length <2 ){
					  $(this).parent().append('<span style="color: red; font-size: 4px; margin-left: 20px">請輸入email</span>')  
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