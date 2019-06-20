<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*,controller.*, model.*, controller.*"%>


<!DOCTYPE hmtl>
<html>
	<head>
		<title>Demo App</title>		
		<meta charset = "UTF - 8">
		<meta charset="ISO-8859-1">
		<meta name="viewport" content="width=device-width, initial-scale=1">

		<link rel="stylesheet" type="text/css" href="assets/css/bootstrap.min.css">		
		<link rel="stylesheet" type="text/css" href="assets/css/bootstrap.css">
		<link rel="stylesheet" type="text/css" href="assets/css/setup.css">
		<link rel="stylesheet" type="text/css" href="assets/css/font-awesome.min.css">
		<link rel="stylesheet" type="text/css" href="assets/css/header-footer.css">
		

		<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css" integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf" crossorigin="anonymous">
	</head>

	<body>
		<div id="header">
			<div class="container">
				<div class="row sign-up-bar">
					<ul class="sign-up">						
						<li><a href="">Login</a></li>
						<li><a href="">Sign up</a></li>
					</ul>
				</div>
				<div class="row">
					<div class="logo">
						<a href="home-page.html"><img src="assets/image/logo.png"></a>
					</div>
				</div>
				<div class="row">
					<ul class="menu-bar">
						<li><a href="home-page.html">Home</a></li>
						<li class="drop-down">
							<a href="" class="drop-button">Genres</a>
								<div class="drop-content">
									<div class="row">
										<a href="" class="col-sm">Action</a>
										<a href="" class="col-sm">Adventure</a>										
									</div>
									<div class="row">
										<a href="" class="col-sm">Children</a>
										<a href="" class="col-sm">Classic</a>
									</div>
									<div class="row">
										<a href="" class="col-sm">Drama</a>
										<a href="" class="col-sm">Fairytale</a>											
									</div>
									<div class="row">
										<a href="" class="col-sm">Historical</a>
										<a href="" class="col-sm">Horror</a>										
									</div>
								</div>
						</li>
						<li class="drop-down">
							<a href="" class="drop-button">Services</a>
							<div class="drop-content">
									<div class="row">
										<a href="" class="col-sm">Action</a>
										<a href="" class="col-sm">Adventure</a>										
									</div>
							</div>
						</li>
						<li class="drop-down">
							<a href="">Envents</a>
							<div class="drop-content">
									<div class="row">
										<a href="" class="col-sm">Children's Day</a>										
									</div>
							</div>
						</li>						
						<li><a href="">About Us</a></li>
						<li><a href="">Contact</a></li>
					</ul>
				</div>
			</div>
		</div>
		<!-- End Header -->

		<!-- ============================Script===================================== -->
		<script type="text/javascript" src="assets/js/bootstrap.js"></script>
		<script type="text/javascript" src="assets/js/bootstrap.min.js"></script>
		<script type="text/javascript" src="assets/js/home-page.js"></script>
	</body>
</html></html>