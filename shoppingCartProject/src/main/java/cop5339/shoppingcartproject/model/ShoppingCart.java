package cop5339.shoppingcartproject.model;

import cop5339.shoppingcartproject.model.Seller;
import cop5339.shoppingcartproject.model.Account;
import cop5339.shoppingcartproject.model.Product;
import cop5339.shoppingcartproject.model.CartProduct;
import cop5339.shoppingcartproject.model.InventoryProduct;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

/**
 *
 * @author eliandro
 */
public class ShoppingCart implements Serializable {
    private Account account;
    private Date createdAt;
    private Date cancelAt;
    private ArrayList<CartProduct> products;

    public ShoppingCart(Account account) {
        this.account = account;
        this.createdAt = new Date();
        this.products = new ArrayList<>();
    }
    
    public synchronized void addProduct(Product product, Seller seller, int quantity) throws Exception {
        Inventory inventory = Ecommerce.getInstance().getInventory(seller);
        // reserve item in the seller inventory
        InventoryProduct inventoryProduct = inventory.reserveProduct(product, quantity);
        if (inventoryProduct == null) {
            throw new Exception("Sorry, this item does not have in the inventory!");
        }                
        products.add(new CartProduct(product, quantity));
    }
    
    public CartProduct removeProduct(Product product, Seller seller, int quantity) {
        Inventory inventory = Ecommerce.getInstance().getInventory(seller);
        Iterator<CartProduct> it = products.iterator();
        while (it.hasNext()) {
            CartProduct item = it.next();
            if (item.getProduct().equals(product)) {
                if (item.getQuantity() >= quantity) {
                    item.setQuantity(item.getQuantity() - quantity);
                } else {
                    this.products.remove(item);
                }
                inventory.releaseProduct(product, quantity);
                return item;
            }
        }
        return null;
    }
    
    /**
     * Change the quantity of any product from the cart
     * @param product
     * @param seller
     * @param quantity 
     * @poscondition quantity > 0
     */
    public void changeProductQuantity(Product product, Seller seller, int quantity) {
        Iterator<CartProduct> it = products.iterator();
        while (it.hasNext()) {
            CartProduct item = it.next();
            if (item.getProduct().equals(product)) {
                item.setQuantity(quantity);
            }
        }
    }
    
    /**
     * Calculate the total of cart
     */
    public void calculate() {
        
    }
    
    /**
     * release all reserved products of the cart
     */
    public void abandon() {
        this.cancelAt = new Date();
        // @todo
    }
    
}
