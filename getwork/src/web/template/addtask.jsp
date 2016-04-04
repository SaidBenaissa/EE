<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Oleg
  Date: 21.03.2016
  Time: 21:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Task</title>
    <!-- Bootstrap Core CSS -->
    <link href="<c:url value="/resources/css/bootstrap.css"/>" rel="stylesheet">
    <script src="//code.jquery.com/jquery-1.10.2.min.js"></script>
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">
    <!-- Custom CSS -->
    <link href="<c:url value="/resources/css/heroic-features.css"/>" rel="stylesheet">
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>

<div class="col-lg-12">
    <div class="panel panel-default">

        <div class="panel-body">
            <div class="row">
                <div class="col-lg-3"></div>
                <div class="col-lg-6">
                    <div class="panel-heading">
                        <h3 class="page-header">Добавление нового задания</h3>
                    </div>
                    <form:form action="/task/save" commandName="taskForm" method="POST">
                        <div class="form-group">
                            <label>Название проекта</label>
                            <form:input path="title" class="form-control"
                                        placeholder="Кого вы ищете и какую работу нужно выполнить" type="text"/>
                            <form:errors path="title" cssStyle="color: red"/>
                        </div>
                        <div class="form-group">
                            <label>Подробно опишите задание</label>
                            <form:textarea path="description" class="form-control text-area" style="min-height: 200px"
                                           placeholder="Укажите требования к исполнителю и результату, сроки выполнения и другие условия работы"/>
                            <form:errors path="description" cssStyle="color: red"/>
                        </div>
                        <div class="form-group">
                            <label>Специализация проекта</label>
                            <form:select id="categories" class="form-control" path="categoryId">
                                <option value="-1">Выберите категорию</option>
                            </form:select>
                            <form:errors path="categoryId" cssStyle="color: red"/>

                        </div>
                        <label>Бюджет</label>
                        <div class="form-group input-group">
                            <span class="input-group-addon"><i class="fa fa-money"></i></span>
                            <form:input path="price" type="number" class="form-control"
                                        placeholder="Укажите сумму оплаты"/>
                            <form:errors path="price" cssStyle="color: red"/>
                        </div>
                        <button type="submit" class="btn btn-primary btn-lg">Опубликовать проект</button>
                    </form:form>

                </div>
                <div class="col-lg-3"></div>
            </div>
            <!-- /.row (nested) -->
        </div>
        <!-- /.panel-body -->
    </div>
    <!-- /.panel -->
</div>
<script type="text/javascript">

    $(document).ready(function () {
        $.getJSON('/api/categories/all', function (data) {
            $.each(data, function (key) {
                $('#categories').append('<option value="' + data[key].id + '">' + data[key].categoryName + '</option>');
            })
        });
    });
</script>
</body>
</html>
