<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>課程管理</title>
</head>
<body>
<h2><a href="<c:url value='/queryCourseServlet' />">查詢所有課程</a></h2>
<h2><a href="<c:url value='/courseMaintain/addCourse.jsp'/>">新增</a></h2>
<h2><a href="<c:url value='/courseMaintain/updateCourse.jsp' />">修改</a></h2>
<h2><a href="<c:url value='deleteCourse.jsp' />">刪除</a></h2>
</body>
</html>