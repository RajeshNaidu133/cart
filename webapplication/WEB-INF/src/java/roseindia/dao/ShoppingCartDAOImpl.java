package roseindia.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import java.util.Date;

import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import roseindia.web.common.PriceDetail;

import roseindia.web.common.OrderDetail;
import roseindia.web.common.CategoryData;

import roseindia.web.common.AboutUs;
import roseindia.web.common.ShippingDelivery;

import roseindia.dao.hibernate.*;

//Java Imports
import java.sql.*;

/**
 * Hibernate implementation of the JobModule interface.
 */
public class ShoppingCartDAOImpl extends HibernateDaoSupport implements
		ShoppingCartDAO {

	// load category data in the tree menu
	public List loadCategoryData() throws DataAccessException {
		CategoryData cData = new CategoryData();
		try {
			Connection conn = this.getSession().connection();
			cData.loadData(conn);
			conn.close();

		} catch (java.sql.SQLException e) {
			System.out.println(e.getMessage());
		}
		return cData.getAllCategory();
	}

	// check admin login

	public boolean checkAdminLogin(String strUserName, String strPassword)
			throws DataAccessException, java.sql.SQLException {
		boolean valid = false;
		Connection conn = this.getSession().connection();
		// Write jdbc code to validate the user against database
		Statement smt = conn.createStatement();
		ResultSet rs;
		// write select query for checking password

		String query = "select id from adminuser where userid='" + strUserName
				+ "' and password='" + strPassword + "'";
		rs = smt.executeQuery(query);
		conn.close();
		if (rs.next() == true) {
			valid = true;
			return valid;
		} else {
			return valid;
		}

	}

	// check user login

	public boolean checkUserLogin(String strUserName, String strPassword)
			throws DataAccessException, java.sql.SQLException {
		boolean valid = false;
		Connection conn = this.getSession().connection();
		// Write jdbc code to validate the user against database
		Statement smt = conn.createStatement();
		ResultSet rs;
		// write select query for checking password

		String query = "select id from user where userid='" + strUserName
				+ "' and password='" + strPassword + "'";
		rs = smt.executeQuery(query);
		conn.close();
		if (rs.next() == true) {
			valid = true;
			return valid;
		} else {
			return valid;
		}

	}

	// check valid user name
	public boolean checkValidUserName(String strUserid)
			throws DataAccessException, java.sql.SQLException {
		boolean valid = false;
		Connection conn = this.getSession().connection();
		// Write jdbc code to validate the user against database
		Statement smt = conn.createStatement();
		ResultSet rs;
		// write select query for checking password

		String query = "select id from user where userid='" + strUserid + "'";
		rs = smt.executeQuery(query);

		if (rs.next() == true) {

			valid = true;
			return valid;
		} else {
			return valid;
		}

	}
//get user id
	public int getUserId(String strUserid) throws DataAccessException,
			java.sql.SQLException {

		Connection conn = this.getSession().connection();
		// Write jdbc code to validate the user against database
		Statement smt = conn.createStatement();
		ResultSet rs;
		// write select query for checking password

		System.out.println("Userid:" + strUserid);

		String query = "select id from user where userid='" + strUserid + "'";
		rs = smt.executeQuery(query);
		rs.next();

		int id = rs.getInt("id");

		System.out.println("ID:" + id);

		return id;
	}

	//get category by parent id
	public Collection getCategoryByParentId(String id)
			throws DataAccessException {
		return getHibernateTemplate().find(
				"from Category category where category.parentid = '" + id
						+ "'order by category.categoryname");
	}

	// show price details
	public Collection getPriceDetail(String id) throws DataAccessException,
			java.sql.SQLException {

		ArrayList<PriceDetail> list = new ArrayList<PriceDetail>();

		Connection conn = this.getSession().connection();

		// Write jdbc code to validate the user against database
		Statement smt = conn.createStatement();

		ResultSet rs = null;
		// ResultSet rs_c=null;

		String query = "SELECT * FROM product WHERE categoryid=" + id + "";

		
		rs = smt.executeQuery(query);

		

		while (rs.next()) {

			PriceDetail pricedetail = new PriceDetail();

			int pid = rs.getInt("productid");
			pricedetail.setProductid(new Integer(pid));

			int cid = rs.getInt("categoryid");
			pricedetail.setCategoryid(cid);

			String pname = rs.getString("productname");
			if (pname == null)
				pname = "";
			pricedetail.setProductname(pname);

			String pprice = rs.getString("productprice");
			if (pprice == null)
				pprice = "";
			pricedetail.setProductprice(pprice);

			String lprice = rs.getString("listprice");
			if (lprice == null)
				lprice = "";
			pricedetail.setListprice(lprice);

			String iname = rs.getString("imagename");
			if (iname == null)
				iname = "";
			pricedetail.setImagename(iname);

			String quant = rs.getString("quantity");

			if (quant == null)
				quant = "";
			pricedetail.setQuantity(quant);

			String desc = rs.getString("description");
			if (desc == null)
				desc = "";
			pricedetail.setDescription(desc);

			String bdesc = rs.getString("briefdisc");
			if (bdesc == null)
				bdesc = "";
			pricedetail.setBriefdisc(bdesc);

			list.add(pricedetail);

		}

		rs.close();
		smt.close();
		conn.close();

		return list;
	}

	// for product large view

	// show price details
	public Collection getProductDetail(String id) throws DataAccessException,
			java.sql.SQLException {

		ArrayList<PriceDetail> list = new ArrayList<PriceDetail>();

		Connection conn = this.getSession().connection();

		// Write jdbc code to validate the user against database
		Statement smt = conn.createStatement();

		ResultSet rs = null;
		// ResultSet rs_c=null;

		String query = "SELECT * FROM product WHERE productid=" + id + "";

		rs = smt.executeQuery(query);

		while (rs.next()) {

			PriceDetail pricedetail = new PriceDetail();

			int pid = rs.getInt("productid");
			pricedetail.setProductid(new Integer(pid));

			int cid = rs.getInt("categoryid");
			pricedetail.setCategoryid(cid);

			String pname = rs.getString("productname");
			if (pname == null)
				pname = "";
			pricedetail.setProductname(pname);

			String pprice = rs.getString("productprice");
			if (pprice == null)
				pprice = "";
			pricedetail.setProductprice(pprice);

			String lprice = rs.getString("listprice");
			if (lprice == null)
				lprice = "";
			pricedetail.setListprice(lprice);

			String iname = rs.getString("imagename");
			if (iname == null)
				iname = "";
			pricedetail.setImagename(iname);

			String quant = rs.getString("quantity");

			if (quant == null)
				quant = "";
			pricedetail.setQuantity(quant);

			String desc = rs.getString("description");
			if (desc == null)
				desc = "";
			pricedetail.setDescription(desc);

			String bdesc = rs.getString("briefdisc");
			if (bdesc == null)
				bdesc = "";
			pricedetail.setBriefdisc(bdesc);

			list.add(pricedetail);

		}

		rs.close();
		smt.close();
		conn.close();

		return list;
	}
	// add user
	public void addUser(roseindia.dao.hibernate.User obj)
			throws DataAccessException {
		getHibernateTemplate().save(obj);
	}

	// update user
	public void updateUser(roseindia.dao.hibernate.User obj)
			throws DataAccessException {
		getHibernateTemplate().update(obj);
	}
	// load user
	public roseindia.dao.hibernate.User loadUser(String id)
			throws DataAccessException {
		
		return (roseindia.dao.hibernate.User) getHibernateTemplate().get(
				User.class, new Integer(id));
	}

	// add edit ordered cart

	public void addOrderedcart(roseindia.dao.hibernate.Orderedcart obj)
			throws DataAccessException {
		getHibernateTemplate().save(obj);
	}
//update ordered cart
	public void updateOrderedcart(roseindia.dao.hibernate.Orderedcart obj)
			throws DataAccessException {
		getHibernateTemplate().update(obj);
	}
//load ordered cart
	public roseindia.dao.hibernate.Orderedcart loadOrderedcart(String id)
			throws DataAccessException {
		
		return (roseindia.dao.hibernate.Orderedcart) getHibernateTemplate()
				.get(Orderedcart.class, new Integer(id));
	}

	//load product to cart

	public roseindia.dao.hibernate.Product loadProductToCart(String id)
			throws DataAccessException {
				return (roseindia.dao.hibernate.Product) getHibernateTemplate().get(
				Product.class, new Integer(id));
	}
//add category
	public void addCategory(roseindia.dao.hibernate.Category obj)
			throws DataAccessException {
		getHibernateTemplate().save(obj);
	}
//update category
	public void updateCategory(roseindia.dao.hibernate.Category obj)
			throws DataAccessException {
		getHibernateTemplate().update(obj);
	}
//load category
	public roseindia.dao.hibernate.Category loadCategory(String id)
			throws DataAccessException {
		
		return (roseindia.dao.hibernate.Category) getHibernateTemplate().get(
				Category.class, new Integer(id));
	}
//check for valid category
	public boolean checkValidCategoryName(String strCategoryName)
			throws DataAccessException, java.sql.SQLException {
		boolean valid = false;
		Connection conn = this.getSession().connection();
		// Write jdbc code to validate the user against database
		Statement smt = conn.createStatement();
		ResultSet rs;
		// write select query for checking password

		String query = "select categoryid from category where categoryname='"
				+ strCategoryName + "'";
		rs = smt.executeQuery(query);

		if (rs.next() == true) {

			valid = true;

		} else {
			valid = false;
		}

		smt.close();
		rs.close();
		conn.close();

		return valid;
	}
//find max category id
	public int getMaxCategoryId() throws DataAccessException,
			java.sql.SQLException {

		Connection conn = this.getSession().connection();

		Statement smt = conn.createStatement();
		ResultSet rs;

		String query = "select max(categoryid)+1 as categoryid from category";
		rs = smt.executeQuery(query);
		rs.next();
		int categoryid = rs.getInt("categoryid");

		return categoryid;
	}

	// show price details
	public Collection getOrderDetail() throws DataAccessException,
			java.sql.SQLException {

		ArrayList list = new ArrayList();

		Connection conn = this.getSession().connection();

		// Write jdbc code to validate the user against database
		Statement smt = conn.createStatement();

		ResultSet rs = null;

		String query = "SELECT o.orderid,o.ordertime,o.custfirstname,o.custlastname,o.custemail,o.custcountry,o.custzip,o.custstate,o.custcity,o.custaddress,o.custphone,o.custfax,c.productname,c.price,c.quantity FROM orders as o,orderedcarts as c WHERE o.orderid=c.orderid";

		rs = smt.executeQuery(query);

		while (rs.next()) {

			OrderDetail orderdetail = new OrderDetail();

			int oid = rs.getInt("orderid");
			orderdetail.setOrderid(new Integer(oid));

			Date ot = rs.getDate("ordertime");
			orderdetail.setOrdertime(ot);

			String pname = rs.getString("productname");
			if (pname == null)
				pname = "";
			orderdetail.setProductname(pname);

			String fname = rs.getString("custfirstname");
			if (fname == null)
				fname = "";
			orderdetail.setCustfirstname(fname);

			String clname = rs.getString("custlastname");
			if (clname == null)
				clname = "";
			orderdetail.setCustlastname(clname);

			String cemail = rs.getString("custemail");
			if (cemail == null)
				cemail = "";
			orderdetail.setCustemail(cemail);

			String quant = rs.getString("quantity");
			if (quant == null)
				quant = "";
			orderdetail.setQuantity(quant);

			String cc = rs.getString("custcountry");
			if (cc == null)
				cc = "";
			orderdetail.setCustcountry(cc);

			String czip = rs.getString("custzip");
			if (czip == null)
				czip = "";
			orderdetail.setCustzip(czip);

			String cs = rs.getString("custstate");
			if (cs == null)
				cs = "";
			orderdetail.setCuststate(cs);

			String ccity = rs.getString("custcity");
			if (ccity == null)
				ccity = "";
			orderdetail.setCustcity(ccity);

			String caddress = rs.getString("custaddress");
			if (caddress == null)
				caddress = "";
			orderdetail.setCustaddress(caddress);

			String cphone = rs.getString("custphone");
			if (cphone == null)
				cphone = "";
			orderdetail.setCustphone(cphone);

			String cfax = rs.getString("custfax");
			if (cfax == null)
				cfax = "";
			orderdetail.setCustfax(cfax);

			String price = rs.getString("price");
			if (price == null)
				price = "";
			orderdetail.setPrice(price);

			list.add(orderdetail);

		}

		rs.close();
		smt.close();
		conn.close();

		return list;
	}
//add admin user
	public void addAdminuser(roseindia.dao.hibernate.Adminuser obj)
			throws DataAccessException {
		getHibernateTemplate().save(obj);
	}
	//update admin user
	public void updateAdminuser(roseindia.dao.hibernate.Adminuser obj)
			throws DataAccessException {
		getHibernateTemplate().update(obj);
	}
	//load admin user
	public roseindia.dao.hibernate.Adminuser loadAdminuser(String id)
			throws DataAccessException {

		return (roseindia.dao.hibernate.Adminuser) getHibernateTemplate().get(
				Adminuser.class, new Integer(id));
	}

	// change Admin Password

	public boolean adminpasswordChange(String userid, String newPassword,
			String oldPassword) throws DataAccessException,
			java.sql.SQLException {
		boolean valid = false;
		Connection conn = this.getSession().connection();
		// Write jdbc code to validate the user against database
		Statement smt = conn.createStatement();

		// write select query for checking password

		String query = "UPDATE adminuser SET password ='" + newPassword
				+ "' where userid='" + userid + "' and password='"
				+ oldPassword + "'";
		int rs = smt.executeUpdate(query);

		smt.close();
		conn.close();
		if (rs == 1) {
			valid = true;
			return valid;
		} else {
			return valid;
		}

	}
	//add config info
	public void addConfig(roseindia.dao.hibernate.Config obj)
			throws DataAccessException {
		getHibernateTemplate().save(obj);
	}
	//update config info
	public void updateConfig(roseindia.dao.hibernate.Config obj)
			throws DataAccessException {
		getHibernateTemplate().update(obj);
	}
	//load config info
	public roseindia.dao.hibernate.Config loadConfig(String id)
			throws DataAccessException {
		return (roseindia.dao.hibernate.Config) getHibernateTemplate().get(Config.class, new Integer(id));
	}

	// show price details
	public Collection getAboutUs() throws DataAccessException,
			java.sql.SQLException {

		ArrayList list = new ArrayList();

		Connection conn = this.getSession().connection();

		// Write jdbc code to validate the user against database
		Statement smt = conn.createStatement();

		ResultSet rs = null;

		String query = "SELECT aboutustext FROM config WHERE id=" + 1 + "";

		rs = smt.executeQuery(query);

		while (rs.next()) {

			AboutUs aboutus = new AboutUs();

			String abus = rs.getString("aboutustext");
			if (abus == null)
				abus = "";
			aboutus.setAboutustext(abus);

			list.add(aboutus);

		}

		rs.close();
		smt.close();
		conn.close();

		return list;
	}

	// show price details
	public Collection getShipDelInfo() throws DataAccessException,
			java.sql.SQLException {

		ArrayList list = new ArrayList();

		Connection conn = this.getSession().connection();

		// Write jdbc code to validate the user against database
		Statement smt = conn.createStatement();

		ResultSet rs = null;

		String query = "SELECT shipdeltext FROM config WHERE id=" + 1 + "";

		rs = smt.executeQuery(query);

		while (rs.next()) {

			ShippingDelivery shipDel = new ShippingDelivery();

			String shdel = rs.getString("shipdeltext");
			if (shdel == null)
				shdel = "";
			shipDel.setShipdeltext(shdel);

			list.add(shipDel);

		}

		rs.close();
		smt.close();
		conn.close();

		return list;
	}

	// get parent category

	public String getParentGategory(int pid) throws DataAccessException,
			java.sql.SQLException {

		Connection conn = this.getSession().connection();
		// Write jdbc code to validate the user against database
		Statement smt = conn.createStatement();
		ResultSet rs;
		// write select query for checking password

		String query = "select categoryname from category where categoryid="
				+ pid + "";
		rs = smt.executeQuery(query);
		rs.next();

		String catname = rs.getString("categoryname");

		conn.close();

		return catname;

	}

	// get parent category

	public int getParentId(String parentcategory) throws DataAccessException,
			java.sql.SQLException {

		Connection conn = this.getSession().connection();
		// Write jdbc code to validate the user against database
		Statement smt = conn.createStatement();
		ResultSet rs;
		// write select query for checking password

		String query = "select categoryid from category where categoryname='"
				+ parentcategory + "'";

		// System.out.println("Query:"+query);

		rs = smt.executeQuery(query);
		rs.next();

		int catid = rs.getInt("categoryid");

		conn.close();

		return catid;

	}

	// get CurrencySymbol

	public String getCurrencySymbol() throws DataAccessException,
			java.sql.SQLException {

		Connection conn = this.getSession().connection();
		// Write jdbc code to validate the user against database
		Statement smt = conn.createStatement();
		ResultSet rs;
		// write select query for checking password

		String query = "select cursymbol from config where id=" + 1 + "";

		// System.out.println("Query:"+query);

		rs = smt.executeQuery(query);
		rs.next();

		String cursymbol = rs.getString("cursymbol");

		conn.close();

		return cursymbol;

	}

	// get Store Name

	public String getStoreName() throws DataAccessException,
			java.sql.SQLException {

		Connection conn = this.getSession().connection();
		// Write jdbc code to validate the user against database
		Statement smt = conn.createStatement();
		ResultSet rs;
		// write select query for checking password

		String query = "select storename from config where id=" + 1 + "";

		// System.out.println("Query:"+query);

		rs = smt.executeQuery(query);
		rs.next();

		String storename = rs.getString("storename");

		conn.close();

		return storename;

	}
//check for valid product name
	public boolean checkValidProductName(String strProductName)
			throws DataAccessException, java.sql.SQLException {
		boolean valid = false;
		Connection conn = this.getSession().connection();
		// Write jdbc code to validate the user against database
		Statement smt = conn.createStatement();
		ResultSet rs;
		// write select query for checking password

		String query = "select productid from product where productname='"
				+ strProductName + "'";
		rs = smt.executeQuery(query);

		if (rs.next() == true) {

			valid = true;

		} else {
			valid = false;
		}

		smt.close();
		rs.close();
		conn.close();

		return valid;
	}
//add product
	public void addProduct(roseindia.dao.hibernate.Product obj)
			throws DataAccessException {
		getHibernateTemplate().save(obj);
	}
	//update product
	public void updateProduct(roseindia.dao.hibernate.Product obj)
			throws DataAccessException {
		getHibernateTemplate().update(obj);
	}
	//load product
	public roseindia.dao.hibernate.Product loadProduct(String id)
			throws DataAccessException {
		
		return (roseindia.dao.hibernate.Product) getHibernateTemplate().get(
				Product.class, new Integer(id));
	}
//get cost per item
	public double getCostPerItem(int productid) throws DataAccessException,
			java.sql.SQLException {

		Connection conn = this.getSession().connection();

		Statement smt = conn.createStatement();
		ResultSet rs;

		String query = "select productprice from product where productid ="
				+ productid + "";
		rs = smt.executeQuery(query);
		rs.next();
		double productprice = Double.parseDouble(rs.getString("productprice"));

		return productprice;
	}

	// add update and load Orders

	public void addOrder(roseindia.dao.hibernate.Order obj)
			throws DataAccessException {
		getHibernateTemplate().save(obj);
	}

	public void updateOrder(roseindia.dao.hibernate.Order obj)
			throws DataAccessException {
		getHibernateTemplate().update(obj);
	}

	public roseindia.dao.hibernate.Order loadOrder(String id)
			throws DataAccessException {

		return (roseindia.dao.hibernate.Order) getHibernateTemplate().get(
				Order.class, new Integer(id));
	}

}
