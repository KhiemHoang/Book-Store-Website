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
		<link rel="stylesheet" type="text/css" href="assets/css/online-reading.css">
		<link rel="stylesheet" type="text/css" href="assets/css/header-footer.css">
		

		<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css" integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf" crossorigin="anonymous">
		
		<%
			List<Book> books = (List<Book>)request.getAttribute("BOOK_LIST");
			List<Publisher> publish = (List<Publisher>)request.getAttribute("PUBLISH_LIST");
			String authorname = (String)request.getAttribute("BOOK_AUTHOR");
		%>

</head>
<body>
	<jsp:include page="header.jsp"/>
		<!-- End Header -->
		
	<div id="content">
			<div class="container">
				<div class="read-pnl">
					<embed src="Principles.of.Distributed.Database.Systems.3rd.Edition.Feb.2011.pdf" type="application/pdf"></embed>
				</div>
				<div class="book-info">
					<h1>Book Name</h1>
					<div class="row description">
						<table class="col-md-7">
							<tr>
								<td class="col-name">Publisher</td>
								<td class="col-detail"><%= publish.get(0).getCompany() %></td>
							</tr>
							<tr>
								<td class="col-name">Author</td>
								<td class="col-detail"><a href="author.html"><%= authorname %></a></td>
							</tr>
							<tr>
								<td class="col-name">Publish date</td>
								<td class="col-detail"><%= publish.get(0).getRelease() %></td>
							</tr>
							<tr>
								<td class="col-name">Size</td>
								<td class="col-detail"><%= books.get(0).getBookSize() %></td>
							</tr>
							<tr>
								<td class="col-name">Version</td>
								<td class="col-detail">Electronic(PFD)</td>
							</tr>
							<tr>
								<td class="col-name">Page number</td>
								<td class="col-detail">350 pages</td>
							</tr>
							<tr>
								<td class="col-name">SKU</td>
								<td class="col-detail"><%= publish.get(0).getBookID() %></td>
							</tr>
						</table>

						<div class="col-md-3 book-img">
							<img src="<%= books.get(0).getBookImg() %>">
						</div>
					</div>
				</div>
			</div>
		
	<jsp:include page="footer.jsp"/>
		<!-- End Footer -->
</body>
</html>