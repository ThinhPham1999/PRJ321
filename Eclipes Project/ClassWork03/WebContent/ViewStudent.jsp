<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h3>Student List</h3>
	<table border="1">
				<tr>
					<th>ID</th>
					<th>Name</th>
					<th>Gender</th>
					<th>DOB</th>
					<th></th>
				</tr>
		<c:forEach items="${listStudent}" var="student">
				
				<tr>
					<td>${student.id}</td>
					<td>${student.name}</td>
					<td>
						<c:if test =  "${student.gender == 0}">
								Male 
						</c:if>
						<c:if test =  "${student.gender == 1}">
							Female
						</c:if>
					</td>
					<td>${student.dob}</td>
					<td>
						<a href="UpdateStudentController?id=${student.id}">Update</a> 
						<a href="DeleteStudentController?id=${student.id}">Delete</a>
					</td>
				</tr>
			</c:forEach>
	</table>
	<a href="addStudent.jsp">Create new student</a>
</body>
</html>