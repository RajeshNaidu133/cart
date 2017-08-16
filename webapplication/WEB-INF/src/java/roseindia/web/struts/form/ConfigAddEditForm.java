package roseindia.web.struts.form;

import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.*;

/**
 * Form bean for the add to cart Entry Screen.
 * 
 */

public class ConfigAddEditForm extends ActionForm {
	// Variables for form processing
	private String action;
	private String actionUpdateData;

	/** identifier field */
	private Integer id;

	/** identifier field */
	private String storename;

	/** identifier field */
	private String storeurl;

	/** identifier field */
	private String ordernoticeemail;

	/** identifier field */
	private String cursymbol;

	/** identifier field */
	private String curcode;

	/** identifier field */
	private String aboutustext;

	/** identifier field */
	private String shipdeltext;

	/**
	 * Reset all properties to their default values.
	 * 
	 * @param mapping
	 *            The mapping used to select this instance
	 * @param request
	 *            The servlet request we are processing
	 */

	public void reset(ActionMapping mapping, HttpServletRequest request) {

		this.id = null;
		this.storename = null;
		this.storeurl = null;
		this.ordernoticeemail = null;
		this.cursymbol = null;
		this.curcode = null;

		this.aboutustext = null;
		this.shipdeltext = null;
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

	// setter getter methods for all properies
	public String getAboutustext() {
		return aboutustext;
	}

	public void setAboutustext(String aboutustext) {
		this.aboutustext = aboutustext;
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

	public String getCurcode() {
		return curcode;
	}

	public void setCurcode(String curcode) {
		this.curcode = curcode;
	}

	public String getCursymbol() {
		return cursymbol;
	}

	public void setCursymbol(String cursymbol) {
		this.cursymbol = cursymbol;
	}

	public String getOrdernoticeemail() {
		return ordernoticeemail;
	}

	public void setOrdernoticeemail(String ordernoticeemail) {
		this.ordernoticeemail = ordernoticeemail;
	}

	public String getShipdeltext() {
		return shipdeltext;
	}

	public void setShipdeltext(String shipdeltext) {
		this.shipdeltext = shipdeltext;
	}

	public String getStorename() {
		return storename;
	}

	public void setStorename(String storename) {
		this.storename = storename;
	}

	public String getStoreurl() {
		return storeurl;
	}

	public void setStoreurl(String storeurl) {
		this.storeurl = storeurl;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}
