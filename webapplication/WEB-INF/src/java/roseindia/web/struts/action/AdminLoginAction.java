package roseindia.web.struts.action;

import roseindia.web.common.ShoppingCartConstants;
import roseindia.web.struts.form.AdminLoginForm;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import roseindia.services.ServiceFinder;

/**
 * Action class to login admin user.
 */

public class AdminLoginAction extends Action {

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

		// Retrieve the DAO Reference
		roseindia.dao.ShoppingCartDAO shoppingCartDAO = (roseindia.dao.ShoppingCartDAO) ServiceFinder
				.getContext(request).getBean(ShoppingCartConstants.DAO_BEAN);

		// Create object of ActionMesssages
		ActionMessages errors = new ActionMessages();

		// Create object of AdminLoginForm
		AdminLoginForm objForm = (AdminLoginForm) form;

		// getting values from the objForm
		String strUserid = objForm.getUserid();
		String strPassword = objForm.getPassword();

		// check admin user login status (user is exist or not)
		boolean loginStatus = shoppingCartDAO.checkAdminLogin(strUserid,
				strPassword);
		if (loginStatus == true) {

			// valid admin user

			// creating new session object
			HttpSession session = request.getSession();

			// set attribute to the session object
			session.setAttribute("adminUserID", strUserid);

			// get store name from the database
			String storename = shoppingCartDAO.getStoreName();

			// set store name to the session object
			session.setAttribute("storename", storename);

			return mapping.findForward("success");
		} else {
			// not allowed

			// adding error text to the ActionMessage object
			errors.add("login", new ActionMessage("error.login.invalid"));

			// saving error object
			saveErrors(request, errors);

			return mapping.findForward("failure");
		}
	}
}
