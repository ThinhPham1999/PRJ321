<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="login" method="post">
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