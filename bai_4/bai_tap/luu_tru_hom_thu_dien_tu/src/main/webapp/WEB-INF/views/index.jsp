<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 12/21/2023
  Time: 10:57 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <title>Title</title>
</head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
<body>
<h1>SETTINGS</h1>
<%--@elvariable id="mailBox" type=""--%>
<table class="table tab-container">
    <form:form method="post" action="/addMailBox" modelAttribute="mailBox">
        <tr>
            <td>
                Name:
            </td>
            <td>
                <form:select path="languages" items="${languagesArray}"/>
            </td>
        </tr>
        <tr>
            <td>Page Size</td>
            <td>show <form:select path="pageSize" items="${pageSizeArray}"/> emails per page</td>
        </tr>
        <tr>
            <td>Spams fillter:</td>
            <td><form:checkbox path="spam"/> Enable spams fillter
            </td>
        </tr>
        <tr>
            <td>
                Signature
            </td>
            <td>
                <form:input path="signature"/>
            </td>
        </tr>
        <tr>
            <td>
                <button class="btn btn-info">Update</button>
            </td>
            <td></td>
        </tr>
    </form:form>
</table>
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
        crossorigin="anonymous"></script>
</html>
