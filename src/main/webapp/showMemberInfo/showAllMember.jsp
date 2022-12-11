<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>showAllMember</title>
<style>
table {
	border: 1px solid black;
	border-collapse: collapse;
	width: 100%;
}
</style>
</head>
<body>
	<div class="container">
		<form id="form" enctype="multipart/form-data" method="POST">
			<table border='1'>
				<thead>
					<tr>
						<th>memberId</th>
						<th>name</th>
						<th>password</th>
						<th>location</th>
						<th>email</th>
						<th>phone</th>
						<th>registerTime</th>
						<th>lastLogin</th>
						<th>memberImage</th>
						<th>verification</th>
						<th>permission</th>
						<th>function</th>

					</tr>
				</thead>

				<tbody class="tbody">
					<c:forEach var="member" items="${members}">
						<tr>
							<td>${member.memberId}</td>
							<td>${member.name}</td>
							<td>${member.password}</td>
							<td>${member.location}</td>
							<td>${member.email}</td>
							<td>${member.phone}</td>
							<td>${member.registerTime}</td>
							<td>${member.lastLogin}</td>


							<td><img
								src="<c:url value='/ShowMemberImgServlet?memberId=${member.memberId} '/>"
								alt="no img" width="200px" height="150px"></td>
							<td><c:choose>
									<c:when test='${member.verification>0}'>
										已驗證
									</c:when>
									<c:otherwise>
										<a href="<c:url value='/regist/regServlet.do' />">發送驗證信</a>
									</c:otherwise>
								</c:choose></td>
							<td>${member.permission}</td>
							<td><input type="button" value="修改" class="toModifyMode">
								<input type="submit" value="刪除" class="delete"></td>
						</tr>
					</c:forEach>
				</tbody>

			</table>
		</form>
	</div>
	 <a href="<c:url value='/' />">回首頁</a>

	<script src="https://code.jquery.com/jquery-3.6.1.min.js"></script>
	<script>
		const member = {
				memberId : 		"1",
				name:			"",
				password:		"",
				location:		"",
				email:			"",
				phone:			"",
				registerTime:	"",
				lastLogin:		"",
//				img 在servlet做判斷修改
		};
		
	
	
		$('tbody').on('click', '.delete', function(){
 			let memberId = $(this).parent().siblings().eq(0).text();
			$.ajax({
			    type: "post",
			    url: '<c:url value='/deleteMember.do'/>',
			    data: {
			    	 memberId : memberId ,
			    },
			    
			    success: function () {
			    	alert("response success")
			    },
			    error: function (thrownError) {
			    	alert("response error")
			    }
			  });
		})
		
		
		var member1 = Object.create(member);
		$('tbody').on('click', '.toModifyMode', function(){
			//將member資訊先存起來，修改完後交回
			
			member1.memberId = $(this).parent().siblings().eq(0).text();
			member1.name=			$(this).parent().siblings().eq(1).text();
			member1.password=		$(this).parent().siblings().eq(2).text();
			member1.location=		$(this).parent().siblings().eq(3).text();
			member1.email=			$(this).parent().siblings().eq(4).text();
			member1.phone=			$(this).parent().siblings().eq(5).text();
			member1.registerTime=	$(this).parent().siblings().eq(6).text();
			member1.lastLogin=		$(this).parent().siblings().eq(7).text();
//					img 在servlet做判斷修改
			
			
			//將表格改成 <input>
			$(this).parent().siblings().eq(1).html('<input type="text" name="name" id="name" > ');
			$('#name').attr("value", member1.name);
 			$(this).parent().siblings().eq(2).html('<input type="text" name="password" id="password">');
 			$('#password').attr("value", member1.password);
 			$(this).parent().siblings().eq(3).html('<input type="text" name="location" id="location"> ');
 			$('#location').attr("value", member1.location);
 			$(this).parent().siblings().eq(4).html('<input type="email" name="email" id="email">');
 			$('#email').attr("value", member1.email);
 			$(this).parent().siblings().eq(5).html('<input type="text" name="phone" id="phone">');
 			$('#phone').attr("value", member1.phone);
 			$(this).parent().siblings().eq(8).html('<input type="file" name="memberImage" id="memberImage">');
			$(this).parent().html('<input type="submit" value="確認修改" id="modifyConfirm"><input type="button" value="取消" id="modifyCancle">');
		})
		
		 $('tbody').on('click', '#modifyCancle', function(){
			
			$(this).parent().siblings().eq(0).text(member1.memberId);
			$(this).parent().siblings().eq(1).text(member1.name);
			$(this).parent().siblings().eq(2).text(member1.password);
			$(this).parent().siblings().eq(3).text(member1.location);
			$(this).parent().siblings().eq(4).text(member1.email);
			$(this).parent().siblings().eq(5).text(member1.phone);
			$(this).parent().siblings().eq(6).text(member1.registerTime);
			$(this).parent().siblings().eq(7).text(member1.lastLogin);
			
			
			
			str = '<img src="<c:url value='/ShowMemberImgServlet?memberId=replace '/>" alt="no img" width="200px" height="150px">'
			img = str.replace( 'replace', member1.memberId );
			$(this).parent().siblings().eq(8).html( img );
			
			$(this).parent().html('<input type="button" value="修改" class="toModifyMode"><input type="submit" value="刪除" class="delete">');
			
		}) 
		
		
		
		$('tbody').on('click', '#modifyConfirm', function(){
		var form = $('form')[0];
		var formData = new FormData(form);
		
		
		let memberId = $(this).parent().siblings().eq(0).text();
		formData.append('memberId', memberId);

			$.ajax({
				type : "POST",
			    url: '<c:url value='/modifyMemberInfo/modifyByAd.do'/>',
			    enctype: "multipart/form-data",
			    
			    data: formData,
 			    contentType: false,
		        cache: false,
 		        processData: false,
			    success: function (response) {
			    	alert("response success")
			    },
			    error: function (thrownError) {
			    	alert("response error")
			    }
			  });
		}) 
		
		//確認使用者是否有修改密碼
		$('tbody').on('blur', '#password', function(){
			// user點進password input內, blur後檢查是否有修改, 沒修改不動作		  
			if( ! $(this).val()==""  ){
				//有修改檢查密碼規則
				if( !varifyPassword() ){
				//不符合將submit變成button不給送出
					$('#modifyConfirm').removeAttr("type").attr("type", "button");
					if( $(this).siblings().length <1 ){
						console.log( $(this).siblings().length )
						$(this).parent().append('<span class="errorMsg" id="errorPwd" style="color: red; font-size: 4px; margin-left: 20px">密碼應至少包含 8 個字元，包括至少一個大寫字母和一個小寫字母、一個特殊字元和一個數字</span>')
					}
				}else{
					$('#modifyConfirm').removeAttr("type").attr("type", "submit");
					$('#errorPwd').remove();
				}
			}
		})
		
		function varifyPassword(){
				let password =  $( "#password" ).val();
				if (password.match(/[a-z]/g) && password.match(/[A-Z]/g) && password.match(/[0-9]/g) && 
		                password.match(/[^a-zA-Z\d]/g) && password.length >= 8){
					return true;
				}else{
					return false;
				}
			}		
		
		
		
	</script>
</body>
</html>