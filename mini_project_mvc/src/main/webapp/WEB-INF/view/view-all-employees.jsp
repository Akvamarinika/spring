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

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"/>
    <script src="<c:url value="/resources/js/script.js"/>"></script>
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
                    <form class="custom-form" role="form">
                        <div class="row inputs">
                            <div class="form-group mb-3">
                                <label for="name">Name:</label>
                                <input id="name" class="form-control" />
                            </div>
                            <div class="form-group mb-3">
                                <label for="surname">Surname:</label>
                                <input id="surname" class="form-control" type="text" />
                            </div>
                            <div class="form-group mb-3">
                                <label for="department">Department:</label>
                                <select id="department" class="form-control">
                                    <option></option>
                                </select>
                            </div>
                            <div class="form-group mb-3">
                                <label for="salary">Salary:</label>
                                <input id="salary" class="form-control" type="number" />
                            </div>
                            <div class="form-group mb-3">
                                <label for="phone">Phone number: </label>
                                <input id="phone" class="form-control" type="text" />
                            </div>
                            <div class="form-group mb-3">
                                <label for="email">E-mail:</label>
                                <input id="email" class="form-control" type="email" />
                            </div>
                            <div class="form-group mb-3">
                                <label for="city">City: </label>
                                <input id="city" class="form-control" type="text" />
                            </div>
                        </div>
                    </form>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                    <button type="button" class="btn btn-primary">Save changes</button>
                </div>
            </div>
        </div>
    </div>
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>
</html>
