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
	String username = (String)request.getAttribute("username");
	System.out.println("verify.jsp "+username);
	out.println("<form action=\"ResetPassword\"><input type=\"text\" name=\"code\" placeholder=\"YOUR CODE\">");
	out.println("<br><br><input type=\"submit\" value=\"Submit\">") ;
	out.println("<input type=\"hidden\" name=\"code2\" value=\""+i+"\"><br>");
	out.println("<input type=\"hidden\" name=\"username\" value=\""+username+"\"><br>");
	out.println("</form>");

%>
      
</body>
</html>