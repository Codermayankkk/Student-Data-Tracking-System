package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
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

@WebServlet("/RegisterChecker")
public class RegisterChecker extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.sendRedirect("index.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException 
	{
		int username = Integer.parseInt(request.getParameter("username"));
		String name = request.getParameter("name");
		String section = request.getParameter("sec");
		String address = request.getParameter("address");
		String mobile = request.getParameter("mobile");

		UserPOJO pojo = new UserPOJO(username, name, section, address, mobile);

		SessionFactory sf = new AnnotationConfiguration().configure().buildSessionFactory();
		Session ss = sf.openSession();
		Transaction tt = ss.beginTransaction();
		ss.save(pojo);
		tt.commit();

		ss.close();
		sf.close();
		System.out.println("Data inserted");
		
		/*HttpSession session = request.getSession(true);
		session.setAttribute("msg", "Data Inserted");
		response.sendRedirect("index.jsp"); */
		RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
		request.setAttribute("msg", "DATA Inserted");
		rd.forward(request, response);
	}
}
