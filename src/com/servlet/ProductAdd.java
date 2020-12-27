package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import com.product.Product;
import com.utility.HibernateUtility;



@WebServlet("/ProductAdd")
public class ProductAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("inside servlet");
		 
		
		String string1 = request.getParameter("prodId");
		String string2 = request.getParameter("prodName");
		Product product= new Product(string1, string2);
		 

		try {
			
			
			
	         Product p = new Product();
	         p.setName(product.getName());
	         p.setId(product.getName());
	         Session session = HibernateUtility.getSessionFactory().openSession();

	         org.hibernate.Transaction transaction = null;
	         
	         try {
	  
	             transaction = session.beginTransaction();
	             String sql = "INSERT INTO Product VALUES (:idVal, :nameVal)";
	  
	             Query query = session.createSQLQuery(sql);
	              
	             query.setParameter("idVal", product.getId());
	             query.setParameter("nameVal", product.getName());
	             
	             query.executeUpdate();
	              
	             session.getTransaction().commit();
	              
	         } catch (HibernateException e) {
	             transaction.rollback();
	             e.printStackTrace();
	          
	         } finally {
	             session.close();
	         }
	     
			
			System.out.println(("Product is added."));

		} catch (Exception e) {
			// TODO: handle exception
		}
		HttpSession session= request.getSession();
	
		session.setAttribute("sesname", request.getParameter("prodId"));
	
		response.sendRedirect("addsuccess.jsp");
	

	}

}