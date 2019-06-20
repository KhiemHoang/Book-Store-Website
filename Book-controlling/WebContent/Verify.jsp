<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
	body {
    text-align: center;
	}

</style>
</head>
<body>
<%
	int i = (int)request.getAttribute("code");
	System.out.println(i);
	
	out.println("<form action=\"ResetPassword\"><input type=\"text\" name=\"code\" placeholder=\"YOUR CODE\"><br><br><input type=\"text\" placeholder = \"NEW PASSWORD\"><br><br><input type=\"submit\" value=\"Submit\"> <input type=\"hidden\" name=\"code2\" value=\""+i+"\"><br></form>");
%>
      
</body>
</html>