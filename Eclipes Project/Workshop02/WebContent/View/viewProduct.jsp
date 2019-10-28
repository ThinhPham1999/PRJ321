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
<% %>
    <h1>All product</h1>
		<table border="1">
			<tr>
				<th>ID</th>
				<th>Name</th>
				<th>Price</th>
				<th>Action</th>
			</tr>
			<s:iterator value="productList">
				<tr>
					<td><s:property value="ID" /></td>
					<td><s:property value="name" /></td>
					<td><s:property value="price" /></td>
					<td>
						<s:url id="add" action="addShopCart">
							<s:param name="id" value="%{ID}"></s:param>
						</s:url>
						<s:a href="%{add}">
							<input type="submit" value="Buy"/>
						</s:a>
					</td>
				</tr>
			</s:iterator>	
		</table>
		<br>
		<br>
	<form action="viewShopCart" method="post">
		<input type="submit" value="View Shopping Card">
	</form>
</body>
</html>