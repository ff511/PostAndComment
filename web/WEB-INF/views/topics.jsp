<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: tianzhang
  Date: 3/13/18
  Time: 20:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <c:if test="${empty requestScope.allPosts}">
        no Post yet
    </c:if>

<c:if test="${!empty requestScope.allPosts}">
    <c:forEach items="${requestScope.allPosts}" var="post">
        <p>${post.post_content} Post by || ${post.post_by}</p><br/>
        <a href=""> reply </a>
    </c:forEach>
</c:if>
</body>
</html>
