<%--
  Created by IntelliJ IDEA.
  User: Molaee
  Date: 3/20/2024
  Time: 5:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add product</title>
</head>
<body>
    <form action="/product/save" method="post">
        NAME: <input type="text" name="name"> <br/>
        PRICE: <input type="text" name="price"> <br/>
        <input type="submit" value="add product">
    </form>
</body>
</html>
