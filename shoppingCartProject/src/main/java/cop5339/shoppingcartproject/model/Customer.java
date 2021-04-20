package cop5339.shoppingcartproject.model;

import java.io.Serializable;

/**
 *
 * @author eliandro
 */
public class Customer extends User implements Serializable {

    public Customer(String username, String password) {
        super(username, password);
    }
    
}
