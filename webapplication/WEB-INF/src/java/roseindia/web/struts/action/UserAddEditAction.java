package roseindia.web.struts.action;

import java.util.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.*; //Project imports
import roseindia.web.struts.form.*;
import roseindia.services.*;
import roseindia.web.common.*;

import roseindia.dao.hibernate.*;

/**
 * Action class to add/edit user.
 */ 

public class UserAddEditAction extends Action {
	
	/**
     * Execute method.
     *
     * @param mapping The ActionMapping used to select this instance
     * @param form The optional ActionForm bean for this request
     * @param request The servlet request we are processing
     * @param response The servlet response we are creating
     *
     * @exception Exception if business logic throws an exception
     */
	
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		UserAddEditForm objForm = (UserAddEditForm) form;

		// Retrieve the DAO Reference
		roseindia.dao.ShoppingCartDAO shoppingCartDAO = (roseindia.dao.ShoppingCartDAO) ServiceFinder
				.getContext(request).getBean(ShoppingCartConstants.DAO_BEAN);
		// By Default show the Add/Edit Page
		String forwardToPage = "input";
		String strError = "";
		
		//check for valid user
		boolean validUsernameStatus = shoppingCartDAO
				.checkValidUserName(objForm.getUserid());

		try {

			String strParent = "0";

			// In case of form submit Add/Update the data
			if (objForm.getActionUpdateData().equals("update")) {
				// In case of Add, Add the data into database
				if (objForm.getAction().equals("add")) {

					if (validUsernameStatus == false) {

						roseindia.dao.hibernate.User pojoObj = new roseindia.dao.hibernate.User();
						pojoObj.setUserid(objForm.getUserid());
						pojoObj.setFirstname(objForm.getFirstname());
						pojoObj.setLastname(objForm.getLastname());
						pojoObj.setEmail(objForm.getEmail());
						pojoObj.setZip(objForm.getZip());
						pojoObj.setCity(objForm.getCity());

						pojoObj.setPhone(objForm.getPhone());
						pojoObj.setFax(new Integer(objForm.getFax()));
						pojoObj.setAddress(objForm.getAddress());

						pojoObj.setState(objForm.getState());
						pojoObj.setCountry(objForm.getCountry());
						pojoObj.setPassword(objForm.getPassword());
						// Add the data
						shoppingCartDAO.addUser(pojoObj);

						forwardToPage = "success";
						// Create object of ActionMesssages
					} else {
						ActionMessages errors = new ActionMessages();

						errors.add("invalidUsername", new ActionMessage(
								"error.invalidUsername.invalid"));
						saveErrors(request, errors);

						return mapping.findForward("input");
					}

				}// User updates the data, update the user details
				if (objForm.getAction().equals("update")) {
					
					roseindia.dao.hibernate.User pojoObj = shoppingCartDAO
							.loadUser(objForm.getId());
					pojoObj.setUserid(objForm.getUserid());
					pojoObj.setFirstname(objForm.getFirstname());
					pojoObj.setLastname(objForm.getLastname());
					pojoObj.setEmail(objForm.getEmail());
					pojoObj.setZip(objForm.getZip());
					pojoObj.setCity(objForm.getCity());
					pojoObj.setPhone(objForm.getPhone());
					pojoObj.setFax(new Integer(objForm.getFax()));
					pojoObj.setAddress(objForm.getAddress());
					pojoObj.setId(new Integer(objForm.getId()));
					pojoObj.setState(objForm.getState());
					pojoObj.setCountry(objForm.getCountry());
					pojoObj.setPassword(objForm.getPassword());
					// Update the data
					shoppingCartDAO.updateUser(pojoObj);
					forwardToPage = "updated";
				}
			}
			// In case of Edit retrieve the data from datbase and set the values
			// in the form obj
			if (objForm.getAction().equals("Edit")) {

				HttpSession session = request.getSession();
				String id = (String) session.getAttribute("ID");

				if (id == null) {
					forwardToPage = "invaliduser";
				} else {

					// Retrieve the data from database
					roseindia.dao.hibernate.User pojoObj = shoppingCartDAO
							.loadUser(id);

					objForm.setUserid(pojoObj.getUserid());
					objForm.setFirstname(pojoObj.getFirstname());
					objForm.setLastname(pojoObj.getLastname());
					objForm.setEmail(pojoObj.getEmail());
					objForm.setZip(pojoObj.getZip());
					objForm.setCity(pojoObj.getCity());
					objForm.setPhone(pojoObj.getPhone());
					objForm.setFax((pojoObj.getFax()).toString());
					objForm.setAddress(pojoObj.getAddress());
					objForm.setId((pojoObj.getId()).toString());
					objForm.setState(pojoObj.getState());
					objForm.setCountry(pojoObj.getCountry());
					objForm.setPassword(pojoObj.getPassword());
					// for the edit form
					forwardToPage = "input";
					// Set the action to update
					objForm.setAction("update");
				}
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