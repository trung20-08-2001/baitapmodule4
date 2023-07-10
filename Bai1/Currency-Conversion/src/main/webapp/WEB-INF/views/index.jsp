<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Bootstrap Example</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
</head>
<body>

<div class="container">
    <h2>Convert</h2>
    <form action="/convert" method="get">
        <div class="form-group">
            <label for="email">USD:</label>
            <input type="number" class="form-control" id="email" placeholder="Enter usd" name="usd" pattern="[0-9]*" required>
        </div>
        <div class="form-group">
            <label>Rate:</label>
            <input type="number" class="form-control" placeholder="Enter rate" name="rate" pattern="[0-9]*" required >

        </div>
        <c:if test="${many!=null}">
            <div class="form-group">
                <label>VND:</label>
                <input type="number" class="form-control" placeholder="Result" value="${many}">
            </div>
        </c:if>
        <button type="submit" class="btn btn-primary">Submit</button>
    </form>
</div>

</body>
</html>
