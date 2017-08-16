package roseindia.web.common;

import java.security.InvalidParameterException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Collections;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


import javax.sql.*;

import javax.naming.*;

import roseindia.web.common.Products;

/*
* this class load category data at the menu

*/
public class CategoryData {
	
	/**
	 * allTheCategory  map
	 */
	
	private static Map allTheCategory = new Hashtable();
	
	
	private int categoryId;
	
	/**
	 * allTheProducts  map
	 */
	private static Map allTheProducts = new Hashtable();
	
	/**
	 * Last product id.
	 */
	private int productId;
	

	public void loadData(Connection conn){
    	
    	try{  
    		
    		
	  	  ResultSet rs;
	  	  ResultSet rs1=null;
	  	  ResultSet rs2=null;
			
			
	  	  Statement smt = conn.createStatement();
    	
	  	  String query="select * from category where parentid=0 order by categoryname";

          String sql = "select categoryname,categoryid from category where parentid= ?";
          PreparedStatement pstmt = conn.prepareStatement(sql);

		  String sql_product = "select productname,productid from product where categoryid= ?";
          PreparedStatement pstmt_product = conn.prepareStatement(sql_product);

	  	  rs=smt.executeQuery(query);  	
    		
		    Products s=null;

			while (rs.next()) {
				         
                  pstmt.setInt(1, rs.getInt("categoryid"));                  
                      			  
				  rs1=pstmt.executeQuery();		  
				  				  
				  while(rs1.next()){
				  			  
				   s = addProduct(rs1.getString(1), "General category concerning Struts-Layout", true, 1);
				   
				   pstmt_product.setInt(1, rs1.getInt(2));
				   rs2=pstmt_product.executeQuery();
				   
				   while(rs2.next()){
				  
                    categoryId=rs2.getInt(2);
				   addCategory(rs2.getString(1), s, "Columns are now sortable !", rs.getString("categoryname"),categoryId);
				   		   
				  }
				   
				   
				  
				}
				  
			}
		
			
			
			rs2.close();
			rs1.close();
			
			rs.close();
			
			pstmt_product.close();
			pstmt.close();
			smt.close();

			
    	}catch(Exception e){System.out.println("Error:"+e);}
    }   
    
	/**
	 * Check a String for null or empty.
	 */
    private  boolean checkNullOrEmpty(String in_string) {
        boolean l_isNullOrEmpty = false;
        if(in_string == null || in_string.equals(""))
            l_isNullOrEmpty = true;
        return l_isNullOrEmpty;
    }
	


	
//Add a new category. Used internally.

    private synchronized void addCategory(String in_title, Products in_subject, String in_body, String in_date,int categoryId) throws InvalidParameterException {
        Categories l_news = null;
        if(checkNullOrEmpty(in_title))
            throw new InvalidParameterException("Database.addCategory : parametre in_title invalide");
        if(in_subject==null)
            throw new InvalidParameterException("Database.addCategory : parametre in_title invalide");
        if(checkNullOrEmpty(in_body)) {
            throw new InvalidParameterException("Database.addCategory : parametre in_title invalide");
        } else {
            l_news = new Categories();
            l_news.setTitle(in_title);
            l_news.setProduct(in_subject);
            l_news.setBody(in_body);
            l_news.setDate(in_date);
            
            String l_id = String.valueOf(categoryId);
            l_news.setId(l_id);
            allTheCategory.put(l_id, l_news);
            return;
        }
    }
    
    public synchronized Products addProduct(String in_name, String in_description, boolean in_active, int in_priority) throws InvalidParameterException {
    	if (checkNullOrEmpty(in_name))
    		throw new InvalidParameterException("Categories.addProduct : parametre in_name invalide");
    	if (checkNullOrEmpty(in_description))
    		throw new InvalidParameterException("Categories.addProduct : parametre in_description invalide");
    	
    	Products lc_product = new Products();
    	lc_product.setName(in_name);
    	lc_product.setDescription(in_description);
    	lc_product.setActive(in_active);
    	lc_product.setPriority(in_priority);
    	
    	lc_product.setId(String.valueOf(productId));
    	allTheProducts.put(lc_product.getId(), lc_product);
    	return lc_product;
    }



    public List getAllCategory() {
        return new ArrayList(allTheCategory.values());
    }
    
    public static List getAllProducts() {    	
    	return new ArrayList(allTheProducts.values());
    }

    public static Categories getCategoryByPrimaryKey(String in_idNews) {        
        Categories l_result = (Categories) allTheCategory.get(in_idNews);
        return l_result;
    }
    
    public List getNewsBySubject(Products in_subject) {
    	if (in_subject==null) {
    		return Collections.EMPTY_LIST;
    	}
    	
    	List lc_list = getAllCategory();
    	Iterator lc_it = lc_list.iterator();
    	while (lc_it.hasNext()) {
    		Categories lc_news = (Categories) lc_it.next();
    		if (!in_subject.equals(lc_news.getProduct())) {
    			lc_it.remove();
    		}    		
    	}
    	return lc_list;
    }
    
    public Products getProductByPrimaryKey(String in_productId) {
    	if (in_productId==null) {
    		return null;
    	} else {    	
    		return (Products) allTheProducts.get(in_productId);
    	}
    }
	
	public Products getProductByName(String in_productName) {
		if (in_productName==null) {
			return null;
		} else {
			Iterator lc_it = allTheProducts.values().iterator(); 
			while (lc_it.hasNext()) {
				Products lc_product = (Products) lc_it.next();
				if (lc_product.getName().equalsIgnoreCase(in_productName)) {
					return lc_product;
				}
			}
		}
		return null;
	}
	
}
