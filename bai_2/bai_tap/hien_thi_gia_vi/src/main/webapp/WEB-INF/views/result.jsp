<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 12/19/2023
  Time: 1:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Gia vị bạn đã chọn là:</h1>
<table>
    <c:forEach items="${condiment}" varStatus="loop" var="type">
        <tr>
            <td>${type}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
