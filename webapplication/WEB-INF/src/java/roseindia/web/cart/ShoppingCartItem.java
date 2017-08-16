package roseindia.web.cart;

/*
 * Bean class to set and get information about items in the shopping cart
 */
public class ShoppingCartItem {
	private int itemCode;
	private String itemName;
	private int qty;
	private double perItemCost;

	private double totalCost;
//update items in the shopping cart 
	public void update(int itemCode, int qty, double perItemCost) {

		setItemCode(itemCode);
		setQty(qty);
		setPerItemCost(perItemCost);
	}
//setter and getter methods
	public int getItemCode() {
		return itemCode;
	}

	public void setItemCode(int itemCode) {
		this.itemCode = itemCode;
	}

	public double getPerItemCost() {
		return perItemCost;
	}

	public void setPerItemCost(double perItemCost) {
		this.perItemCost = perItemCost;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public double getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}

}
