<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<link rel='stylesheet' href='<c:url value="/css/styles.css" />'  type="text/css" />
<meta charset="UTF-8">
<title>Show All Members</title>
</head>
<body>
<div align="center">
<c:choose>
   <c:when test="${empty AllMembers}">
        <br>
        <p/>
        <h3>查無任何會員資料</h3>
   </c:when>
   <c:otherwise>
   
	<c:forEach var="mem"  varStatus="statusX" items="${AllMembers}">
        <c:if test="${statusX.first}" >
            <c:out value="<table border='1' cellspacing='5' cellpadding='5' >" escapeXml="false"/>
      	    <tr bgcolor="CCCC00">
	            <td  colspan='5' ALIGN='CENTER'>會員基本資料</td>
			</tr>
			<tr  bgcolor="CCCC00">
			     <th>帳 號</th><th>姓 名</th><th>eMail</th><th>電話</th><th>Java經驗</th>
			</tr>
        </c:if>		         
        <c:choose>
            <c:when test="${ statusX.count % 2 == 0 }">
                <c:set var="colorVar" value="99ddff" />
            </c:when>
            <c:otherwise>
                <c:set var="colorVar" value="88dd00" />
                             </c:otherwise>
                   </c:choose>
                    
                    <tr bgcolor="${colorVar}">
                         <td>${mem.userId}</td>
                         <td>${mem.name} </td>
                         <td>${mem.email}</td>
                         <td>${mem.tel} </td>
                         <td>${mem.experience}</td>
                    </tr>
                     <c:if test="${statusX.last}" >
                        <c:out value="</table>" escapeXml="flase" />
                    </c:if>		                      
		    </c:forEach>
</c:otherwise>
</c:choose>		
<c:if test='${not empty filterPath}'>
  <c:out value="<table border='1'>" escapeXml="false" />
  <tr><th>Filter 執行順序</th></tr>

  <c:forEach var='message' items='${filterPath}' >
	<tr><td>${message}</td>   
  </c:forEach>
  <c:out value="</table>" escapeXml="false" />
</c:if>    
<font color='red'>${ErrorMessage} </font>
<jsp:include page="/commons/previousPage.jsp" />
</div>
</body>
</html>