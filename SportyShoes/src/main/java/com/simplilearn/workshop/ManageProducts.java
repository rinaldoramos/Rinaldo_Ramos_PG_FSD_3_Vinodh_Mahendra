package com.simplilearn.workshop;

import java.io.IOException;
import java.sql.ResultSet;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ManageProducts
 */
public class ManageProducts extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String choice = request.getParameter("category");
		System.out.println(choice);
		MyJDBCConnector connector = new MyJDBCConnector();
		
		if(choice.equals("none")) {
			request.setAttribute("none", choice);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("ProductsWithoutCategory.jsp");
			requestDispatcher.forward(request, response);
		}else {
			List<Products> products = connector.manageProductsByCategory(choice);
			request.setAttribute("products", products);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("ProductsByCategory.jsp");
			requestDispatcher.forward(request, response);	
		}			
	}
}
