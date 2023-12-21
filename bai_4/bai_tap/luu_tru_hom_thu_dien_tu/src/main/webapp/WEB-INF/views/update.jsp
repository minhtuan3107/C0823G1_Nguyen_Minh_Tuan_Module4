<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: macbook
  Date: 11/16/23
  Time: 11:45 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">

</head>
<body>
<table class="table tab-container">
    <tr>
        <td>Languages</td>
        <td>${mailBox.languages}</td>
    </tr>
    <tr>
        <td>Page Size</td>
        <td>${mailBox.pageSize}</td>
    </tr>
    <tr>
        <td>Spam</td>
        <c:if test="${mailBox.spam == true}">
            <td>OK</td>
        </c:if>
        <c:if test="${mailBox.spam == false}">
            <td>NO</td>
        </c:if>
    </tr>
    <tr>
        <td>signature</td>
        <td>${mailBox.signature}</td>
    </tr>
</table>
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
        crossorigin="anonymous"></script>
</html>
