package com.simplilearn.workshop;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UpdatePassword
 */
public class UpdatePassword extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		String newPassword = request.getParameter("newPass");

		MyJDBCConnector con = new MyJDBCConnector();

		try {
			if (con.adminPasswordChange("admin", newPassword)) {			
				response.sendRedirect("login.jsp");
			}
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
