<%--
  Created by IntelliJ IDEA.
  User: tianzhang
  Date: 3/13/18
  Time: 18:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>

<body>
<c:if test="${empty requestScope.relation}">
    no accounts found!
</c:if>

<c:if test="${!empty requestScope.relation}">
    <table>
        <tr>
            <th>account_name</th>
            <th>account_email</th>
            <th>operation</th>
        </tr>

        <c:forEach items="${requestScope.relation}" var="re">
            <c:if test="${re.key.account_id != sessionScope.current_Account_id}">
                <tr>
                    <td>${re.key.account_name}</td>
                    <td>${re.key.account_email}</td>
                    <td>
                        <c:if test="${re.value == 0}">
                            <%-- not friend yet--%>
                            <form action="/Friend/fellow" method="post">
                                <input type="hidden" name="Fans_id" value=${sessionScope.current_Account_id}>
                                <input type="hidden" name="Master_id" value=${re.key.account_id}>
                                <input type="submit" value="add"/>
                            </form>
                        </c:if>

                        <c:if test="${re.value == 1}">
                            friend already
                        </c:if>
                    </td>
                </tr>
            </c:if>
        </c:forEach>
    </table>
</c:if>
</body>
</html>
