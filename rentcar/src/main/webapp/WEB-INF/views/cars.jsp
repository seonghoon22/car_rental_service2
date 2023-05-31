<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link href="<c:url value="/resources/css/bootstrap.min.css"/>"  
    rel="stylesheet">
<title>차량 목록</title>
</head>
<body>
    <nav class="navbar navbar-expand  navbar-dark bg-dark"> 
        <div class="container">
            <div class="navbar-header">
                <a class="navbar-brand" href="./index">Home</a>
            </div>
        </div>
    </nav>
    <div class="jumbotron">
        <div class="container">
            <h1 class="display-3">차량 목록</h1>
        </div>
    </div>
    <div class="container">
        <div class="row" align="center">
            <c:forEach items="${CarList}" var="car"> 
                <div class="col-md-4">
                 	 <c:choose>
                        <c:when test="${car.getImgpath()==null}">
                        
                        
                            <img src="<c:url value="C:\\upload\\${car.getCarId()}.png"/>" style="width: 60%" />
                       
                       
                        </c:when>
                        <c:otherwise>
                        
                        
                        
                            <img src="<c:url value="C:\\upload\\${car.getImgpath().getOriginalFilename()}"/>" style="width: 60%" />
                        
                        
                        
                        </c:otherwise>
                    </c:choose>
                    
                    <h3>${car.model}</h3>
                    <p>${car.car_no}</p>
                        <br> ${car.price} | ${car.model_year}<br/>
                        
                        
                        
                 
                    
                    
                    
                    <p>${car.price}원</p>
                    <p><a href="<c:url  value="/cars/car?id=${car.car_no}"/>" class="btn btn-Secondary" role="button">상세정보 &raquo;</a></p>
                </div>
            </c:forEach> 
        </div>
        <hr>
        <footer>
            <p>&copy; car_rent</p>
        </footer>
    </div>
</body>
</html>