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
	width:100%;
}
</style>
</head>
<body>
	<div class="container">
		<form>
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
							<td><input type="button" value="修改" class="toModifyMode">
								<input type="submit" value="刪除" class="delete"></td>
						</tr>
					</c:forEach>
				</tbody>

			</table>
		</form>
	</div>


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
		var member1 = Object.create(member);
	
	
		$('tbody').on('click', '.delete', function(){
 			let memberId = $(this).parent().siblings().eq(0).text();
			$.ajax({
			    type: "post",
			    url: '<c:url value='/delete.do'/>',
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
			$(this).parent().siblings().eq(1).empty().html('<input type="text" name="name">');
 			$(this).parent().siblings().eq(2).html('<input type="text" name="password">');
 			$(this).parent().siblings().eq(3).html('<input type="text" name="location"> ');
 			$(this).parent().siblings().eq(4).html('<input type="text" name="email">');
 			$(this).parent().siblings().eq(5).html('<input type="text" name="phone">');
 			$(this).parent().siblings().eq(8).html('<input type="file" name="memberImage">');
			$(this).parent().html('<input type="submit" value="確認修改"class="modifyConfirm"><input type="button" value="取消" class="modifyCancle">');
			
		})
		
		 $('tbody').on('click', '.modifyCancle', function(){
			
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
		
		
		
		$('tbody').on('click', '.modifyConfirm', function(){
			alert("response success")
		let memberId = $(this).parent().siblings().eq(0).text();
		let name = $(this).parent().siblings().eq(1).children().val();
		let password = $(this).parent().siblings().eq(2).children().val();
		let location = $(this).parent().siblings().eq(3).children().val();
		let email = $(this).parent().siblings().eq(4).children().val();
		let phone = $(this).parent().siblings().eq(5).children().val();
	//	let memberImage = $(this).parent().siblings().eq(8).value();
			$.ajax({
			    type: "post",
			    url: '<c:url value='/modify/modifyByAd.do'/>',
			    data: {
			    	 memberId : memberId ,
			    	 name: name,
			    	 password: password,
			    	 location: location,
			    	 email: email,
			    	 phone: phone,
			    	 //memberImage: memberImage,
			    },
			    
			    success: function () {
			    	alert("response success")
			    },
			    error: function (thrownError) {
			    	alert("response error")
			    }
			  });
		})
		
		
		
	</script>
</body>
</html>