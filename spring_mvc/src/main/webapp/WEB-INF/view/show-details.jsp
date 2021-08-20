<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: rozes
  Date: 19.08.2021
  Time: 21:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Show details</title>
</head>
<body>
    <h2>Show details: </h2><br>
        <br><br>
            Name: ${empObj.name}
        <br><br>
            Surname:${empObj.surname}
        <br><br>
            Salary: ${empObj.salary}
        <br><br>
            Department: ${empObj.department}
        <br><br>
            Car brand: ${empObj.carBrand}
        <br><br>
            <ul>
                <c:forEach var="lang" items="${empObj.languages}">
                    <li>${lang}</li>
                </c:forEach>
            </ul>
        <br><br>
            Phone number: ${empObj.phoneNumber}
        <br><br>
            Email: ${empObj.email}

</body>
</html>
