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
		<link rel="stylesheet" type="text/css" href="assets/css/font-awesome.min.css">
		
		
		<script type="text/javascript" src="assets/js/bootstrap.js"></script>
		<script type="text/javascript" src="assets/js/bootstrap.min.js"></script>
		<link rel="stylesheet" type="text/css" href="assets/css/customer-history.css">
		<link rel="stylesheet" type="text/css" href="assets/css/header-footer.css">
		

		<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css" integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf" crossorigin="anonymous">
	
		<%
		List<Users> users = (List<Users>)request.getAttribute("cus_infor");
		List<Order_History> history = (List<Order_History>)request.getAttribute("history");
		List<String> bname = (List<String>)request.getAttribute("bname");
		%>
	
	</head>

	<body>
		<div id="header">
			<div class="container">
				<div class="row sign-up-bar">
					<ul class="sign-up">
						<li><a href="">Sign out</a></li>					
						<li><a href="">Manage Account</a></li>
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

		<div id="content">
			<div class="container">
				<div class="head-text">
					<h1>CUSTOMER INFORMATION</h1>					
				</div>

				<div class="row customer-infor">
					<div class="col-md-7 infor-pnl">						
						<table>
							<tr>
								<td class="col-name">User name</td>
								<td class="col-detail"><%= users.get(0).getUserName() %></a></td>
							</tr>
							<tr>
								<td class="col-name">Email</td>
								<td class="col-detail"><%= users.get(0).getUserEmail() %></a></td>
							</tr>
							<tr>
								<td class="col-name">Address</td>
								<td class="col-detail"><%= users.get(0).getUserAddress() %></td>
							</tr>								
						</table>

						<p>Change Password:</p>
						<form class="pwd-change" action="changepassword" method="get">
							<p>Old password:</p>
							<input type="password" name="old_password">
							<p>New password:</p>
							<input type="password" name="new_password">
							<input class="btn-change" type="Submit" name="" value="Change">
						</form>
					</div>

					<div class="col-md-4 user-img">
						<img src="assets/image/adventure-cover.jpg">
						<form class="upt-img">
							<p>Change avatar:</p>
							<input type="text" name="" placeholder="Input image link.">
							<input class="btn-submit" type="Submit" name="">
						</form>
					</div>
				</div>

				<div class="head-text">
					<h1>PURCHASE BOOKS</h1>					
				</div>
				<div class="row customer-purchase">
					<table>
						<tr>
							<th class="th" style="width: 5%;">No.</th>
							<th class="th" style="width: 50%;">Book title</th>
							<th class="th" style="width: 20%;">Date Purchase</th>
							<th class="th" style="width: 10%;">Quantity</th>
							<th class="th" style="width: 15%;">TotalPrice</th>
						</tr>
						<%
							for(int i = 0; i< history.size(); i++)
							{
								out.println("<tr>");
									out.println("<td class=\"td\" >" + (i+1) + "</td>");
									out.println("<td class=\"td\" ><a href=\"Online_Reading_Servlet?bookid="+history.get(i).getBookID() +"\">"+ bname.get(i)+"</td>");
									out.println("<td class=\"td\" >2019-02-12</td>");
									out.println("<td class=\"td\" >" + history.get(i).getOrderQuantity() + "</td>");
									out.println("<td class=\"td\" >" + history.get(i).getOrderPrice() + "</td>");
								out.println("</tr>");								
							}
						%>
					</table>
				</div>
			</div>
		</div>

		<jsp:include page="footer.jsp"/>
		<!-- End footer -->
	</body>
</hmtl>	