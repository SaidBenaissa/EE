<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
</head>
<body>
<form action="/hello" method="POST">
    First name : <input type="text" name="firstname">
    Last name : <input type="text" name="lastname">
    Age : <input type="numbers" name="age">
    Role :
    <select name="role">
        <option value="USER">USER</option>
        <option value="ADMIN">ADMIN</option>
        <option value="SUPER_ADMIN">SUPER_ADMIN</option>
    </select>
    <input type="submit" value="Add">
</form>

</body>
</html>