package roseindia.web.struts.form;

import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.*;
/**
 * Form bean for User Add/Edit Form Entry Screen.
 *
 */
public class UserAddEditForm extends ActionForm
{
	//Variables for form processing
	private String action;
	private String actionUpdateData;
   /** identifier field */
    private String id;

   /** identifier field */
    private String userid;

   /** identifier field */
    private String password;

   /** identifier field */
    private String firstname;

   /** identifier field */
    private String lastname;

   /** identifier field */
    private String email;

   /** identifier field */
    private String country;

   /** identifier field */
    private String zip;

   /** identifier field */
    private String state;

   /** identifier field */
    private String city;

   /** identifier field */
    private String address;

   /** identifier field */
    private String phone;

   /** identifier field */
    private String fax;

    /**
	 * Reset all properties to their default values.
	 *
	 * @param mapping The mapping used to select this instance
	 * @param request The servlet request we are processing
	 */

public void reset(ActionMapping mapping, HttpServletRequest request) {
            this.id = null;
            this.userid = null;
            this.password = null;
            this.firstname = null;
            this.lastname = null;
            this.email = null;
            this.country = null;
            this.zip = null;
            this.state = null;
            this.city = null;
            this.address = null;
            this.phone = null;
            this.fax = null;
           this.action="add";
           this.actionUpdateData="";
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

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public String getFax() {
	return fax;
}

public void setFax(String fax) {
	this.fax = fax;
}

public String getFirstname() {
	return firstname;
}

public void setFirstname(String firstname) {
	this.firstname = firstname;
}

public String getId() {
	return id;
}

public void setId(String id) {
	this.id = id;
}

public String getLastname() {
	return lastname;
}

public void setLastname(String lastname) {
	this.lastname = lastname;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
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

public String getUserid() {
	return userid;
}

public void setUserid(String userid) {
	this.userid = userid;
}

public String getZip() {
	return zip;
}

public void setZip(String zip) {
	this.zip = zip;
}
}
