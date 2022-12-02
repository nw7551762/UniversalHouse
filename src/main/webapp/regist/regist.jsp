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
</head>
<body>
	<div id="container">
        <form action="<c:url value='/regist/regist.do' />" method="post" enctype="multipart/form-data">
            <p>
                <label class="t1" for="memberId">memberId:</label>
                <input type="text" name="memberId">
            </p>
            
            <p>
                <label class="t1" for="name">name:</label>
                <input type="text" name="name">
            </p>
           
            <p>
                <label for="password" class="t1">password:</label>
                <input type="text" name="password">
            </p>
           
            <p>
                <label for="email" class="t1">email:</label>
                <input type="text" name="email">
            </p>
            
            <input id="submit" type="submit" value="送出">
        </form>
        
        
        
        
        
        
        
        
    </div>
</body>
</html>