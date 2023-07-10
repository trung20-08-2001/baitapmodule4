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
    <h2>Sandwich Condiments</h2>
    <form action="/save" method="get">
        <div class="form-check-inline">
            <label class="form-check-label">
                <input type="checkbox" class="form-check-input" name="condiment" value="Lettuce" >Lettuce
            </label>
        </div>
        <div class="form-check-inline">
            <label class="form-check-label">
                <input type="checkbox" class="form-check-input" name="condiment" value="Tomato">Tomato
            </label>
        </div>
        <div class="form-check-inline">
            <label class="form-check-label">
                <input type="checkbox" class="form-check-input" name="condiment" value="Mustard">Mustard
            </label>
        </div>
        <div class="form-check-inline">
            <label class="form-check-label">
                <input type="checkbox" class="form-check-input" name="condiment" value="Sprouts">Sprouts
            </label>
        </div>
        <button type="submit" class="btn btn-primary">Submit</button>
    </form>
</div>
<br><br>
<c:if test="${condiments!=null}">
    <h5>You have chosen: </h5>
    <c:forEach items="${condiments}" var="c">
        <p>${c}</p>
    </c:forEach>
</c:if>
</body>
</html>
