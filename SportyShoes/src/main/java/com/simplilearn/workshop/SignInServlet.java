package com.simplilearn.workshop;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SignInServlet
 */
public class SignInServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		MyJDBCConnector con = new MyJDBCConnector();

		String fname = request.getParameter("fName");
		String lname = request.getParameter("lName");
		String email = request.getParameter("email");
		String user = request.getParameter("username");
		String pass = request.getParameter("password");
		if (con.addUser(fname, lname, email, user, pass)) {
			System.out.println("User added successfully");
			response.sendRedirect("login.jsp");
		} else {
			System.out.println("User was not added successfully");
			response.sendRedirect("login.jsp");
		}
	}
}
