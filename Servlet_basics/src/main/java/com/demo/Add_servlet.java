 package com.demo;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.security.auth.message.callback.PrivateKeyCallback.Request;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/Add_servlet")
public class Add_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Add_servlet() {
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int i = Integer.parseInt(request.getParameter("num1"));
		int j = Integer.parseInt(request.getParameter("num2"));
		int k = i+j;
//		PrintWriter out = response.getWriter();
//		out.println("Addtion is " + k);
//		request.setAttribute("k", k);
//		RequestDispatcher rd = request.getRequestDispatcher("Sq_servlwt");
//		rd.forward(request, response);
		
		HttpSession session = request.getSession();
		session.setAttribute("k", k);
		
		response.sendRedirect("Second_servlet"); // URL rewriting
		
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
