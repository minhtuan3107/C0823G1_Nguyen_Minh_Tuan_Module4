<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 12/18/2023
  Time: 1:36 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Từ điển</h1>
<form action="/dictionary">
    <table>
        <tr>
            <td>Nhập từ cần tìm</td>
            <td>
                <input type="text" name="name">
            </td>
        </tr>
        <tr>
            <td><input type="submit" value="Xác nhận"></td>
        </tr>
    </table>
</form>
<a>${result}</a>
</body>
</html>
