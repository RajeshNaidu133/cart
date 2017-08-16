package roseindia.web.struts.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.*;
import org.apache.struts.action.ActionForm;

/**
 * Form bean for change admin password Entry Screen.
 * 
 */

public class ChangeAdminPwdForm extends ActionForm {

	private String action = "add";

	private String oldpassword = null;
	private String newpassword = null;
	private String cnewpassword = null;

	public void setAction(String action) {
		this.action = action;
	}

	public String getAction() {
		return this.action;
	}

	public void setOldpassword(String oldpassword) {
		this.oldpassword = oldpassword;
	}

	public String getOldpassword() {
		return this.oldpassword;
	}

	public void setNewpassword(String newpassword) {
		this.newpassword = newpassword;
	}

	public String getNewpassword() {
		return this.newpassword;
	}

	public void setCnewpassword(String cnewpassword) {
		this.cnewpassword = cnewpassword;
	}

	public String getCnewpassword() {
		return this.cnewpassword;
	}

	/**
	 * Reset all properties to their default values.
	 * 
	 * @param mapping
	 *            The mapping used to select this instance
	 * @param request
	 *            The servlet request we are processing
	 */

	public void reset(ActionMapping mapping, HttpServletRequest request) {

		this.oldpassword = null;
		this.newpassword = null;
		this.cnewpassword = null;
		this.action = "add";

	}

	/**
	 * Validate the properties posted in this request. If validation errors are
	 * found, return an <code>ActionErrors</code> object containing the
	 * errors. If no validation errors occur, return <code>null</code> or an
	 * empty <code>ActionErrors</code> object.
	 * 
	 * @param mapping
	 *            The current mapping (from struts-config.xml)
	 * @param request
	 *            The servlet request object
	 */

	public ActionErrors validate(ActionMapping mapping,
			HttpServletRequest request) {

		ActionErrors errors = new ActionErrors();

		if (getOldpassword() == null || getOldpassword().length() < 1) {
			errors.add("oldpassword", new ActionMessage(
					"error.oldpassword.required"));
		}
		if (getNewpassword() == null || getNewpassword().length() < 1) {
			errors.add("newpassword", new ActionMessage(
					"error.newpassword.required"));
		}

		if (getCnewpassword() == null || getCnewpassword().length() < 1) {
			errors.add("cnewpassword", new ActionMessage(
					"error.cnewpassword.required"));
		}

		if (!getCnewpassword().equals(getNewpassword())) {
			errors.add("cnewpassword", new ActionMessage(
					"error.comparedPwd.required"));
		}

		return errors;
	}

}