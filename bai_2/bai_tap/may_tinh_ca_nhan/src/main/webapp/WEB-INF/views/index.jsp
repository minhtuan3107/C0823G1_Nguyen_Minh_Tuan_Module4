<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 12/19/2023
  Time: 1:40 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Máy tính</h1>
<form action="caculator">
    <input type="number" name="firstNumber">
    <input type="number" name="secondNumber">
    <input type="submit" name="operator" value="Cộng">
    <input type="submit" name="operator" value="Trừ">
    <input type="submit" name="operator" value="Nhân">
    <input type="submit" name="operator" value="Chia">
</form>
<p>${result}</p>
</body>
</html>
