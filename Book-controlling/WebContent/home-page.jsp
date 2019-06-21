<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import="java.util.*, model.*, controller.*"%>   
<!DOCTYPE hmtl>
<hmtl>
	<head>
		<title>Demo App</title>		
		<meta charset="ISO-8859-1">
		<meta charset = "UTF - 8">
		<meta name="viewport" content="width=device-width, initial-scale=1">

		<link rel="stylesheet" type="text/css" href="assets/css/bootstrap.min.css">		
		<link rel="stylesheet" type="text/css" href="assets/css/bootstrap.css">
		<link rel="stylesheet" type="text/css" href="assets/css/setup.css">
		<link rel="stylesheet" type="text/css" href="assets/css/font-awesome.min.css">
		
		
		<script type="text/javascript" src="assets/js/bootstrap.js"></script>
		<script type="text/javascript" src="assets/js/bootstrap.min.js"></script>
		<link rel="stylesheet" type="text/css" href="assets/css/home-page.css">
		<link rel="stylesheet" type="text/css" href="assets/css/header-footer.css">
		

		<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css" integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf" crossorigin="anonymous">
	
		<%
			List<Book> BestSellBooks = (List<Book>)request.getAttribute("BEST_SELL_LIST");
			List<Book> ActionBooks = (List<Book>)request.getAttribute("ACTION_LIST");
			List<Book> AdventureBooks = (List<Book>)request.getAttribute("ADVENTURE_LIST");
		%>
	
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
									<%
									List<String> type = (List<String>) request.getAttribute("booktypes");
									int hang = type.size()/2;
									int le = type.size()%2;
									int counter = 0;
									int o = 0;
									for ( counter=0;counter < hang;counter++)
									{	
										
										out.println("<div class=\"row\"><a href=\"categoryservlet?type=" +type.get(o) +"\" class=\"col-sm\">"+type.get(o)+"</a><a href=\"categoryservlet?type=" +type.get(o+1)+"\" class=\"col-sm\">"+type.get(o+1)+"</a></div>");
										o = o+2;
										
										
									}
									if (le != 0)
									{
										out.println("<div class=\"row\"><a href=\"\" class=\"col-sm\">"+type.get(type.size()-1)+"</a></div>");
									}
									
									%>								
								
								</div>
						</li>
						
												
						<li><a href="">About Us</a></li>
						<li><a href="">Contact</a></li>
					</ul>
				</div>
			</div>
		</div>
		
		
		
		<!-- End Header -->

		<div id="content">
			<div class="container">
				<div class="advertise-banner">

						<a class="prev" onclick="plus_slide_banner(-1)">&#10094;</a>
						<a class="next" onclick="plus_slide_banner(1)">&#10095;</a>

						<div class="slide-show-banner fade">
							<img src="assets/image/cover1.jpg">
							<div class="advertise-text">
								<a href=""><h1>Search every Books on this World</h1></a>
								<input id="input-box-search" type="text" name="search" placeholder="Search..">							
							</div>
						</div>

						<div class="slide-show-banner fade">
							<img src="assets/image/cover2.jpg">
							<div class="advertise-text">
								<a href=""><h1>Raise fund to help children</h1></a>
								<div class="read-more-btn">
									<button>Read more &#10095;&#10095;</button>
								</div>							
							</div>
						</div>

						<div class="slide-show-banner fade">
							<img src="assets/image/cover3.jpg">
							<div class="advertise-text">
								<a href=""><h1>Anytime, Anyplace, Anywhere.</h1></a>						
							</div>
						</div>
					</div>					
					<!-- End banner -->

					<div id="book-display-pnl">
						<div class="row">
							<h1>Our Bestsellers</h1>
						</div>
						<hr>
						<div class="row book-display">
						<%
							for(int i = 0; i < 4; i++)
							{
								out.println("<div class=\"col-sm-3 item\">");
									out.println("<div class=\"item-image\">");
										out.println("<img src=\""+ BestSellBooks.get(i).getBookImg() +"\">");
										out.println("<div class=\"row status-book\">");
											out.println("<i class=\"fas fa-eye col-md-4\">5000</i>");
											out.println("<i class=\"far fa-thumbs-up col-md-4\">5000</i>");
											out.println("<i class=\"fas fa-shopping-basket col-md-4\">5000</i>");
										out.println("</div>");
									out.println("</div>");
									
									out.println("<div class=\"item-infor\">");
										out.println("<div class=\"item-text\">");
											out.println("<a href=\"book-display.html\">" + BestSellBooks.get(i).getBookName() + "</a>");
											out.println("<p>Life of Pi is a Canadian fantasy adventure novel by Yann Martel published in 2001. The protagonist is Piscine Molitor \"Pi\" Patel, an Indian Tamil boy ...</p>");
										out.println("</div>");
										out.println("<div class=\"view-more\">");
											out.println("<a href=\"book-display.html\">View more &#10095;&#10095;</a>");
										out.println("</div>");
									out.println("</div>");
								out.println("</div>");
							}
						
						%>
						</div>
					<!-- End Bestsellers pnl -->

					<div class="row advertise-pnl">
						<div class="col-md-6"><img src="assets/image/banner.jpg"></div>
						<div class="col-md-6"><img src="assets/image/banner.jpg"></div>
					</div>
					<div class="row advertise-pnl">
						<div class="col-md-6"><img src="assets/image/banner.jpg"></div>
						<div class="col-md-6"><img src="assets/image/banner.jpg"></div>
					</div>
					<!-- End advertise pnl -->

					<div class="category-display-pnl">
						<ul class="row category-header">
							<li class="col-md-4"><button class="category-button" onclick="openCategory('genre-action')">Action</button></li>
							<li class="col-md-4"><button class="category-button" onclick="openCategory('genre-adventure')">Adventure</button></li>
							<li class="col-md-4"><button class="category-button" onclick="openCategory('genre-classic')">Classic</button></li>
						</ul>
						<!-- End category header -->

						<hr>

						<div class="row category-tabs">
							<a class="prev" onclick="plus_slide_category_1(-1)">&#10094;</a>
							<a class="next" onclick="plus_slide_category_1(1)">&#10095;</a>

							<div id="genre-action" class="row category slide-show-category-1 fade">
							<%
								for(int i = 0; i < 4; i++)
								{
									out.println("<div class=\"col-md-3 item\">");
										out.println("<a href=\"book-display.html\"><img src=\"" + ActionBooks.get(i).getBookImg() + "\"></a>");
										
										out.println("<div class=\"item-text\">");
											out.println("<a href=\"book-display.html\">" + ActionBooks.get(i).getBookName() +"</a>");
											out.println("<p> Price: " + ActionBooks.get(i).getBookPrice() + "</p>");
											out.println("<p>Rate: <i class=\"fas fa-star\"></i><i class=\"fas fa-star\"></i><i class=\"fas fa-star\"></i><i class=\"fas fa-star\"></i></p>");
										out.println("</div>");
									out.println("</div>");
								}
							%>
							</div>
							<!-- End genre action -->

							<div id="genre-adventure" class="row category slide-show-category-1 fade">
								<%
								for(int i = 0; i < 4; i++)
								{
									out.println("<div class=\"col-md-3 item\">");
										out.println("<a href=\"book-display.html\"><img src=\"" + AdventureBooks.get(i).getBookImg() + "\"></a>");
										
										out.println("<div class=\"item-text\">");
											out.println("<a href=\"book-display.html\">" + AdventureBooks.get(i).getBookName() +"</a>");
											out.println("<p> Price: " + AdventureBooks.get(i).getBookPrice() + "</p>");
											out.println("<p>Rate: <i class=\"fas fa-star\"></i><i class=\"fas fa-star\"></i><i class=\"fas fa-star\"></i><i class=\"fas fa-star\"></i></p>");
										out.println("</div>");
									out.println("</div>");
								}
								%>
							</div>
							<!-- End genre adventure -->

							<div id="genre-classic" class="row category slide-show-category-1 fade">
								<div class="col-md-3 item">
									<a href="book-display.html"><img src="assets/image/classic-cover.jpg"></a>

									<div class="item-text">
										<a href="book-display.html">The Great Gatsby</a>
										<p>Price: 200,000 VND</p>
										<p>Rate: <i class="fas fa-star"></i><i class="fas fa-star"></i><i class="fas fa-star"></i><i class="fas fa-star"></i></p>
									</div>
								</div>
								<div class="col-md-3 item">
									<a href="book-display.html"><img src="assets/image/classic-cover.jpg"></a>

									<div class="item-text">
										<a href="book-display.html">The Great Gatsby</a>
										<p>Price: 200,000 VND</p>
										<p>Rate: <i class="fas fa-star"></i><i class="fas fa-star"></i><i class="fas fa-star"></i><i class="fas fa-star"></i></p>
									</div>
								</div>
								<div class="col-md-3 item">
									<a href="book-display.html"><img src="assets/image/classic-cover.jpg"></a>

									<div class="item-text">
										<a href="book-display.html">The Great Gatsby</a>
										<p>Price: 200,000 VND</p>
										<p>Rate: <i class="fas fa-star"></i><i class="fas fa-star"></i><i class="fas fa-star"></i><i class="fas fa-star"></i></p>
									</div>
								</div>
								<div class="col-md-3 item">
									<a href="book-display.html"><img src="assets/image/classic-cover.jpg"></a>

									<div class="item-text">
										<a href="book-display.html">The Great Gatsby</a>
										<p>Price: 200,000 VND</p>
										<p>Rate: <i class="fas fa-star"></i><i class="fas fa-star"></i><i class="fas fa-star"></i><i class="fas fa-star"></i></p>
									</div>
								</div>
							</div>
							<!-- End genre classic -->

							<div class="view-more">
								<a href="book-display.html">View more &#10095;&#10095;</a>
							</div>
						</div>
						<!-- End category tabs -->						
					</div>
					<!-- End category-display-pnl -->
			</div>
			<!-- End content container -->			
		</div>
		<!-- End content -->

		<jsp:include page="footer.jsp"/>
		<!-- End footer -->

		<!-- ============================Script===================================== -->
		<script type="text/javascript" src="assets/js/home-page.js"></script>
	</body>
</hmtl>