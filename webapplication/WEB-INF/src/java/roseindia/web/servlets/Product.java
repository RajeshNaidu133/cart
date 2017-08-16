package roseindia.web.servlets;
/*
 * bean class set and get product information
 */
public class Product {

	//identifier fields
	private String productName;
	private int quantity;
	private String costPerUnit;
	
	//setter and getter methods
	public String getCostPerUnit() {
		return costPerUnit;
	}
	public void setCostPerUnit(String costPerUnit) {
		this.costPerUnit = costPerUnit;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
}
