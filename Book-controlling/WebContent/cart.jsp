<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.*, model.*, controller.*"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
table {
  font-family: arial, sans-serif;
  border-collapse: collapse;
  width: 100%;
}

td, th {
  border: 1px solid #dddddd;
  text-align: left;
  padding: 8px;
}

tr:nth-child(even) {
  background-color: #dddddd;
}
</style>
</head>
<body style = "text-align: center;">
	<%
	if(null == session.getAttribute("username")){
		String redirectURL = "login.jsp";
	    response.sendRedirect(redirectURL);
		}else{
		  //logged in
		}
	%>
	<h2>Your Cart</h2>
	<form action = "deletecart" method = "GET">
	
<table>
  <tr>
    <th>Item</th>
    <th></th>
  </tr>
  <%
  	List<String> namelist = (List<String>)session.getAttribute("cartlist");
  	for (int i = 0; i<namelist.size();i++)
  	{
  		out.println("<tr>");
  		out.println("<td>"+namelist.get(i)+"</td>");
  		out.println("<td><input type =\"submit\" name=\"button"+i+"\" value=\"Delete\" style=\"width:100%;height:50px\"></td");
  		out.println("</tr>");

  	}
  %>
</table>
	 </form>
	 <br>
	 <br>
	 <form action = "buycart" method = "GET">
	 <input type="submit" value="BUY" style ="height:50px;width:300px">
	 </form>
	
</body>
</html>