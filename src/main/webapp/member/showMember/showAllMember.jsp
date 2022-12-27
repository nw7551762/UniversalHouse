<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="description" content="">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<!-- The above 4 meta tags *must* come first in the head; any other head content must come *after* these tags -->

<!-- Title  -->
<title>Amado - Furniture Ecommerce Template | Cart</title>

<!-- Favicon  -->

<link rel="icon"
	href="<c:url value='/amado-master/img/core-img/favicon.ico'/>">

<!-- Core Style CSS -->
<link rel="stylesheet"
	href="<c:url value='/amado-master/css/core-style.css'/>">
<link rel="stylesheet" href="<c:url value='/amado-master/style.css'/>">
<link rel="stylesheet"
	href="<c:url value='/amado-master/scss/style.scss'/>">

</head>

<body>
	<!-- Search Wrapper Area Start -->
	<div class="search-wrapper section-padding-100">
		<div class="search-close">
			<i class="fa fa-close" aria-hidden="true"></i>
		</div>
		<div class="container">
			<div class="row">
				<div class="col-12">
					<div class="search-content">
						<form action="#" method="get">

							<input type="search" name="search" id="search"
								placeholder="Type your keyword...">
							<button type="submit">
								<img
									src="<c:url value='/amado-master/img/core-img/search.png'/>"
									alt="">
							</button>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- Search Wrapper Area End -->

	<!-- ##### Main Content Wrapper Start ##### -->
	<div class="main-content-wrapper d-flex clearfix">

		<!-- Mobile Nav (max width 767px)-->
		<div class="mobile-nav">
			<!-- Navbar Brand -->
			<div class="amado-navbar-brand">

				<a href="<c:url value='/index.jsp'/>"><img
					src="<c:url value='/amado-master/img/core-img/logo.png'/>" alt=""></a>
			</div>
			<!-- Navbar Toggler -->
			<div class="amado-navbar-toggler">
				<span></span><span></span><span></span>
			</div>
		</div>

		<!-- Header Area Start -->
		<header class="header-area clearfix">
			<!-- Close Icon -->
			<div class="nav-close">
				<i class="fa fa-close" aria-hidden="true"></i>
			</div>
			<!-- Logo -->
			<div class="logo">

				<a href="<c:url value='/index.jsp'/>"><img
					src="<c:url value='/amado-master/img/core-img/logo.png'/>" alt=""></a>
			</div>
			<!-- Amado Nav -->
			<nav class="amado-nav">
				<ul>
					<li><a href="<c:url value='/index.jsp'/>">Home</a></li>
					<li><a href="<c:url value='/'/>">Project</a></li>
					<li><a href="<c:url value='/'/>">Space Rental</a></li>
					<li class="active"><a href="<c:url value='/'/>">Course</a></li>
					<li><a href="<c:url value='/'/>">Test</a></li>
					<li><a href="<c:url value='/'/>">Forum</a></li>
				</ul>
			</nav>
			<!-- Button Group -->
			<div class="amado-btn-group mt-30 mb-100">
				<a href="#" class="btn amado-btn mb-15">%Discount%</a> <a href="#"
					class="btn amado-btn active">New this week</a>
			</div>
			<!-- Cart Menu -->
			<div class="cart-fav-search mb-100">

				<a href="cart.html" class="cart-nav"><img
					src="<c:url value='/amado-master/img/core-img/cart.png'/>" alt="">
					Account <span>(0)</span></a> <a href="#" class="fav-nav"><img
					src="<c:url value='/amado-master/img/core-img/favorites.png'/>"
					alt=""> Favourite</a> <a href="#" class="search-nav"><img
					src="<c:url value='/amado-master/img/core-img/search.png'/>" alt="">
					Search</a>
			</div>
			<!-- Social Button -->
			<div class="social-info d-flex justify-content-between">
				<a href="#"><i class="fa fa-pinterest" aria-hidden="true"></i></a> <a
					href="#"><i class="fa fa-instagram" aria-hidden="true"></i></a> <a
					href="#"><i class="fa fa-facebook" aria-hidden="true"></i></a> <a
					href="#"><i class="fa fa-twitter" aria-hidden="true"></i></a>
			</div>
		</header>
		<!-- Header Area End -->

		<div class="cart-table-area section-padding-100">
			<div class="container-fluid">
				<!-- <div class="row"> -->
				<div>
					<div class="cart-title mt-50">
						<h2>Shopping Cart</h2>
					</div>

					<div class="clearfix">
						<form id="form" enctype="multipart/form-data" method="POST">
							<table class="table table-responsive">
								<!-- <thead style="display: table-header-group;"> -->
								<thead>
									<tr>
										<th style="flex: 8%">Image</th>
										<th style="flex: 8%">memberId</th>
										<th style="flex: 8%">name</th>
										<th style="flex: 8%">password</th>
										<th style="flex: 8%">location</th>
										<th style="flex: 8%">email</th>
										<th style="flex: 8%">phone</th>
										<th style="flex: 8%">registerTime</th>
										<th style="flex: 8%">lastLogin</th>
										<th style="flex: 8%">verification</th>
										<th style="flex: 8%">permission</th>
										<th style="flex: 8%">function</th>

									</tr>
								</thead>
								<tbody>
									<c:forEach var="member" items="${members}">
										<tr>
											<td class="cart_product_img" style="flex: 8%"><span><img
													src="<c:url value='/ShowMemberImgServlet.do?memberId=${member.memberId}'/>"
													alt="Product"></span></td>
											<td class="price" style="flex: 8%"><span>${member.memberId}</span>
											</td>
											<td class="price" style="flex: 8%"><span>${member.name}</span>
											</td>
											<td class="qty" style="flex: 8%"><span>${member.password}</span>
											</td>
											<td class="price" style="flex: 8%"><span>${member.location}</span>
											</td>
											<td class="price" style="flex: 8%"><span>${member.email}</span>
											</td>
											<td class="price" style="flex: 8%"><span>${member.phone}</span>
											</td>
											<td class="price" style="flex: 8%"><span>${member.registerTime}</span>
											</td>
											<td class="price" style="flex: 8%"><span>${member.lastLogin}</span>
											</td>
											<td class="verification" style="flex: 8%">
												<c:choose>
													<c:when test="${empty member.verification}">
														<form action="<c:url value='/regist/regServlet.do?memberId=${member.memberId}' />">
														<input type="button" class="btn" value="send mail" style="font-size:5px;margin: 3px; width: 80px; height: 40px;">
													</c:when>
												</c:choose> 
											<td class="price" style="flex: 8%"><span>${member.permission}</span>
											</td>
											<td class="price" style="flex: 8%"><input type="button"
												class="btn toModifyMode" value="modify"
												style="margin: 3px; width: 150px; height: 40px;"> <input
												type="submit" class="btn delete" value="delete"
												style="margin: 3px; width: 150px; height: 40px;"></td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</form>
					</div>
				</div>

				<!-- </div> -->
			</div>
		</div>
	</div>
	<!-- ##### Main Content Wrapper End ##### -->

	<!-- ##### Newsletter Area Start ##### -->
	<section class="newsletter-area section-padding-100-0">
		<div class="container">
			<div class="row align-items-center">
				<!-- Newsletter Text -->
				<div class="col-12 col-lg-6 col-xl-7">
					<div class="newsletter-text mb-100">
						<h2>
							Subscribe for a <span>25% Discount</span>
						</h2>
						<p>Nulla ac convallis lorem, eget euismod nisl. Donec in
							libero sit amet mi vulputate consectetur. Donec auctor interdum
							purus, ac finibus massa bibendum nec.</p>
					</div>
				</div>
				<!-- Newsletter Form -->
				<div class="col-12 col-lg-6 col-xl-5">
					<div class="newsletter-form mb-100">
						<form action="#" method="post">
							<input type="email" name="email" class="nl-email"
								placeholder="Your E-mail"> <input type="submit"
								value="Subscribe">
						</form>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- ##### Newsletter Area End ##### -->

	<!-- ##### Footer Area Start ##### -->
	<footer class="footer_area clearfix">
		<div class="container">
			<div class="row align-items-center">
				<!-- Single Widget Area -->
				<div class="col-12 col-lg-4">
					<div class="single_widget_area">
						<!-- Logo -->
						<div class="footer-logo mr-50">
							<a href="<c:url value='/index.jsp'/>"><img
								src="img/core-img/logo2.png" alt=""></a>
						</div>
						<!-- Copywrite Text -->
						<p class="copywrite">
							<!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
							Copyright &copy;
							<script>document.write(new Date().getFullYear());</script>
							All rights reserved | This template is made with <i
								class="fa fa-heart-o" aria-hidden="true"></i> by <a
								href="https://colorlib.com" target="_blank">Colorlib</a>
							<!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
							& Re-distributed by <a href="https://themewagon.com/"
								target="_blank">Themewagon</a>
						</p>
					</div>
				</div>
				<!-- Single Widget Area -->
				<div class="col-12 col-lg-8">
					<div class="single_widget_area">
						<!-- Footer Menu -->
						<div class="footer_menu">
							<nav class="navbar navbar-expand-lg justify-content-end">
								<button class="navbar-toggler" type="button"
									data-toggle="collapse" data-target="#footerNavContent"
									aria-controls="footerNavContent" aria-expanded="false"
									aria-label="Toggle navigation">
									<i class="fa fa-bars"></i>
								</button>
								<div class="collapse navbar-collapse" id="footerNavContent">
									<ul class="navbar-nav ml-auto">
										<li class="nav-item active"><a class="nav-link"
											href="<c:url value='/index.jsp'/>">Home</a></li>
										<li class="nav-item"><a class="nav-link"
											href="<c:url value='/'/>">Space Rental</a></li>
										<li class="nav-item"><a class="nav-link"
											href="product-details.html">Course</a></li>
										<li class="nav-item"><a class="nav-link" href="cart.html">Test</a>
										</li>
										<li class="nav-item"><a class="nav-link"
											href="checkout.html">Forum</a></li>
									</ul>
								</div>
							</nav>
						</div>
					</div>
				</div>
			</div>
		</div>
	</footer>
	<!-- ##### Footer Area End ##### -->

	<!-- ##### jQuery (Necessary for All JavaScript Plugins) ##### -->
	<script src="https://code.jquery.com/jquery-3.6.1.min.js"></script>
	<!-- Popper js -->

	<script src="<c:url value='/amado-master/js/popper.min.js'/>"></script>
	<!-- Bootstrap js -->
	<script src="<c:url value='/amado-master/js/bootstrap.min.js'/>"></script>
	<!-- Plugins js -->
	<script src="<c:url value='/amado-master/js/plugins.js'/>"></script>
	<!-- Active js -->
	<script src="<c:url value='/amado-master/js/active.js'/>"></script>
	<script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
	<script>
    $(function(){
    	
    	
    	
    })
		const member = {
				memberId : 		"1",
				name:			"",
				password:		"",
				location:		"",
				email:			"",
				phone:			"",
				registerTime:	"",
				lastLogin:		"",
		};
	
		$('tbody').on('click', '.delete', function(){
 			let memberId = $(this).parent().siblings().eq(1).children().text();
			$.ajax({
			    type: "post",
			    url: '<c:url value='/deleteMember.do'/>',
			    data: {
			    	 memberId : memberId ,
			    },
			    
			    success: function () {
			    	Swal.fire("response success")
			    },
			    error: function (thrownError) {
			    	Swal.fire("response error")
			    }
			  });
		})
		
		
		var member1 = Object.create(member);
		$('tbody').on('click', '.toModifyMode', function(){
			//remove Class toModifyMode讓其他修改不能動
			$('.toModifyMode').removeClass('toModifyMode').addClass('modifying');
			//將member資訊先存起來，修改完後交回
			member1.memberId = 		$(this).parent().siblings().eq(1).children().text();
			member1.name=			$(this).parent().siblings().eq(2).children().text();
			member1.password=		$(this).parent().siblings().eq(3).children().text();
			member1.location=		$(this).parent().siblings().eq(4).children().text();
			member1.email=			$(this).parent().siblings().eq(5).children().text();
			member1.phone=			$(this).parent().siblings().eq(6).children().text();
			member1.registerTime=	$(this).parent().siblings().eq(7).children().text();
			member1.lastLogin=		$(this).parent().siblings().eq(8).children().text();
//					img 在servlet做判斷修改
			
			
			//將表格改成 <input>
			$(this).parent().siblings().eq(0).children().html('<input type="file" name="memberImage" id="memberImage">');
			$(this).parent().siblings().eq(2).children().html('<input type="text" name="name" id="name" > ');
			$('#name').attr("value", member1.name);
 			$(this).parent().siblings().eq(3).children().html('<input type="text" name="password" id="password">');
 			$('#password').attr("value", member1.password);
 			$(this).parent().siblings().eq(4).children().html('<input type="text" name="location" id="location"> ');
 			$('#location').attr("value", member1.location);
 			$(this).parent().siblings().eq(5).children().html('<input type="email" name="email" id="email">');
 			$('#email').attr("value", member1.email);
 			$(this).parent().siblings().eq(6).children().html('<input type="text" name="phone" id="phone">');
 			$('#phone').attr("value", member1.phone);
 			
			$(this).parent().html('<input type="submit" class="btn" id="modifyConfirm" value="confirm" style="margin:3px; width: 150px; height: 40px;"><input type="submit" class="btn" id="modifyCancle" value="cancel" style="margin:3px; width: 150px; height: 40px;">');
		})
		
		 $('tbody').on('click', '#modifyCancle', function(){
			 $('.modifying').removeClass('modifying').addClass('toModifyMode');
			
			$(this).parent().siblings().eq(2).html('<span></span>');
			$(this).parent().siblings().eq(2).children().text(member1.name);
			$(this).parent().siblings().eq(3).html('<span></span>');
			$(this).parent().siblings().eq(3).children().text(member1.password);
			$(this).parent().siblings().eq(4).html('<span></span>');
			$(this).parent().siblings().eq(4).children().text(member1.location);
			$(this).parent().siblings().eq(5).html('<span></span>');
			$(this).parent().siblings().eq(5).children().text(member1.email);
			$(this).parent().siblings().eq(6).html('<span></span>');
			$(this).parent().siblings().eq(6).children().text(member1.phone);
			
			str = '<img src="<c:url value='/ShowMemberImgServlet.do?memberId=replace '/>" alt="no img" width="200px" height="150px">'
			img = str.replace( 'replace', 'bbb' );
			$(this).parent().siblings().eq(0).children().html( img );
			
			$(this).parent().html('<input type="button" class="btn toModifyMode" value="modify" style="margin:3px; width: 150px; height: 40px;"><input type="submit" class="btn delete" value="delete" style="margin:3px; width: 150px; height: 40px;">');
			
		}) 
		
		
		
		$('tbody').on('click', '#modifyConfirm', function(){
			 $('.modifying').removeClass('modifying').addClass('toModifyMode');
			var form = $('#form')[0];
			var formData = new FormData(form);
		
		
		let memberId = $(this).parent().siblings().eq(1).children().text();
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
			    	Swal.fire("response success")
			    },
			    error: function (thrownError) {
			    	Swal.fire("response error")
			    }
			  });
		}) 
		
		//確認使用者是否有修改密碼
		$('tbody').on('blur', '#password', function(){
			// user點進password input內, blur後檢查是否有修改, 沒修改不動作		  
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