<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
body {
    font-size: 17px;
    font-family: Arial, Helvetica, sans-serif;
    background-color: #fff;
}

header {
    background-color: black;
    color: lightgreen;
    /* 內距 */
    padding: 20px;
    text-align: center;
}

.container {
    width: 90%;
    /* 外距 */
    margin: auto;
    padding: 10px;
}
</style>
</head>
<body>
   <ul>
   		<li><label class="t1" for="imgNumber">imgNumber</label>
			<input type="text" value="${test.imageNumber}" readonly></li>
			

        	
   </ul>
   <img src="<c:url value='/ShowImgTestServlet?imageNumber=${test.imageNumber} '/>" alt="no img" width="400px" height="400px">
	<table>
        <tr><td></td></tr>
        <a href="<c:url value='/' />" >回首頁</a>
            </table>
</body>
</html>