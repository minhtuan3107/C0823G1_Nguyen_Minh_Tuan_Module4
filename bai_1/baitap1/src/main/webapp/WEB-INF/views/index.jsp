<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 12/18/2023
  Time: 11:19 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>USD to VND</h1>
<form action="/calculator">
    <table>
        <tr>
            <td>Nhập tỷ giá</td>
            <td><input type="number" name="rate"></td>
        </tr>
        <tr>
            <td>Nhập số tiền cần chuyển đổi</td>
            <td><input type="number" name="price"></td>
        </tr>
        <tr>
            <td><input type="submit" value="Chuyển"></td>
        </tr>
    </table>
</form>
Kết quả : ${result} vnd
</body>
</html>
