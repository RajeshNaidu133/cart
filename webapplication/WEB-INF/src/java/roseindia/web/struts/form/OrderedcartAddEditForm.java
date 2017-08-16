package roseindia.web.struts.form;

import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.*;
/**
 * Form bean for add/edit ordered cart Entry Screen.
 *
 */
public class OrderedcartAddEditForm extends ActionForm
{
	//Variables for form processing
	private String action;
	private String actionUpdateData;
   
	/** identifier field */
    private Integer productid;
    
    /** identifier field */
    private Integer orderid;

   /** identifier field */
    private String name;

   /** identifier field */
    private String price;

   /** identifier field */
    private String quantity;

    /**
	 * Reset all properties to their default values.
	 *
	 * @param mapping The mapping used to select this instance
	 * @param request The servlet request we are processing
	 */

public void reset(ActionMapping mapping, HttpServletRequest request) {
            this.productid=null ;
            this.orderid=null ;
            this.price = null;
            this.quantity = null;
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



public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getPrice() {
	return price;
}

public void setPrice(String price) {
	this.price = price;
}

public String getQuantity() {
	return quantity;
}

public void setQuantity(String quantity) {
	this.quantity = quantity;
}

public Integer getOrderid() {
	return orderid;
}

public void setOrderid(Integer orderid) {
	this.orderid = orderid;
}

public Integer getProductid() {
	return productid;
}

public void setProductid(Integer productid) {
	this.productid = productid;
}
}
