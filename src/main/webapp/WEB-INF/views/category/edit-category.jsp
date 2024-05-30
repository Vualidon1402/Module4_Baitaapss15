<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 5/28/2024
  Time: 4:24 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">

</head>
<body>
<h1>Cập nhật sản phẩm</h1>
<a href="/category?action=LIST">Quay lại</a>
<form action="/category" method="post" >
    <div class="mb-3">
        <label for="id" class="form-label">Category ID</label>
        <input type="text" class="form-control" value="${category.categoryId}" id="id" name="id" readonly>
    </div>
    <div class="mb-3">
        <label for="name" class="form-label">Category Name</label>
        <input type="text" class="form-control" value="${category.categoryName}" id="name" name="name" placeholder="Category name...">
    </div>
    <div class="mb-3">
        <label for="status" class="form-label">Category status</label>
        <input type="text" class="form-control" value="${category.categoryStatus}" name="status" id="status">
    </div>

    <input type="submit" name="action" value="UPDATE" class="btn btn-primary"/>
</form>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>

</body>
</html>
