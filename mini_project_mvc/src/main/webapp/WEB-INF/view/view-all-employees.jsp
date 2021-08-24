<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: rozes
  Date: 24.08.2021
  Time: 20:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"  %>
<html>
<head>
    <title>MVC mini-app</title>
</head>
<body>
    <h2>All Employees:</h2>
    <table>
        <tr>
            <th>Name</th>
            <th>Surname</th>
            <th>Department</th>
            <th>Salary</th>
            <th>Phone number</th>
            <th>E-mail</th>
            <th>City</th>
        </tr>
        <c:forEach var="emp" items="${empList}">
        <tr>
            <td>${emp.name}</td>
            <td>${emp.surname}</td>
            <td>${emp.department.name}</td>
            <td>${emp.salary}</td>
            <td>${emp.detail.phoneNumber}</td>
            <td>${emp.detail.email}</td>
            <td>${emp.detail.city}</td>
        </tr>
        </c:forEach>
    </table>
</body>
</html>
