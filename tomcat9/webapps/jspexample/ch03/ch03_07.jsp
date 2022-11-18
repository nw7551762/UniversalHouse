<%@ page session="false" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta charset="UTF-8">
<link rel='stylesheet' href='<c:url value="/css/styles.css" />'  type="text/css" />
<title>本網頁會包含其他的網頁片段</title>
</head>
<body>
<div align='center'>
<h2>包含共用的網頁片段</h2>
<table style='width:800px;' border='1'>
  <tr>
     <td>靜態包含</td><td><a href="<c:url value='/ch03/ch03_07_directive_include.jsp' />">使用 &lt;%@ include file='ch03_07_directive_include.jsp'  %&gt;</a></td>
  </tr>
  <tr>
     <td>動態包含</td><td><a href="<c:url value='/ch03/ch03_07_standard_action_include.jsp' />">使用 &lt;jsp:include page='ch03_07_standard_action_include.jsp'  %&gt;</a></td>
  </tr>
  <tr>
     <td>動態包含</td><td><a href="<c:url value='/ch03/ch03_07_jstl_import.jsp' />">使用 &lt;c:import url='ch03_07_jstl_import.jsp'  %&gt;</a></td>
  </tr>
</table>
<p/>
<small>
<a href="<c:url value='/ch03/index.jsp' />">回第三章首頁</a>
</small>
</div>
</body>

</html>
