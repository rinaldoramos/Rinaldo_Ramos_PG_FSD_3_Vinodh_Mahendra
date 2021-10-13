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
			<a href="ChangePassword.jsp">| Change Password</a> | <a
				href="BrowseUsers.jsp">Browse User</a> | <a
				href="ManageProducts.jsp">Manage Products</a> | <a
				href="PurchaseReport.jsp">Check Reports</a> |
		</nav>
	</div>
	
	<br> <br>
	<div align="center">
		<form action="purchaseReport" method="post">
			<input type="submit" value="Order By Date" name="bydate"> &nbsp;&nbsp;&nbsp;&nbsp;
			<input type="submit" value="Order By Category" name="bycategory"> 
		</form>
	</div>
</body>
</html>