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
    <h1>All product</h1>
		<table border="1">
			<tr>
				<th>ID</th>
				<th>Name</th>
				<th>Price</th>
				<th>Action</th>
			</tr>
			<c:forEach items="${listProduct}" var="product">
				<tr>
					<td>${product.ID}</td>
					<td>${product.name}</td>
					<td>${product.price}</td>
					<td><a href="ProductController?id=${product.ID}">
					<input type="submit" value="Buy"/></a></td>
				</tr>
			</c:forEach>	
		</table>
		<br>
		<br>
	<form action="ProductController" method="post">
		<input type="submit" value="View Shopping Card">
	</form>
</body>
</html>