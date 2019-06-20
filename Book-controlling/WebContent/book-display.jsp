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
		<link rel="stylesheet" type="text/css" href="assets/css/book-display.css">
		<link rel="stylesheet" type="text/css" href="assets/css/header-footer.css">
		

		<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css" integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf" crossorigin="anonymous">
	</head>

	<body>
		<jsp:include page="header.jsp"/>
		<!-- End Header -->

		<div id="content">
			<div class="container">
				<div class="row product-summary">
					<div class="row col-md-6 product-image">
						<div class="col-md-3 product-feature-image">
							<img src="assets/image/book-cover.jpg" onclick="imageZoom(this);">
							<img src="assets/image/book-page.png" onclick="imageZoom(this);">
						</div>
						<!-- End product feature -->

						<div class="col-md-8 product-zoom">
							<img id="zoomImg">

							<div class="status-bar">
								<i class="far fa-thumbs-up">5000</i>
								<i class="fas fa-eye">5000</i>
								<i class="fas fa-shopping-cart">5000</i>
							</div>
						</div>
						<!-- End product zoom -->
					</div>
					<!-- End product image -->

					<div class="col-md-6 product-cart">
						<div class="product-cart-header">
							<div class="product-name">
								<i class="far fa-hand-point-right"></i>
								<h1>LIFE OF PI</h1>					
							</div>
							<div class="product-info">
								<div class="product-status">
									<i class="fas fa-star"></i>
									<i class="fas fa-star"></i>
									<i class="fas fa-star"></i>
									<i class="fas fa-star"></i>
									<i class="fas fa-star-half-alt"></i>
									<a href="">(View 20+ comments)</a>									
								</div>
								<div class="product-detail">
									<p>Author: </p>
									<a href="author.html">Yasn Martel</a>
									<p>Release date: 11 September 2001</p>
								</div>
							</div>
						</div>
						<!-- End product cart header -->

						<div class="row">
							<div class="col-md-7 no-padding-right">
								<div class="product-price">
									<h1>212.500 VND</h1>
									<div class="price-info">
										<span class="text">Save up: </span>
										<span class="discount">15%</span>
										<span class="price">(37.500 VND)</span>
									</div>
									<div class="price-info">
										<span class="text">Market price: </span>
										<span class="price">250.000 VND</span>
									</div>
								</div>
								<!-- End product price -->

								<div class="row product-quantity">
									<div class="col-md-4 quantity-selector">
										<span class="text">Quantity:</span>
										<div class="input-form">
											<button onclick="add()" class="button-right">+</button>
											<input type="number" id="quantity" value="1" min="1" max="10">
											<button onclick="minus()" class="button-left">-</button>
										</div>										
									</div>

									<button class="col-md-7 submit-btn">
										<i class="fas fa-shopping-cart"></i>
										<span class="submit">Add to cart</span>
									</button>
								</div>
								<!-- End product quantity -->

								<div class="time-place">
									<h1>Time and Place</h1>
									<span class="text">Where and when you want your books delivered?</span>
									<a href="">(Input place and location)</a>
								</div>
								<!-- End time and place -->
							</div>
							<!-- End no padding right -->

							<div class="col-md-5 more-cart-info">
								<div class="commitment">
									<div class="commitment-info">
										<i class="fas fa-store"></i>
										<div class="info">
											<span class="heading">Or4nge Trading<span>
											<span class="text">100% genuine commitment.</span>
										</div>
									</div>

									<div class="commitment-info">
										<i class="fas fa-hand-holding-usd"></i>
										<div class="info">z
											<span class="heading">Refund 111%<span>
											<span class="text">Fake detected only.</span>
										</div>
									</div>
								</div>
								<!-- End commiment -->


								<div class="contact">
									<div class="contact-info">
										<i class="fas fa-phone-volume"></i>
										<div class="info">
											<span class="heading">Contact<span>
											<span class="text">Hotline order: 3004-1975</span>
											<small>(Free, 6a.m-18:00, daily)</small>
										</div>
									</div>

									<div class="contact-email">
										<i class="far fa-envelope"></i>
										<div class="info">
											<span class="heading">Email:<span>
											<span class="text">GPMN_3004@gmail.com</span>
										</div>
									</div>

									<div class="contact-register">
										<span class="heading">Become our partner: </span>
										<button>Register</button>
									</div>
								</div>
								<!-- End contact -->
							</div>
							<!-- End more cart info -->
						</div>
						<!-- End row -->

						<div class="advertise">
							<img src="assets/image/banner.jpg">
						</div>
					</div>
					<!-- End product cart -->
				</div>
				<!-- End product summary -->

				<div class="row recommend-product">
					<div class="recommend-header">
						<h1>RECOMMEND PRODUCT</h1>
					</div>

					<div class="recommend-slide">

						<div id="genre-adventure" class="row category slide-show-category-1 fade">
								<div class="col-md-3 item">
									<a href=""><img src="assets/image/adventure-cover.jpg"></a>

									<div class="item-text">
										<a href="">Harry Potter</a>
										<p>Price: 145,000 VND</p>
										<p>Rate: <i class="fas fa-star"></i><i class="fas fa-star"></i><i class="fas fa-star"></i><i class="fas fa-star"></i><i class="fas fa-star"></i></p>
									</div>
								</div>
								<div class="col-md-3 item">
									<a href=""><img src="assets/image/adventure-cover.jpg"></a>

									<div class="item-text">
										<a href="">Harry Potter</a>
										<p>Price: 145,000 VND</p>
										<p>Rate: <i class="fas fa-star"></i><i class="fas fa-star"></i><i class="fas fa-star"></i><i class="fas fa-star"></i><i class="fas fa-star"></i></p>
									</div>
								</div>
								<div class="col-md-3 item">
									<a href=""><img src="assets/image/adventure-cover.jpg"></a>

									<div class="item-text">
										<a href="">Harry Potter</a>
										<p>Price: 145,000 VND</p>
										<p>Rate: <i class="fas fa-star"></i><i class="fas fa-star"></i><i class="fas fa-star"></i><i class="fas fa-star"></i><i class="fas fa-star"></i></p>
									</div>
								</div>
								<div class="col-md-3 item">
									<a href=""><img src="assets/image/adventure-cover.jpg"></a>

									<div class="item-text">
										<a href="">Harry Potter</a>
										<p>Price: 145,000 VND</p>
										<p>Rate: <i class="fas fa-star"></i><i class="fas fa-star"></i><i class="fas fa-star"></i><i class="fas fa-star"></i><i class="fas fa-star"></i></p>
									</div>
								</div>
							</div>
							<!-- End genre adventure -->
					</div>
					<!-- End recommend slide -->
				</div>
				<!-- End recommend product -->

				<div class="row description">
					<div class="description-header">
						<h1>DESCRIPTION</h1>
					</div>

					<div class="row description-table">
						<table class="col-md-7">
							<tr>
								<td class="col-name">Publisher</td>
								<td class="col-detail"><a href="">Kim Dong</a></td>
							</tr>
							<tr>
								<td class="col-name">Author</td>
								<td class="col-detail"><a href="author.html">Yans Martel</a></td>
							</tr>
							<tr>
								<td class="col-name">Publish date</td>
								<td class="col-detail">11 September 2001</td>
							</tr>
							<tr>
								<td class="col-name">Size</td>
								<td class="col-detail">14x20cm</td>
							</tr>
							<tr>
								<td class="col-name">Version</td>
								<td class="col-detail">Hardcover, Electronic(PFD)</td>
							</tr>
							<tr>
								<td class="col-name">Page number</td>
								<td class="col-detail">350 pages</td>
							</tr>
							<tr>
								<td class="col-name">SKU</td>
								<td class="col-detail">2701536880385</td>
							</tr>
						</table>
						<!-- End table -->
					</div>
					<!-- End description table -->
				</div>
				<!-- End description -->

				<div class="row QandA">
					<div class="QandA-header">
						<h1>Q&A</h1>
					</div>

					<div class="QandA-panel">
						<div class="row question-answer">
							<div class="col-md-1 question-rate">
								<p class="number">1</p>
								<p class="text">likes</p>
							</div>	

							<div class="col-md-10 answer-group">
								<h1>What's the payment method?</h1>
								<p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium quis, sem. Nulla consequat massa quis enim. Donec pede justo, fringilla vel, aliquet nec, vulputate eget, arcu. In enim justo, rhoncus ut, imperdiet a, venenatis vitae, justo. Nullam dictum felis eu pede mollis pretium. Integer tincidunt. Cras dapibus. Vivamus elementum semper nisi. Aenean vulputate eleifend tellus. Aenean leo ligula, porttitor eu, consequat vitae, eleifend ac, enim. Aliquam lorem ante, dapibus in, viverra quis, feugiat a, tellus. Phasellus viverra nulla ut metus varius laoreet. Quisque rutrum. Aenean imperdiet. Etiam ultricies nisi vel augue.</p>
								<p>Answer by: <a href="">Khiem</a> in 30/04/2019</p>
								<div class="answer-feedback">
									<i class="far fa-thumbs-up"></i>
									<p onclick="">Like</p>
									<i class="fas fa-reply"></i>
									<p>Reply</p>
								</div>
							</div>						
						</div>
						<div class="row question-answer">
							<div class="col-md-1 question-rate">
								<p class="number">1</p>
								<p class="text">likes</p>
							</div>	

							<div class="col-md-10 answer-group">
								<h1>Does Or4nge really deliver books to my bed?</h1>
								<p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium quis, sem. Nulla consequat massa quis enim. Donec pede justo, fringilla vel, aliquet nec, vulputate eget, arcu.</p>
								<p>Answer by: <a href="">Khiem</a> in 30/04/2019</p>
								<div class="answer-feedback">
									<i class="far fa-thumbs-up"></i>
									<p onclick="">Like</p>
									<i class="fas fa-reply"></i>
									<p>Reply</p>
								</div>
							</div>						
						</div>
						<div class="row question-answer">
							<div class="col-md-1 question-rate">
								<p class="number">1</p>
								<p class="text">likes</p>
							</div>	

							<div class="col-md-10 answer-group">
								<h1>I'm so busy in weekdays so can I get my book delivered on Tuesday?</h1>
								<p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus.</p>
								<p>Answer by: <a href="">Khiem</a> in 30/04/2019</p>
								<div class="answer-feedback">
									<i class="far fa-thumbs-up"></i>
									<p onclick="">Like</p>
									<i class="fas fa-reply"></i>
									<p>Reply</p>
								</div>
							</div>						
						</div>
						<div class="row raise-question">
							<div class="col-md-7 question-box">
								<input id="input-question-box" type="text" name="question" placeholder="Type your question here.">
							</div>
							<div class="col-md-2 send-button">								
								<button>Send</button>
							</div>
						</div>
					</div>
				</div>
				<!-- End Q&A -->

				<div class="row customer-review">
					<div class="review-header">
						<h1>CUSTOMER REVIEWS</h1>
					</div>

					<div class="row rate-pnl">
						<div class="col-md-3 rate-score">
							<h1>Average rate</h1>
							<p class="number">4.5/5</p>
							<div class="product-status">
								<i class="fas fa-star"></i>
								<i class="fas fa-star"></i>
								<i class="fas fa-star"></i>
								<i class="fas fa-star"></i>
								<i class="fas fa-star-half-alt"></i>
								<a href="">(View 20+ comments)</a>									
							</div>
						</div>

						<div class="col-md-6 progress-pnl">
							<div class="progress-info">
								<p>5</p>
								<i class="fas fa-star"></i>
								<div class="progress-contain">
									<div class="progress-bar" role="progressbar" aria-valuenow="70" aria-valuemin="0" aria-valuemax="100" style="width:70%"></div>									
								</div>
								<p class="percentage">70%</p>
							</div>
							<div class="progress-info">
								<p>4</p>
								<i class="fas fa-star"></i>
								<div class="progress-contain">
									<div class="progress-bar" role="progressbar" aria-valuenow="50" aria-valuemin="0" aria-valuemax="100" style="width:50%"></div>									
								</div>
								<p class="percentage">50%</p>
							</div>
							<div class="progress-info">
								<p>3</p>
								<i class="fas fa-star"></i>
								<div class="progress-contain">
									<div class="progress-bar" role="progressbar" aria-valuenow="0" aria-valuemin="0" aria-valuemax="100" style="width:0%"></div>									
								</div>
								<p class="percentage">0%</p>
							</div>
							<div class="progress-info">
								<p>2</p>
								<i class="fas fa-star"></i>
								<div class="progress-contain">
									<div class="progress-bar" role="progressbar" aria-valuenow="0" aria-valuemin="0" aria-valuemax="100" style="width:0%"></div>									
								</div>
								<p class="percentage">0%</p>
							</div>
							<div class="progress-info">
								<p>1</p>
								<i class="fas fa-star"></i>
								<div class="progress-contain">
									<div class="progress-bar" role="progressbar" aria-valuenow="0" aria-valuemin="0" aria-valuemax="100" style="width:0%"></div>									
								</div>
								<p class="percentage">0%</p>
							</div>
						</div>
						<!-- End progress pnl -->

						<div class="col-md-3 rate-btn">
							<p>Share your comments</p>
							<button>Leave your comment</button>
						</div>
					</div>
					<!-- End rate-pnl -->

					<div class="row cmt-pnl">
						<div class="col-md-3 cmt-user">
							<img src="assets/image/user-icon.png"> 
							<h1>Michael John</h1>
							<p>6 months ago</p>
						</div>

						<div class="col-md-9 cmt-detail">
							<div class="cmt-rate">							
								<i class="fas fa-star"></i>
								<i class="fas fa-star"></i>
								<i class="fas fa-star"></i>
								<i class="fas fa-star"></i>
								<h1>Good</h1>
							</div>

							<div class="cmt-check">
								<i class="fas fa-check-circle"></i>
								<p>Buy product at Or4nge</p>
							</div>

							<div class="cmt-text">
								<p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus.</p>
							</div>

							<div class="cmt-option">
								<i class="fas fa-thumbs-up"></i>
								<p>Thanks</p>
								<i class="fas fa-reply"></i>
								<p>Reply</p>
							</div>
						</div>
					</div>
					<!-- End cmt-pnl -->

					<div class="row cmt-pnl">
						<div class="col-md-3 cmt-user">
							<img src="assets/image/user-icon.png"> 
							<h1>Michael John</h1>
							<p>6 months ago</p>
						</div>

						<div class="col-md-9 cmt-detail">
							<div class="cmt-rate">							
								<i class="fas fa-star"></i>
								<i class="fas fa-star"></i>
								<i class="fas fa-star"></i>
								<i class="fas fa-star"></i>
								<h1>Good</h1>
							</div>

							<div class="cmt-check">
								<i class="fas fa-check-circle"></i>
								<p>Buy product at Or4nge</p>
							</div>

							<div class="cmt-text">
								<p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus.</p>
							</div>

							<div class="cmt-option">
								<i class="fas fa-thumbs-up"></i>
								<p>Thanks</p>
								<i class="fas fa-reply"></i>
								<p>Reply</p>
							</div>
						</div>
					</div>
					<!-- End cmt-pnl -->

					<div class="row cmt-pnl">
						<div class="col-md-3 cmt-user">
							<img src="assets/image/user-icon.png"> 
							<h1>Michael John</h1>
							<p>6 months ago</p>
						</div>

						<div class="col-md-9 cmt-detail">
							<div class="cmt-rate">							
								<i class="fas fa-star"></i>
								<i class="fas fa-star"></i>
								<i class="fas fa-star"></i>
								<i class="fas fa-star"></i>
								<h1>Good</h1>
							</div>

							<div class="cmt-check">
								<i class="fas fa-check-circle"></i>
								<p>Buy product at Or4nge</p>
							</div>

							<div class="cmt-text">
								<p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus.</p>
							</div>

							<div class="cmt-option">
								<i class="fas fa-thumbs-up"></i>
								<p>Thanks</p>
								<i class="fas fa-reply"></i>
								<p>Reply</p>
							</div>
						</div>
					</div>
					<!-- End cmt-pnl -->
				</div>
			</div>
			<!-- End content container -->
		</div>
		<!-- End content -->



		<jsp:include page="footer.jsp"/>
		<!-- End footer -->
		<!-- ============================Script===================================== -->
		<script type="text/javascript" src="assets/js/bootstrap.js"></script>
		<script type="text/javascript" src="assets/js/bootstrap.min.js"></script>
		<script type="text/javascript" src="assets/js/book-display.js"></script>
	</body>
</hmtl>	