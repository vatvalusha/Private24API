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

<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Insert title here</title>
</head>
<body>
<table>
    <%=eList.get(0)%>
    <%=eList.get(1)%>
    <%=eList.get(2)%>

    <c:if test="${not empty eList}">
        Inside If
        <c:forEach items="${eList}" var="item" >
            <tr>
                <td> Item<c:out value="${item.buy}" /></td>
                <td> Item<c:out value="${item}" /></td>
            </tr>
        </c:forEach>
    </c:if>

</table>
</body>
</html>
