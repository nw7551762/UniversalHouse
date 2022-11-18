<%@ page language="java" contentType="text/html; charset=UTF-8"  %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<link rel='stylesheet' href='<c:url value="/css/styles.css" />'  type="text/css" />
<meta charset="UTF-8">
<title>Hello, Kitty</title>
</head>
<body>

		<table style="border: 1px solid blue;">
		
			<tr >
				<th style="border: 1px solid blue;" height='36'>相對於本文件所在目錄</th>
				<th style="border: 1px solid blue;" height='36'>相對於文件根目錄</th>
				<th style="border: 1px solid blue;" height='36'>絕對路徑</th>
			</tr>
			<tr>
				<td style="border: 1px solid blue;" height='36' align='center'><a href='kitty.jpg'>凱蒂貓</a><br>
				<small> &lt;a href='kitty.jpg' &gt;</small></td>
				<td style="border: 1px solid blue;" height='36' align='center'><a href='/jspexample/ch66/kitty.jpg'>凱蒂貓</a><br>
				<small>&lt;a href='/example/ch99/kitty.jpg'&gt;</small></td>
				<td style="border: 1px solid blue;" height='36' align='center'><a
					href='http://localhost:8080/jspexample/ch66/kitty.jpg'>凱蒂貓</a><br>
					<small>&lt;a
						href='http://localhost:8080/jspexample/ch66/kitty.jpg'&gt;</small></td>
			</tr>
			<tr>
				<td style="border: 1px solid blue;" height='36' align='center'><a href='../images/snoopy.jpg'>史奴比</a><br>
				<small> &lt;a href='../images/snoopy.jpg' &gt;</small></td>
				<td style="border: 1px solid blue;" height='36' align='center'><a href='/jspexample/images/snoopy.jpg'>史奴比</a><br>
                <small> &lt;a href='/jspexample/images/snoopy.jpg' &gt;</small></td>
				<td style="border: 1px solid blue;" height='36' align='center'><a href='http://localhost:8080/jspexample/images/snoopy.jpg'>史奴比</a><br>
				<small> &lt;a href='http://localhost:8080/jspexample/images/snoopy.jpg' &gt;</small></td>
			</tr>
			<tr>
				<td style="border: 1px solid blue;" height='36' align='center'>
					<form action="../ch02/ShowPictureServlet" method="GET">
						<input type="submit" value="美圖" /><br>
						<small> &lt;a href='../ch02/ShowPictureServlet' &gt;</small>
					</form>
				</td>
				<td style="border: 1px solid blue;" height='36' align='center'>
					<form action="/jspexample/ch02/ShowPictureServlet" method="GET">
						<input type="submit" value="美圖" /><br>
						<small> &lt;a href='/jspexample/ch02/ShowPictureServlet' &gt;</small>
					</form>
				</td>
				<td style="border: 1px solid blue;" height='36' align='center'>
					<form action="http://localhost:8080/jspexample/ch02/ShowPictureServlet" method="GET">
						<input type="submit" value="美圖" /><br>
						<small> &lt;a href='http://localhost:8080/example/ch02/ShowPictureServlet' &gt;</small>
					</form>
				</td>
			</tr>
			
		</table>
	</font> 
	<br>
	<a href='browser.jsp'>瀏覽器如何提出請求</a>
	<hr>
<div align='center'>
<small>&lt;&lt;<a href="<c:url value='/ch02/index.jsp' />">回第二章首頁</a>&gt;&gt;</small>
</div>
</body>
</html>