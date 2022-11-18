<!DOCTYPE HTML>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta charset="UTF-8">
<link rel='stylesheet' href='<c:url value="/css/styles.css" />'  type="text/css" />
<title>瀏覽器送出GET命令的時機</title>
</head>
<body>
<div align='center'>
<h2>瀏覽器送出GET命令的時機</h2>
<table style='border: 2px solid green;'>
<tr>
   <td style="border: 1px solid black; width: 50%">
      <table>
         <tr height='40'><th>1. 在網址列輸入URL，然後按下Enter</th></tr>
         <tr height='40'><td>http://192.168.xx.xx:8080/example <br>(IP 應以實際的IP為主)</td></tr>
      </table>
   </td>
   <td style="border: 1px solid black; width: 50%">
      <table>
         <tr height='40'><th>2. 當使用者在網頁內按下某個超連結</th></tr>    
         <tr height='40'><td align='center'><a href="<c:url value='/ch02/index.jsp' />" >第二章首頁</a><br>&nbsp;</td></tr>
      </table>
   </td>
</tr>
<tr>
    <td colspan='2' align='center'>
      <table>
         <tr><th> 3.利用表單輸入資料(Form標籤的method屬性為GET)</th></tr>    
         <tr><td style="border: 1px solid black; width: 60%">
            <Form action="<c:url value='/ch02/survey.do' />" method="GET">
            <table>
            <tr>
            <td width='20%'>
            <td width='30%'>
              <p >姓名: <input	type="text" size='5' name="userName" value="李大華"></p>
              <p >EMail: <input type="text" size='15' name="eMail" value="user@ppp.com.tw"></p>
              <p >電話號碼 <input type="text" size='10' name="tel" > </p>
              </td>
              <td width='20%'>
              <td width='30%'>
              
               請挑選喜歡的水果:<br>
                  <input TYPE='checkbox' NAME='fruit' VALUE='香蕉'> 香蕉 <br>      
                  <input TYPE='checkbox' NAME='fruit' VALUE='橘子'> 橘子 <br>
                  <input TYPE='checkbox' NAME='fruit' VALUE='蘋果'> 蘋果 <br>
                  <input TYPE='checkbox' NAME='fruit' VALUE='西瓜'> 西瓜 <br>
                  <input TYPE='checkbox' NAME='fruit' VALUE='梨子'> 梨子 <br><p/>
              
                  </td>
                  </tr>
                  <tr><td style="text-align:center; " colspan='4'>
                  <input   type="submit" value="提交">
                  </td></tr>
                  </table>
            </form>
         </td></tr>
      </table>
    </td>
</tr>
</table>     
</div>
<P/>
<div align='center'>
<small>&lt;&lt;<a href="<c:url value='/ch02/index.jsp' />">回前頁</a>&gt;&gt;</small>
</div>
</body>
</html>