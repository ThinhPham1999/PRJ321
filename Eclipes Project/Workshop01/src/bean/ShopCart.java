package bean;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ShopCart implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private HashMap<Long, ProductLine> cartItems;
	 
    public ShopCart() {
        cartItems = new HashMap<>();
    }
 
    public ShopCart(HashMap<Long , ProductLine> cartItems) {
        this.cartItems = cartItems;
    }
 
    public HashMap<Long, ProductLine> getCartItems() {
        return cartItems;
    }
 
    public void setCartItems(HashMap<Long, ProductLine> cartItems) {
        this.cartItems = cartItems;
    }
    
    public void insertToCart(Long key, ProductLine item) {
        boolean bln = cartItems.containsKey(key);
        if (bln) {
             ProductLine olditem= cartItems.get(key);
             int oldquantity = olditem.getQuatity();
             olditem.setQuatity(oldquantity + 1);
             cartItems.put((long)item.getProduct().getID(), olditem);
        } else {
        	item.setQuatity(1);
            cartItems.put((long)item.getProduct().getID(), item);
        }
    }
    
    public int total() {
    	int tmp = 0;
    	Iterator interator = cartItems.entrySet().iterator();
    	while(interator.hasNext()) {
    		Map.Entry<Long, ProductLine> cartItem2 = (Map.Entry<Long, ProductLine>)interator.next();
    		tmp = tmp + cartItem2.getValue().getQuatity() * cartItem2.getValue().getProduct().getPrice();
    	}
    	return tmp;
    }
}
