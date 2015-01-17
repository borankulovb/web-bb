<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
LOgin page:

<form action="${pageContext.request.contextPath}/do/login" method="post">
    <input name="command" type="hidden" value="${login}"/>

    Login: <input type="text" name="login" value="user"/>
    Password: <input type="password" name="password" value="pass"/>
    <button type="submit">Login</button>
</form>
</body>
</html>
