<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
	 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <meta charset="UTF-8">
    <title>MyPage</title>
    <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
    <link href="static/css/mypage.css" rel="stylesheet" />
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
    <table>
    	<thead>
        <tr>
            <th>ID</th>
            <th>Password</th>
            <th>Name</th>
            <th>Age</th>
            <th>Address</th>
            <th>Phone</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>${user.id}</td>
            <td>${user.password}</td>
            <td>${user.name}</td>
            <td>${user.age}</td>
            <td>${user.address}</td>
            <td>${user.phone}</td>
        </tr>
        </tbody>
    </table>
</body>
</html>