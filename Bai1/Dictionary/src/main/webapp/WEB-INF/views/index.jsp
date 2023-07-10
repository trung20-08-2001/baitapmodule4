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
  <form action="/dictionary" method="get">
    <div class="form-group">
      <label for="email">Eng:</label>
      <input type="text" class="form-control" id="email" name="eng"  required>
    </div>
    <c:if test="${vn!=null}">
      <div class="form-group">
        <label>VN</label>
        <input type="text" class="form-control" placeholder="Result" value="${vn}">
      </div>
    </c:if>
    <button type="submit" class="btn btn-primary">Submit</button>
  </form>
</div>

</body>
</html>
