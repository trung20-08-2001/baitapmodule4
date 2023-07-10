<%--
  Created by IntelliJ IDEA.
  User: trung
  Date: 7/9/2023
  Time: 1:57 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
</head>
<body>

<div class="container">
    <h2 style="text-align: center">Create Post</h2>
    <form action="/create" method="post" class="was-validated">
        <div class="form-group">
            <label for="uname">Title</label>
            <input type="text" class="form-control" id="uname" placeholder="Enter title" name="title" required>
            <div class="valid-feedback">Valid.</div>
            <div class="invalid-feedback">Please fill out this field.</div>
        </div>
        <div class="form-group">
            <label for="pwd">Image:</label>
            <input type="text" class="form-control" id="pwd"  placeholder="Enter img" name="image" required>
            <div class="valid-feedback">Valid.</div>
            <div class="invalid-feedback">Please fill out this field.</div>
        </div>
        <div class="form-group">
            <label >Content:</label>
            <textarea rows="10"  class="form-control"  placeholder="Enter content" name="content" required></textarea>
            <div class="valid-feedback">Valid.</div>
            <div class="invalid-feedback">Please fill out this field.</div>
        </div>
        <button type="submit" class="btn btn-primary">Submit</button>
    </form>
</div>


</body>
</html>
