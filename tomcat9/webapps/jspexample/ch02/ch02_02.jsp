<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE HTML>
<html>
<head>
<meta charset="UTF-8">
<link rel='stylesheet' href='<c:url value="/css/styles.css" />'  type="text/css" />
<title>瀏覽器送出POST命令的時機</title>
</head>
<body>
<div align='center'>
<h2>瀏覽器送出POST命令的時機</h2>
<table>
<tr>
    <td colspan='2' align='center'>
      <table border='1'>
         <tr><th> 1.利用表單輸入資料(Form標籤的method屬性為POST)</th></tr>    
         <tr><td align="center">
            <form action="<c:url value='/ch02/survey.do' />" method="POST">
            <table style='width: 640px' border='1' >
            <tr>
            <td width='50%'>
              <p >姓名: <input	type="text" size='5' name="userName" value="李大華"></p>
              <p >EMail: <input type="text" size='15' name="eMail" value="user@ppp.com.tw"></p>
              <p >電話號碼 <input type="text" size='10' name="tel" > </p>
            </td>
            <td width='50%'>
              
               請挑選喜歡的水果:<br>
                  <input TYPE='checkbox' NAME='fruit' VALUE='香蕉'> 香蕉 <br>      
                  <input TYPE='checkbox' NAME='fruit' VALUE='橘子'> 橘子 <br>
                  <input TYPE='checkbox' NAME='fruit' VALUE='蘋果'> 蘋果 <br>
                  <input TYPE='checkbox' NAME='fruit' VALUE='西瓜'> 西瓜 <br>
                  <input TYPE='checkbox' NAME='fruit' VALUE='梨子'> 梨子 <br><p/>
              
                  </td>
                  </tr>
                  <tr><td style="text-align:center; " colspan='2'>
                  <input type="submit" value="提交">
                  </td></tr>
                  </table>
            </form>
         </TD></TR>
      </TABLE>
    </TD>
</TR>
</TABLE>     
<p/>

<small>&lt;&lt;<a href="<c:url value='/ch02/index.jsp' />">回前頁</a>&gt;&gt;</small>
</div>
</body>
</html>