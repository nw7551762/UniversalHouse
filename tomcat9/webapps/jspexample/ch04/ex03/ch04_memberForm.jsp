<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<link rel='stylesheet' href='<c:url value="/css/styles.css" />'  type="text/css" />
<meta charset="UTF-8">
<title>MVC</title>
</head>
<body>
<div align='center'>
<h2>加入會員(將會員資料寫入資料庫)</h2>
 (1) Controller呼叫 error.jsp 與 success.jsp 兩個 View 元件<br>
 (2) 呼叫Model元件來進行會員資料的新增<br><P/>
 <br>
<hr>
<form action="<c:url value='/ch04/ex03/register.do' />" method="POST">
    <table>
         <tr>
             <td align="RIGHT">帳號：</td>
             <td align="LEFT"><input	type="text" name="userId" value="helloSnoopy" size="20"></td>
         </tr>
         <tr>
             <td align="RIGHT">密碼：</td>
             <td align="LEFT" ><input	type="password" name="pswd" value="123456" size="20"></td>
         </tr>             
         <tr>
             <td align="RIGHT">姓名：</td>
             <td align="LEFT" ><input	type="text" name="userName" value="史努比"  size="30"></td>
         </tr>             
         <tr>
             <td align="RIGHT">EMail：</td>
             <td align="LEFT" ><input type="text" name="eMail" value="snoopyHello@ppp.com.tw" size="40"></td>
         </tr>             
         <tr>
             <td align="RIGHT">電話號碼：</td>
             <td align="LEFT" > <input type="text" name="tel" value="0999000999"></td>
         </tr>             
         <tr>
             <td align="RIGHT">使用Java經驗：</td>
             <td align="LEFT" > <input type="text" name="experience" value="1" size="3"> 年</td>
         </tr>    
        <tr>
            <td colspan="2" align="center"><input type="submit" value="提交"> </td>
            </tr>
    </table>
</form>
<p/>
<small>&lt;&lt;<a href="<c:url value='/ch04/index.jsp' />">回第四章首頁</a>&gt;&gt;</small>
</div>
</body>
</html>
