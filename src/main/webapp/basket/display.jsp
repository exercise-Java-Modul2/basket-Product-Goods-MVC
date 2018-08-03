<%--
  Created by IntelliJ IDEA.
  User: 1234567890
  Date: 8/2/2018
  Time: 9:45 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Display basket product customer</title>
</head>
<body>
<h1>Basket product</h1>
<p>
    <a href="/products">Back to product list</a>
</p>
<table border="1" style="text-align: center">
    <tr>
        <td>Product code</td>
        <td>Name</td>
        <td>Price</td>
        <td>Brand</td>
        <td>Quantity</td>
    </tr>
    <c:forEach items='${requestScope["products"]}' var="product">
        <tr>
            <td>${product.getId()}</td>
            <td>${product.getName()}</td>
            <td>${product.getPrice()}</td>
            <td>${product.getBrand()}</td>
            <td><input type="number" name="number" id="number"></td>
        </tr>
    </c:forEach>
    <tr>
        <td colspan="1">Total money</td>
        <td colspan="3">${requestScope["totalPrice"]}</td>
        <td><a href="/products?action=by">Purchase</a></td>
    </tr>
</table>
</body>
</html>
