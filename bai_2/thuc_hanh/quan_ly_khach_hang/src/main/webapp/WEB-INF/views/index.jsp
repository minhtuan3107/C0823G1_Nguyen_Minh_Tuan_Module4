<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 12/19/2023
  Time: 2:23 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>QUẢN LÝ KHÁCH HÀNG</h1>
<table>
    <tr>
        <td>STT</td>
        <td>Tên</td>
        <td>Địa Chỉ</td>
    </tr>
    <c:forEach items="${list}" varStatus="loop" var="customer">
        <tr>
            <td>${loop.count}</td>
            <td>
                <a href="info?id=${customer.id}">${customer.name}</a>
            </td>
            <td>${customer.address}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
