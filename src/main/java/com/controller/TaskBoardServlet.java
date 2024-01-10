package com.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.dao.Dao;
import com.signupbo.signupbo;

/**
 * Servlet implementation class TaskBoardServlet
 */
public class TaskBoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public TaskBoardServlet() {
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
		
		String id=request.getParameter("id");
		pw.print("<table border='1px solid black' width='100%'>");
		pw.print("<link rel=\"stylesheet\" type=\"text/css\" href=\"style.css\">");
		
		pw.print("<tr> <th>Id</th>  <th>Name</th>  <th>Email</th>  <th>Phone</th>  <th>Password</th> <th>Update</th> <th>Delete</th> </tr> ");
		
		    List<signupbo> list = Dao.getAllRegisteredUser(id);
		
		for(signupbo sb:list)
		{
			pw.print("<tr><td>"+sb.getId()+"</td><td>"+sb.getName()+"</td> <td><a href='EditServlet?id="+sb.getId()+"'> edit </a> </td> <td><a href='DeleteController?id="+sb.getId()+"'>delete </a></td> </tr>");
			
		}
		pw.print("</table>");
		
	}

	}

}
