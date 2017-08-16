package roseindia.web.cart;
import java.util.*;
/*
 * class to add items ,remove items and edit items in the shopping cart 
 * 
 */
public class ShoppingCart {
	protected int total;
	protected List<ShoppingCartItem> items;
	
	public ShoppingCart()
		{
			items = new ArrayList<ShoppingCartItem>();
			total = 0;
		}

		//	 Add a new item and update the total
		public void addItem(ShoppingCartItem newItem)
		{
			//See if there's already an item like this in the cart
			boolean currIndex = items.isEmpty();	
			if (currIndex) {
				//If the item is new, add it to the cart
				items.add(newItem);
			} else {
				Boolean itemExists=false;
				for (Iterator it = items.iterator (); it.hasNext (); ) {
				    Object o = it.next ();
				    ShoppingCartItem shop=(ShoppingCartItem)o;
				    if(shop.getItemCode() == newItem.getItemCode()){
				    	//update
				    	shop.update(newItem.getItemCode(), newItem.getQty(), newItem.getPerItemCost());
				    	itemExists=true;
				    }
				  }
				if(!itemExists)
					items.add(newItem);

				
			}
		}
	

	public void removeItem(int itemCode) {
		//Find item
		for(int i=0; i<items.size();i++ ) {
			    Object o = items.get(i);
			    ShoppingCartItem shop=(ShoppingCartItem)o;
			    if(shop.getItemCode()==itemCode){	
			    	//Remove item
			    	items.remove(i);
			    	break;
			    }  
		}
		
	}

	public List getItems() {	
		return items;	
	}
	
	

}
