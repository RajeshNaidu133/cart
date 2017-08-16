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
 * Action class to add/edit categiries.
 */

public class CategoryAddEditAction extends Action {

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
		CategoryAddEditForm objForm = (CategoryAddEditForm) form;

		// Retrieve the DAO Reference
		roseindia.dao.ShoppingCartDAO shoppingCartDAO = (roseindia.dao.ShoppingCartDAO) ServiceFinder
				.getContext(request).getBean(ShoppingCartConstants.DAO_BEAN);
		// By Default show the Add/Edit Page
		String forwardToPage = "input";
		String strError = "";

		try {

			// default case
			if (objForm.getAction().equals("add")
					&& objForm.getActionUpdateData().equals("")) {

				String pid = request.getParameter("pid");

				if (pid != null) {
					String parentCatName = shoppingCartDAO
							.getParentGategory(Integer.parseInt(pid));
					objForm.setParentid(parentCatName);
				}

				int maxid = shoppingCartDAO.getMaxCategoryId();

				objForm.setCategoryid(String.valueOf(maxid));

				if (pid == null) {

					objForm.setParentid("Root");
				}

			}

			// In case of form submit Add/Update the data
			if (objForm.getActionUpdateData().equals("update")) {
				// In case of Add, Add the data into database
				if (objForm.getAction().equals("add")) {

					boolean ValidCategoryStatus = shoppingCartDAO
							.checkValidCategoryName(objForm.getCategoryname());

					if (ValidCategoryStatus == false) {
						roseindia.dao.hibernate.Category pojoObj = new roseindia.dao.hibernate.Category();

						pojoObj.setCategoryid(new Integer(objForm
								.getCategoryid()));

						pojoObj.setCategoryname(objForm.getCategoryname());

						if (objForm.getParentid().equals("Root")) {

							pojoObj.setParentid(0);
						} else {

							int parentid = shoppingCartDAO.getParentId(objForm
									.getParentid());

							pojoObj.setParentid(parentid);
						}

						// Add the data
						shoppingCartDAO.addCategory(pojoObj);

						forwardToPage = "success";
					} else {

						// Create object of ActionMesssages
						ActionMessages errors = new ActionMessages();

						errors.add("invalidcategoryname", new ActionMessage(
								"error.categoryname.invalid"));

						// saving error
						saveErrors(request, errors);

						return mapping.findForward("input");
					}

				}// User updates the data, update the user details
				if (objForm.getAction().equals("update")) {
					// load Category class from the database
					roseindia.dao.hibernate.Category pojoObj = shoppingCartDAO
							.loadCategory(objForm.getCategoryid());
					pojoObj.setCategoryid(new Integer(objForm.getCategoryid()));
					pojoObj.setCategoryname(objForm.getCategoryname());

					if (objForm.getParentid().equals("Root")) {

						pojoObj.setParentid(0);
					} else {

						int parentid = shoppingCartDAO.getParentId(objForm
								.getParentid());

						pojoObj.setParentid(parentid);
					}

					// Update the data
					shoppingCartDAO.updateCategory(pojoObj);
					forwardToPage = "success";

				}
			}
			// In case of Edit retrieve the data from datbase and set the values
			// in the form obj
			if (objForm.getAction().equals("Edit")) {

				// Retrieve the data from database
				roseindia.dao.hibernate.Category pojoObj = shoppingCartDAO
						.loadCategory(objForm.getCategoryid());

				objForm.setCategoryid(String.valueOf(pojoObj.getCategoryid()));
				objForm.setCategoryname(pojoObj.getCategoryname());

				if (pojoObj.getParentid() == 0) {
					objForm.setParentid("Root");
				} else {

					String parentCatName = shoppingCartDAO
							.getParentGategory(pojoObj.getParentid());
					objForm.setParentid(parentCatName);
				}

				// for the edit form
				forwardToPage = "input";
				// Set the action to update
				objForm.setAction("update");
			}

		} catch (Exception e) {
			forwardToPage = "input";
			strError = e.getMessage();
			System.out.println("Error from CategoryAddEditAction:" + strError);

		}
		// Display the registration form to the user
		return mapping.findForward(forwardToPage);
	}

}