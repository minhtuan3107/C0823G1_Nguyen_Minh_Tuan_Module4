<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 12/19/2023
  Time: 11:46 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<h1>Bảng gia vị</h1>
<body>
<form action="save">
    <table>
        <tr>
            <td>Muối<input type="checkbox" name="condiment" value="Muối">
            </td>
            <td>Đường<input type="checkbox" name="condiment" value="Đường">
            </td>
            <td>Vị tinh<input type="checkbox" name="condiment" value="Vị tinh">
            </td>
            <td>Hạt nêm<input type="checkbox" name="condiment" value="Hạt nêm">
            </td>
        </tr>
    </table>
    <input type="submit" value="Submit">
    <p>${text}</p>
</form>
</body>
</html>
