package cop5339.shoppingcartproject.model;

import cop5339.shoppingcartproject.model.Product;
import java.io.Serializable;

/**
 *
 * @author eliandro
 */
public class InventoryProduct implements Serializable {
    private Product product;
    private int quantity;
    private int reservedQuantity;

    public InventoryProduct(Product product, int quantity, int reservedQuantity) {
        this.product = product;
        this.quantity = quantity;
        this.reservedQuantity = reservedQuantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public synchronized void updateQuantity(int quantity) {
        this.quantity += quantity;
    }
    
    public synchronized void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getReservedQuantity() {
        return reservedQuantity;
    }

    public synchronized void setReservedQuantity(int reservedQuantity) {
        this.reservedQuantity = reservedQuantity;
    }
    
    public synchronized void updateReservedQuantity(int reservedQuantity) {
        this.reservedQuantity += reservedQuantity;
    }
    
}
