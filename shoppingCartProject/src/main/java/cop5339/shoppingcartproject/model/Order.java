package cop5339.shoppingcartproject.model;

import java.beans.Transient;
import java.io.Serializable;

/**
 *
 * @author eliandro
 * @todo enum for status
 */
public class Order implements Serializable {
    private double total;
    private String status;
    private ShoppingCart shoppingCart;
    private Transaction transaction;
    private Address billingAddress;

    public Order(double total, String status, ShoppingCart shoppingCart, Transaction transaction, Address billingAddress) {
        this.total = total;
        this.status = status;
        this.shoppingCart = shoppingCart;
        this.transaction = transaction;
        this.billingAddress = billingAddress;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }

    public Address getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(Address billingAddress) {
        this.billingAddress = billingAddress;
    }
    
    @Transient
    public void showDetails() {
        // return order details
    }
    
    
}
