<%--
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
--%>
<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" %>

<html>
    <head>
        <title>${requestScope.user.name}</title>
        <link />
    </head>
    <body>
        <h2>information</h2>
        <table>
            <tr>
                <th>id</th>
                <th>name</th>
                <th>surname</th>
                <th>age</th>
            </tr>
            <tr>
                <td>${requestScope.user.id}</td>
                <td>${requestScope.user.name}</td>
                <td>${requestScope.user.surname}</td>
                <td>${requestScope.user.age}</td>
            </tr>
        </table>

        <button role="button" type="submit" onclick="window.location.href='index'">Main page</button>
    </body>
</html>