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
		<table>
			<tr>
				<td><label>CustomerID</label></td>
				<td><input type="text" name="customerID"/></td>
			</tr>
			<tr>
				<td><label>Password</label></td>
				<td><input type="password" name="pass"/></td>
			</tr>
		</table>
			<input type="submit" value="login">
	</form>
</body>
</html>