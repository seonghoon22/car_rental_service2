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
	<br>
<h2>대여 가능 차량 검색</h2>
<hr>
<form id="rentalForm" action ="/web/rental/search" method = "post">
    <label for="startDate">대여 시작일</label>
    <input type="date" id="startDate" name="startDate" required>
    <label for="startTime">대여시간</label>
    <select id="startTime" name="startTime" required>
        <option value="">시간 선택</option>
        <option value="8">8시</option>
        <option value="9">9시</option>
        <option value="10">10시</option>
        <option value="11">11시</option>
        <option value="12">12시</option>
        <option value="13">13시</option>
        <option value="14">14시</option>
        <option value="15">15시</option>
        <option value="16">16시</option>
        <option value="17">17시</option>
        <option value="18">18시</option>
    </select>
    <br>
    <label for="endDate">대여 종료일</label>
    <input type="date" id="endDate" name="endDate" required>
    <br>
    <input type="submit" value="Search">
</form>


<br>
<table class="table text-center">
    <thead class="thead-dark">
        <tr>
            <th scope="col">Car No</th>
            <th scope="col">Model</th>
            <th scope="col">Model Year</th>
            <th scope="col">Price</th>        
 			<th scope="col">     </th>	
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${cars}" var="car">
            <tr>
                <td>${car.car_no}</td>
                <td>${car.model}</td>
                <td>${car.model_year}</td>
                <td>${car.price}</td>
                <td>
                    <img src="${pageContext.request.contextPath}/static/images/${car.imgpath}" class="car-image">
                </td>        
                <td> <button onclick="rentCar(${car.car_no})">대여</button></td> 
            </tr>
        </c:forEach>
    </tbody>
</table>
<br>
<script>
        function rentCar(carNo) {
                location.href = "/web/rental/rentCar?carNo=" + carNo;
        }
</script>

</body>
</html>