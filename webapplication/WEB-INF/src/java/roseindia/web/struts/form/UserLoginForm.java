package roseindia.web.struts.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.*;
import org.apache.struts.action.ActionForm;

/**
 * Form bean for User Login Entry Screen.
 * 
 */
public class UserLoginForm extends ActionForm {

	private String action = "add";
	private String userid = null;
	private String password = null;
	
	/**
	 * Reset all properties to their default values.
	 *
	 * @param mapping The mapping used to select this instance
	 * @param request The servlet request we are processing
	 */
	
	public void reset(ActionMapping mapping, HttpServletRequest request) {

		this.userid = null;
		this.password = null;

		this.action = "add";

	}
	/**
	 * Validate the properties posted in this request. If validation errors are
	 * found, return an <code>ActionErrors</code> object containing the errors.
	 * If no validation errors occur, return <code>null</code> or an empty
	 * <code>ActionErrors</code> object.
	 *
	 * @param mapping The current mapping (from struts-config.xml)
	 * @param request The servlet request object
	 */
	public ActionErrors validate(

	ActionMapping mapping, HttpServletRequest request) {
		ActionErrors errors = new ActionErrors();
		
		return errors;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

}
