<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Login</title>
    <!-- Bootstrap Core CSS -->
    <link href="<c:url value="/resources/css/bootstrap.css"/>" rel="stylesheet">
    <link href="<c:url value="/resources/css/login.css"/>" rel="stylesheet">

</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-lg-4 col-sm-6 col-md-4 col-md-offset-4 ">
            <div class="account-wall">
                <h3 align="center">Create new account</h3>
                <form:form action="/register" cssClass="form-signin" commandName="userForm" method="POST">
                <div>
                    <form:input path="username" cssClass="form-control" placeholder="Username" type = "text"/>
                    <form:errors path="username" cssClass="error"/>

                    <form:input path="email" cssClass="form-control" placeholder="Email" type = "text"/>
                    <form:errors path="email" cssClass="error"/>

                    <form:input path="password" cssClass="form-control" placeholder="Password" type="password"/>
                    <form:errors path="password" cssClass="error"/>

                    <form:input path="password2" cssClass="form-control" placeholder="Repeat password" type="password"/>
                    <form:errors path="password2" cssClass="error"/>

                    <button class="btn btn-lg btn-primary btn-block" type="submit">
                        Register
                    </button>
                    </form:form>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>