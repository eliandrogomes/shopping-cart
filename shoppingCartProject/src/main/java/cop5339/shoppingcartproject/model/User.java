package cop5339.shoppingcartproject.model;

import java.util.ArrayList;
import java.util.EventListener;

/**
 *
 * @author eliandro
 */
public abstract class User {
    private ArrayList<EventListener> listeners;
    private String username;
    private String password;

    public User() {
    }
    
    public User(String username, String password) {
        listeners = new ArrayList<EventListener>();
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    /**
     * Add a listener (view -- observer)
     * @param e
     */
    public void addEventListener(EventListener e) {
        listeners.add(e);
    }    
    
}
