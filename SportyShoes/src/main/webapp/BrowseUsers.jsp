<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="style.css" type="text/css">
</head>
<body>
	<p>
	<h1 align="center">Welcome administrator to Sporty Shoes
		Management Portal</h1>
	<br>
	<br>

	<h2 align="center">Which of the following options you want to do:</h2>
	<br>
	<br>
	</p>

	<div class="container" align="center">
		<nav>
			<a href="ChangePassword.jsp">| Change Password</a> |
			<a href="BrowseUsers.jsp">Browse User</a> |
			<a href="ManageProducts.jsp">Manage Products</a> |
			<a href="PurchaseReport.jsp">Check Reports</a> |							
		</nav>
	</div>
	
	<div align="center">
		<h3>Please select how you want to search for users:</h3>
		<form action="searchUser" method="post" >
			By email: <input type="email" name="email" placeholder="Type email here" size="25"> <br> <br> 
			<input type="submit" value="Search user">
			<br><br>
			Search all: <br> <br>
			<input type="submit" value="Search user">
		</form>
					
	</div>
</body>
</html>