package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import pojo.StudentLogin;

@WebServlet("/LoginChecker")
public class LoginChecker extends HttpServlet 
{
	
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
	  response.sendRedirect("login.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
	  int username = Integer.parseInt(request.getParameter("uname"));
	  String password = request.getParameter("password");
	  
	  System.out.println(username);
	  System.out.println(password);
	  
	  SessionFactory sf = new AnnotationConfiguration().configure().buildSessionFactory();
	  Session ss = sf.openSession();
	  
	  Criteria ct = ss.createCriteria(StudentLogin.class);
	  
	  ct.add(Restrictions.eq("username", username));
	  ct.add(Restrictions.eq("password", password));
	  
	  List l1 = ct.list();
	  System.out.println("hello =  "+l1);
	  
	  if(!l1.isEmpty())
	  {
		HttpSession session = request.getSession(true);
		session.setAttribute("username", username);
		response.sendRedirect("index.jsp");
	  }
	  else
	  {
		  RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
		  request.setAttribute("msg", "Login Failed");
		  rd.forward(request, response);
	  }
	}
}
