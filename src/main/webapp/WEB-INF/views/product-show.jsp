<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="mvc" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--
  Created by IntelliJ IDEA.
  User: Molaee
  Date: 3/20/2024
  Time: 5:39 PM
  To change this template use File | Settings | File Templates.
--%>
<html>
<head>
    <title>Add product</title>
</head>
<body>
<%--    <form action="/product/save" method="post">--%>
<%--        NAME: <input type="text" name="name"> <br/>--%>
<%--        PRICE: <input type="text" name="price"> <br/>--%>
<%--        Type:--%>
<%--        <input type="submit" value="add product">--%>
<%--    </form>--%>
<h2><mvc:message code="product.title" text="ADD ALT"/></h2>

    <form:form commandName="dto" action="/product/save" method="post" modelAttribute="dto">
        NAME : <form:input path="name" /> <br/>
            <form:errors path="name" cssStyle="color: crimson" />
        PRICE : <form:input path="price" /> <br/>
        <form:errors path="price" cssStyle="color: crimson" />

        TYPE: <form:select path="type">
                <form:options items="${dto.validTypes}"/>
            </form:select>
        Color:
        Black <form:radiobutton path="color" value="black"/>
        Green <form:radiobutton path="color" value="green"/>
        Blue <form:radiobutton path="color" value="blue"/>
        <input type="submit" value="add product">
    </form:form>
</body>
</html>
