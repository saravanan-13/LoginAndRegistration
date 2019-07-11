<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome</title>
<style>
body{
text-align:center;
}
</style>
</head>
<body>
	<h1 style="text-align: center;font-size: 25px;">
		Welcome
		<%=request.getParameter("username")%>
	</h1>
</body>
</html>