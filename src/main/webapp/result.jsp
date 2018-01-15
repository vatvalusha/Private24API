<%@ page import="java.util.List" %>
<%@ page import="classes.Private" %><%--
  Created by IntelliJ IDEA.
  User: valeriyartemenko
  Date: 13.01.18
  Time: 00:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<anyxmlelement xmlns:c="http://java.sun.com/jsp/jstl/core">


        <% List<Private> eList = (List<Private>) request.getAttribute("collectionName");
    request.setAttribute("eList", eList);
%>

            <style>
                th{
                    background-color: #2BC430;
                }
                td{
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
        <c:if test="${not empty eList}">
            <div>
                <table border="1" cellpadding="5">
                    <caption><h2>Private24</h2></caption>
                    <tr>
                        <th>Currency</th>
                        <th>Base Currency</th>
                        <th>Bay</th>
                        <th>Sale</th>
                    </tr>
                    <c:forEach items="${eList}" var="item">
                        <tr>
                            <td><c:out value="${item.ccy}"/></td>
                            <td><c:out value="${item.baseCcy}"/></td>
                            <td><c:out value="${item.buy}"/></td>
                            <td><c:out value="${item.sale}"/></td>
                        </tr>
                    </c:forEach>
                </table>
                <input type=button value="Back" onCLick="history.back()">
            </div>
        </c:if>
    </table>
    </body>
    </html>
