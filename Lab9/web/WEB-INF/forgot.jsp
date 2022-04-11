<%-- 
    Document   : forgot
    Created on : Apr. 10, 2022, 11:47:26 a.m.
    Author     : Scott
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <body>
        <h1>Notes App</h1>
        <h2>Forgot Password?</h2>
        <form action="forgot" method="post">
            email: <input type="text" name="email">
            <input type="submit" value="Submit">
        </form>
        <p>${message}</p>
        <a href="login">Back to Login</a>
    </body>
</html>
