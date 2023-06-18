<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <title>Car List</title>
</head>
<body>
	<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
	    <div class="collapse navbar-collapse" id="collapsibleNavbar">
	        <ul class="navbar-nav">
	            <li class="nav-item">
	                <a class="nav-link" href="loginindex">Home</a>
	            </li>
	        </ul>
	    </div>  
	</nav>  
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
                <td><img src="static/images/${car.imgpath}" ></td> 
                <td> <button onclick="deleteCar(${car.car_no})">삭제</button></td>           
            </tr>
        </c:forEach>
    </table>
    <br>
    <a href="/web/cars/new">Add New Car</a>
    
     <script>
        function deleteCar(carNo) {
                location.href = "/web/cars/deleteCar?car_no=" + carNo;
        }
    </script>
</body>
</html>