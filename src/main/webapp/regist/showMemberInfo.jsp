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
	<ul>
		<li><label class="t1" for="memberId">memberId:</label>
			<input type="text" value="${member.memberId}" readonly></li>
			
        <li><label class="t1" for="name">name:</label>
        	<input type="text" value="${member.name}" readonly></li>
        	
        <li><label class="t1" for="password">password:</label>
        	<input type="text" value="${member.password}" readonly></li>
        	
        <li><label class="t1" for="location">location:</label> 
        	<input type="text" value="${member.location}" readonly></li>
        	
        <li><label class="t1" for="email">email:</label>
        	<input type="text" value="${member.email}" readonly></li>
        	
        <li><label class="t1" for="phone">phone:</label>
        	<input type="text" value="${member.phone}" readonly></li>
        	
        <li><label class="t1" for="registerTime">registerTime:</label>
        	<input type="text" value="${member.registerTime}" readonly></li>
        	
        <li><label class="t1" for="lastLogin">lastLogin:</label>
        	<input type="text" value="${member.lastLogin}" readonly></li>
        	
         
        	
	</ul>
	<img src="<c:url value='/ShowMemberImgServlet?memberPK=${member.memberPK} '/>" alt="no img" width="400px" height="400px">
	<table>
        <tr><td></td></tr>

    </table>



</body>
</html>