<%--
  Created by IntelliJ IDEA.
  User: new
  Date: 16.01.2018
  Time: 12:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head><title>Welcome</title></head>
<in>
    <h3>Welcome</h3>
    <hr/>
    ${user}, hello!
    <hr/>
    <body>
    <form name="loginForm" method="POST" action="controller">
        <a href="controller?command=logout">Logout</a>
        <input type="hidden" name="command" value="users"/>
        <input type="submit" value="Show Users"/>
    </form>
    <%--<a href="controller?command=users">List Users</a>--%>
    </body>
</html>
