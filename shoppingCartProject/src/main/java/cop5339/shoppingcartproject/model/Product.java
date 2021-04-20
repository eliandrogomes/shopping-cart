package cop5339.shoppingcartproject.model;

import java.io.Serializable;

/**
 *
 * @author eliandro
 */
public class Product implements Serializable {
    private int code;
    private String name;
    private String description;
    private double unitPrice;

    public Product(int code, String name, String description, double unitPrice) {
        this.code = code;
        this.name = name;
        this.description = description;
        this.unitPrice = unitPrice;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }
    
}
