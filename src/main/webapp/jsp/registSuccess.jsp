<%--
  Created by IntelliJ IDEA.
  User: new
  Date: 17.01.2018
  Time: 12:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form class="modal-content" action="controller">
    <div class="container">
        <h1>REGISTRATION IS SUCCESSFUL</h1>
            ${user}, hello!
        <input type="hidden" name="command" value="main"/>
        <button type="submit" class="signupbtn" onclick="javascript:window.location=main.jsp" >
            <jsp:forward page="/jsp/main.jsp"/>
            Continue</button>
        </div>
    </div>
</form>
</body>
</html>
