package roseindia.dao;

import java.util.Collection;
import java.util.List;


import org.springframework.dao.DataAccessException;

public interface ShoppingCartDAO {
	
	
	/**
	 * Retrieve all <code>true</code>/<code>false</code> from the datastore.
	 * @return a <code>true</code> or  <code>fase</code>.
	 */
	public boolean checkAdminLogin(String strUserName, String strPassword) throws DataAccessException,java.sql.SQLException;
   
	/**
	 * Retrieve all <code>true</code>/<code>false</code> from the datastore.
	 * @return a <code>true</code> or  <code>fase</code>.
	 */
	public boolean checkUserLogin(String strUserName, String strPassword) throws DataAccessException,java.sql.SQLException;
   
	
	
	/**
	 * Retrieve all <code>true</code>/<code>false</code> from the datastore.
	 * @return a <code>true</code> or  <code>fase</code>.
	 */
	//public boolean checkValidUserName(String strUserid) throws DataAccessException,java.sql.SQLException;
	
	
	

	/**
	 * Retrieve all <code>true</code>/<code>false</code> from the datastore.
	 * @return a <code>true</code> or  <code>fasel</code>.
	 */
	public int getUserId(String strUserid) throws DataAccessException,java.sql.SQLException;
	
	
	/**
	 * Saves User object to the datastore.
	 *
	 */
	public void addUser(roseindia.dao.hibernate.User obj) throws DataAccessException;


	/**
	 * Update User object ot the datastore.
	 *
	 */
	public void updateUser(roseindia.dao.hibernate.User obj) throws DataAccessException;


	/**
	 * Retrieve <code>User</code> from the datastore.
	 * @return User.
	 */
	public roseindia.dao.hibernate.User loadUser(String id) throws DataAccessException;

    
	/**
	 * Retrieve all <code>true</code>/<code>false</code> from the datastore.
	 * @return a <code>true</code> or  <code>fasel</code>.
	 */
	public boolean checkValidUserName(String strUserName) throws DataAccessException,java.sql.SQLException;
	
	/**
	 * Retrieve <code>Country Name</code>s from the datastore.
	 * @return a <code>Collection</code> of Country.
	 */
	//public Collection getProductList() throws DataAccessException,java.sql.SQLException;


	/**
	 * Retrieve <code>Country Name</code>s from the datastore.
	 * @return a <code>Collection</code> of Country.
	 */
	//public Collection getParentCategoryList() throws DataAccessException,java.sql.SQLException;
	
	
	/**
	 * Retrieve <code>Tutcategory</code>s from the datastore.
	 * @return a <code>Collection</code> of Tutcategory.
	 */
	public Collection getCategoryByParentId(String id) throws DataAccessException;
	
	/**
	 * Retrieve <code>Tutcategory</code>s from the datastore.
	 * @return a <code>Collection</code> of Tutcategory.
	 */
	public Collection getPriceDetail(String id) throws DataAccessException,java.sql.SQLException;
	
	
	/**
	 * Retrieve <code>Tutcategory</code>s from the datastore.
	 * @return a <code>Collection</code> of Tutcategory.
	 */
	public Collection getProductDetail(String id) throws DataAccessException,java.sql.SQLException;
	
	/**
	 * Saves Orderedcart object to the datastore.
	 *
	 */
	public void addOrderedcart(roseindia.dao.hibernate.Orderedcart obj) throws DataAccessException;


	/**
	 * Update Orderedcart object ot the datastore.
	 *
	 */
	public void updateOrderedcart(roseindia.dao.hibernate.Orderedcart obj) throws DataAccessException;


	
	/**
	 * Retrieve <code>Orderedcart</code> from the datastore.
	 * @return Orderedcart.
	 */
	public roseindia.dao.hibernate.Orderedcart loadOrderedcart(String id) throws DataAccessException;
	
	
	/**
	 * Retrieve <code>Orderedcart</code> from the datastore.
	 * @return Orderedcart.
	 */
	public roseindia.dao.hibernate.Product loadProductToCart(String id) throws DataAccessException;
	
	
	/**
	 * Saves Category object to the datastore.
	 *
	 */
	public void addCategory(roseindia.dao.hibernate.Category obj) throws DataAccessException;


	/**
	 * Update Category object ot the datastore.
	 *
	 */
	public void updateCategory(roseindia.dao.hibernate.Category obj) throws DataAccessException;


	/**
	 * Retrieve <code>Category</code> from the datastore.
	 * @return Category.
	 */
	public roseindia.dao.hibernate.Category loadCategory(String id) throws DataAccessException;
	
    /*
     * check valid category name
     */
	public boolean checkValidCategoryName(String strCategoryName) throws DataAccessException,java.sql.SQLException;
	
	/*
     * check valid product name
     */
	public boolean checkValidProductName(String strProductName) throws DataAccessException,java.sql.SQLException;
	
	/*
     * find maximum category id 
     */
	public int getMaxCategoryId()throws DataAccessException,java.sql.SQLException;
	
	
	/**
	 * Retrieve <code>View Order</code>s from the datastore.
	 * @return a <code>Collection</code> of View Order.
	 */
	public Collection getOrderDetail() throws DataAccessException,java.sql.SQLException;
	
	
	/**
	 * Saves Adminuser object to the datastore.
	 *
	 */
	public void addAdminuser(roseindia.dao.hibernate.Adminuser obj) throws DataAccessException;


	/**
	 * Update Adminuser object ot the datastore.
	 *
	 */
	public void updateAdminuser(roseindia.dao.hibernate.Adminuser obj) throws DataAccessException;


	/**
	 * Retrieve <code>Adminuser</code> from the datastore.
	 * @return Adminuser.
	 */
	public roseindia.dao.hibernate.Adminuser loadAdminuser(String id) throws DataAccessException;

	/**
	 * Retrieve all <code>true</code>/<code>false</code> from the datastore.
	 * @return a <code>true</code> or  <code>fasel</code>.
	 */
	//public boolean recuriterpasswordChange(String recId,String newPassword,String oldPassword) throws DataAccessException,java.sql.SQLException;
     
   public boolean adminpasswordChange(String userid,String newPassword,String oldPassword) throws DataAccessException,java.sql.SQLException;
	
   
   /**
	 * Saves Config object to the datastore.
	 *
	 */
	public void addConfig(roseindia.dao.hibernate.Config obj) throws DataAccessException;


	/**
	 * Update Config object ot the datastore.
	 *
	 */
	public void updateConfig(roseindia.dao.hibernate.Config obj) throws DataAccessException;


	/**
	 * Retrieve <code>Config</code> from the datastore.
	 * @return Config.
	 */
	public roseindia.dao.hibernate.Config loadConfig(String id) throws DataAccessException;
   
   
	/**
	 * Retrieve <code>View Order</code>s from the datastore.
	 * @return a <code>Collection</code> of View Order.
	 */
	public Collection getAboutUs() throws DataAccessException,java.sql.SQLException;
	
	/**
	 * Retrieve <code>View Order</code>s from the datastore.
	 * @return a <code>Collection</code> of View Order.
	 */
	public Collection getShipDelInfo() throws DataAccessException,java.sql.SQLException;
	
	
	/**
	 * Retrieve all <code>true</code>/<code>false</code> from the datastore.
	 * @return a <code>true</code> or  <code>fasel</code>.
	 */
	public String getParentGategory(int pid) throws DataAccessException,java.sql.SQLException;
	
	/**
	 * Retrieve all <code>true</code>/<code>false</code> from the datastore.
	 * @return a <code>true</code> or  <code>fasel</code>.
	 */
	public int getParentId(String parentcategory) throws DataAccessException,java.sql.SQLException;
	
	
	/**
	 * Saves Product object to the datastore.
	 *
	 */
	public void addProduct(roseindia.dao.hibernate.Product obj) throws DataAccessException;
	
	

	/**
	 * Update Product object ot the datastore.
	 *
	 */
	public void updateProduct(roseindia.dao.hibernate.Product obj) throws DataAccessException;


	/**
	 * Retrieve <code>Product</code> from the datastore.
	 * @return Product.
	 */
	public roseindia.dao.hibernate.Product loadProduct(String id) throws DataAccessException;
	
	/**
	 * Retrieve <code>CurrencySymbol</code> from the datastore.
	 * @return CurrencySymbol.
	 */
	public String getCurrencySymbol() throws DataAccessException,java.sql.SQLException;
	 
	 /**
	 * return store name to the datastore.
	 *
	 */
	 public String getStoreName() throws DataAccessException,java.sql.SQLException;
	 
	 /**
		 * return cost per items to the datastore.
		 *
		 */
	 public double getCostPerItem(int productId) throws DataAccessException,java.sql.SQLException;
	
	 
	 
	 /**
		 * Saves Orders object to the datastore.
		 *
		 */
		public void addOrder(roseindia.dao.hibernate.Order obj) throws DataAccessException;
		
		
		/**
		 * Update Order object to the datastore.
		 *
		 */
		public void updateOrder(roseindia.dao.hibernate.Order obj) throws DataAccessException;
		
		/**
		 * Retrieve <code>Order</code> from the datastore.
		 * @return Order.
		 */
		public roseindia.dao.hibernate.Order loadOrder(String id) throws DataAccessException;
		

		/**
		 * Retrieve <code>List</code> from the datastore.
		 * @return Map.
		 */
		public List loadCategoryData() throws DataAccessException;
	
		
	
}

