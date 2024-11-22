package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import pojo.UserPOJO;

@WebServlet("/SelectChecker")
public class SelectChecker extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		SessionFactory sf = new AnnotationConfiguration().configure().buildSessionFactory();
		Session ss = sf.openSession();

		String hql = "FROM UserPOJO";
		Query q = ss.createQuery(hql);

		ArrayList<UserPOJO> al = new ArrayList<UserPOJO>();
		Criteria ct = ss.createCriteria(UserPOJO.class);

		al = (ArrayList<UserPOJO>)ct.list();
		
		RequestDispatcher rd = request.getRequestDispatcher("show.jsp");
		request.setAttribute("USER", al);
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{

	}
}
