package cop5339.shoppingcartproject.model;

import cop5339.shoppingcartproject.model.Product;
import java.io.Serializable;

/**
 *
 * @author eliandro
 */
public class CartProduct implements Serializable {
    private Product product;
    private int quantity;

    public CartProduct(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
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

    public synchronized void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
}
