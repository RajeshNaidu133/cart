package roseindia.web.struts.action;

import roseindia.web.common.ShoppingCartConstants;
import roseindia.web.struts.form.UserLoginForm;
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
 * Action class to login shopping cart user.
 */

public class UserLoginAction extends Action {

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

		// creating object of UserLoginForm
		UserLoginForm objForm = (UserLoginForm) form;

		// get userid from objForm
		String strUserid = objForm.getUserid();

		// get password from objForm
		String strPassword = objForm.getPassword();

		// check user is valid or not
		boolean loginStatus = shoppingCartDAO.checkUserLogin(strUserid,
				strPassword);
		if (loginStatus == true) {

			// valid user

			// create new session object
			HttpSession session = request.getSession();

			// setting attributes to the session object
			session.setAttribute("UserID", strUserid);

			// getting userid from database
			String id = String.valueOf(shoppingCartDAO.getUserId(strUserid));
			session.setAttribute("ID", id);

			return mapping.findForward("success");
		} else {
			// invalid user

			// adding error text to the ActionMessage object
			errors.add("login", new ActionMessage("error.login.invalid"));
			// saving error object
			saveErrors(request, errors);

			return mapping.findForward("failure");
		}
	}
}
