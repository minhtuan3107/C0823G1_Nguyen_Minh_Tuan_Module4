<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 12/19/2023
  Time: 2:27 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Thông tin khách hàng có ID là: <span>${customer.id}</span></h1>
<table>
    <tr>
        <td>
            Tên
        </td>
        <td>Email</td>
        <td>Địa chỉ</td>
    </tr>
    <tr>
        <td>${customer.name}</td>
        <td>${customer.email}</td>
        <td>${customer.address}</td>
    </tr>
</table>
</body>
</html>
