<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
 let msg = "${msg}";
 if(msg == "loginFail"){
	 alert("로그인 정보를 확인하세요.");
 }
</script>
</head>
<body>

<form id="loginForm" method="post">
  <div class="container">
    <label for="name"><b>UserID${data}</b></label>
    <input type="text" placeholder="아이디를 입력하세요." id="id" name="id" required>

    <label for="psw"><b>Password</b></label>
    <input type="password" placeholder="비밀번호를 입력하세요." id="password" name="password" required>

    <button type="submit">Login</button>
    <label>
      <input type="checkbox" checked="checked" name="remember"> Remember me
    </label>
  </div>

  <div class="container" style="background-color:#f1f1f1">
    <span class="psw">Forgot <a href="/member/forgotPW">password?</a></span>
  </div>
</form>
</body>
</html>