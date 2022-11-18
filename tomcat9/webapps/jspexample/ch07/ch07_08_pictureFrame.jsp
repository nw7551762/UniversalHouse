<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<link rel='stylesheet' href='<c:url value="/css/styles.css" />'  type="text/css" />
<meta charset="UTF-8">
<title>風景圖</title>
</head>
<body bgcolor='#fffacd'>
<div align='center'>
<TABLE>
   <TR><TD width='120'>&nbsp;</TD>
       <TD>
           <TABLE border='3'><TR><TD>
           <IMG SRC='randomPicture.do'/>
           </TD></TR>
           </TABLE>
       </TD>
       <TD width='120' valign='bottom'>
       <small>&lt;&lt;<a href="${header['referer']}">回前頁</a>&gt;&gt;</small>
       </TD>
   </TR>
</TABLE>
</div>
</body>
</html>