package roseindia.web.struts.action;

import java.io.File;
import java.io.FileOutputStream;
import java.util.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.*; //Project imports
import roseindia.web.struts.form.*;
import roseindia.services.*;
import roseindia.web.common.*;

import org.apache.struts.upload.FormFile;
import roseindia.dao.hibernate.*;

/**
 * Action class to add/edit products.
 */

public class ProductAddEditAction extends Action {

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

		ProductAddEditForm objForm = (ProductAddEditForm) form;

		// Retrieve the DAO Reference
		roseindia.dao.ShoppingCartDAO shoppingCartDAO = (roseindia.dao.ShoppingCartDAO) ServiceFinder
				.getContext(request).getBean(ShoppingCartConstants.DAO_BEAN);
		// By Default show the Add/Edit Page
		String forwardToPage = "input";
		String strError = "";

		// get currency symbol from the database
		String CurrencySymbol = shoppingCartDAO.getCurrencySymbol();
		request.setAttribute("csymbol", CurrencySymbol);

		try {
			// default case
			if (objForm.getAction().equals("add")
					&& objForm.getActionUpdateData().equals("")) {

				String cid = request.getParameter("catid");
				if (cid != null) {
					String CatName = shoppingCartDAO.getParentGategory(Integer
							.parseInt(cid));
					objForm.setCategoryid(CatName);
				}

			}

			// In case of form submit Add/Update the data
			if (objForm.getActionUpdateData().equals("update")) {
				// In case of Add, Add the data into database
				if (objForm.getAction().equals("add")) {

					roseindia.dao.hibernate.Product pojoObj = new roseindia.dao.hibernate.Product();

					boolean ValidProductStatus = shoppingCartDAO
							.checkValidProductName(objForm.getProductname());

					if (ValidProductStatus == false) {

						int categoryid = shoppingCartDAO.getParentId(objForm
								.getCategoryid());

						pojoObj.setCategoryid(categoryid);
						pojoObj.setProductname(objForm.getProductname());
						pojoObj.setProductprice(objForm.getProductprice());
						pojoObj.setListprice(objForm.getListprice());

						// product image upload

						FormFile myFile = objForm.getTheFile();
						// String contentType = myFile.getContentType();
						String fileName = myFile.getFileName();

						String filePath = getServlet().getServletContext()
								.getRealPath("/");

						filePath = filePath + "images";

						File fileToCreate = new File(filePath, fileName);
						if (!fileToCreate.exists()) {
							FileOutputStream fileOutStream = new FileOutputStream(
									fileToCreate);
							fileOutStream.write(myFile.getFileData());
							fileOutStream.flush();
							fileOutStream.close();
						}

						pojoObj.setImagename(fileName);
						// pojoObj.setImagename ("imagename");
						pojoObj.setQuantity(objForm.getQuantity());
						pojoObj.setBriefdisc(objForm.getBriefdisc());
						pojoObj.setDescription(objForm.getDescription());
						// Add the data
						shoppingCartDAO.addProduct(pojoObj);

						forwardToPage = "success";

					} else {

						// Create object of ActionMesssages
						ActionMessages errors = new ActionMessages();

						errors.add("invalidcategoryname", new ActionMessage(
								"error.categoryname.invalid"));
						saveErrors(request, errors);

						return mapping.findForward("input");
					}

				}// User updates the data, update the user details
				if (objForm.getAction().equals("update")) {
					System.out
							.println("getProductid:" + objForm.getProductid());
					roseindia.dao.hibernate.Product pojoObj = shoppingCartDAO
							.loadProduct(objForm.getProductid());

					pojoObj.setProductid(new Integer(objForm.getProductid()));

					int categoryid = shoppingCartDAO.getParentId(objForm
							.getCategoryid());

					// pojoObj.setCategoryid
					// (Integer.parseInt(objForm.getCategoryid()));
					pojoObj.setCategoryid(categoryid);
					pojoObj.setProductname(objForm.getProductname());
					pojoObj.setProductprice(objForm.getProductprice());
					pojoObj.setListprice(objForm.getListprice());

					// image upload

					FormFile myFile = objForm.getTheFile();
					String fileName = myFile.getFileName();
					String filePath = getServlet().getServletContext()
							.getRealPath("/");
					filePath = filePath + "images";

					System.out.println("fileName:==>" + fileName);

					if (!fileName.equals("")) {
						File fileToCreate = new File(filePath, fileName);
						if (!fileToCreate.exists()) {
							FileOutputStream fileOutStream = new FileOutputStream(
									fileToCreate);
							fileOutStream.write(myFile.getFileData());
							fileOutStream.flush();
							fileOutStream.close();
						}
					}
					// image upload end
					if (!fileName.equals("")) {
						pojoObj.setImagename(fileName);
					}
					pojoObj.setQuantity(objForm.getQuantity());
					pojoObj.setBriefdisc(objForm.getBriefdisc());
					pojoObj.setDescription(objForm.getDescription());
					// Update the data
					shoppingCartDAO.updateProduct(pojoObj);
					forwardToPage = "success";

				}
			}
			// In case of Edit retrieve the data from datbase and set the values
			// in the form obj
			if (objForm.getAction().equals("Edit")) {

				String productid = request.getParameter("proid");

				// Retrieve the data from database
				roseindia.dao.hibernate.Product pojoObj = shoppingCartDAO
						.loadProduct(productid);

				objForm.setProductid(String.valueOf(pojoObj.getProductid()));

				String parentCatName = shoppingCartDAO
						.getParentGategory(pojoObj.getCategoryid());

				objForm.setCategoryid(parentCatName);
				objForm.setProductname(pojoObj.getProductname());
				objForm.setProductprice(pojoObj.getProductprice());
				objForm.setListprice(pojoObj.getListprice());

				objForm.setQuantity(pojoObj.getQuantity());
				objForm.setBriefdisc(pojoObj.getBriefdisc());
				objForm.setDescription(pojoObj.getDescription());
				// for the edit form
				forwardToPage = "input";
				// Set the action to update
				objForm.setAction("update");
			}

		} catch (Exception e) {
			forwardToPage = "input";
			strError = e.getMessage();

			System.out.println("Error:" + strError);

		}
		// Display the registration form to the user
		return mapping.findForward(forwardToPage);
	}

}