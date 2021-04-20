package cop5339.shoppingcartproject.model;

import java.io.Serializable;

/**
 *
 * @author eliandro
 */
public class Seller extends User implements Serializable {

    public Seller(String username, String password) {
        super(username, password);
    }
}
