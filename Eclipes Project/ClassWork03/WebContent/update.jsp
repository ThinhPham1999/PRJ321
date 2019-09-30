<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="UpdateStudentController" method="post">
		<label>Id</label>
		<input type="text" name="idU" value="${update.id}" readonly="readonly"/><br>
		<label>Name</label>
		<input type="text" name="nameU" value="${update.name}"/><br>
		<label>Gender</label>
		<c:if test =  "${update.gender == 0}">
			<input type="radio" name="genderU" value="Male" checked/> <label>Male</label>
			<input type="radio" name="genderU" value="Female"/> <label>Female</label><br>
		</c:if>
		<c:if test =  "${update.gender == 1}">
			<input type="radio" name="genderU" value="Male" /> <label>Male</label>
			<input type="radio" name="genderU" value="Female" checked/> <label>Female</label><br> 
		</c:if>
		<label>DOB</label>
		<input type="text" name="dobU" value="${update.dob}" placeholder="yyyy-mm-dd"/><br>
		<input type="submit" value="Update"/>
	</form>
</body>
</html>