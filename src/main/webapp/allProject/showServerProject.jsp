<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>想找人才</title>
<style>
.t1{
	width:1400px;
	margin:auto;
	border:1px solid #bebebe;
	text-align:center;
}

.t2{
	width:1400px;
	margin:auto;
	border:1px solid #bebebe;
	text-align:left;
}

.ip1{
	width:200px;
	margin:10px;
}

tr{
	border:1px solid #bebebe;
}

td{
	border:1px solid #bebebe;
}

th{
	border:1px solid #bebebe;
}
</style>
</head>
<body>
<form>
<c:if test="${ empty serverProject}">
<div class="t1">
<h2>查無服務案件資料</h2>
</div>
</c:if>
<c:if test="${not empty serverProject}">
<div class="t2">
<form id="form2" action="/allProject/showServerProjectServlet">
<input type="text" name="findPJName" placeholder="請輸入專案名稱" class="ip1"><input type="submit"  form="form2" value="確認">
</form>
</div>
	<table class="t1">
	<thead>
		<tr>
			<th>案件編號</th>
			<th>領域分類</th>
			<th>案件名稱</th>
			<th>會員編號</th>
			<th>服務地區</th>
			<th>案件報價</th>
			<th>上傳日期</th>
			<th>功能</th>
		</tr>
		</thead>
		<tbody id='tb'>
		<c:forEach var="pj" items="${serverProject}" >
		<tr>
			<td>${pj.pjID}</td>
			<td>${pj.fieldName}</td>
			<td>${pj.pjName}</td>
			<td>${pj.memberID}</td>
			<td>${pj.pjServerLocation}</td>
			<td>${pj.pjPrice}</td>
			<td>${pj.pjUploadDate}</td>
			<td><input type="button" value="查看詳情" id="detail">
				<input type="button" value="邀請報價" id="quotation"></td>
		</tr>
		</c:forEach>
		</tbody>
	</table>
</c:if>
</form>

<div  class="t1"><a href="<c:url value='/' />">回首頁</a></div>

<script src="https://code.jquery.com/jquery-3.6.1.min.js"></script>
<script>

$('#tb').on('click','#quotation',function(){
	let pj_ID = $(this).parent().siblings().eq(0).text();
	let memberID = $(this).parent().siblings().eq(3).text();
	let pj_Price = $(this).parent().siblings().eq(5).text();
	
	$.ajax({
		type:'post',
		url:'<c:url value='/evaluation/AddToProjectCart'/>',
		data:{
			pj_ID:pj_ID,
			memberID:memberID,
			pj_Price:pj_Price,
		},
	
		success:function(){
			alert("成功加入清單")
		},
		
		error:function(thrownError){
			alert("加入清單失敗")
		}
	});
})

</script>
</body>
</html>