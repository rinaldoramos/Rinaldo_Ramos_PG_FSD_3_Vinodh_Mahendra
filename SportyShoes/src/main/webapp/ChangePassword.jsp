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
		<h1 align="center">Welcome administrator to Sporty Shoes Management Portal</h1><br><br>
		
		<h2 align="center">Which of the following options you want to do:</h2> <br> <br>		
	</p>
	
	<div class="container" align="center">
		<nav>
			<a href="ChangePassword.jsp">| Change Password</a> |
			<a href="BrowseUsers.jsp">Browse User</a> |
			<a href="ManageProducts.jsp">Manage Products</a> |
			<a href="PurchaseReport.jsp">Check Reports</a> |							
		</nav>
	</div>
	
	<h2 align="center">To change the password please fill the blank</h2>
	
	<div class="container" align="center">
		<form action="update" method="post">
		<%
			String name = request.getParameter("aname");
			request.setAttribute("aname", name);
		%>
		Enter new password	<br><input type="password" name="newPass" placeholder="Type password" required="required"> <br> <br>
								<input type="submit" value="Change">
		</form>												
	</div>						
</html>