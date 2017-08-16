package roseindia.web.struts.action;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import roseindia.services.ServiceFinder;
import roseindia.web.common.ShoppingCartConstants;


/**
 * Action class to Show Order placed.
 */

public class ShowOrderAction extends Action {
	
	/**
     * Execute method.
     *
     * @param mapping The ActionMapping used to select this instance
     * @param form The optional ActionForm bean for this request
     * @param request The servlet request we are processing
     * @param response The servlet response we are creating
     *
     * @exception Exception if business logic throws an exception
     */
	
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		// Retrieve the DAO Reference
		roseindia.dao.ShoppingCartDAO shoppingCartDAO = (roseindia.dao.ShoppingCartDAO) ServiceFinder
				.getContext(request).getBean(ShoppingCartConstants.DAO_BEAN);
		try {
			
			//getting collection of order detail data
			Collection col = shoppingCartDAO.getOrderDetail();
			request.setAttribute("showorders", col);

		} catch (Exception e) {
			String strError = e.getMessage();
			System.out.println("Error is: " + strError);
		}

		return mapping.findForward("success");
	}

}
