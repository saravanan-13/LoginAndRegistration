package com.controller;

import java.io.IOException;

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
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RegisterBean rBean = new RegisterBean();
		if(rBean.connectDatabase()) {
			
			if(rBean.register(request.getParameter("username"),request.getParameter("password"),
					Integer.parseInt(request.getParameter("age")),request.getParameter("department"),
					request.getParameter("designation"),request.getParameter("email"))) {
				RequestDispatcher rd = request.getRequestDispatcher("RegistrationSuccessful.jsp");
				rd.forward(request, response);
				
			}else {
				RequestDispatcher rd = request.getRequestDispatcher("InvalidRegistration.jsp");
				rd.forward(request, response);
			}
			
		}else {
			response.getWriter().append("<h1>Error Connecting Database</h1>");
		}
	}

}
