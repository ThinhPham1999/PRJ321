<%-- 
    Document   : addFailed
    Created on : Nov 7, 2019, 3:02:13 AM
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
        <h1>${message}</h1>
        <jsp:include page="product.jsp"></jsp:include>
        <jsp:include page="hitcount.jsp"></jsp:include>
    </body>
</html>
