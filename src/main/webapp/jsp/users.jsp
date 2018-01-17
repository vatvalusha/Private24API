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
    <html>
    <head>
        <meta charset="ISO-8859-1">
        <title>Insert title here</title>
    </head>
    <body align="center">
    <table>
        Valera : <%=eList%>
        <c:if test="${not empty eList}">
            <div>
                <form class="modal-content" action="controller">
                    <input type="hidden" name="command" value="delete"/>

                    <table border="1" cellpadding="5">
                        <caption><h2>Users</h2></caption>
                        <tr>
                            <th>Name</th>
                            <th>Password</th>
                            <th>Age</th>
                        </tr>
                        <c:forEach items="${eList}" var="item">
                            <tr>
                                <td><c:out value="${item.name}"/></td>

                                <td><c:out value="${item.password}"/></td>
                                <td><c:out value="${item.age}"/>
                                </td>
                                <td>
                                    <c:out value="${item._id.$oid}"/>
                                </td>
                                <td style="background-color:white; border:0">
                                    <button name="ids" value="${item._id.$oid}" type="submit">-</button>
                                </td>
                            </tr>
                        </c:forEach>
                    </table>
                    <input type=button value="Back" onCLick="history.back()">
                </form>
            </div>
        </c:if>
    </table>
    </body>
    </html>
