<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 5/28/2024
  Time: 2:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">

</head>
<body>
<nav class="navbar navbar-expand-lg bg-light">
    <div class="container-fluid">
        <a class="navbar-brand" href="#">Home</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="#">product</a>
                </li>
            </ul>
            <form class="d-flex" role="search" action="/product">
                <input class="form-control me-2" type="search" value="${keyword}" placeholder="Search" name="keyword" aria-label="Search">
                <input class="btn btn-outline-success"  type="submit" name="action" value="SEARCH">
            </form>
        </div>
    </div>
</nav>
<h1>Danh sách danh mục</h1>

<a href="/category?action=ADD">Thêm mới danh mục</a>
<table class="table">
    <thead>
    <tr>
        <th scope="col">#</th>
        <th scope="col">Name</th>
        <th scope="col">Status</th>
        <th scope="col" colspan="2">Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${categories}" var="category" varStatus="loop">
        <tr>
            <th scope="row">${loop.count}</th>
            <td>${category.categoryName}</td>
            <td>${category.categoryStatus}</td>
            <td><a href="/category?action=EDIT&id=${category.categoryId}" class="btn btn-warning">Edit</a></td>
            <td><a href="/category?action=DELETE&id=${category.categoryId}" class="btn btn-danger" onclick="return confirm('Bạn có chắc chắn muốn xoa ko')">Delete</a></td>
        </tr>
    </c:forEach>


    </tbody>
</table>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>

</body>
</html>
