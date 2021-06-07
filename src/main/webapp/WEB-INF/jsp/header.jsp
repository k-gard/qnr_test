<%--<!DOCTYPE html>--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%--<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>--%>
<%--<%--%>
<%--    String baseURL = request.getServerName() + ":" + request.getServerPort();--%>
<%--%>--%>
<%--<html>--%>
<%--<head>--%>

<%--    <title>${title}</title>--%>
<%--    <link href="<c:url value="/src/main/resources/static/css/common.css"/>" rel="stylesheet" type="text/css">--%>
<%--</head>--%>



<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
<head>
    <title>${title}</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <%    String baseURL = request.getServerName();%>

</head>
<body>



<nav class="navbar navbar-expand-sm bg-dark navbar-dark ">

    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="collapsibleNavbar">
        <ul class="nav navbar-nav navbar-center mx-auto">
            <li class="nav-item">
                <a class="nav-link" href="http://<%= baseURL %>/locations/">Locations</a>
            </li>
            <li class="nav-item">
                <a class="nav-link mx-2" href="http://<%= baseURL %>/departments/">Departments</a>
            </li>
            <li class="nav-item">
                <a class="nav-link mx-2" href="http://<%= baseURL %>/employees/">Employees</a>
            </li>
        </ul>
    </div>
</nav>
