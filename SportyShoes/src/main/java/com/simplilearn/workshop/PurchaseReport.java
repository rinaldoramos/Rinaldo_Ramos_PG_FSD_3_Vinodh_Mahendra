package com.simplilearn.workshop;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PurchaseReport
 */
public class PurchaseReport extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String choice = request.getParameter("bydate"); 
		MyJDBCConnector connector = new MyJDBCConnector();
		
		if (choice != null &&  !choice.isEmpty()) {
			// order by date
			String order = "ORDER BY purchase_date";
			List<Report> lists = connector.getReportByDate(order);
			request.setAttribute("by-date", lists);
			RequestDispatcher rd = request.getRequestDispatcher("DisplayReport.jsp");
			rd.forward(request, response);
		}else {
			// order by category
			String order = "ORDER BY category";
			List<Report> lists = connector.getReportByCategory(order);
			request.setAttribute("by-category", lists);
			RequestDispatcher rd = request.getRequestDispatcher("DisplayReport.jsp");
			rd.forward(request, response);
		}
	}

}
