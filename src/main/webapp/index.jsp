<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" %>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Main page</title>
    <link href="index.css">
</head>
<body>
<a href="${pageContext.request.contextPath}/users">List users</a>
<a href="users/add">Add user</a>
</body>
</html>