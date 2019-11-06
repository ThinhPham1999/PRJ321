<%-- 
    Document   : index
    Created on : Nov 7, 2019, 1:36:12 AM
    Author     : Thinh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<jsp:useBean id="list" class="dao.ProductDAO" scope="page"></jsp:useBean>

    <!DOCTYPE html>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <title>JSP Page</title>
        </head>
        <body>
            <h1>All product</h1>
            <table border="1">
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Unit</th>
                    <th>Price</th>
                </tr>
            <c:forEach items="${list.listAll()}" var="product">
                <tr>
                    <td>${product.productID}</td>
                    <td>${product.productName}</td>
                    <td>${product.productUnit}</td>
                    <td>${product.productPrice}</td>
                </tr>
            </c:forEach>	
        </table>
        <br>
        <br>
        <a href="product.jsp"><button>Add new product</button></a><br>
        <jsp:include page="hitcount.jsp"></jsp:include>
</body>
</html>
