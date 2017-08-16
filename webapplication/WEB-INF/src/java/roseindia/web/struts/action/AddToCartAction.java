package roseindia.web.struts.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.*;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import roseindia.services.ServiceFinder;
import roseindia.web.struts.form.AddToCartForm;
import roseindia.web.cart.*;
import roseindia.web.common.*;

/**
 * Action class to add items to the cart.
 */

public class AddToCartAction extends Action {

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
		AddToCartForm objForm = (AddToCartForm) form;

		Utilities utill = new Utilities();

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

		ShoppingCart cart;

		if (session.getAttribute("cart") == null) {
			cart = new ShoppingCart();
			session.setAttribute("cart", cart);
		} else {
			cart = (ShoppingCart) session.getAttribute("cart");

		}

		try {

			// In case of delete, Delete item from shopping cart
			if (objForm.getAction().equals("delete")) {
				int productid = Integer.parseInt(request.getParameter("pid"));
				// Delete Item from cart
				cart.removeItem(productid);

				// Set to the request attribute to show the items in the cart
				request.setAttribute("cartitems", cart.getItems());

				objForm.setAction("Edit");
			}

			// In case of Edit retrieve the data from datbase and set the values
			// in the form obj
			if (objForm.getAction().equals("Edit")) {

				if (request.getParameter("totalitems") != null) {

					int totalitms = Integer.parseInt(request
							.getParameter("totalitems"));

					for (int i = 1; i < totalitms; i++) {

						ShoppingCartItem item = new ShoppingCartItem();

						// Set values
						item.setItemCode(Integer.parseInt(request
								.getParameter("itemcode" + i)));

						// find per item cast by product id

						double perItemCast = shoppingCartDAO
								.getCostPerItem(Integer.parseInt(request
										.getParameter("itemcode" + i)));

						// rounding item cost up to 2 decimal places
						double itemsCast = Integer.parseInt(request
								.getParameter("quantity" + i))
								* perItemCast;

						double roundedItemCost = utill
								.RoundDoubleTo2DecimalPlaces(itemsCast, 2);

						item.setPerItemCost(roundedItemCost);

						// Set Item quantity
						item.setQty(Integer.parseInt(request
								.getParameter("quantity" + i)));
						// Update to cart

						cart.addItem(item);

					}
				} else {

					roseindia.dao.hibernate.Product pojoObj = shoppingCartDAO
							.loadProductToCart(String.valueOf(objForm
									.getProductid()));

					ShoppingCartItem item = new ShoppingCartItem();

					item.setItemCode(pojoObj.getProductid());
					item.setItemName(pojoObj.getProductname());
					item.setPerItemCost(Double.valueOf(pojoObj
							.getProductprice()));
					item.setQty((1));
					cart.addItem(item);

				}

				session.setAttribute("cart", cart);

				// Set to the request attribute to show the items in the cart
				request.setAttribute("cartitems", cart.getItems());

				// for the edit form
				forwardToPage = "input";
				// Set the action to update
				objForm.setAction("Edit");
			}

		} catch (Exception e) {
			forwardToPage = "input";
			strError = e.getMessage();
			System.out.println("Error:" + strError);

		}
		// Display the registration form to the user
		return mapping.findForward(forwardToPage);
	}

}
