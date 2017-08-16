package roseindia.web.servlets;
import javax.servlet.*;
import javax.servlet.http.*;

import roseindia.services.ServiceFinder;

import java.io.*;
import java.util.*;

/*
 * Servlet dispaching request to the jsp page with attributes
 * showproducts-collection of product details
 * catid-category id value 
 */

public class ShowProducts extends HttpServlet 
{

 
public void service(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException {
 
  res.setContentType("text/html");
  
  //getting uri from request object
  String uri=req.getRequestURI();
  
 
    String id = uri.substring(uri.lastIndexOf("/")+1);
   
//  Retrieve the DAO Reference
	  roseindia.dao.ShoppingCartDAO shoppingCartDAO = (roseindia.dao.ShoppingCartDAO) ServiceFinder.getContext(req)
		.getBean("ShoppingCartDao");
    
    try{
    	
    	req.setAttribute("showproducts",shoppingCartDAO.getPriceDetail(id));
    	req.setAttribute("catid",id);   
    	
    }catch(Exception e){
    	
    	String strError=e.getMessage();
		System.out.println("Error from viewproducts Servlet: " + strError);
    }
    
      
  //dispatching request to jsp page  
    String strViewPage="/pages/admin/showProductsList.jsp";
	RequestDispatcher dispatcher = req.getRequestDispatcher(strViewPage);
	if (dispatcher != null){
		dispatcher.forward(req, res);
	} 
	
	
}



}