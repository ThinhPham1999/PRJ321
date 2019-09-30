<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="StudentAdd" method="post">
		<label>Name</label>
		<input type="text" name="name"/><br>
		<label>Gender</label>
		<input type="radio" name="gender" value="Male" /> <label>Male</label>
		<input type="radio" name="gender" value="Female"/> <label>Female</label><br>
		<label>DOB</label>
		<input type="text" name="dob" placeholder="yyyy-mm-dd"><br>
		<input type="submit" value="Create">
	</form>
</body>
</html>