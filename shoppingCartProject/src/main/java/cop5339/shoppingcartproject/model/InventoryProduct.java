package cop5339.shoppingcartproject.model;

import java.io.Serializable;
import java.util.ArrayList;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *
 * @author eliandro
 */
public class InventoryProduct implements Serializable {
    private ArrayList<ChangeListener> listeners;
    private Seller seller;
    private Product product;
    private int quantity;
    private int reservedQuantity;

    public InventoryProduct(Seller seller, Product product, int quantity, int reservedQuantity) {
        this.listeners = new ArrayList<ChangeListener>();
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
        update();
    }
    
    public synchronized void setQuantity(int quantity) {
        this.quantity = quantity;
        update();
    }

    public int getReservedQuantity() {
        return reservedQuantity;
    }

    public synchronized void setReservedQuantity(int reservedQuantity) {
        this.reservedQuantity = reservedQuantity;
        update();
    }
    
    public synchronized void updateReservedQuantity(int reservedQuantity) {
        this.reservedQuantity += reservedQuantity;
        update();
    }
    
    public void removeListeners() {
        this.listeners = new ArrayList<ChangeListener>();
    }
    
    /**
     * Add a listener (view -- observer)
     * @param cl
     */
    public void addChangeListener(ChangeListener cl) {
        this.listeners.add(cl);
    }
    
    public void update() {
        // notify observers
        ChangeEvent event = new ChangeEvent(this);
        for (ChangeListener e: listeners) {
            e.stateChanged(event);
        }
    }
    
}
