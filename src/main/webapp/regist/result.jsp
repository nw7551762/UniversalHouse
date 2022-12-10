<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<script type="text/javascript">
    var i = 4;
    function a() {
        i--;
        div1.innerHTML = i + "秒鐘之後自動登錄";
        if (i <= 1) {
            window.clearInterval(tm);
            window.location.href = "<c:url value='/index.jsp'/>";
        }
    }
</script>

</head>

<body>
    <c:if test="${boo }">
        激活成功
        <a href="<c:url value='/index.jsp'/>">返回登錄頁面</a>
        <div id="div1"></div>
        <script type="text/javascript">
            tm = window.setInterval(aa, 1000);
        </script>
    </c:if>
    <c:if test="${!boo }">
        激活不成功,請檢查激活碼,或另擇時間再激活
    </c:if>
</body>
</html>