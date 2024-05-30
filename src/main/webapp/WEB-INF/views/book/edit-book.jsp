<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 5/29/2024
  Time: 5:10 PM
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
<h1>Cập nhật Sách</h1>
<a href="/book?action=LIST">Quay lại</a>
<form action="/book" method="post" >
    <div class="mb-3">
        <label for="id" class="form-label">Book ID</label>
        <input type="text" class="form-control" value="${book.bookId}" id="id" name="id" readonly>
    </div>
    <div class="mb-3">
        <label for="categoryId" class="form-label">Category ID</label>
        <input type="text" class="form-control" value="${book.categoryId}" id="categoryId" name="categoryId" placeholder="category id">
    </div>
    <div class="mb-3">
        <label for="name" class="form-label">Book Name</label>
        <input type="text" class="form-control" value="${book.bookName}" id="name" name="name" placeholder="Book name...">
    </div>
    <div class="mb-3">
        <label for="price" class="form-label">Price</label>
        <input type="text" class="form-control" value="${book.bookPrice}" name="price" id="price">
    </div>
    <div class="mb-3">
        <label for="stock" class="form-label">Stock</label>
        <input type="text" class="form-control" value="${book.stock}" name="stock" id="stock">
    </div>
    <div class="mb-3">
        <label for="totalPages" class="form-label">Total Pages</label>
        <input type="text" class="form-control" value="${book.totalPages}" name="totalPages" id="totalPages">
    </div>
    <div class="mb-3">
        <label for="yearCreated" class="form-label">Year Created</label>
        <input type="text" class="form-control" value="${book.yearCreated}" name="yearCreated" id="yearCreated">
    </div>
    <div class="mb-3">
        <label for="author" class="form-label">Author</label>
        <input type="text" class="form-control" value="${book.author}" name="author" id="author">
    </div>
    <div class="mb-3">
        <label for="bookStatus" class="form-label">Book Status</label>
        <input type="text" class="form-control" value="${book.bookStatus}" name="bookStatus" id="bookStatus">
    </div>

    <input type="submit" name="action" value="UPDATE" class="btn btn-primary"/>
</form>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>

</body>
</html>
