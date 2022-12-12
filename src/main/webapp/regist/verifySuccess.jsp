<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>


</head>

<body>
	<c:if test="${! empty LoginOK }">
		<p>驗證成功</p>
		<br>
		<a href="<c:url value='/index.jsp'/>">返回登錄頁面</a>
		<div id="div1"></div>
		<script type="text/javascript">
			tm = window.setInterval(a, 1000);
		</script>
	</c:if>
	<c:if test="${ empty LoginOK }">
		<p>驗證成功</p>
		<a href="<c:url value='/index.jsp'/>">返回登錄頁面</a>
	</c:if>

	<script type="text/javascript">
		var i = 5;
		function a() {
			i--;
			div1.innerHTML = i + "秒鐘之後返回首頁";
			if (i <= 1) {
				window.clearInterval(tm);
				window.location.href = "<c:url value='/index.jsp'/>";
			}
		}
	</script>

</body>
</html>