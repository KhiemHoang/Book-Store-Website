<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*, model.*, controller.*"%>

<!DOCTYPE hmtl>
<hmtl>
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
		<div id="footer">
			<div class="container">
				<div class="row footer-header">
					<div class="col-md-5 text">
						<h1>Subsribe for Or4nge's lastest news</h1>
						<p>Don't miss thousands of Or4nge's wonderful books</p>
					</div>
					<!-- End text -->
					<div class="col-md-4 email-box">
						<input id="input-email-box" type="text" name="email" placeholder="Your Email">
					</div>
					<!-- End email-box -->
					<div class="col-md-2 submit-btn">
						<button>Submit</button>
					</div>
				</div>
				<!-- End footer-header -->

				<div class="row footer-content">
					<div class="col-md-3 customer-services">
						<h1>CUSTOMER SERVICES</h1>
						<div class="hotline">
							<a href="">Hotline order: 3004-1975</a><br>
							<small>(Free, 6a.m-18:00, daily)</small>							
						</div>
						<div class="hotline">
							<a href="">Hotline: 1705-1945</a><br>
							<small>(1,000VND/min, 6a.m-18:00, daily)</small>							
						</div>
						
					</div>
					<!-- End customer service -->

					<div class="col-md-3 about-us">
						<h1>ABOUT US</h1>
						<a href="">Introduction</a>
						<a href="">Recruitment</a>
						<a href="">Payment security policy</a>
						<a href="">Information security policy</a>
						<a href="">Resolve complaints policy</a>
						<a href="">Terms of use</a>
					</div>
					<!-- End about us -->

					<div class="col-md-3 payment">
						<h1>PAYMENT METHODS</h1>
						<i class="fab fa-cc-visa" title="Visa card"></i>
						<i class="fab fa-cc-mastercard" title="Master card"></i>
						<i class="far fa-credit-card" title="Credit card"></i>
						<i class="far fa-money-bill-alt" title="Cash"></i>
						<i class="fas fa-university" title="Internet banking"></i>
						<i class="fas fa-piggy-bank" title="Installment"></i>
					</div>
					<!-- End payment -->

					<div class="col-md-3 contact-us">
						<div class="connect-us">
							<h1>CONTACT US</h1>
							<a href="https://www.facebook.com/" target="_blank"><i class="fab fa-facebook-square"></i></a>
							<a href="https://www.youtube.com/" target="_blank"><i class="fab fa-youtube"></i></a>
							<a href="https://www.instagram.com/" target="_blank"><i class="fab fa-instagram"></i></a>
						</div>

						<div class="install">
							<h1>AVAILABLE ON</h1>
							<a href="https://play.google.com/store" target="_blank"><i class="fab fa-google-play"></i></a>
							<a href="https://www.apple.com/ios/app-store/" target="_blank"><i class="fab fa-app-store-ios"></i></a>
						</div>
					</div>
					<!-- End contact us -->
				</div>
				<!-- End footer content -->
			</div>
		</div>
		<!-- End footer -->

		<!-- ============================Script===================================== -->
		<script type="text/javascript" src="assets/js/bootstrap.js"></script>
		<script type="text/javascript" src="assets/js/bootstrap.min.js"></script>
		<script type="text/javascript" src="assets/js/home-page.js"></script>
	</body>
</hmtl>