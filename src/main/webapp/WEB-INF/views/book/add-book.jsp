<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 5/29/2024
  Time: 10:19 AM
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
<h1>Thêm mới Sách</h1>
<a href="/book?action=LIST">Quay lại</a>
<form action="/book" method="post" >
    <div class="mb-3">
        <label for="name" class="form-label">Name</label>
        <input type="text" class="form-control" id="name" name="name" placeholder="book name">
    </div>
    <div class="mb-3">
        <label for="categoryId" class="form-label">categoryId</label>
        <input type="text" class="form-control" id="categoryId" name="categoryId" placeholder="categoryId">
    </div>
    <div class="mb-3">
        <label for="price" class="form-label">Price</label>
        <input type="text" class="form-control" name="price" id="price" placeholder="price">
    </div>
    <div class="mb-3">
        <label for="stock" class="form-label">Stock</label>
        <input type="text" class="form-control" name="stock" id="stock" placeholder="stock">
    </div><div class="mb-3">
    <label for="totalPages" class="form-label">Total Pages</label>
    <input type="text" class="form-control" name="totalPages" id="totalPages" placeholder="total Pages">
</div><div class="mb-3">
    <label for="yearCreated" class="form-label">Year Created</label>
    <input type="date" class="form-control" name="yearCreated" id="yearCreated" placeholder="Year Created">
</div><div class="mb-3">
    <label for="author" class="form-label">Author</label>
    <input type="text" class="form-control" name="author" id="author" placeholder="author">
</div><div class="mb-3">
    <label for="status" class="form-label">Status</label>
    <input type="text" class="form-control" name="status" id="status" placeholder="status">
</div>

    <input type="submit" name="action" value="ADD" class="btn btn-primary"/>
</form>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
<%--<script>--%>
<%--    let inputImg = document.getElementById("image");--%>
<%--    let imgPreview = document.getElementById("preview")--%>
<%--    inputImg.onchange = ()=>{--%>
<%--        // destructoring--%>
<%--        const [file] = inputImg.files;--%>
<%--        if (file){--%>
<%--            imgPreview.src = URL.createObjectURL(file);--%>
<%--        }--%>
<%--    }--%>
<%--</script>--%>
</body>
</html>
