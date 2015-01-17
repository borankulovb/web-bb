<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<%--<form action="${pageContext.request.contextPath}/do/login" method="post">--%>

<%--Login: <input type="text" name="login" value="user"/>--%>
<%--Password: <input type="password" name="password" value="pass"/>--%>
<%--<button type="submit">Login</button>--%>
<%--</form>--%>

<%response.sendRedirect(request.getContextPath() + "/do/");%>
</body>
</html>
