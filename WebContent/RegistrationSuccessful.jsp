<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration SuccessFul</title>
</head>
<body>
<h1>
<%= request.getParameter("username") %>
<br>
You have been Registered Successfully!
</h1>
<jsp:include page='Login.html' />
</body>
</html>