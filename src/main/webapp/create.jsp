<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Add User</title>
</head>
<body>
<h1>Add User</h1>
<form action="/users/add" method="post">
    <label for="name">Name:</label>
    <input type="text" name="name" required><br><br>
    <label for="surname">Surname:</label>
    <input type="text" name="surname" required><br><br>
    <label for="surname">Age:</label>
    <input type="text" name="age" required><br><br>
    <input type="submit" value="Add User">
</form>
</body>
</html>