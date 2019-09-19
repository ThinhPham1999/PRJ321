<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student List</title>
</head>
<body>

	<h3>Student List</h3>
	<table border="1">
		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>Gender</th>
			<th>DOB</th>
		</tr>
		<c:forEach items="${listStudent}" var="Student">
			<tr>
				<td>${Student.id}</td>
				<td>${Student.name}</td>
				<td>
					<c:if test =  "${Student.gender == 0}">
						<input type="checkbox" name="gender" checked/> 
					</c:if>
					<c:if test =  "${Student.gender == 1}">
						<input type="checkbox" name="gender"/> 
					</c:if>
				</td>
				<td>${Student.dob}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>