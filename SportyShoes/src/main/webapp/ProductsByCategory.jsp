<%@page import="java.util.Iterator"%>
<%@page import="com.simplilearn.workshop.Products"%>
<%@page import="java.util.List"%>
<%@page import="java.sql.ResultSet"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
	<br>	
	
	<div align="center">
		<table border="2">
	    <tr>
	        <th>Item ID</th>
	        <th>Category</th>
	        <th>Brand</th>
	        <th>Product Name</th>
	        <th>Quantity</th>
	        <th>Price</th>
	    </tr>
	    <%
	    	List<Products> lists  = (List<Products>)request.getAttribute("products");
	    	Iterator<Products> iterator = lists.iterator();
	    	while(iterator.hasNext()){
	    		Products productItem = iterator.next();
	    %>
	    	<tr>
	            <td><%= productItem.getId() %></td>
	            <td><%= productItem.getCategory() %></td>
	            <td><%= productItem.getBrand() %></td>
	            <td><%= productItem.getProductName() %></td>
	            <td><%= productItem.getQuantity() %></td>
	            <td><%= productItem.getPrice() %></td>	            
	        </tr>
	    <% 		
	    	}
	    %>
	</table>
	</div>
	</body>
</html>