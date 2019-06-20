<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*, model.*, controller.*"%>

<!DOCTYPE html>
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
		<link rel="stylesheet" type="text/css" href="assets/css/author.css">
		<link rel="stylesheet" type="text/css" href="assets/css/header-footer.css">
		
		<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css" integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf" crossorigin="anonymous">
	
		<%
		String authorName = (String)request.getAttribute("AUTHORS_NAME");
		Date authorDOB = (Date)request.getAttribute("AUTHORS_DOB");
		String authorNation = (String)request.getAttribute("AUTHORS_NATION");
		String authorImg = (String)request.getAttribute("AUTHORS_IMG");
		int authorTotal = (int)request.getAttribute("AUTHORS_TOTAL");
		
		String bookImg = (String)request.getAttribute("BOOK_IMG");
		List<Book> books = (List<Book>)request.getAttribute("BOOK_LIST");
		%>
		


</head>
<body>
		<jsp:include page="header.jsp"/>
		<!-- End Header -->

		<div id="content">
			<div class="container">
				<div class="author-header">
					<h1><%= authorName %></h1>
				</div>
				<!-- End author header -->

				<div class="row detail-table">
					<table class="col-md-7">
						<tr>
							<td class="col-name">Name</td>
							<td class="col-detail"><a href=""><%= authorName %></a></td>
						</tr>
						<tr>
							<td class="col-name">Born</td>
							<td class="col-detail"><%= authorDOB %></td>
						</tr>
						<tr>
							<td class="col-name">Nationality</td>
							<td class="col-detail"><%= authorNation %></td>
						</tr>						
						<tr>
							<td class="col-name">Trend</td>
							<td class="col-detail"><a href="">Adventure</a>,<a href=""> Literature</a></td>
						</tr>
						<tr>
							<td class="col-name">Available books</td>
							<td class="col-detail"><%= authorTotal %></td>
						</tr>
					</table>

					<img src="<%=authorImg%>" class="col-md-3 author-image">
				</div>
				<!-- End detail-table -->

				<div class="row recommend-product">
					<div class="recommend-header">
						<h1>SAME AUTHOR PRODUCT</h1>
					</div>

					<div class="recommend-slide">

						<div id="genre-adventure" class="row category slide-show-category-1 fade">
						<%
							for(int i = 0; i < authorTotal; i++)
							{
								out.println("<div class=\"col-md-3 item\">");
								out.println("<a href=\"\"> <img src =\""+books.get(i).getBookImg() +"\"> </img> </a>");
								
								out.println("<div class=\"item-text\">");
								out.println("<a href=\"\">"+books.get(i).getBookName()+"</a>");
								out.println("<p>Price: "+ books.get(i).getBookPrice() +" VND</p>");
								out.println("<p>Rate: <i class=\"fas fa-star\"></i><i class=\"fas fa-star\"></i><i class=\"fas fa-star\"></i><i class=\"fas fa-star\"></i><i class=\"fas fa-star\"></i></p>");
								out.println("</div>");
								out.println("</div>");
							}						
						%>
							<!-- End genre adventure -->
					</div>
					<!-- End recommend slide -->
				</div>
				<!-- End recommend product -->
			</div>
		</div>
		<!-- End content -->

		<jsp:include page="footer.jsp"/>
		<!-- End footer -->
		<!-- ============================Script===================================== -->
		<script type="text/javascript" src="assets/js/bootstrap.js"></script>
		<script type="text/javascript" src="assets/js/bootstrap.min.js"></script>
		<script type="text/javascript" src="assets/js/book-display.js"></script>
</body>
</html>