package roseindia.web.struts.form;

import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.*;
import org.apache.struts.upload.FormFile;
/**
 * Form bean for Product Add/Edit Entry Screen.
 *
 */
public class ProductAddEditForm extends ActionForm
{
	//Variables for form processing
	private String action;
	private String actionUpdateData;
   /** identifier field */
    private String productid;

   /** identifier field */
    private String categoryid;

   /** identifier field */
    private String productname;

   /** identifier field */
    private String productprice;

   /** identifier field */
    private String listprice;

   /** identifier field */
    private String imagename;
    private FormFile theFile;

    /** identifier field */
    //private String imagename;
    
   /** identifier field */
    private String quantity;

   /** identifier field */
    private String description;

   /** identifier field */
    private String briefdisc;

    /**
	 * Reset all properties to their default values.
	 *
	 * @param mapping The mapping used to select this instance
	 * @param request The servlet request we are processing
	 */
public void reset(ActionMapping mapping, HttpServletRequest request) {
            this.productid = null;
            this.categoryid = null;
            this.productname = null;
            this.productprice = null;
            this.listprice = null;
            this.theFile = null;
            this.imagename = null;
            this.quantity = null;
            this.description = null;
            this.briefdisc = null;
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

public String getBriefdisc() {
	return briefdisc;
}

public void setBriefdisc(String briefdisc) {
	this.briefdisc = briefdisc;
}

public String getCategoryid() {
	return categoryid;
}

public void setCategoryid(String categoryid) {
	this.categoryid = categoryid;
}

public String getDescription() {
	return description;
}

public void setDescription(String description) {
	this.description = description;
}



public String getListprice() {
	return listprice;
}

public void setListprice(String listprice) {
	this.listprice = listprice;
}

public String getProductid() {
	return productid;
}

public void setProductid(String productid) {
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

public String getQuantity() {
	
	return quantity;
}



public void setQuantity(String quantity) {
	this.quantity = quantity;
}



public String getImagename() {
	return imagename;
}

public void setImagename(String imagename) {
	this.imagename = imagename;
}

public FormFile getTheFile() {
	return theFile;
}

public void setTheFile(FormFile theFile) {
	this.theFile = theFile;
}


}
