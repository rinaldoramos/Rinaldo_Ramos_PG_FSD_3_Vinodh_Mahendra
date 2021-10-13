package com.simplilearn.workshop;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.tagplugins.jstl.core.If;

/**
 * Servlet implementation class SearchUser
 */
public class SearchUser extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String findEmail = request.getParameter("email");
		if (findEmail.isEmpty() || findEmail.equals("")) {
			findEmail = null;
		}
		
		String user = "";
		MyJDBCConnector con = new MyJDBCConnector();		
		System.out.println(findEmail);
		if (findEmail != null) {			
			try {
				user = con.findUserByEmail(findEmail);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (user != null) {
				request.setAttribute("user", user);
				RequestDispatcher rd = request.getRequestDispatcher("ReportUsers.jsp");
				rd.forward(request, response);
				user = null;
			}else {
				user = "No user was found with the given email: " + findEmail;
				request.setAttribute("user", user);
				RequestDispatcher rd = request.getRequestDispatcher("ReportUsers.jsp");
				rd.forward(request, response);
				user = null;
			}
		}else {
			// search everyone
			List<User> users;
			try {
				users = con.findAllUsers();
				request.setAttribute("users", users);
				RequestDispatcher rd = request.getRequestDispatcher("ReportUsers.jsp");
				rd.forward(request, response);
				user = null;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
		}
	}
}
