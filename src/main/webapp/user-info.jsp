<%@ page import="com.softserve.ita.model.User" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User Info</title>
</head>
<body>

    <%
        User user = (User) request.getAttribute("theUser");
        out.print(user);
    %>

</body>
</html>
