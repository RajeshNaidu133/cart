package roseindia.web.struts.action;

import java.util.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.*; //Project imports
import roseindia.web.struts.form.*;
import roseindia.services.*;
import roseindia.web.common.*;

import roseindia.dao.hibernate.*;

/**
 * Action class to add order cart.
 */

public class OrderedcartAddEditAction extends Action {

	/**
	 * Execute method.
	 * 
	 * @param mapping
	 *            The ActionMapping used to select this instance
	 * @param form
	 *            The optional ActionForm bean for this request
	 * @param request
	 *            The servlet request we are processing
	 * @param response
	 *            The servlet response we are creating
	 * 
	 * @exception Exception
	 *                if business logic throws an exception
	 */

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		OrderedcartAddEditForm objForm = (OrderedcartAddEditForm) form;

		// Retrieve the DAO Reference
		roseindia.dao.ShoppingCartDAO shoppingCartDAO = (roseindia.dao.ShoppingCartDAO) ServiceFinder
				.getContext(request).getBean(ShoppingCartConstants.DAO_BEAN);
		// By Default show the Add/Edit Page
		String forwardToPage = "input";
		String strError = "";

		try {

			// In case of form submit Add/Update the data
			if (objForm.getActionUpdateData().equals("update")) {
				// In case of Add, Add the data into database
				if (objForm.getAction().equals("add")) {
					roseindia.dao.hibernate.Orderedcart pojoObj = new roseindia.dao.hibernate.Orderedcart();
					pojoObj.setOrderid(objForm.getOrderid());
					pojoObj.setProductid(objForm.getProductid());
					pojoObj.setPrice(new Float(objForm.getPrice()));
					pojoObj.setQuantity(new Integer(objForm.getQuantity()));
					pojoObj.setName(objForm.getName());
					// Add the data
					shoppingCartDAO.addOrderedcart(pojoObj);

					forwardToPage = "success";
				}// User updates the data, update the user details
				if (objForm.getAction().equals("update")) {
					// System.out.println("Update the Data");
					roseindia.dao.hibernate.Orderedcart pojoObj = shoppingCartDAO
							.loadOrderedcart(String.valueOf(objForm
									.getOrderid()));
					pojoObj.setOrderid(objForm.getOrderid());
					pojoObj.setProductid(objForm.getProductid());
					pojoObj.setPrice(new Float(objForm.getPrice()));
					pojoObj.setQuantity(new Integer(objForm.getQuantity()));
					pojoObj.setName(objForm.getName());
					// Update the data
					shoppingCartDAO.updateOrderedcart(pojoObj);
					forwardToPage = "success";
				}
			}
			// In case of Edit retrieve the data from datbase and set the values
			// in the form obj
			if (objForm.getAction().equals("Edit")) {
				// Retrieve the data from database
				roseindia.dao.hibernate.Orderedcart pojoObj = shoppingCartDAO
						.loadOrderedcart(String.valueOf(objForm.getOrderid()));

				objForm.setOrderid(pojoObj.getOrderid());
				objForm.setProductid(pojoObj.getProductid());
				objForm.setPrice(String.valueOf(pojoObj.getPrice()));
				objForm.setQuantity(String.valueOf(pojoObj.getQuantity()));
				objForm.setName(pojoObj.getName());
				// for the edit form
				forwardToPage = "input";
				// Set the action to update
				objForm.setAction("update");
			}

		} catch (Exception e) {
			forwardToPage = "input";
			strError = e.getMessage();
		}
		// Display the registration form to the user
		return mapping.findForward(forwardToPage);
	}

}