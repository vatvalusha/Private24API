<%--
  Created by IntelliJ IDEA.
  User: valeriyartemenko
  Date: 15.01.18
  Time: 22:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head><title>Login</title></head>
<body>
<form name="loginForm" method="POST" action="Controller">
    <input type="hidden" name="command" value="login"/>
    Login:<br/>
    <input type="text" name="login" value=""/>
    <br/>Password:<br/>
    <input type="password" name="password" value=""/>
    <br/>
    <%--${errorLoginPassMessage}--%>
    <br/>
    <%--${wrongAction}--%>
    <br/>
    <%--${nullPage}--%>
    <br/>
    <input type="submit" value="Log in"/>
</form>
<hr/>
</body>
</html>
