<%--
  Created by IntelliJ IDEA.
  User: tianzhang
  Date: 3/11/18
  Time: 20:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/Account/editAccountInfo" method="post">
    email: <input name="Account_id" readonly value=${sessionScope.current_Account}>
    <br/>
    password: <input name="Account_password" type="password"/><br/>
    address:<input name="Account_address" type="text"/> <br/>
    FullName: <input name="Account_name" type="text"/><br/>
    <input type="submit" value="submit">
</form>
</body>
</html>
