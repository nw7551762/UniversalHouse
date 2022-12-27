<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>圖片</title>
</head>

<body>
	<h1>文章編號 [${article.articleId}] 的圖片</h1>

	<table>
		<tr>
			<th colspan="6">圖片資料庫</th>
		</tr>
		
		<tr>
			<td>圖片編號</td>
			<td>圖片名稱</td>
			<td>圖片</td>
		</tr>

		<c:forEach var="imgList" varStatus="stat" items="${imgList}">
			<tr>
				<td>${imgList.imgNo}</td>
				<td>${imgList.imgName}</td>
				<td>
					<img height="50" width="50" src="<c:url value='/getArticleImage?imgNo=${imgList.imgNo} ' />">
				</td>

				<td>
					<form method="POST" action="<c:url value='/deleteImg_BS' />">
						<input type="hidden" name="articleId" value="${article.articleId}">
						<input type="hidden" name="imgNo" value="${imgList.imgNo}">
						<input type="submit" value="刪除圖片">
					</form>
				</td>
				
				<td>
					<form method="POST" action="<c:url value='/updateImg_BS' />">
						<input type="hidden" name="articleId" value="${article.articleId}">
						<input type="hidden" name="imgNo" value="${imgList.imgNo}">
						<input type="submit" value="更新圖片">
					</form>
				</td>

			</tr>
		</c:forEach>
		
	</table>

	<a href="<c:url value='/backSide' />">回前頁</a>

</body>

</html>