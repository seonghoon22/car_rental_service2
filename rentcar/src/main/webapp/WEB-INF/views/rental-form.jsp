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
        <c:forEach items="${rent}" var="rent">
            <tr>
                <td>${rent.car_no}</td>
                <td>${rent.model}</td>
                <td>${rent.model_year}</td>
                <td>${rent.startDate}</td>
                <td>${rent.startTime}</td>
                <td>${rent.endDate}</td>
                <td>${rent.rentalPeriod}</td>
                <td>${rent.totalCost}</td>                                        
            </tr>
        </c:forEach>
    </tbody>
</body>
</html>