<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="StudentServlet" method="POST">
		<h1>Add new Student</h1>
		<table border="0">
		<tr>
			<td><label>Student ID</label> </td>
			<td><input type="text" name="ID"></td>
		</tr>
		<tr>
			<td><label>Name</label> </td>
			<td><input type="text" name="name"></td>
		</tr>
		<tr>
			<td><label>Gender</label></td>
			<td>
				<input type="radio" name="gender" value="Male"> 
				<input type="radio" name="gender" value="Female">
			</td>
		</tr>
		<tr>
			<td><label>Date of Birth</label></td>
			<td><input type="text" name="dob" placeholder="dd/mm/yyyy"></td>
		</tr>
		</table>
		<input type="submit" value="Add">
	</form>
	<jsp:include page="listStudent.jsp"></jsp:include>
</body>
</html>