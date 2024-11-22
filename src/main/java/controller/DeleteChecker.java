package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;


import pojo.UserPOJO;

@WebServlet("/DeleteChecker")
public class DeleteChecker extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
	  response.sendRedirect("index.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
	   int username = Integer.parseInt(request.getParameter("username"));
	   
	   UserPOJO pojo = new UserPOJO();
	   pojo.setUsername(username);
	   
	   SessionFactory sf = new AnnotationConfiguration().configure().buildSessionFactory();
	   Session ss = sf.openSession();
	   Transaction tt = ss.beginTransaction();
	   ss.delete(pojo);
	   tt.commit();
	   System.out.println("Data Deleted");
	   
	   HttpSession session = request.getSession(true);
	   session.setAttribute("msg", "Data Deleted");
	   response.sendRedirect("delete.jsp");
	}

}
