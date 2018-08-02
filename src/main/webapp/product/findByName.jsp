<%--
  Created by IntelliJ IDEA.
  User: 1234567890
  Date: 8/2/2018
  Time: 9:11 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Find product by name</title>
</head>
<body>
<h1>Search by name</h1>
<p>
    <a href="/products">Back to product list</a>
</p>
<form method="post">
    <fieldset>
        <legend>Search by name</legend>
        <table>
            <tr>
                <td>Enter name:</td>
                <td><input type="text" name="name" id="name"></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="Search"></td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>
