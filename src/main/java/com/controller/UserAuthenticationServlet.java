package com.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import com.dao.Dao;

/**
 * Servlet implementation class UserAuthenticationServlet
 */
public class UserAuthenticationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public UserAuthenticationServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
	    String email=request.getParameter("email");
	    String password=request.getParameter("password");
	    
	   if( Dao.login(email, password))
	   {
		   pw.print("<script> alert('login successfully') </script>");
		  // RequestDispatcher rd=request.getRequestDispatcher("index.html");
		   //rd.include(request, response);
		   HttpSession session=request.getSession();
			session.setAttribute("email", email);
			
			pw.print("<a href='UserAuthenticationServlet'>UserAuthenticationServlet</a>");
		   		   
	   }
	   else
	   {
		   pw.print("<script> alert('try again') </script>");
		   RequestDispatcher rd=request.getRequestDispatcher("index.html");
		   rd.include(request, response); 
	   }
	}
	

}
