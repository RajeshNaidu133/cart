package roseindia.web.servlets;

import javax.servlet.*;
import javax.servlet.http.*;

import roseindia.services.ServiceFinder;

import java.io.*;
import java.util.*;
/*
 * Servlet dispaching request to the jsp page with attributes
 * viewprice-collection of product details
*/
public class ViewPrice extends HttpServlet {

	public void service(HttpServletRequest req, HttpServletResponse res)
			throws IOException, ServletException {

		res.setContentType("text/html");

		String uri = req.getRequestURI();

		String id = uri.substring(uri.lastIndexOf("/") + 1);

		// Retrieve the DAO Reference
		roseindia.dao.ShoppingCartDAO shoppingCartDAO = (roseindia.dao.ShoppingCartDAO) ServiceFinder
				.getContext(req).getBean("ShoppingCartDao");

		try {

			req.setAttribute("viewprice", shoppingCartDAO.getPriceDetail(id));

		} catch (Exception e) {

			String strError = e.getMessage();
			System.out.println("Error from ViewPrice Servlet: " + strError);
		}

		// dispatching request to jsp page
		String strViewPage = "/allNews.do?reqCode=treeview";
		RequestDispatcher dispatcher = req.getRequestDispatcher(strViewPage);
		if (dispatcher != null) {
			dispatcher.forward(req, res);
		}

	}

}