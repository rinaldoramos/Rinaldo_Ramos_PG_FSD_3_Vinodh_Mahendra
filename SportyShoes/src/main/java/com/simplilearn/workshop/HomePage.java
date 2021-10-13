package com.simplilearn.workshop;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class HomePage extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String user = request.getParameter("uname");
		String pass = request.getParameter("password");
		
		System.out.println("Welcome to HomePage Servlet " + user);
		
		request.setAttribute("name", user);
		
		if (user.equals("admin")) {
			request.setAttribute("pass", pass);
			RequestDispatcher dispatcher = request.getRequestDispatcher("welcomeAdmin.jsp");
			dispatcher.forward(request, response);			
		}else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("welcome.jsp");
			dispatcher.forward(request, response);	
		}			
	}
}
