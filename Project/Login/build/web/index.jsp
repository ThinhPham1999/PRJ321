<%@page contentType="text/html" pageEncoding="utf-8" %>
<%@ include file="/includes/header.jsp" %>
<%@ include file="/includes/column_left_home.jsp" %>


<!-- start the middle column -->

<section>
    <form name="input" action="Login" method="POST">
        <h2>Login</h2>
        <label>Username</label>
        <input type="text" name="username" /><br>
        <label>Password</label>
        <input type="password" name="pass" /><br>
        <input type="submit" value="Login"/>
    </form>
    
    
</section>


<!-- end the middle column -->

<%@ include file="/includes/column_right_news.jsp" %>
<%@ include file="/includes/footer.jsp" %>
