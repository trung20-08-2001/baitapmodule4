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
    <h2>CALCULATOR SIMP</h2>
    <form action="/calculator">
        <div class="form-group">
            <label>Fist number:</label>
            <input type="number" name="fistNumber" class="form-control" placeholder="Enter number" required >
        </div>
        <div class="form-check">
            <label class="form-check-label" for="radio1">
                <input type="radio" class="form-check-input" id="radio1" name="operator" value="+" checked>+
            </label>
        </div>
        <div class="form-check">
            <label class="form-check-label" for="radio2">
                <input type="radio" class="form-check-input" id="radio2" name="operator" value="-">-
            </label>
        </div>
        <div class="form-check">
            <label class="form-check-label" for="radio3">
                <input type="radio" class="form-check-input" id="radio3" name="operator" value="*">*
            </label>
        </div>
        <div class="form-check">
            <label class="form-check-label" for="radio4">
                <input type="radio" class="form-check-input" id="radio4" name="operator" value="/">/
            </label>
        </div><br>
        <div class="form-group">
            <label >Second number</label>
            <input type="number" name="secondNumber" class="form-control" placeholder="Enter number" required >
        </div>
        <button type="submit" class="btn btn-primary">Submit</button>
    </form>
    <br><br>
    <c:if test="${result!=null}">
        <span>${result}</span>
    </c:if>
</div>

</body>
</html>
