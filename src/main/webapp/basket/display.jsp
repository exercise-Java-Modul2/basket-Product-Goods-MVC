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
<form method="post">
    <table border="1" style="text-align: center">
        <tr>
            <td>Product code</td>
            <td>Name</td>
            <td>Price</td>
            <td>Brand</td>
            <td>Quantity</td>
            <td>Total money</td>
        </tr>
        <c:forEach items='${requestScope["products"]}' var="product">
            <tr>
                <td>${product.getId()}</td>
                <td>${product.getName()}</td>
                <td>${product.getPrice()}</td>
                <td>${product.getBrand()}</td>
                <td><input type="number" name="number" id="number"></td>
                <td>${requestScope["money"]}</td>
            </tr>
        </c:forEach>
        <tr>
            <td colspan="2">Total money</td>
            <td colspan="4">${requestScope["totalPrice"]}</td>
        </tr>
    </table>
</form>
</body>
</html>
