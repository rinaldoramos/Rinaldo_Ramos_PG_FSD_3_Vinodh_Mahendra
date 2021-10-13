<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div class="container" align="center">
		<p>
			<h2>Welcome to the sign up page. Please fill the information requested below</h2>
			<br> <br>
		</p>				
	</div>
	
	<div class="container" align="center">
		<form action="signIn" method="post">
			Enter first name <br> <br>
			
			<input type="text" name="fName" placeholder="Type name..." required="required"> <br> <br>
			
			Enter last name <br> <br>
			
			<input type="text" name="lName" placeholder="Type last name..." required="required"> <br> <br>
			
			Enter email address <br> <br>
			
			<input type="email" name="email" placeholder="Type email..." required="required"> <br> <br>
			
			Enter username <br> <br>
			
			<input type="text" name="username" placeholder="Type user..." required="required"> <br> <br>
			
			Enter password <br> <br>
			
			<input type="password" name="password" placeholder="Type pass..." required="required"> <br> <br>
			
			<input type="submit" value="Submit">
		</form>			
	</div>
</body>
</html>