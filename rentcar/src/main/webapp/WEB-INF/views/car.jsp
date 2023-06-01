<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <link href="<c:url value="/resources/css/bootstrap.min.css"/>" rel="stylesheet">
    <title>차량 상세 정보</title>
</head>
<body>
<nav class="navbar navbar-expand navbar-dark bg-dark">
    <div class="container">
        <div class="navbar-header">
            <a class="navbar-brand" href="./home">Home</a>
        </div>
    </div>
</nav>
<div class="jumbotron">
    <div class="container">
        <h1 class="display-3">차량 정보</h1>
    </div>
</div>

<div class="container">
    <div class="row">
        <div class="col-md-4">
            <c:choose>
                <c:when test="${car.imgpath == null}">
                    <img src="<c:url value="/resources/images/default-car.png"/>" style="width: 100%" />
                </c:when>
                <c:otherwise>
                    <img src="<c:url value="/uploads/${car.imgpath}"/>" style="width: 100%" />
                </c:otherwise>
            </c:choose>
        </div>
        <div class="col-md-8">
            <h3>${car.model}</h3>
            <p><b>차량코드 : </b><span class="badge badge-info">${car.car_no}</span></p>
            <p><b>모델 : </b>${car.model}</p>
            <p><b>model_year : </b>${car.model_year}</p>
            <p><b>가격 : </b>${car.price}원</p>
            <p><b>imgpath : </b>${car.imgpath}</p>
            <br>
            <p><a href="#" class="btn btn-primary">차량대여 &raquo;</a>
            <a href="<c:url value="/cars"/>" class="btn btn-secondary">차량목록 &raquo;</a></p>
        </div>
    </div>
    <hr>
    <footer>
        <p>&copy; car</p>
    </footer>
</div>
</body>
</html>