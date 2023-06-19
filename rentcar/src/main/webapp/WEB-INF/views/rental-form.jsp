<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table>
        <tr>
            <th>Car No</th>
            <th>Model</th>
            <th>Model Year</th>
            <th>Price</th>        
        </tr>
            <tr>
                <td>${cars.car_no}</td>
                <td>${cars.model}</td>
                <td>${cars.model_year}</td>
                <td>${cars.price}</td>
                <td><img src="static/images/${car.imgpath}" ></td>        
            </tr>

    </table>
</body>
</html>