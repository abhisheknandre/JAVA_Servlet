 package com.demo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		
//		HttpSession session = request.getSession();
//		session.setAttribute("k", k);
		
		Cookie cookie = new Cookie("k", k + "");
		response.addCookie(cookie);
		
		response.sendRedirect("Second_servlet"); // URL rewriting
		
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
