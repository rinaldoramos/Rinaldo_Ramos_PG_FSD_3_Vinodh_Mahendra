<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="com.simplilearn.workshop.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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

	<br>

	<div align="center">
		<%
		String user = (String) request.getAttribute("user");
		if (user != null) {
			/* Display a user or not founn user */
			out.println(user);
		} else {
		%>
	</div>

	<div align="center">
		<table border="2">
			<tr>
				<th>ID</th>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Email</th>
				<th>Username</th>
				<th>Password</th>
			</tr>
			<%
			List<User> lists = (List<User>) request.getAttribute("users");
			Iterator<User> iterator = lists.iterator();
			while (iterator.hasNext()) {
				User oneUser = iterator.next();
			%>
			<tr>
				<td><%=oneUser.getId()%></td>
				<td><%=oneUser.getFname()%></td>
				<td><%=oneUser.getLname()%></td>
				<td><%=oneUser.getEmail()%></td>
				<td><%=oneUser.getUsername()%></td>
				<td><%=oneUser.getPassword()%></td>
			</tr>
			<%
			}
			}
			%>
		</table>
	</div>
</body>
</html>

