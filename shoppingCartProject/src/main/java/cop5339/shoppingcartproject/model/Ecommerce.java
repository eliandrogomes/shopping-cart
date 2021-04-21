package cop5339.shoppingcartproject.model;

import cop5339.shoppingcartproject.model.Address;
import cop5339.shoppingcartproject.model.Seller;
import cop5339.shoppingcartproject.model.Transaction;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author eliandro
 */
public class Ecommerce implements Serializable {
    private final ArrayList<Inventory> inventories;
    private final ArrayList<Account> accounts;
    private static final Ecommerce instance = new Ecommerce();

    private Ecommerce() {
        inventories = new ArrayList<>();
        accounts = new ArrayList<>();
    }
    
    public static Ecommerce getInstance() {
        return instance;
    }
    
    public void addInventory(Inventory inventory) {
        inventories.add(inventory);
    }
    
    public void createAccount(Account account) {
        accounts.add(account);
    }

    public ArrayList<Inventory> getInventories() {
        return inventories;
    }
    
    /**
     * Get a specific seller inventory
     * @param seller
     * @return 
     */
    public Inventory getInventory(Seller seller) {
        Iterator<Inventory> it = inventories.iterator();
        while (it.hasNext()) {
            Inventory inventory = it.next();
            if (inventory.getSeller().equals(seller)) {
                return inventory;
            }
        }
        return null;
    }
    
    /**
     * Process the user login
     * @param username
     * @param password
     * @return 
     * @throws java.lang.Exception 
     */
    public Account getAccount(String username, String password) throws Exception {
        Iterator<Account> it = accounts.iterator();
        while (it.hasNext()) {
            Account account = it.next();
            if (account.getUser().getUsername().equals(username)) {
                if (account.getUser().getPassword().equals(password)) {
                    // successful login
                    return account;
                } else {
                    throw new Exception("Username or passwor invalid!");
                }
            }
        }
        throw new Exception("Account not found!");
    }
    
    /**
     * Process the customer payment
     * If billing address and card information is good, update the transaction status to PAID otherwise REFUSED
     * @param shoppingCart
     * @param transaction
     * @param billingAddress 
     */
    public void processPayment(ShoppingCart shoppingCart, Transaction transaction, Address billingAddress) {
        // update the status from transaction (PAID or REFUSED)
    }
    
}
