package cop5339.shoppingcartproject.model;

import cop5339.shoppingcartproject.model.Product;
import java.io.Serializable;

/**
 *
 * @author eliandro
 */
public class BundledProduct extends Product implements Serializable {

    private double quantity;
    
    public BundledProduct(int code, String name, String description, double unitPrice, double quantity) {
        super(code, name, description, unitPrice);
        this.quantity = quantity;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }
    
}
