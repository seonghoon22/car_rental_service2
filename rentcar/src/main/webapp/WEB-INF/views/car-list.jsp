<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Car List</title>
</head>
<body>
    <h2>Car List</h2>
    <table>
        <tr>
            <th>Car No</th>
            <th>Model</th>
            <th>Model Year</th>
            <th>Price</th>
        </tr>
        <c:forEach items="${cars}" var="car">
            <tr>
                <td>${car.car_no}</td>
                <td>${car.model}</td>
                <td>${car.model_year}</td>
                <td>${car.price}</td>
            </tr>
        </c:forEach>
    </table>
    <div>
			<img src="${car.imgpath}" style="width:300px;height:auto;">
	</div>
    <br>
    <a href="/web/cars/new">Add New Car</a>
</body>
</html>