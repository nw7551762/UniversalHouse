<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>所有案件</title>
<style>
.t1{
	width:1400px;
	margin:auto;
	border:1px solid #bebebe;
	text-align:center;
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
<c:if test="${ empty allProject}">
<h2>查無案件資料</h2>
</c:if>
<c:if test="${not empty allProject}">
	<table class="t1">
	<thead>
		<tr>
			<th>案件編號</th>
			<th>案件分類</th>
			<th>領域分類</th>
			<th>案件名稱</th>
			<th>會員編號</th>
			<th>案件描述</th>
			<th>服務地區</th>
			<th>案件報價</th>
			<th>預計完成日</th>
			<th>執行時間</th>
			<th>上傳日期</th>
			<th>最後更新日期</th>
			<th>案件狀態</th>
			<th>功能</th>
		</tr>
		</thead>
		<tbody id='tb'>
		<c:forEach var="pj" items="${allProject}" >
		<tr>
			<td>${pj.pjID}</td>
			<td>${pj.pjClass}</td>
			<td>${pj.fieldName}</td>
			<td>${pj.pjName}</td>
			<td>${pj.memberPK}</td>
			<td>${pj.pjInstruction}</td>
			<td>${pj.pjServerLocation}</td>
			<td>${pj.pjPrice}</td>
			<td>${pj.pjExCompletionDate}</td>
			<td>${pj.pjExecutionTime}</td>
			<td>${pj.pjUploadDate}</td>
			<td>${pj.pjLastUpdate}</td>
			<td>${pj.pjStatus}</td>
			<td><input type="button" value="修改" id="reviseProject">
				<input type="button" value="刪除" id="delete"></td>
		</tr>
		</c:forEach>
		</tbody>
	</table>
</c:if>

<div  class="t1"><a href="<c:url value='/' />">回首頁</a></div>

<script src="https://code.jquery.com/jquery-3.6.1.min.js"></script>
<script>
	const project = {
			pjID:'',
			pjClass:'',
			fieldName:'',
			pjName:'',
			memberPK:'',
			pjInstruction:'',
			pjServerLocation:'',
			pjPrice:'',
			pjExCompletionDate:'',
			pjExecutionTime:'',
			pjStatus:'',
	};
	var project1 = Object.create(project);
	
	$('#tb').on('click','#delete',function(){
		let pj_ID = $(this).parent().siblings().eq(0).text();
		$.ajax({
			type:'post',
			url: '<c:url value='/project/DeleteProjectServlet'/>',
		    data: {
		    	 pj_ID : pj_ID ,
		    },
		    
		    success: function () {
		    	alert("response success")
		    },
		    error: function (thrownError) {
		    	alert("response error")
		    }
		});
	})
	
	$('#tb').on('click','#reviseProject',function(){
		project.pjID = $(this).parent().siblings().eq(0).text();
		project.pjClass = $(this).parent().siblings().eq(1).text();
		project.fieldName = $(this).parent().siblings().eq(2).text();
		project.pjName = $(this).parent().siblings().eq(3).text();
		project.memberPK = $(this).parent().siblings().eq(4).text();
		project.pjInstruction = $(this).parent().siblings().eq(5).text();
		project.pjServerLocation = $(this).parent().siblings().eq(6).text();
		project.pjPrice = $(this).parent().siblings().eq(7).text();
		project.pjExCompletionDate = $(this).parent().siblings().eq(8).text();
		project.pjExecutionTime = $(this).parent().siblings().eq(9).text();
		project.pjStatus = $(this).parent().siblings().eq(12).text();
		
		console.log(project);
		
		$(this).parent().siblings().eq(2).html('<select name="fieldName" id="fieldName"><option value="設計">設計</option><option value="資訊">資訊</option><option value="文書">文書</option><option value="影視">影視</option><option value="生活">生活</option><option value="顧問">顧問</option>');
		$(this).parent().siblings().eq(3).html('<input type="text" name="pj_Name">');
		$(this).parent().siblings().eq(5).html('<textarea name="pj_Instruction" cols="40" rows="10"></textarea>');
		$(this).parent().siblings().eq(6).html('<input type="text" name="pj_ServerLocation">');
		$(this).parent().siblings().eq(7).html('<input type="text" name="pj_Price" pattern="\d{8}">');
		$(this).parent().siblings().eq(8).html('<input type="date" name="pj_ExCompletionDate" id="pj_ExCompletionDate" value="2022-12-01">');
		$(this).parent().siblings().eq(9).html('<input type="text" name="pj_ExecutionTime">');
		$(this).parent().siblings().eq(12).html('<select name="pj_Status" id="pj_Status"><option value="待審核">待審核</option><option value="已上架">已上架</option><option value="下架中">下架中</option>');
		$(this).parent().html('<input type="submit" value="確認修改" id="Confirm"><input type="button" value="取消修改" id="Cancle">');
		
	})
	
	$('#tb').on('click', '#Cancle', function(){
			
		$(this).parent().siblings().eq(0).text(project.pjID);
		$(this).parent().siblings().eq(1).text(project.pjClass);
		$(this).parent().siblings().eq(2).text(project.fieldName);
		$(this).parent().siblings().eq(3).text(project.pjName);
		$(this).parent().siblings().eq(4).text(project.memberPK);
		$(this).parent().siblings().eq(5).text(project.pjInstruction);
		$(this).parent().siblings().eq(6).text(project.pjServerLocation);
		$(this).parent().siblings().eq(7).text(project.pjPrice);
		$(this).parent().siblings().eq(8).text(project.pjExCompletionDate);
		$(this).parent().siblings().eq(9).text(project.pjExecutionTime);
		$(this).parent().siblings().eq(12).text(project.pjStatus);
		
			
		$(this).parent().html('<input type="button" value="修改" class="reviseProject"><input type="button" value="刪除" class="delete">');
			
	}) 
	
	$('#tb').on('click', '#Confirm', function(){
			alert("response success")
		let pj_ID = $(this).parent().siblings().eq(0).text();
		let pj_Class = $(this).parent().siblings().eq(1).text();
		let fieldName = document.getElementById("fieldName").value;
		let pj_Name = $(this).parent().siblings().eq(3).children().val();
		let memberPK = $(this).parent().siblings().eq(4).text();
		let pj_Instruction = $(this).parent().siblings().eq(5).children().val();
		let pj_ServerLocation = $(this).parent().siblings().eq(6).children().val();
		let pj_Price = $(this).parent().siblings().eq(7).children().val();
		let pj_ExCompletionDate = document.getElementById("pj_ExCompletionDate").value;
		let pj_ExecutionTime = $(this).parent().siblings().eq(9).children().val();
		let pj_Status = document.getElementById("pj_Status").value;
		
			$.ajax({
			    type: "post",
			    url: '<c:url value='/project/UpdateProjectServlet'/>',
			    data: {
			    	pj_ID:pj_ID,
					pj_Class:pj_Class,
					fieldName:fieldName,
					pj_Name:pj_Name,
					memberPK:memberPK,
					pj_Instruction:pj_Instruction,
					pj_ServerLocation:pj_ServerLocation,
					pj_Price:pj_Price,
					pj_ExCompletionDate:pj_ExCompletionDate,
					pj_ExecutionTime:pj_ExecutionTime,
					pj_Status:pj_Status,
			    },
			    
			    success: function () {
			    	alert("response success");
			    },
			    error: function (thrownError) {
			    	alert("response error");
			    }
			  });
		})
</script>
</body>
</html>