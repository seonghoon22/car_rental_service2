<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Car Rental Service</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.22/css/jquery.dataTables.css">
<script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.10.22/js/jquery.dataTables.js"></script>
  <style>
  .fakeimg {
    height: 200px;
    background: #aaa;
  }
  </style>

 <script>
        $(document).ready(function() {
            $('#id').on('input', function() {
                var id = $(this).val();
                if (id !== '') {
                    $.ajax({
                        url: 'checkDuplicateId',
                        method: 'GET',
                        data: { id: id },
                        success: function(data) {
                            if (data === 'true') {
                                $('#idMessage').text('사용할 수 있는 아이디입니다.');
                            } else {
                                $('#idMessage').text('이미 사용 중인 아이디입니다.');
                            }
                        },
                        error: function(xhr, status, error) {
                            console.error(error);
                        }
                    });
                }
            });
        });
    </script>
</head>
<body>
    <h2>회원가입</h2>
    <form action="join" method="post">
        <label for="id">아이디:</label>
        <input type="text" id="id" name="id" required>
        <span id="idMessage"></span><br>
        
        <label for="password">비밀번호:</label>
        <input type="password" id="password" name="password" required><br>
        
        <label for="name">이름:</label>
        <input type="text" id="name" name="name" required><br>
        
        <label for="age">나이:</label>
        <input type="number" id="age" name="age" required><br>
        
        <label for="address">주소:</label>
        <input type="text" id="address" name="address" required><br>
        
        <label for="phone">전화번호:</label>
        <input type="text" id="phone" name="phone" required><br>
        
        <button type="submit">가입하기</button>
    </form>
</body>
</html>