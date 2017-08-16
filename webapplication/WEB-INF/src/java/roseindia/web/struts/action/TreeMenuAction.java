
package roseindia.web.struts.action;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import roseindia.services.ServiceFinder;
import roseindia.web.common.CategoryData;
import roseindia.web.common.Categories;
import roseindia.web.common.Products;
import roseindia.web.common.ShoppingCartConstants;
import roseindia.web.struts.form.CategoriesForm;

import fr.improve.struts.taglib.layout.menu.MenuComponent;
import fr.improve.struts.taglib.layout.util.LayoutUtils;

/**
 * Action class to display category tree menu.
 */

public class TreeMenuAction extends DispatchAction {
	
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

	public ActionForward showAllNews(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		
		//Retrieve the DAO Reference
		roseindia.dao.ShoppingCartDAO shoppingCartDAO = (roseindia.dao.ShoppingCartDAO) ServiceFinder
				.getContext(request).getBean(ShoppingCartConstants.DAO_BEAN);
		
		
		//CategoryData l_database = CategoryData.get();
		Collection l_allNews = shoppingCartDAO.loadCategoryData(); ////change
		request.setAttribute("allNews", l_allNews);
		return mapping.findForward("list");
	}
	
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
	
    public ActionForward treeview(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    	
    	//Retrieve the DAO Reference
		roseindia.dao.ShoppingCartDAO shoppingCartDAO = (roseindia.dao.ShoppingCartDAO) ServiceFinder
				.getContext(request).getBean(ShoppingCartConstants.DAO_BEAN);
		
    	
    	try{
    	// Build the news map.
     	Map lc_map = new TreeMap();          	
     	    	     	
     	Iterator lc_it = shoppingCartDAO.loadCategoryData().iterator();//change
     	    	     	
     	while (lc_it.hasNext()) {
     		Categories lc_news = (Categories) lc_it.next();
     		
     		
     		
     		Map lc_innerMap = (Map) lc_map.get(lc_news.getDate());//lc_calendar.getTime()
     		if (lc_innerMap==null) {
     			lc_innerMap = new TreeMap();
     			lc_map.put(lc_news.getDate(), lc_innerMap);//lc_calendar.getTime()
     		}
     		List lc_list = (List) lc_innerMap.get(lc_news.getProduct());
     		if (lc_list==null) {
     			lc_list = new ArrayList();
     			lc_innerMap.put(lc_news.getProduct(), lc_list);
     		}
     		lc_list.add(lc_news);
     	}
     	
     	
     	// Create a treeview.
     	MenuComponent lc_menu = new MenuComponent();
     	
     	// Name it.
        lc_menu.setName("news");
     	
     	// Build the treeview content.
     	lc_it = lc_map.entrySet().iterator();
     	
     	while (lc_it.hasNext()) {
     		
     		
     		
     		Map.Entry lc_entry = (Map.Entry) lc_it.next();
     		
     		String lc_date = (String) lc_entry.getKey();
     		
     		
     		
     		MenuComponent lc_subject = createChildMenu(lc_menu, lc_date, lc_date);
     		Iterator lc_it2 = ((Map)lc_entry.getValue()).entrySet().iterator();
     		while (lc_it2.hasNext()) {
     			
     			
     			
     			Map.Entry lc_entry2 = (Map.Entry) lc_it2.next();
     			Products lc_subjectBean = (Products) lc_entry2.getKey();
     			MenuComponent lc_title = createChildMenu(lc_subject, lc_subjectBean.getName(), lc_subjectBean.getId());
     			
     			Iterator lc_it3 = ((List)lc_entry2.getValue()).iterator();
     			while (lc_it3.hasNext()) {
     					   				
     				Categories lc_news = (Categories) lc_it3.next();
     				   				
     				MenuComponent lc_newsItem = createChildMenu(lc_title, lc_news.getTitle(), lc_news.getId());
     				lc_newsItem.setLocation("../largeview/" + lc_news.getId());
     			}
     		}
     	}
     	
     	
     	
     	// Store the treeview into the session.
     	// This also synchronizes the new treeview node state (open or close)
     	// with the previous state.
     	LayoutUtils.addMenuIntoSession(request, lc_menu);
     	
     	// If a news is selected, display it.
     	String lc_newsId = request.getParameter("newsId");
     	if (lc_newsId!=null) {
     		Categories lc_news = CategoryData.getCategoryByPrimaryKey(lc_newsId);
     		CategoriesForm lc_form = (CategoriesForm) form;
     		lc_form.setId(lc_news.getId());
     		lc_form.setTitle(lc_news.getTitle());
     		lc_form.setSubject(lc_news.getProduct().getId());
     		lc_form.setBody(lc_news.getBody());
     		
	        request.setAttribute("subjects", CategoryData.getAllProducts());
     	}
     	    	
     	
     	
    	}catch(Exception e){System.out.println("Error:==>"+e);}
    	
     	return mapping.findForward("treeview");
     	
    	
    }
    
  
    private MenuComponent createChildMenu(MenuComponent in_parent, String in_title,String in_id) {
    	MenuComponent lc_child = new MenuComponent(in_id);
 		in_parent.addMenuComponent(lc_child);
 		lc_child.setTitle(in_title);
 		return lc_child;
    }
 
}