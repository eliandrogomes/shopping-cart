package cop5339.shoppingcartproject.model;

import java.io.Serializable;

/**
 *
 * @author eliandro
 */
public class InventoryProduct implements Serializable {
    private Seller seller;
    private Product product;
    private int quantity;
    private int reservedQuantity;

    public InventoryProduct(Seller seller, Product product, int quantity, int reservedQuantity) {
        this.seller = seller;
        this.product = product;
        this.quantity = quantity;
        this.reservedQuantity = reservedQuantity;
    }

    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
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
