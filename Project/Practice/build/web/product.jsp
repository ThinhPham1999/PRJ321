<%-- 
    Document   : product
    Created on : Nov 7, 2019, 2:23:03 AM
    Author     : Thinh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Add Product</h1>
        
        <form action="AddProductController" method="post">
            <label>Product ID</label>
            <input type="text" name="productID"/><br>
            <label>Product Name</label>
            <input type="text" name="productName"/><br>
            <label>Product Unit</label>
            <input type="text" name="productUnit"/><br>
            <label>Product Price</label>
            <input type="text" name="productPrice"/><br>
            <input type="submit" value="Add new Product"/>
        </form>
        <a href="index.jsp"><button>Back</button></a><br>
        <jsp:include page="hitcount.jsp"></jsp:include>
    </body>
</html>
