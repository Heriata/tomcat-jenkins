<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" %>

<html>
<head>
    <title>edit</title>
    <link />
</head>
<body>
<h2>edit user</h2>

<form method="post">
    <input type="hidden" value="${requestScope.user.id}" name="id"/>
    <label>name</label>
    <label>
        <input value="${requestScope.user.name}" name="name"/>
    </label>
    <label>
        <input value="${requestScope.user.surname}" name="surname"/>
    </label>
    <label>
        <input value="${requestScope.user.age}" name="age"/>
    </label>
    <input type="submit" value="save">
</form>
</body>
</html>