<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.Iterator"%>
<%@page import="com.simplilearn.workshop.Report"%>
<%@page import="java.util.List"%>
<%@page import="java.sql.ResultSet"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="style.css" type="text/css">
</head>
<body>

	<%!
		List<Report> lists = null; 
	%>
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
	        <th>Price</th>
	        <th>Purchase Date</th>
	    </tr>
	    <%
	    	lists  = (List<Report>)request.getAttribute("by-date");
	    	if (lists != null &&  !lists.isEmpty()) {
	    	Iterator<Report> iterator = lists.iterator();
	    	while(iterator.hasNext()){
	    		Report reportItem = iterator.next();
	    %>
	    	<tr>
	            <td><%= reportItem.getId() %></td>
	            <td><%= reportItem.getCategory() %></td>
	            <td><%= reportItem.getBrand() %></td>
	            <td><%= reportItem.getProduct_name() %></td>
	            <td><%= reportItem.getPrice() %></td>
	            <td><%= reportItem.getPurchase_date() %></td>	            
	        </tr>
	    <% 		
	    	}
	    }else{
	    	lists  = (List<Report>)request.getAttribute("by-category");
	    	Iterator<Report> iterator = lists.iterator();
	    	while(iterator.hasNext()){
	    		Report reportItem = iterator.next();
	    		%>
		    	<tr>
		            <td><%= reportItem.getId() %></td>
		            <td><%= reportItem.getCategory() %></td>
		            <td><%= reportItem.getBrand() %></td>
		            <td><%= reportItem.getProduct_name() %></td>
		            <td><%= reportItem.getPrice()  %></td>
		            <td><%= reportItem.getPurchase_date() %></td>	            
		        </tr>
		    <% 		
		    	}
		    }
	    %>
	</table>
	</div>
</body>
</html>