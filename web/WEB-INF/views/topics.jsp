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

<a href="/PostText/returnToPersonalPage/${sessionScope.current_Account_id}">home</a>
<c:if test="${empty requestScope.PostAndComment}">
    no Post yet
</c:if>

<c:if test="${!empty requestScope.PostAndComment}">
    <c:forEach items="${requestScope.PostAndComment}" var="map">
        <c:forEach items="${map}" var="pac">
            <p style="font-size:14px;">${pac.key.post_content} Post by
                <span style="font-style:italic;color:blue">${pac.key.post_by}</span>
            </p><br/>
            <c:forEach items="${pac.value}" var="comment">
                <p style="font-size:12px;">${comment.comment_content} commented by
                    <span style="font-style:italic;color:cornflowerblue">${comment.comment_by}</span>
                </p>
            </c:forEach>
            <form action="/Comment/makeNewComment" method="post">
                <input name="Post_id" type="hidden" value=${pac.key.post_id}>
                <input name="Comment_by" type="hidden" value=${sessionScope.current_Account_id}>
                <input name="Comment_content" type="text"/>
                <input type="submit" value="reply"/>
            </form>
        </c:forEach>
        <hr/>
    </c:forEach>
</c:if>


</body>
</html>
