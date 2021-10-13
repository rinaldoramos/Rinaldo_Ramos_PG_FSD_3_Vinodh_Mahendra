<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
<link rel="stylesheet" href="style.css" type="text/css">
</head>
<body>
<br>
	<div class="container" align="center">
		<nav>
			<a href="login.jsp">Home</a>
			<a href="About.jsp">About us</a>
			<a href="sign.jsp">Sign</a>
		</nav>
	</div>
	
	<div class="container" align="center">
	<p>
	 	<h3>Welcome to</h3> <h1>Sporty Shoes</h1> <img alt="SportyShoes Logo" height="200"  src="C:\Users\Rinal\git\SportyShoesRepo\SportyShoes\src\main\resources\logo.jpg"><br>	
	</p>
	<p><h2>Where you can even find Cinderella's lost shoe!</h2></p>
	</div>
	
	<div class="container" align="center">	
	<form action="home" method="post">
		Enter username <br> <br> 
		<input type="text" name="uname" placeholder="Type username here..." required="required"><br> <br> 
		Enter password <br> <br> 
		<input type="password" name="password" placeholder="Type passoword here..." required="required"><br> <br> 
		<input type="submit" value="Login">		
	</form>
	</div>
</body>
</html>