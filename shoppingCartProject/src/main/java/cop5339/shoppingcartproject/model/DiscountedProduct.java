package cop5339.shoppingcartproject.model;

import cop5339.shoppingcartproject.model.Product;
import java.io.Serializable;

/**
 *
 * @author eliandro
 */
public class DiscountedProduct extends Product implements Serializable {

    private double percentualDiscount;
    
    public DiscountedProduct(int code, String name, String description, double unitPrice, double percentualDiscount) {
        super(code, name, description, unitPrice);
        this.percentualDiscount = percentualDiscount;
    }

    public double getPercentualDiscount() {
        return percentualDiscount;
    }

    public void setPercentualDiscount(double percentualDiscount) {
        this.percentualDiscount = percentualDiscount;
    }
    
    
    
}
