package roseindia.web.struts.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import roseindia.web.common.ShoppingCartConstants;
import roseindia.web.struts.form.*;

import javax.servlet.*;

import javax.servlet.http.*;

import roseindia.services.ServiceFinder;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.action.ActionMessage;

/**
 * Action class to change admin password.
 */

public class ChangeAdminPwdAction extends Action {

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

		// Create object of ChangeAdminPwdForm
		ChangeAdminPwdForm objForm = (ChangeAdminPwdForm) form;

		// getting values from objForm
		String oldPwd = objForm.getOldpassword();
		String newPwd = objForm.getNewpassword();

		// Get the session object - "request" represents the HTTP servlet

		HttpSession session = request.getSession();

		// Get the User Name
		String userid = (String) session.getAttribute("adminUserID");

		// find user is valid or not
		boolean recuriterpasswordchangeStatus = shoppingCartDAO
				.adminpasswordChange(userid, newPwd, oldPwd);

		if (recuriterpasswordchangeStatus == true) {

			// valid user

			return mapping.findForward("success");

		} else {

			// invalid user

			// adding error
			errors.add("changePwd",
					new ActionMessage("error.changePwd.invalid"));
			// saving error
			saveErrors(request, errors);

			return mapping.findForward("failure");
		}

	}
}