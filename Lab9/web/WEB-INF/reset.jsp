<%-- 
    Document   : reset
    Created on : Apr. 10, 2022, 2:43:11 p.m.
    Author     : Scott
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <body>
        <h1>Notes App</h1>
        <h2>Reset Password</h2>
        <form action="forgot" method="post">
            <input type="hidden" name="uuid" value="${uuid}">
            New Password: <input type="text" name="password">
            <input type="submit" value="Submit">
        </form>
        <p>${message}</p>
    </body>
</html>
