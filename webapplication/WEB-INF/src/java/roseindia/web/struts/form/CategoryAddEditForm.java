package roseindia.web.struts.form;

import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.*;

/**
 * Form bean for add /edit category Entry Screen.
 * 
 */

public class CategoryAddEditForm extends ActionForm {
	// Variables for form processing
	private String action;
	private String actionUpdateData;
	/** identifier field */
	private String categoryid;

	/** identifier field */
	private String categoryname;

	/** identifier field */
	private String parentid;

	/**
	 * Reset all properties to their default values.
	 * 
	 * @param mapping
	 *            The mapping used to select this instance
	 * @param request
	 *            The servlet request we are processing
	 */
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		this.categoryid = null;
		this.categoryname = null;
		this.parentid = null;
		this.action = "add";
		this.actionUpdateData = "";
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
		return errors;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getActionUpdateData() {
		return actionUpdateData;
	}

	public void setActionUpdateData(String actionUpdateData) {
		this.actionUpdateData = actionUpdateData;
	}

	public String getCategoryid() {
		return categoryid;
	}

	public void setCategoryid(String categoryid) {
		this.categoryid = categoryid;
	}

	public String getCategoryname() {
		return categoryname;
	}

	public void setCategoryname(String categoryname) {
		this.categoryname = categoryname;
	}

	public String getParentid() {
		return parentid;
	}

	public void setParentid(String parentid) {
		this.parentid = parentid;
	}
}
