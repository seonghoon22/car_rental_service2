<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
                <a class="nav-link" href="loginindex">Home</a>
            </li>
        </ul>
    </div>  
</nav>

<br>
<h2>대여 가능 차량 검색</h2>
<hr>
<form id="rentalForm">
    <label for="startDate">대여 시작일</label>
    <input type="date" id="startDate" name="startDate" required>
    <label for="startTime">대여 시작시간</label>
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
    <label for="endTime">대여 종료시간</label>
    <select id="endTime" name="endTime" required>
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
    <input type="submit" value="Search">
</form>

<h3>Available Cars:</h3>
<table id="carTable">
    <tr>
        <th>Car No</th>
        <th>Model</th>
        <th>Model Year</th>
        <th>Price</th>
    </tr>
</table>
<br>

<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>
    $(document).ready(function() {
        // 폼 제출 이벤트 핸들러
        $("#rentalForm").submit(function(event) {
            event.preventDefault(); // 기본 제출 동작 방지

            var formData = $(this).serialize(); // 폼 데이터 직렬화

            // AJAX 요청 전송
            $.ajax({
                url: "/web/rental/search",
                type: "POST",
                data: formData,
                success: function(response) {
                    // 성공적으로 요청이 완료되었을 때 실행될 콜백 함수
                    // 결과를 처리하고 HTML 업데이트
                    var cars = JSON.parse(response); // 받은 결과 데이터
                    var tableRows = ""; // 테이블 행 HTML

                    // 결과 데이터를 순회하며 테이블 행 HTML 생성
                    for (var i = 0; i < cars.length; i++) {
                        var car = cars[i];
                        var row = "<tr>" +
                            "<td>" + car.car_no + "</td>" +
                            "<td>" + car.model + "</td>" +
                            "<td>" + car.model_year + "</td>" +
                            "<td>" + car.price + "</td>" +
                            "</tr>";
                        tableRows += row;
                    }

                    // 테이블 업데이트
                    $("#carTable").html(tableRows);
                },
                error: function(xhr, status, error) {
                    // 요청이 실패했을 때 실행될 콜백 함수
                    console.log("AJAX 요청 실패:", status, error);
                }
            });
        });
    });
</script>
</body>
</html>