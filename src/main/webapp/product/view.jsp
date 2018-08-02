<%--
  Created by IntelliJ IDEA.
  User: 1234567890
  Date: 8/2/2018
  Time: 8:06 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Detail information product</title>
</head>
<body>
<h1>Detail information product</h1>
<p>
    <a href="/products">Back to product list</a>
</p>
<form>
    <fieldset>
        <legend>Detail information</legend>
        <table>
            <tr>
                <td>Product code:</td>
                <td>${requestScope["product"].getId()}</td>
            </tr>
            <tr>
                <td>Name:</td>
                <td>${requestScope["product"].getName()}</td>
            </tr>
            <tr>
                <td>Price:</td>
                <td>${requestScope["product"].getPrice()}</td>
            </tr>
            <tr>
                <td>Brand:</td>
                <td>${requestScope["product"].getBrand()}</td>
            </tr>
            <tr>
                <td><a href="/products?action=save&id=${requestScope["product"].getId()}">save to basket</a></td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>
