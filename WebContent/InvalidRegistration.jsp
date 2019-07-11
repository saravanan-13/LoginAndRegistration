<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Invalid Registration</title>
</head>
<body>
<h1 style="text-align: center;font-size: 25px;">
<%= request.getAttribute("message") %>
<br>
Try Again !
</h1>
<jsp:include page='Registration.html' />
</body>
</html>