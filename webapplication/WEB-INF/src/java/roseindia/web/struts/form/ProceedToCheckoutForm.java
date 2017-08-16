package roseindia.web.struts.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import java.util.*;
/**
 * Form bean for proceed to checkout Entry Screen.
 *
 */
public class ProceedToCheckoutForm extends ActionForm {

	//	Variables for form processing
	private String action;

	private String actionUpdateData;

	/** identifier field */
	private Integer orderId;

	/** identifier field */
	private String firstName;

	/** identifier field */
	private String lastName;
	
	/** identifier field */
	private String email;

	/** identifier field */
	private String orderTime;

	/** identifier field */
	private String phone;

	/** identifier field */
	private Integer fax;

	/** identifier field */
	private String address;

	/** identifier field */
	private String city;

	/** identifier field */
	private String state;

	/** identifier field */
	private String zipCode;

	/** identifier field */
	private String country;

	/** identifier field */
	private String creditCardType;

	/** identifier field */
	private String cardHolderName;

	/** identifier field */
	private String creditCardNumber;

	/** identifier field */
	private String expirationDate;

	/** identifier field */
	private String customerNotes;

	/** identifier field */
	private Integer cvvNumber;
	/**
	 * Reset all properties to their default values.
	 *
	 * @param mapping The mapping used to select this instance
	 * @param request The servlet request we are processing
	 */
	public void reset(ActionMapping mapping, HttpServletRequest request) {

		this.orderId = null;
		this.orderTime = null;
		this.firstName = null;
		this.lastName = null;
		this.city = null;
		this.country = null;
		this.fax = null;
		this.phone = null;
		this.address = null;
		this.state = null;
		this.zipCode = null;
		this.creditCardType = null;
		this.creditCardNumber = null;
		this.cardHolderName = null;
		this.cvvNumber = null;
		this.expirationDate = null;
		this.customerNotes = null;
		this.email=null;

		this.action = "add";
		this.actionUpdateData = "";
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public String getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(String orderTime) {
		this.orderTime = orderTime;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	

	public String getCardHolderName() {
		return cardHolderName;
	}

	public void setCardHolderName(String cardHolderName) {
		this.cardHolderName = cardHolderName;
	}

	public String getCreditCardNumber() {
		return creditCardNumber;
	}

	public void setCreditCardNumber(String creditCardNumber) {
		this.creditCardNumber = creditCardNumber;
	}

	public String getCreditCardType() {
		return creditCardType;
	}

	public void setCreditCardType(String creditCardType) {
		this.creditCardType = creditCardType;
	}

	

	public Integer getCvvNumber() {
		return cvvNumber;
	}

	public void setCvvNumber(Integer cvvNumber) {
		this.cvvNumber = cvvNumber;
	}

	

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getFax() {
		return fax;
	}

	public void setFax(Integer fax) {
		this.fax = fax;
	}

	public String getCustomerNotes() {
		return customerNotes;
	}

	public void setCustomerNotes(String customerNotes) {
		this.customerNotes = customerNotes;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(String expirationDate) {
		this.expirationDate = expirationDate;
	}

}
