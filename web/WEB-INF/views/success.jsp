<%--
  Created by IntelliJ IDEA.
  User: tianzhang
  Date: 3/4/18
  Time: 22:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<head>
    <title>show all stuff info</title>
</head>
<body>
<c:if test="${empty requestScope.user}">
    no user info
</c:if>

<c:if test="${!empty requestScope.user}">
    <table>
        <tr>
            <th>id</th>
            <th>name</th>

        </tr>

        <c:forEach items="${requestScope.user}" var="usr">
            <tr>
                <td>${usr.User_id}</td>
                <td>${usr.User_name}</td>

            </tr>
        </c:forEach>
    </table>
</c:if>
</body>
</html>
