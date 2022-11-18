<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta charset="UTF-8">	
<link rel='stylesheet' href='<c:url value="/css/styles.css" />'  type="text/css" />
<title>要求瀏覽器不要Cache回應</title>
<script language="JavaScript" type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.js"></script>
<script src="<c:url value='/scripts/ajax.js' />" type="text/javascript">
</script>
<style type="text/css">
table, th, td {
  border: 1px solid;
}
</style>
</head>
<body>
<div align='center'>
<table>
   <tr><th>Cache回應之範例展示(JQuery)</th></tr>  
</table>
<hr>
<div id="currentTime">目前時間為...</div>
<p />
<c:url var='showMessage' value='/ch02/ex09/ShowMessage' />
<input type="button" value="顯示目前時間" id='btncurrentTime' />
<p />

<script>
 $("#btncurrentTime").click(function(){
		  $.getJSON("${showMessage}",null, function(result){
              $("#currentTime").empty();
		      let seg = "<table><tbody><tr><td>瀏覽器</td><td>" + result.browser + "</td></tr>";
		      seg += "<tr><td>訊息</td><td>" + result.msg + "</td></tr>";
		      seg += "<tr><td>現在時間</td><td>" + result.timeNow + "</td></tr>";
		      seg += "</tbody></table>";
		      $("#currentTime").append(seg);
		    });
	});
</script>


<small>&lt;&lt;<a href="<c:url value='/ch02/index.jsp' />">回前頁</a>&gt;&gt;</small>
</div>
</body>
</html>