<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: rozes
  Date: 19.08.2021
  Time: 21:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Form details</title>
</head>
<body>
    <h2>Write details: </h2><br>
    <form:form action="${pageContext.request.contextPath}/showDetails" method="get" modelAttribute="empObj">
        <label>
            Name: <form:input path="name" />
        </label><br>
        <label>
            Surname: <form:input path="surname" />
        </label><br>
        <label>
            Salary: <form:input path="salary" />
        </label><br>
        <form:select path="department">
            <form:options items="${empObj.departments}"  />
        </form:select>
        <br>
        <label>
            Car brand: <form:radiobuttons path="carBrand" items="${empObj.brands}"/>
        </label>
        <br>
        <label>
            Language(s): <form:checkboxes path="languages" items="${empObj.languageList}"/>
        </label>
        <br>

        <input type="submit" value="OK" />
    </form:form>
</body>
</html>
