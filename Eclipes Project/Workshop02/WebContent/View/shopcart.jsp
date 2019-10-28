<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Your Shopping Card</h1>
	<form action="ShopCartToDatabase" method="post">
		<s:select label="Customer" name="customer" list="customerList" listValue="name"/> <br>
		<label>Payment Method</label>
		<s:select label="Payment Method" name="payment" 
				list="#{'1':'Cash', '2':'Card'}" value="2"/>
		<table border="1">
			<tr>
				<th>Product</th>
				<th>Quantity</th>
				<th>Price</th>
			</tr>
			<s:iterator value="listProductCart">		
				<tr>
					<td><s:property value="value.product.name" /></td>
					<td><s:property value="value.quatity" /></td>
					<td><s:property value="value.product.price" /></td>					
				</tr>
			</s:iterator>
		</table>
		<label>Total: </label>
		<label><s:property value="total"/></label><br>
		<input type="submit" value="Confirm"/>
	</form>
</body>
</html>