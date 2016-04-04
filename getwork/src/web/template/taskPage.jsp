<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Home
  Date: 28.03.2016
  Time: 21:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="<c:url value="/resources/css/bootstrap.css"/>" rel="stylesheet">
    <script src="//code.jquery.com/jquery-1.10.2.min.js"></script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/handlebars.js/4.0.5/handlebars.js"></script>
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">
</head>
<body>
<div class="container">
    <div class="navbar">
        <jsp:include page="header.jsp"></jsp:include>
    </div>
    <div class="col-md-2">
    </div>
    <div class="col-md-8">
        <h3 class="panel-heading">Подробное описание проекта</h3>
        <div class="result panel panel-body">
            <div id="loading" style="display: none; text-align: -webkit-center;">
                <i class="fa fa-spinner fa-spin fa-4x" style="color: lightgray"></i>
            </div>
            <div class="panel-body" id="updates" style="background-color: #f5f5f5">
                <script id="task-details" type="text/x-handlebars-template">
                    <table>
                        <tbody>
                        <tr>
                            <td></td>
                            <td><h4>{{this.title}}</h4></td>
                        </tr>
                        <tr>
                            <td><h4>Описание:</h4></td>
                            <td>{{this.description}}</td>
                        </tr>
                        <tr>
                            <td><h4>Оплата:</h4></td>
                            <td><h4>$ {{this.price}}</h4></td>
                        </tr>
                        </tbody>
                    </table>
                    <div>
                        <form action="/task/apply" method="POST">
                            <input name="id" value={{this.id}} type="hidden">
                            <input type="submit" value="Подать заявку">
                        </form>
                    </div>
                </script>
            </div>
            <!-- /.panel-body -->
        </div>
        <div class="panel">
            <h3 class="panel-heading">Заявки на проект</h3>

            <div class="panel-body" id="bids" style="background-color: #f5f5f5">
                <div id="loading2" style="display: none; text-align: -webkit-center;">
                    <i class="fa fa-spinner fa-spin fa-4x" style="color: lightgray"></i>
                </div>

                <script id="bids-details" type="text/x-handlebars-template">
                    <table>
                        <tbody>
                        {{#each this}}
                        <tr>
                            <td><h4>{{this.username}}</h4></td>
                        </tr>
                        {{/each}}
                        </tbody>
                    </table>
                </script>
            </div>
        </div>
    </div>
    <div class="col-md-2">

    </div>

</div>
</div>
<script type="text/javascript">
    $(document).ready(function () {
        var api_url = "/api/tasks/task/" + ${id};
        var api_bids_url = "/api/users/bids/task/" + ${id};
        var template = Handlebars.compile($('#task-details').html());
        var template2 = Handlebars.compile($('#bids-details').html());

        $.ajax({
            url: api_url,
            dataType: "json",
            before: $('#loading').show(),
            success: function (data) {
                $('#updates').append(template(data));
                $("#loading").hide()
            }
        });
        $.ajax({
            url: api_bids_url,
            dataType: "json",
            before: $('#loading2').show(),
            success: function (data) {
                $('#bids').append(template2(data));
                console.log(data)
                $("#loading2").hide()
            }
        });
    });
</script>
</body>
</html>
