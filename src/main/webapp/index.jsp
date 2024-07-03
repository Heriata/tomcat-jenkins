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
<button class="create" role="button" type="submit" onclick="window.location.href='create'">Add new User</button>
<table>
    <tr>
        <th>name</th>
        <th>surname</th>
        <th>age</th>
    </tr>
    <c:forEach var="u" items="${requestScope.users}">
        <tr>
            <td><a href="info?id=<c:out value='${u.id}' />">${u.name}}</td>
            <td><a href="info?id=<c:out value='${u.id}' />">${u.surname}}</td>
            <td><a href="info?id=<c:out value='${u.id}' />">{u.age}</td>
            <td>
                <form method="GET" action='<c:url value="/edit">' style="display:inline;">
                    <input type="hidden" name="id" value="${u.id}">
                    <input type="submit" value="Edit">
                </form
                <form method="POST" action='<c:url value="/delete"/>' style="display:inline;">
                    <input type="hidden" name="id" value="${u.id}">
                    <input type="submit" value="Delete">
                </form>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>