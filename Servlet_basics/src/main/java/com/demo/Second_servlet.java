package com.demo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.parser.Cookie;


@WebServlet("/Second_servlet")
public class Second_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    
    public Second_servlet() {
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
//		HttpSession session = request.getSession();
//		int k = (int)session.getAttribute("k");
		
		int k = 0;
		javax.servlet.http.Cookie[] cookies = request.getCookies();
		
		for(javax.servlet.http.Cookie c: cookies) {
			if(c.getName().equals("k"))
				k = Integer.parseInt(c.getValue());
		}
		
		k = k * k;
		PrintWriter out = response.getWriter();
//		out.println("<html><body bgcolor='cyon'>");
		out.println("Result is " + k);
//		out.println("</body></html>");
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
