<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"/>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>
    <h2>All Employees:</h2>
    <table class="table table-condensed table-striped">
        <tr class="table-dark">
            <th>Name</th>
            <th>Surname</th>
            <th>Department</th>
            <th>Salary</th>
            <th>Phone number</th>
            <th>E-mail</th>
            <th>City</th>
            <th>Operation</th>
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
            <td>
                <button type="button" data-id="${emp.id}" class="btn btn-info btn-sm" data-bs-toggle="modal" data-bs-target="#modal-add-employee">
                    <i class="fa fa-pencil"></i> Edit
                </button>
                <button type="button" class="btn btn-danger btn-sm">
                    <span class="fa fa-trash"></span> Delete
                </button>
            </td>
        </tr>
        </c:forEach>
    </table>
    <button id="btn-add" type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#modal-add-employee">Add</button>


    <!--Modal window -->
    <div class="modal fade" id="modal-add-employee" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog ">
            <div class="modal-content">
                <div class="modal-header">
                    <h4 class="modal-title mx-4">Add new employee: </h4>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body mx-4">
                    <form:form action="${pageContext.request.contextPath}/employees" method="post" modelAttribute="empObj">
                        <div class="row inputs">
                            <form:hidden path="id" id="id"/>
                            <div class="form-group mb-3">
                                <label for="name">Name:</label>
                                <form:input path="name" id="name" class="form-control" />
                            </div>
                            <div class="form-group mb-3">
                                <label for="surname">Surname:</label>
                                <form:input path="surname" id="surname" class="form-control" type="text" />
                            </div>
                            <div class="form-group mb-3">
                                <label for="department">Department:</label>
                                <form:select  id="department" class="form-control"  path="department.id">
                                    <form:options items="${departmentList}" itemValue="id" itemLabel="name"/>
                                </form:select>
                            </div>
                            <div class="form-group mb-3">
                                <label for="salary">Salary:</label>
                                <form:input path="salary" id="salary" class="form-control" type="number" />
                            </div>
                            <div class="form-group mb-3">
                                <label for="phoneNumber">Phone number: </label>
                                <form:input path="detail.phoneNumber" id="phoneNumber" class="form-control" type="text" />
                            </div>
                            <div class="form-group mb-3">
                                <label for="email">E-mail:</label>
                                <form:input path="detail.email" id="email" class="form-control" type="email" />
                            </div>
                            <div class="form-group mb-3">
                                <label for="city">City: </label>
                                <form:input path="detail.city" id="city" class="form-control" type="text" />
                            </div>
                        </div>
                        <div class="modal-footer">
                            <button type="reset" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                            <button type="submit" class="btn btn-primary">Save changes</button>
                        </div>
                    </form:form>
                </div>
            </div>
        </div>
    </div>


    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>
    <script src="<c:url value="/resources/js/script.js"/>"></script>
</body>
</html>
