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
<title>UniversalHouse - Furniture Ecommerce Template | Home</title>

<!-- Favicon  -->
<link rel="icon" href="<c:url value='/amado-master/img/core-img/favicon.ico' />">


<!-- Core Style CSS -->
<link rel="stylesheet" href="<c:url value='/amado-master/css/core-style.css' />">
<%-- <link rel="stylesheet" href="<c:url value='/amado-master/css/style.css' />"> --%>
<link rel="stylesheet" href="<c:url value='/forum/template/css/open-iconic-bootstrap.min.css'/>">
<link rel="stylesheet" href="<c:url value='/forum/template/css/animate.css'/>">
<link rel="stylesheet" href="<c:url value='/forum/template/css/owl.carousel.min.css'/>">
<link rel="stylesheet" href="<c:url value='/forum/template/css/owl.theme.default.min.css'/>">
<link rel="stylesheet" href="<c:url value='/forum/template/css/magnific-popup.css'/>">
<link rel="stylesheet" href="<c:url value='/forum/template/css/aos.css'/>">
<link rel="stylesheet" href="<c:url value='/forum/template/css/ionicons.min.css'/>">
<link rel="stylesheet" href="<c:url value='/forum/template/css/bootstrap-datepicker.css'/>">
<link rel="stylesheet" href="<c:url value='/forum/template/css/jquery.timepicker.css'/>">
<link rel="stylesheet" href="<c:url value='/forum/template/css/flaticon.css'/>">
<link rel="stylesheet" href="<c:url value='/forum/template/css/icomoon.css'/>">
<link rel="stylesheet" href="<c:url value='/forum/template/css/style1.css'/>">

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
								<img src="<c:url value='/amado-master/img/core-img/search.png' />" alt="">
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
				<a href="<c:url value='/index.jsp' />">
					<img src="<c:url value='/amado-master/img/core-img/logo.png' />" alt="">
				</a>
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
				<a href="<c:url value='/index.jsp' />">
				<img src="<c:url value='/amado-master/img/core-img/logo.png' />" alt=""></a>
					
			</div>
			<!-- Amado Nav -->
			<!-- 左列 -->
			<nav class="amado-nav">
				<ul>
					<li class="active"><a href="<c:url value='/index.jsp' />">Home</a></li>
					<li><a
						href="<c:url value='/allProject/showServerProjectServlet' />">Project</a></li>
					<li><a
						href="<c:url value='/spaceAdmin/showAllSpaceServlet' />">Space
							Rental</a></li>
					<li><a href="<c:url value='/queryCourseServlet' />">Course</a></li>
					<li><a href="<c:url value='/ShowTestOverServlet.do' />">Test</a></li>
					<li><a href="<c:url value='/frontPage' />">Forum</a></li>
				</ul>
			</nav>
			<!-- Button Group -->
			<div class="amado-btn-group mt-30 mb-100">

				<a href="#" id="Login" class="btn amado-btn mb-15">%Discount%</a> <a
					href="<c:url value='/member/login/login.jsp' />"
					class="btn amado-btn active">Login</a>
				<c:choose>
					<c:when test="${!empty LoginOK}">
						<p class="userInfo">User: ${ LoginOK.memberId }</p>
						<p class="userInfo">Last login time: ${ LoginOK.lastLogin }</p>
					</c:when>
				</c:choose>
			</div>
			<!-- Cart Menu -->
			<div class="cart-fav-search mb-100">
				<a href="<c:url value='/showMember.controller/showAllMember.do' />"
					class="cart-nav"><img src="img/core-img/cart.png" alt="">
					Account <span>(0)</span></a> <a href="#" class="fav-nav">
					<img src="<c:url value='/amado-master/img/core-img/favorites.png' />" alt="">
					Favorite</a> <a href="#"
					class="search-nav">
					<img src="<c:url value='/amado-master/img/core-img/search.png' />" alt="">
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

		<!-- Product Catagories Area Start -->
		<div class="products-catagories-area clearfix">
			<div class="amado-pro-catagory clearfix">
			
			
			
			<!-- 論壇內容 -->
			
			
			
			
			
			<div id="colorlib-main">
			<section class="ftco-section ftco-no-pt ftco-no-pb">
	    	<div class="container">
	    		<div class="row d-flex">
	    			<div class="col-xl-8 px-md-5 py-5">
	    				<div class="row pt-md-4">
	    								
	    				<c:forEach var="anForumBean" varStatus="stat" items="${articleList}">
	    					<div class="col-md-12">
		    					<div class="blog-entry-2 ftco-animate">
	    							<a href="single.html" class="img" style="background-image: url(images/image_1.jpg);"></a>
	    							<div class="text pt-4">
				              <h3 class="mb-4"><a href="#">${anForumBean.title}</a></h3>
				              <p class="mb-4">${anForumBean.content}</p>
				              <div class="author mb-4 d-flex align-items-center">
				            		<a href="#" class="img" style="background-image: url(images/person_1.jpg);"></a>
				            		<div class="ml-3 info">
				            			<span>Written by</span>
				            			<h3><a href="#">${anForumBean.authorId}</a>, <span>${anForumBean.updateTime}</span></h3>
				            		</div>
				            	</div>
				              <div class="meta-wrap d-md-flex align-items-center">
				              	<div class="half order-md-last text-md-right">
					              	<p class="meta">
					              		<span><i class="icon-heart"></i>${anForumBean.like}</span>
					              		<span><i class="icon-eye"></i>100</span>
					              		<span><i class="icon-comment"></i>5</span>
					              	</p>
				              	</div>
				              	<div class="half">
					              	<p><a href="#" class="btn btn-primary p-3 px-xl-4 py-xl-3">Continue Reading</a></p>
				              	</div>
				              </div>
				            </div>
	    						</div>
	    					</div>
	    					
	    					
	    						</c:forEach>	
	    					
			    		</div><!-- END-->
			    		
			    		
			    		
			    		<div class="row">
			          <div class="col">
			            <div class="block-27">
			              <ul>
			                <li><a href="#">&lt;</a></li>
			                <li class="active"><span>1</span></li>
			                <li><a href="#">2</a></li>
			                <li><a href="#">3</a></li>
			                <li><a href="#">4</a></li>
			                <li><a href="#">5</a></li>
			                <li><a href="#">&gt;</a></li>
			              </ul>
			            </div>
			          </div>
			        </div>
			    	</div>
	    			<div class="col-xl-4 sidebar ftco-animate bg-light pt-5">
	            <div class="sidebar-box pt-md-4">
	              <form action="#" class="search-form">
	                <div class="form-group">
	                  <span class="icon icon-search"></span>
	                  <input type="text" class="form-control" placeholder="Type a keyword and hit enter">
	                </div>
	              </form>
	            </div>
	            <div class="sidebar-box ftco-animate">
	            	<h3 class="sidebar-heading">Categories</h3>
	              <ul class="categories">
	                <li><a href="#">Fashion <span>(6)</span></a></li>
	                <li><a href="#">Technology <span>(8)</span></a></li>
	                <li><a href="#">Travel <span>(2)</span></a></li>
	                <li><a href="#">Food <span>(2)</span></a></li>
	                <li><a href="#">Photography <span>(7)</span></a></li>
	              </ul>
	            </div>

	            <div class="sidebar-box ftco-animate">
	              <h3 class="sidebar-heading">Popular Articles</h3>
	              <div class="block-21 mb-4 d-flex">
	                <a class="blog-img mr-4" style="background-image: url(images/image_1.jpg);"></a>
	                <div class="text">
	                  <h3 class="heading"><a href="#">Even the all-powerful Pointing has no control</a></h3>
	                  <div class="meta">
	                    <div><a href="#"><span class="icon-calendar"></span> June 28, 2019</a></div>
	                    <div><a href="#"><span class="icon-person"></span> Dave Lewis</a></div>
	                    <div><a href="#"><span class="icon-chat"></span> 19</a></div>
	                  </div>
	                </div>
	              </div>
	              <div class="block-21 mb-4 d-flex">
	                <a class="blog-img mr-4" style="background-image: url(images/image_2.jpg);"></a>
	                <div class="text">
	                  <h3 class="heading"><a href="#">Even the all-powerful Pointing has no control</a></h3>
	                  <div class="meta">
	                    <div><a href="#"><span class="icon-calendar"></span> June 28, 2019</a></div>
	                    <div><a href="#"><span class="icon-person"></span> Dave Lewis</a></div>
	                    <div><a href="#"><span class="icon-chat"></span> 19</a></div>
	                  </div>
	                </div>
	              </div>
	              <div class="block-21 mb-4 d-flex">
	                <a class="blog-img mr-4" style="background-image: url(images/image_3.jpg);"></a>
	                <div class="text">
	                  <h3 class="heading"><a href="#">Even the all-powerful Pointing has no control</a></h3>
	                  <div class="meta">
	                    <div><a href="#"><span class="icon-calendar"></span> June 28, 2019</a></div>
	                    <div><a href="#"><span class="icon-person"></span> Dave Lewis</a></div>
	                    <div><a href="#"><span class="icon-chat"></span> 19</a></div>
	                  </div>
	                </div>
	              </div>
	            </div>

	            <div class="sidebar-box ftco-animate">
	              <h3 class="sidebar-heading">Tag Cloud</h3>
	              <ul class="tagcloud">
	                <a href="#" class="tag-cloud-link">animals</a>
	                <a href="#" class="tag-cloud-link">human</a>
	                <a href="#" class="tag-cloud-link">people</a>
	                <a href="#" class="tag-cloud-link">cat</a>
	                <a href="#" class="tag-cloud-link">dog</a>
	                <a href="#" class="tag-cloud-link">nature</a>
	                <a href="#" class="tag-cloud-link">leaves</a>
	                <a href="#" class="tag-cloud-link">food</a>
	              </ul>
	            </div>

							<div class="sidebar-box subs-wrap img py-4" style="background-image: url(images/bg_1.jpg);">
								<div class="overlay"></div>
								<h3 class="mb-4 sidebar-heading">Newsletter</h3>
								<p class="mb-4">Far far away, behind the word mountains, far from the countries Vokalia</p>
	              <form action="#" class="subscribe-form">
	                <div class="form-group">
	                  <input type="text" class="form-control" placeholder="Email Address">
	                  <input type="submit" value="Subscribe" class="mt-2 btn btn-white submit">
	                </div>
	              </form>
	            </div>

	            <div class="sidebar-box ftco-animate">
	            	<h3 class="sidebar-heading">Archives</h3>
	              <ul class="categories">
	              	<li><a href="#">December 2018 <span>(10)</span></a></li>
	                <li><a href="#">September 2018 <span>(6)</span></a></li>
	                <li><a href="#">August 2018 <span>(8)</span></a></li>
	                <li><a href="#">July 2018 <span>(2)</span></a></li>
	                <li><a href="#">June 2018 <span>(7)</span></a></li>
	                <li><a href="#">May 2018 <span>(5)</span></a></li>
	              </ul>
	            </div>


	            <div class="sidebar-box ftco-animate">
	              <h3 class="sidebar-heading">Paragraph</h3>
	              <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Ducimus itaque, autem necessitatibus voluptate quod mollitia delectus aut.</p>
	            </div>
	          </div><!-- END COL -->
	    		</div>
	    	</div>
	    </section>
		</div><!-- END COLORLIB-MAIN -->
			
			
			
			
			
			
			<!-- 論壇內容 -->			
			
			
			
			</div>
		</div>
		<!-- Product Catagories Area End -->
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
							<a href="index.html">
							<img src="<c:url value='/amado-master/img/core-img/logo2.png' />" alt="">
						</div>
						<!-- Copywrite Text -->
						<p class="copywrite">
							<!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
							Copyright &copy;
							<script>
								document.write(new Date().getFullYear());
							</script>
							All rights reserved | This template is made with <i
								class="fa fa-heart-o" aria-hidden="true"></i> by <a
								href="https://colorlib.com" target="_blank">Colorlib</a> &
							Re-distributed by <a href="https://themewagon.com/"
								target="_blank">Themewagon</a>
							<!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
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
											href="<c:url value='/' />">Home</a></li>
										<li class="nav-item"><a class="nav-link" href="shop.html">PROJECT</a>
										</li>
										<li class="nav-item"><a class="nav-link"
											href="product-details.html">SPACE RENTAL</a></li>
										<li class="nav-item"><a class="nav-link" href="cart.html">COURSE</a>
										</li>
										<li class="nav-item"><a class="nav-link"
											href="checkout.html">TEST</a></li>
										<li class="nav-item"><a class="nav-link"
											href="checkout.html">FORUM</a></li>
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
	<script src="<c:url value='/amado-master/js/jquery/jquery-2.2.4.min.js' />"></script>
	<script src="<c:url value='/amado-master/js/popper.min.js' />"></script>
	<script src="<c:url value='/amado-master/js/bootstrap.min.js' />"></script>
	<script src="<c:url value='/amado-master/js/plugins.js' />"></script>
	<script src="<c:url value='/amado-master/js/active.js' />"></script>
	<script src="<c:url value='/forum/template/js/jquery.min.js'/>"></script>
	<script src="<c:url value='/forum/template/js/jquery-migrate-3.0.1.min.js'/>"></script>
	<script src="<c:url value='/forum/template/js/popper.min.js'/>"></script>
	<script src="<c:url value='/forum/template/js/bootstrap.min.js'/>"></script>
	<script src="<c:url value='/forum/template/js/jquery.easing.1.3.js'/>"></script>
	<script src="<c:url value='/forum/template/js/jquery.waypoints.min.js'/>"></script>
	<script src="<c:url value='/forum/template/js/jquery.stellar.min.js'/>"></script>
	<script src="<c:url value='/forum/template/js/owl.carousel.min.js'/>"></script>
	<script src="<c:url value='/forum/template/js/jquery.magnific-popup.min.js'/>"></script>
	<script src="<c:url value='/forum/template/js/aos.js'/>"></script>
	<script src="<c:url value='/forum/template/js/jquery.animateNumber.min.js'/>"></script>
	<script src="<c:url value='/forum/template/js/scrollax.min.js'/>"></script>
	<script src="<c:url value='/forum/template/js/google-map.js'/>"></script>
	<script src="<c:url value='/forum/template/js/main.js'/>"></script>	

</body>

</html>