<%@ page import="java.util.List" %>
<%@ page import="classes.entity.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: valeriyartemenko
  Date: 13.01.18
  Time: 00:00
  To change this template use File | Settings | File Templates.
--%>

<anyxmlelement xmlns:c="http://java.sun.com/jsp/jstl/core">


        <% List<User> eList = (List<User>) request.getAttribute("users");
        request.setAttribute("eList", eList);
%>

    <style>
        th {
            background-color: #2BC430;
        }

        td {
            background-color: #149DC7;
        }
    </style>
    <script src="/js/users.js"></script>
    <html>
    <head>
        <meta charset="ISO-8859-1">
        <title>Insert title here</title>
    </head>
    <body align="center">
    Valera : <%=eList%>
    <c:if test="${not empty eList}">
        <div>
            <form class="modal-content" action="controller">
                <input type="hidden" name="command" value="delete"/>
                <%--<table border="1" cellpadding="5">--%>
                <caption><h2>Users</h2></caption>
                <div style="width: 100%; padding-top: 5px;">
                    <output style="display: inline-block;">Name</output>
                    <output style="display: inline-block;">Password</output>
                    <output style="display: inline-block;">Age</output>
                </div>
                <fieldset style="background-color:white; border:0" id="2" disabled>
                    <c:forEach items="${eList}" var="item">
                        <div style="width: 100%; padding-top: 5px;">
                            <input name="name${item._id.$oid}" style="display: inline-block;" type="text"
                                   value="${item.name}"/>
                            <input name="password${item._id.$oid}" style="display: inline-block;" type="text"
                                   value="${item.password}"/></td>
                            <input name="age${item._id.$oid}" style="display: inline-block;" type="text"
                                   value="${item.age}"/>
                            <button name="ids" value="${item._id.$oid}" type="submit">-</button>
                        </div>
                    </c:forEach>
                </fieldset>

            </form>
            <form class="modal-content" action="controller">
                <input type="hidden" name="command" value="update"/>
                <div>
                    <div id="id1" style="display:inline-block">
                        <button name="updateUser" style="padding-right: 5px;"
                                value="${item._id.$oid}"
                                onclick="disableInput(2)" type="button">Update
                        </button>
                    </div>

                    <div id="id2" style="display: none">
                        <button name="updateUser" style="padding-right: 5px;"
                                value="${item._id.$oid}"
                        <%--onclick="disableInput(2)" --%>
                                display="none" type="submit">Confirm Update
                        </button>
                    </div>
                    <div style="display: inline-block">
                        <input type=button value="Back" onCLick="history.back()">
                    </div>
                </div>
            </form>
            <%--########################################################################--%>
        </div>
    </c:if>
    </body>
    </html>
