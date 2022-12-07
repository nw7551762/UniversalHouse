<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
		ul{
			list-style: none;
		}
        .t1 {
            width: 100px;
            float: left;
            text-align: right;
            margin-right: 10px;
        }
    </style>
</head>

<body>

<c:choose>
	<c:when test="${empty testCenter}">
		 fail
	</c:when>
	
	 	<c:otherwise>
   			${testCenter} success
   		</c:otherwise>
</c:choose>
   
<h1>end</h1>
</body>
</html>