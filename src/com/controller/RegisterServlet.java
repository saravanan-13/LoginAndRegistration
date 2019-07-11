package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public RegisterServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		pw.println("<h1>Unauthorized access to this page!</h1>");
		RequestDispatcher rd = request.getRequestDispatcher("Registration.html");
		rd.include(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RegisterBean rBean = new RegisterBean();
		if (rBean.connectDatabase()) {
			
			ResponseObject responseObject = rBean.register(request.getParameter("username"), request.getParameter("password"),
					Integer.parseInt(request.getParameter("age")), request.getParameter("department"),
					 request.getParameter("email"));
			
			System.out.println(request.getAttribute("message"));
			if (responseObject.getResult()) {
				request.setAttribute("message", responseObject.getMessage());
				RequestDispatcher rd = request.getRequestDispatcher("RegistrationSuccessful.jsp");
				rd.forward(request, response);

			} else {
				request.setAttribute("message", "Account Already exists");
				RequestDispatcher rd = request.getRequestDispatcher("InvalidRegistration.jsp");
				rd.forward(request, response);
			}

		} else {
			response.getWriter().append("<h1>Error Connecting Database</h1>");
		}
	}

}