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
<form>
<c:if test="${ empty allProject}">
<div class="t1">
<h2>查無案件資料</h2>
</div>
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
			<td>${pj.memberID}</td>
			<td>${pj.pjInstruction}</td>
			<td>${pj.pjServerLocation}</td>
			<td>${pj.pjPrice}</td>
			<td>${pj.pjExCompletionDate}</td>
			<td>${pj.pjExecutionTime}</td>
			<td>${pj.pjUploadDate}</td>
			<td>${pj.pjLastUpdate}</td>
			<td>${pj.pjStatus}</td>
			<td><input type="button" value="修改" id="reviseProject">
				<input type="submit" value="刪除" id="delete"></td>
		</tr>
		</c:forEach>
		</tbody>
	</table>
</c:if>
</form>

<div  class="t1"><a href="<c:url value='/' />">回首頁</a></div>

<script src="https://code.jquery.com/jquery-3.6.1.min.js"></script>
<script>
	project = {
			pjID:'',
			pjClass:'',
			fieldName:'',
			pjName:'',
			memberID:'',
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
			url: '<c:url value='/myProject/DeleteProjectServlet'/>',
		    data: {
		    	 pj_ID : pj_ID ,
		    },
		    
		    success: function () {
		    	alert("刪除成功")
		    	$.ajax({
					type:'post',
					url: '<c:url value='/allProject/showAllProjectServlet'/>'
				});
		    },
		    error: function (thrownError) {
		    	alert("刪除失敗")
		    }
		});
	})
	
	$('#tb').on('click','#reviseProject',function(){
		project.pjID = $(this).parent().siblings().eq(0).text();
		project.pjClass = $(this).parent().siblings().eq(1).text();
		project.fieldName = $(this).parent().siblings().eq(2).text();
		project.pjName = $(this).parent().siblings().eq(3).text();
		project.memberID = $(this).parent().siblings().eq(4).text();
		project.pjInstruction = $(this).parent().siblings().eq(5).text();
		project.pjServerLocation = $(this).parent().siblings().eq(6).text();
		project.pjPrice = $(this).parent().siblings().eq(7).text();
		project.pjExCompletionDate = $(this).parent().siblings().eq(8).text();
		project.pjExecutionTime = $(this).parent().siblings().eq(9).text();
		project.pjStatus = $(this).parent().siblings().eq(12).text();
		
		$(this).parent().siblings().eq(2).html('<select name="fieldName" id="fieldName"><option value="設計">設計</option><option value="資訊">資訊</option><option value="文書">文書</option><option value="影視">影視</option><option value="生活">生活</option><option value="顧問">顧問</option></select>');
		//$('#fieldName').attr('option',project.fieldName);
		//for迴圈，如果fieldName.text()=fieldName.value，就attr他的selected指定為selected
		$(this).parent().siblings().eq(3).html('<input type="text" name="pj_Name" id="pj_Name">');
		$('#pj_Name').attr('value',project.pjName);
		$(this).parent().siblings().eq(5).html('<textarea name="pj_Instruction" id="pj_Instruction" cols="30" rows="15"></textarea>');
		$('#pj_Instruction').attr('value',project.pjInstruction);
		$(this).parent().siblings().eq(6).html('<input type="text" name="pj_ServerLocation" id="pj_ServerLocation">');
		$('#pj_ServerLocation').attr('value',project.pjServerLocation);
		$(this).parent().siblings().eq(7).html('<input type="text" name="pj_Price" id="pj_Price">');
		$('#pj_Price').attr('value',project.pjPrice);
		$(this).parent().siblings().eq(8).html('<input type="date" name="pj_ExCompletionDate" id="pj_ExCompletionDate" value="2022-12-01">');
		$('#pj_ExCompletionDate').attr('value',project.pjExCompletionDate);
		$(this).parent().siblings().eq(9).html('<input type="text" name="pj_ExecutionTime" id="pj_ExecutionTime">');
		$('#pj_ExecutionTime').attr('value',project.pjExecutionTime);
		$(this).parent().siblings().eq(12).html('<select name="pj_Status" id="pj_Status"><option value="待審核">待審核</option><option value="已上架">已上架</option><option value="下架中">下架中</option></select>');
		$('#pj_Status').attr('value',project.pjStatus);
		$(this).parent().html('<input type="submit" value="確認修改" id="Confirm"><input type="button" value="取消修改" id="Cancle">');		
	})
	
	$('#tb').on('click', '#Cancle', function(){
			
		$(this).parent().siblings().eq(0).text(project.pjID);
		$(this).parent().siblings().eq(1).text(project.pjClass);
		$(this).parent().siblings().eq(2).text(project.fieldName);
		$(this).parent().siblings().eq(3).text(project.pjName);
		$(this).parent().siblings().eq(4).text(project.memberID);
		$(this).parent().siblings().eq(5).text(project.pjInstruction);
		$(this).parent().siblings().eq(6).text(project.pjServerLocation);
		$(this).parent().siblings().eq(7).text(project.pjPrice);
		$(this).parent().siblings().eq(8).text(project.pjExCompletionDate);
		$(this).parent().siblings().eq(9).text(project.pjExecutionTime);
		$(this).parent().siblings().eq(12).text(project.pjStatus);
		
			
		$(this).parent().html('<input type="button" value="修改" id="reviseProject"><input type="button" value="刪除" id="delete">');
			
	}) 
	
	$('#tb').on('click', '#Confirm', function(){
		let pj_ID = $(this).parent().siblings().eq(0).text();
		let pj_Class = $(this).parent().siblings().eq(1).text();
		let fieldName = document.getElementById("fieldName").value;
		let pj_Name = $(this).parent().siblings().eq(3).children().val();
		let memberID = $(this).parent().siblings().eq(4).text();
		let pj_Instruction = $(this).parent().siblings().eq(5).children().val();
		let pj_ServerLocation = $(this).parent().siblings().eq(6).children().val();
		let pj_Price = $(this).parent().siblings().eq(7).children().val();
		let pj_ExCompletionDate = document.getElementById("pj_ExCompletionDate").value;
		let pj_ExecutionTime = $(this).parent().siblings().eq(9).children().val();
		let pj_Status = document.getElementById("pj_Status").value;
		
			$.ajax({
			    type: "post",
			    url: '<c:url value='/myProject/UpdateProjectServlet'/>',
			    data: {
			    	pj_ID:pj_ID,
					pj_Class:pj_Class,
					fieldName:fieldName,
					pj_Name:pj_Name,
					memberID:memberID,
					pj_Instruction:pj_Instruction,
					pj_ServerLocation:pj_ServerLocation,
					pj_Price:pj_Price,
					pj_ExCompletionDate:pj_ExCompletionDate,
					pj_ExecutionTime:pj_ExecutionTime,
					pj_Status:pj_Status,
			    },
			    
			    success: function () {
			    	alert("修改成功")
			    },
			    error: function (thrownError) {
			    	alert("修改失敗")
			    }
			  });
			
			    	
		})
</script>
</body>
</html>