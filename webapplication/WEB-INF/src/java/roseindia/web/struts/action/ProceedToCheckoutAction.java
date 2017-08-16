package roseindia.web.struts.action;

import java.util.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.*; //Project imports
import roseindia.web.struts.form.*;
import roseindia.services.*;
import roseindia.web.cart.ShoppingCart;
import roseindia.web.common.*;

import roseindia.dao.hibernate.*;

/**
 * Action class to proceed check out.
 */

public class ProceedToCheckoutAction extends Action {

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
		ProceedToCheckoutForm objForm = (ProceedToCheckoutForm) form;

		// Retrieve the DAO Reference
		roseindia.dao.ShoppingCartDAO shoppingCartDAO = (roseindia.dao.ShoppingCartDAO) ServiceFinder
				.getContext(request).getBean(ShoppingCartConstants.DAO_BEAN);
		// By Default show the Add/Edit Page
		String forwardToPage = "input";
		String strError = "";

		// getting curency symbol
		String CurrencySymbol = shoppingCartDAO.getCurrencySymbol();
		request.setAttribute("csymbol", CurrencySymbol);

		HttpSession session = request.getSession();

		try {

			Utilities utill = new Utilities();

			if (objForm.getAction().equals("add")
					&& objForm.getActionUpdateData().equals("")) {

				// getting seession data

				session.getAttribute("cart");
				ShoppingCart cart = (ShoppingCart) session.getAttribute("cart");

				// Set to the request attribute to show the items in the cart
				request.setAttribute("cartItems", cart.getItems());

			}

			// In case of form submit Add/Update the data
			if (objForm.getActionUpdateData().equals("update")) {

				// In case of Add, Add the data into database
				if (objForm.getAction().equals("add")) {
					roseindia.dao.hibernate.Order pojoObj = new roseindia.dao.hibernate.Order();

					// pojoObj.setOrderid(objForm.getOrderId());
					pojoObj.setOrdertime(new Date());
					pojoObj.setCardHolderName(objForm.getCardHolderName());
					pojoObj.setCreditCardNumber(objForm.getCreditCardNumber());
					pojoObj.setCreditCardType(objForm.getCreditCardType());
					pojoObj.setCustcity(objForm.getCity());
					pojoObj.setCustcountry(objForm.getCountry());
					pojoObj.setCustemail(objForm.getEmail());
					pojoObj.setCustfax(objForm.getFax());
					pojoObj.setCustfirstname(objForm.getFirstName());
					pojoObj.setCustlastname(objForm.getLastName());
					pojoObj.setCustomerNotes(objForm.getCustomerNotes());
					pojoObj.setCustphone(objForm.getPhone());
					pojoObj.setCuststate(objForm.getState());
					pojoObj.setCustzip(objForm.getZipCode());
					pojoObj.setCvvNumber(objForm.getCvvNumber());
					pojoObj.setExpirationDate(utill.changeStringtoDate(objForm
							.getExpirationDate()));
					pojoObj.setCustaddress(objForm.getAddress());

					// Add the data
					shoppingCartDAO.addOrder(pojoObj);

					// remove cart from session
					session.invalidate();

					forwardToPage = "success";
				}

			}

		} catch (Exception e) {
			forwardToPage = "input";
			strError = e.getMessage();

			System.out.println("Errors==>" + strError);
		}
		// Display the registration form to the user
		return mapping.findForward(forwardToPage);
	}

}