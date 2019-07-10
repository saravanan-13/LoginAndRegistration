package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class VerifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public VerifyServlet() {
        super();
    }


	public void init(ServletConfig config) throws ServletException {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		VerifyBean vBean = new VerifyBean();
		if(vBean.connectDatabase()) {
			
			if(vBean.loginAuthentication(request.getParameter("username"),request.getParameter("password"))) {
				RequestDispatcher rd = request.getRequestDispatcher("Welcome.jsp");
				rd.forward(request, response);
			}else {
				RequestDispatcher rd = request.getRequestDispatcher("InvalidLogin.jsp");
				rd.forward(request, response);
			}
			
		}else {
			response.getWriter().append("<h1>Error Connecting Database</h1>");
		}
	}

}
