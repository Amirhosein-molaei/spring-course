<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Molaee
  Date: 3/20/2024
  Time: 9:24 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>product list</title>
</head>
<body>
    <table>
        <tr>
            <th>Name</th>
            <th>Price</th>
            <th>Detail</th>
            <th>Delete</th>
            <th>Edit</th>
        </tr>
        <c:forEach items="${list}" var="productDTO">
            <tr>
                <td>${productDTO.name}</td>
                <td>${productDTO.price}</td>
                <td>
<%--                    <a href="/product/detail?id=${productDTO.id}">--%>
<%--                        <img src="/resource/img/product.jpg" alt="">--%>
<%--                    </a>--%>
                    <a href="/product/detail/${productDTO.id}">
                        <img src="/resource/img/product.jpg" alt="">
                    </a>
                </td>
                <td><a href="/product/delete?id=${productDTO.id}">DELETE</a></td>
                <td><a href="/product/edit?id=${productDTO.id}">EDIT</a></td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
