<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 12/19/2023
  Time: 11:20 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="validate" method="post">
    <table>
        <tr>
            <td>
                Nhập email cần kiểm tra
            </td>
            <td>
                <input type="text" name="email">
            </td>
            <td>
                <input type="submit" value="Xác nhận">
            </td>
            <td>${result}</td>
        </tr>
    </table>
</form>
</body>
</html>
