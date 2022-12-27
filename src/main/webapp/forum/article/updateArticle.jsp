<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>更新文章</title>

</head>
<body>
	<c:set var="memberId" value="${cookie['user'].getValue()}" />
	
	<form method="POST" action="<c:url value='/updateArticle' />" enctype="multipart/form-data">
		<input type="hidden" name="authorId" value="${memberId}">
		<input type="hidden" name="articleId" value="${article.articleId}">

		<table>

			<tr>	
				<td><label>隱私狀態：</label></td>
				<td>
					<select name="status">
						<option value="normal" selected>公開</option>
						<option value="hidden">隱藏</option>
					</select>
				</td>
			<tr>


			<tr>
				<td><div>${errorTitleDup}</div></td>
				<td><label>文章主題：</label></td>
				<td><input type="text" name="title" value="${article.title}" required />
			</tr>

			<tr>
				<td><label>內容：</label></td>
				<td><textarea name="content" required>${article.content}</textarea><br>
				</td>
			</tr>

			<tr>
				<td><label>領域：</label></td>
					<td><select name="topicName">
						<option>文書</option>
						<option>生活</option>
						<option>設計</option>
						<option>資訊</option>
						<option>影視</option>
						<option>顧問</option>
					</select>
				</td>
			</tr>

			<tr>
				<td><label>圖片：</label><br>
				
				<c:forEach var="img" varStatus="stat" items="${imgs}">
					<img height="50" width="50" src="<c:url value='/getArticleImage?imgNo=${img.imgNo} ' />">
				</c:forEach>
			
					<input name="images" type="file" accept="image/gif, image/jpeg, image/png" multiple/></td>
			</tr>

			<tr>
				<td>
					<input type="submit" value="修改" />
					<input type="reset" value="還原" />
				</td>
			</tr>

		</table>

	</form>

	<a href="<c:url value='/frontPage' />">回首頁</a>
	
	<form method="POST" action="<c:url value='/searchRecord' />">
		<input type="hidden" name="memberId" value="${memberId}">
		<input type="submit" value="我的紀錄">
	</form>

</body>

</html>