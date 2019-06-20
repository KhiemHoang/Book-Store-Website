<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*,controller.*, model.*, controller.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>

<%
	List<Author> authors = (List<Author>) request.getAttribute("AUTHORS_LIST");
%>

<body>
<%= authors %>
</body>
</html>