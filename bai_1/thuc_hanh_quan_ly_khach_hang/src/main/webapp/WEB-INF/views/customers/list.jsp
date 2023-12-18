<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 12/18/2023
  Time: 10:24 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table style="border: 1px;width: 100%   ">
    <tr>
        <td>STT</td>
        <td>Ten</td>
        <td>Email</td>
        <td>Dia Chi</td>
    </tr>
    <c:forEach items="${customerList}" var="list" varStatus="loop">
        <tr>
            <td>${loop.count}</td>
            <td><a>${list.name}</a></td>
            <td>${list.email}</td>
            <td>${list.address}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
