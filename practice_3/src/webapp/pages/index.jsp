<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page isELIgnored="false" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
    <title>Панель управления пользователями</title>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-lg-11">
            <h1 class="page-header" align="center">Панель управления пользователями</h1>
        </div>
    </div>
    <div class="col-lg-11">
        <div class="panel panel-primary">
            <div class="panel-body">
                <c:if test="${requestScope.exception == true}">
                    <div class="alert alert-danger">
                        <c:forEach var="exceptionMessage" items="${requestScope.exceptionMessages}">
                            <p><strong>Warning! </strong>${exceptionMessage}</p>
                        </c:forEach>
                    </div>
                </c:if>
                <c:if test="${requestScope.info == true}">
                    <div class="alert alert-success">
                        <c:forEach var="infoMessage" items="${requestScope.infoMessages}">
                            <p><strong>Success! </strong>${infoMessage}</p>
                        </c:forEach>
                    </div>
                </c:if>
                <form style="display: inline" class="form-select-button" method="POST" action="/addUser">
                    <button type="submit" class="btn btn-default">Добавить</button>
                </form>
                <form style="display: inline" method="GET" action="/users">
                    <button type="submit" class="btn btn-info">Info</button>
                </form>

            </div>
        </div>
    </div>


    <div class="col-lg-11">
        <div class="panel panel-default">
            <div class="panel-heading">
                Список пользователей
            </div>
            <!-- /.panel-heading -->
            <div class="panel-body">
                <div class="table-responsive">
                    <table class="table table-hover">
                        <thead>
                        <tr>
                            <th>ID</th>
                            <th>First Name</th>
                            <th>Last Name</th>
                            <th>Age</th>
                            <th>Email</th>
                            <th>Role</th>
                            <th>Action</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="user" items="${users}">
                            <tr>
                                <td><c:out value="${user.id}"></c:out></td>
                                <td><c:out value="${user.firstName}"></c:out></td>
                                <td><c:out value="${user.lastName}"></c:out></td>
                                <td><c:out value="${user.age}"></c:out></td>
                                <td><c:out value="${user.email}"></c:out></td>
                                <td><c:out value="${user.role}"></c:out></td>
                                <td>
                                    <a href="/edit/<c:out value="${user.id}"></c:out>" class="btn btn-primary">Edit</a>
                                    <a href="/delete/<c:out value="${user.id}"></c:out>" class="btn btn-danger">Delete</a>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
                <!-- /.table-responsive -->
            </div>
            <!-- /.panel-body -->
        </div>
        <!-- /.panel -->
    </div>
</div>
</div>
</body>
</html>