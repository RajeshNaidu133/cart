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
 * Action class to add config details.
 */

public class ConfigAddEditAction extends Action {

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
		ConfigAddEditForm objForm = (ConfigAddEditForm) form;

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
					roseindia.dao.hibernate.Config pojoObj = new roseindia.dao.hibernate.Config();
					pojoObj.setStorename(objForm.getStorename());
					pojoObj.setStoreurl(objForm.getStoreurl());
					pojoObj.setOrdernoticeemail(objForm.getOrdernoticeemail());
					pojoObj.setCursymbol(objForm.getCursymbol());
					pojoObj.setCurcode(objForm.getCurcode());

					pojoObj.setAboutustext(objForm.getAboutustext());
					pojoObj.setShipdeltext(objForm.getShipdeltext());
					// Add the data
					shoppingCartDAO.addConfig(pojoObj);

					forwardToPage = "success";
				}// User updates the data, update the user details
				if (objForm.getAction().equals("update")) {

					roseindia.dao.hibernate.Config pojoObj = shoppingCartDAO
							.loadConfig(String.valueOf(objForm.getId()));

					pojoObj.setId(objForm.getId());
					pojoObj.setStorename(objForm.getStorename());
					pojoObj.setStoreurl(objForm.getStoreurl());
					pojoObj.setOrdernoticeemail(objForm.getOrdernoticeemail());
					pojoObj.setCursymbol(objForm.getCursymbol());
					pojoObj.setCurcode(objForm.getCurcode());

					pojoObj.setAboutustext(objForm.getAboutustext());
					pojoObj.setShipdeltext(objForm.getShipdeltext());
					// Update the data
					shoppingCartDAO.updateConfig(pojoObj);
					forwardToPage = "success";
				}
			}
			// In case of Edit retrieve the data from datbase and set the values
			// in the form obj
			if (objForm.getAction().equals("Edit")) {
				// Retrieve the data from database
				roseindia.dao.hibernate.Config pojoObj = shoppingCartDAO
						.loadConfig(String.valueOf(1));

				objForm.setId(pojoObj.getId());
				objForm.setStorename(pojoObj.getStorename());
				objForm.setStoreurl(pojoObj.getStoreurl());
				objForm.setOrdernoticeemail(pojoObj.getOrdernoticeemail());
				objForm.setCursymbol(pojoObj.getCursymbol());
				objForm.setCurcode(pojoObj.getCurcode());

				objForm.setAboutustext(pojoObj.getAboutustext());
				objForm.setShipdeltext(pojoObj.getShipdeltext());
				// for the edit form
				forwardToPage = "input";
				// Set the action to update
				objForm.setAction("update");
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