package roseindia.web.struts.action;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import roseindia.services.ServiceFinder;

import roseindia.web.common.*;
import roseindia.dao.hibernate.*;

/**
 * Action class to show price list of products.
 */

public class PriceListAction extends Action {

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

		// Retrieve the DAO Reference
		roseindia.dao.ShoppingCartDAO shoppingCartDAO = (roseindia.dao.ShoppingCartDAO) ServiceFinder
				.getContext(request).getBean(ShoppingCartConstants.DAO_BEAN);
		try {

			HttpSession session_store = request.getSession();
			String sstorename = shoppingCartDAO.getStoreName();
			session_store.setAttribute("sstorename", sstorename);

			List list = new ArrayList();
			String strParent = "0";

			getCategoryList(list, strParent, shoppingCartDAO);
			request.setAttribute("categoryList", list);

		} catch (Exception e) {
			String strError = e.getMessage();
			System.out.println("Error is: " + strError);
		}

		return mapping.findForward("success");
	}

	// category combo
	private void getCategoryList(List list, String strParent,
			roseindia.dao.ShoppingCartDAO shoppingCartDAO) {
		// get collection of category by parent id
		Collection col = shoppingCartDAO.getCategoryByParentId(strParent);

		// iterating Collection
		for (Iterator iter = col.iterator(); iter.hasNext();) {
			Category element = (Category) iter.next();
			DataBean objDataBean = new DataBean();
			objDataBean.setId(String.valueOf(element.getCategoryid()));
			objDataBean.setPid(String.valueOf(element.getParentid()));
			if (strParent.equals("0"))
				objDataBean.setValue(element.getCategoryname());
			else
				objDataBean.setValue(element.getCategoryname());

			list.add(objDataBean);
			// get category list from database
			getCategoryList(list, String.valueOf(element.getCategoryid()),
					shoppingCartDAO);
		}

	}

}
