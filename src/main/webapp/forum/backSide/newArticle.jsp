<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>新增文章</title>
<c:set var="memberId" value="${cookie['user'].getValue()}" />
</head>
<body>

	<form method="POST" action="<c:url value='/newArticle_BS'/>" enctype='multipart/form-data'>
		<input type="hidden" name="memberId" value="${memberId}">
		<table>
	
			<tr>
				<td><label>隱私狀態：</label></td>
				<td>
					<select name="status">
							<option value="public" selected>公開</option>
							<option value="hidden">隱藏</option>
							<option value="banned">封禁</option>
							<option value="deleted">被刪除</option>
					</select>
				</td>
			<tr>
	
			<tr>
				<td><label>讚：</label></td>
				<td><input type="number" name="like" value="0" min="0"></td>
			</tr>
			
			<tr>
				<td><label>爛：</label></td>
				<td><input type="number" name="dislike" value="0"  min="0"></td>
			</tr>
	 
			<tr>
				<td><label>文章主題：</label><div>${errorTitleDup}</div></td>
				<td><input type="text" name="title" value="${param.title}" required /></td>
			</tr>
	
			<tr>
				<td><label>內容：</label></td>
				<td><textarea name="content" required></textarea></td>
			</tr>
	
			<tr>
				<td><label>領域：</label></td>
				<td>
					<select name="topicName">
							<option>文書</option>
							<option>生活</option>
							<option>設計</option>
							<option>資訊</option>
							<option>影視</option>
							<option>顧問</option>
					</select>
				</td>
				
			<tr>
				<td><label>圖片：</label></td>
				<td><input name="images" type="file" accept="image/gif, image/jpeg, image/png" multiple/></td>
			</tr>
	
			<tr>
				<td>
					<input type="submit" value="儲存" />
					<input type="reset" value="清除" />
				</td>
			</tr>
		</table>
	
	</form>
	
	<a href="<c:url value='/backSide' />">回上一頁</a>

</body>

</html>