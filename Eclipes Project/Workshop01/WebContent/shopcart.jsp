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
	<h1>Your Shopping Card</h1>
	<form action="ShoppingCardController" method="post">
		<label>Customer</label>
		<select name="customer">
    		<c:forEach items="${listCustomer}" var="customer">
        		<option value="${customer.name}">${customer.name}</option>
    		</c:forEach>
		</select><br>
		<label>Payment Method</label>
		<select name="pay">
			<option value="Cash">Cash</option>
			<option value="Card">Card</option>
		</select><br>
		<table border="1">
			<tr>
				<th>Product</th>
				<th>Quantity</th>
				<th>Price</th>
			</tr>
			<c:forEach items="${listCard}" var="card">		
				<tr>
					<td>${card.value.product.name}</td>
					<td>${card.value.quatity}</td>
					<td>${card.value.product.price}</td>					
				</tr>
			</c:forEach>
		</table>
		<label>Total: </label>
		<label><%=request.getSession().getAttribute("total")%></label><br>
		<input type="submit" value="Confirm"/>
	</form>
</body>
</html>