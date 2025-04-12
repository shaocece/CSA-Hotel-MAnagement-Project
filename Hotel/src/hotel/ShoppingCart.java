package hotel;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

public class ShoppingCart {
    private HashMap<String, Double> cart;

    public ShoppingCart() {
        cart = new HashMap<String,Double>();
    }

    // Add item to cart
    public void addItem(String item, double price) 
    {
        cart.put(item, price);
    }

    // Remove item from cart
    public void removeItem(String item) 
    {
        if (cart.containsKey(item)) 
        {
            cart.remove(item);
            System.out.println(item + " removed from cart.");
        } 
        else 
        {
            System.out.println(item + " not found in cart.");
        }
    }

    //calculate total price
    public double getTotalPrice() {
        double total = 0.0;
        for (double price : cart.values()) {
            total += price;
        }
        return total;
    }
    
    //num of items
    public int getSize()
    {
    	return cart.size();
    }
    
    //return all entry sets
    public Set<Entry<String, Double>> getEntrySets()
    {
    	return cart.entrySet();
    }
    
    public String toString()
    {
    	return cart.toString();
    }

}
