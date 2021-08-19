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
    <form action="${pageContext.request.contextPath}/showDetails" method="get">
        <label>
            Name: <input type="text" placeholder="Please, write your name" name="yourName1">
        </label>
        <input type="submit" value="Submit" id="btn">
    </form>
</body>
</html>
