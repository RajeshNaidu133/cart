package roseindia.web.struts.form;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.*;
import org.apache.struts.action.ActionForm;

/**
 * Form bean for the add to cart Entry Screen.
 *
 */

public class AddToCartForm extends ActionForm {

	private String action = "add";

	private String actionUpdateData;

	private Integer productid = null;
	private String productname = null;

	private String productprice = null;

	private Integer quantity = null;

	/**
	 * Reset all properties to their default values.
	 *
	 * @param mapping The mapping used to select this instance
	 * @param request The servlet request we are processing
	 */

	public void reset(ActionMapping mapping, HttpServletRequest request) {

		this.productid = null;
		this.productname = null;
		this.productprice = null;
		this.quantity = null;

		this.actionUpdateData = "";
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

	public Integer getProductid() {
		return productid;
	}

	public void setProductid(Integer productid) {
		this.productid = productid;
	}

	public String getProductname() {
		return productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	public String getProductprice() {
		return productprice;
	}

	public void setProductprice(String productprice) {
		this.productprice = productprice;
	}

	public String getActionUpdateData() {
		return actionUpdateData;
	}

	public void setActionUpdateData(String actionUpdateData) {
		this.actionUpdateData = actionUpdateData;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

}
