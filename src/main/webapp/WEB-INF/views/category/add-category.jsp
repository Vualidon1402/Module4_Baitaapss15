<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 5/28/2024
  Time: 2:30 PM
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
<h1>Thêm mới danh mục</h1>
<a href="/category?action=LIST">Quay lại</a>
<form action="/category" method="post" >
    <div class="mb-3">
        <label for="name" class="form-label">Category Name</label>
        <input type="text" class="form-control" id="name" name="name" placeholder="category name">
    </div>
    <div class="mb-3">
        <label for="status" class="form-label">Category status</label>
        <input type="text" class="form-control" name="status" id="status" placeholder="category status">
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
