<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="d" uri="/WEB-INF/tlds/display"%>
<jsp:useBean id="counter" class="Controller.CountFilter" scope="application"></jsp:useBean>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <d:Display></d:Display>
        <p>Hit count: <p>${hit}
    </body>
</html>
