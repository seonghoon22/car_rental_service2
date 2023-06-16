<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
	<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
	  <div class="collapse navbar-collapse" id="collapsibleNavbar">
	    <ul class="navbar-nav">
	      <li class="nav-item">
	        <a class="nav-link" href="index">Home</a>
	      </li>
	    </ul>
	  </div>  
	</nav>
	
	<h2>Rental Availability</h2>
    <form method="post" action="/web/rental/search">
        <label for="rentalDate">Rental Date:</label>
        <input type="date" id="rentalDate" name="rentalDate" required>
        <br>
        <input type="submit" value="Search">
    </form>

    <h3>Available Cars:</h3>
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
    <br>
</body>
</html>