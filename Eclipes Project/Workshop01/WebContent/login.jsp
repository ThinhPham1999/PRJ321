<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1><%= request.getAttribute("messageFailed")!=null?request.getAttribute("messageFailed"):""%></h1>
	<form action="LoginController" method="post">
		<label>CustomerID</label>
		<input type="text" name="customerID"/><br>
		<label>Password</label>
		<input type="text" name="pass"/><br>
		<input type="submit" value="login">
	</form>
</body>
</html>