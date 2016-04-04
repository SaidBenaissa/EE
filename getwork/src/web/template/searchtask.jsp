<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Home
  Date: 25.03.2016
  Time: 20:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Search Task</title>
    <!-- Bootstrap Core CSS -->
    <link href="<c:url value="/resources/css/bootstrap.css"/>" rel="stylesheet">
    <script src="//code.jquery.com/jquery-1.10.2.min.js"></script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/handlebars.js/4.0.5/handlebars.js"></script>
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">
</head>
<body>

<!-- Navigation -->

<div class="container">
    <div class="navbar">
        <jsp:include page="header.jsp"></jsp:include>
    </div>
    <div class="panel-default">
        <div class="col-md-4 panel panel-default">
            <h3 class="panel-heading">Category</h3>
            <div class="panel-body">
                <ul id="categories" type="disc">
                </ul>
            </div>

        </div>
        <div class="col-md-8 panel panel-default">
            <h3 class="panel-heading">Search Results</h3>
            <div class="result panel panel-body">
                <div id="loading" style="display: none; text-align: -webkit-center;">
                    <i class="fa fa-spinner fa-spin fa-4x" style="color: lightgray"></i>
                </div>

                <div class="panel-body" id="updates">
                    <div class="table-responsive">
                        <script id="some-template" type="text/x-handlebars-template">
                            <table class="table table-hover" id="output">
                                <thead>
                                <tr>
                                    <th>#</th>
                                    <th>Название проекта</th>
                                    <th>Стоимость</th>
                                    <th>Действие</th>
                                </tr>
                                </thead>
                                <tbody>
                                {{#each this}}
                                <tr>
                                    <td>{{this.id}}</td>
                                    <td>{{this.title}}</td>
                                    <td>{{this.price}}</td>
                                    <td>
                                        <a href="/task/{{this.id}}" class="btn btn-default">Посмотреть</a>
                                    </td>
                                </tr>
                                {{/each}}
                                </tbody>
                            </table>
                        </script>
                    </div>
                    <!-- /.table-responsive -->
                </div>
                <!-- /.panel-body -->

            </div>
        </div>
    </div>
</div>
</div>

<script type="text/javascript">
    $(document).ready(function () {
        $.getJSON('/api/categories/all', function (data) {
            $.each(data, function (key, val) {
                $('#categories').append('<li><a href="javascript:test(' + val.id + ')">' + val.categoryName + '</a></li>');
            });
        });
    });
    function test(cat_id) {
        var api_url = "/api/tasks/category/" + cat_id;
        var template = Handlebars.compile($('#some-template').html());
        $("#output").remove();
        $.ajax({
            url: api_url,
            dataType: "json",
            before: $('#loading').show(),
            success: function (data) {
                $('#updates').append(template(data));
                console.log(data);
                $("#loading").hide()
            }
        });
    }
</script>
</body>
</html>

