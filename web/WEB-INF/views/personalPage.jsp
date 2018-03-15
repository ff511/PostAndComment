<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: tianzhang
  Date: 3/9/18
  Time: 17:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        * {
            font-family: Monaco;
        }
    </style>
</head>
<body>
<div style="float:left;">
    <a href="/Account/editAccountInfo">edit</a>
    Hello, ${requestScope.name}
    <br/>
    <br/>
    <br/>

    <div>
        <form action="/PostText/initNewTopic" method="post" style="margin: 0 auto;">
            <input type="hidden" name="Post_by" value=${sessionScope.current_Account_id}>
            <textarea type="text" name="Post_content" style="width:650px; height:250px"></textarea>
            <input type="submit" value="post"/>
        </form>
    </div>

    <br/>
    Following List: <br/>
    <div style="float: left;">
        <c:if test="${empty requestScope.friends}">
            none
        </c:if>

        <c:if test="${!empty requestScope.friends}">
            <table>

                <c:forEach items="${requestScope.friends}" var="fri">
                    <tr>
                        <td><a href="/Friend/friendSeePage/${fri.account_id}">${fri.account_name}</a></td>
                        <td>
                            <form action="/Friend/delete" method="post">
                                <input name="_method" value="DELETE" type="hidden"/>
                                <input name="Master_id" type="hidden" value=${fri.account_id}>
                                <input name="Fans_id" type="hidden" value=${sessionScope.current_Account_id}>
                                <input type="submit" value="delete"/>
                            </form>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </c:if>
    </div>
    <br/>
    <br/>
    + friends<br/>
    <form action="/Account/searchAccounts" method="post">
        <input type="text" name="Search_pattern"/>
        <input type="hidden" name="Fans_id" value=${requestScope.id}>
        <input type="submit" value="search"/>
    </form>
</div>

<div id="Post_Show_Part" style="float:right;">
    <a href="/PostText/showAllTopics/${sessionScope.current_Account_id}">
        all related posts
    </a>
</div>
</body>
</html>
