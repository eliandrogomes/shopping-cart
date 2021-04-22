package cop5339.shoppingcartproject.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author eliandro
 */
public class Inventory implements Serializable {
    private Seller seller;
    private ArrayList<InventoryProduct> products;

    public Inventory(Seller seller) {
        this.seller = seller;
        this.products = new ArrayList<>();
    }

    public Seller getSeller() {
        return seller;
    }

    public ArrayList<InventoryProduct> getProducts() {
        return products;
    }
    
    public InventoryProduct addProduct(Product product, int quantity) {
        InventoryProduct inventoryProduct = new InventoryProduct(seller, product, quantity, 0);
        this.products.add(inventoryProduct);
        return inventoryProduct;
    }
    
    /**
     * Remove only one product unit or reference of product if has only one unit
     * @param code
     * @return removed or changed product item
     */
    public InventoryProduct removeProduct(int code) {
        Iterator<InventoryProduct> it = products.iterator();
        while (it.hasNext()) {
            InventoryProduct item = it.next();
            if (item.getProduct().getCode() == code) {
                if (item.getQuantity() > 1) {
                    item.setQuantity(item.getQuantity() - 1);
                } else {
                    this.products.remove(item);
                }
                return item;
            }
        }
        // element not found and not removed
        return null;
    }
    
    /**
     * Remove all inventory products
     * @param code
     * @return 
     */
    public InventoryProduct removeAllProducts(int code) {
        Iterator<InventoryProduct> it = products.iterator();
        while (it.hasNext()) {
            InventoryProduct item = it.next();
            if (item.getProduct().getCode() == code) {
                this.products.remove(item);
                return item;
            }
        }
        // element not found and not removed
        return null;
    }
    
    /**
     * mark the product quantity as reserved by customer
     * @param product
     * @param quantity
     * @return 
     * @precondition the inventory must have enough items to reserved
     * @poscondition the inventory will have the actual reserved quantity + new quantity
     */
    public synchronized InventoryProduct reserveProduct(Product product, int quantity) {
        Iterator<InventoryProduct> it = products.iterator();
        while (it.hasNext()) {
            InventoryProduct item = it.next();
            if (item.getProduct().equals(product) && (item.getQuantity() - item.getReservedQuantity()) >= quantity) {
                item.updateReservedQuantity(quantity);
                return item;
            }
        }
        return null;
    }
    
    /**
     * Release a quantity of any product to other customer to buy
     * @param product
     * @param quantity
     * @return if was possible release the product to another customer
     */
    public boolean releaseProduct(Product product, int quantity) {
        Iterator<InventoryProduct> it = products.iterator();
        while (it.hasNext()) {
            InventoryProduct item = it.next();
            if (item.getProduct().equals(product) && (item.getReservedQuantity() >= quantity)) {
                item.updateReservedQuantity(quantity * -1);
                return true;
            }
        }
        return false;
    }
}
