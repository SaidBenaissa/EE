<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
    <jsp:useBean id="user" scope="request" type="oracle.academy.model.User"/>
</head>
<body>
<form action="/editUser" method="POST">
    <input type="hidden" name="id" value=<c:out value="${user.id}"/>>
    First name : <input type="text" name="firstname"
                        value=<c:out value="${user.firstName}"/>>
    Last name : <input type="text" name="lastname"
                       value=<c:out value="${user.lastName}"/>>
    Age : <input type="numbers" name="age"
                 value=<c:out value="${user.age}"/>>
    Role :
    <select name="role">
        <option value="USER">USER</option>
        <option value="ADMIN">ADMIN</option>
        <option value="SUPER_ADMIN">SUPER_ADMIN</option>
    </select>
    <input type="submit" value="Save">
</form>

</body>
</html>