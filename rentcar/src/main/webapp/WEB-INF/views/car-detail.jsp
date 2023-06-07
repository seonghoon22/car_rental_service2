<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Car Details</title>
</head>
<body>
    <h2>Car Details</h2>
    <table>
        <tr>
            <td>car_no:</td>
            <td>${car.car_no}</td>
        </tr>
        <tr>
            <td>Model:</td>
            <td>${car.model}</td>
        </tr>
        <tr>
            <td>Model Year:</td>
            <td>${car.model_year}</td>
        </tr>
        <tr>
            <td>Price:</td>
            <td>${car.price}</td>
        </tr>
    </table>
</body>
</html>