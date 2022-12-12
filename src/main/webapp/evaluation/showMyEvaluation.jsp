<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>我委託的項目</title>
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
<c:if test="${ empty evaluation}">
<div class="t1">
<h2>查無資料</h2>
</div>
</c:if>
<c:if test="${not empty evaluation}">
<div class="t2">
<form id="form2" action="/allProject/showProjectServlet">
<input type="text" name="findPJName" placeholder="請輸入專案名稱" class="ip1"><input type="submit"  form="form2" value="確認">
</form>
</div>
	<table class="t1">
	<thead>
		<tr>
			<th>評價編號</th>
			<th>案件編號</th>
			<th>委託者ID</th>
			<th>成交金額</th>
			<th>完成時間</th>
			<th>對方的評分</th>
			<th>對方的評價</th>
			<th>功能</th>
		</tr>
		</thead>
		<tbody id='tb'>
		<c:forEach var="ev" items="${evaluation}" >
		<tr>
			<td>${ev.evID}</td>
			<td>${ev.pjID}</td>
			<td>${ev.pjMemberID}</td>
			<td>${ev.evDealPrice}</td>
			<td>${ev.evCompletionDate}</td>
			<td>${ev.evClientEV}</td>
			<td>${ev.evClientComment}</td>
			<td>
			<c:if test="${not empty ev.evCompletionDate}">
				<input type="button" value="查看詳情" id="detail">
			</c:if>	
			<c:if test="${empty ev.evCompletionDate}">
				<input type="button" value="查看詳情" id="detail">
				<input type="submit" value="完成" id="deal">
			</c:if>	
			</td>
		</tr>
		</c:forEach>
		</tbody>
	</table>
</c:if>
</form>

<div  class="t1"><a href="<c:url value='/' />">回首頁</a></div>

<script src="https://code.jquery.com/jquery-3.6.1.min.js"></script>
<script>

$('#tb').on('click','#deal',function(){
	let ev_ID = $(this).parent().siblings().eq(0).text();
	
	$.ajax({
		type:'post',
		url:'<c:url value='/evaluation/DealServlet'/>',
		data:{
			ev_ID:ev_ID,
		},
	
		success:function(){
			alert("已完成")
		},
		
		error:function(thrownError){
			alert("再試一次")
		}
	});
})
</script>
</body>
</html>