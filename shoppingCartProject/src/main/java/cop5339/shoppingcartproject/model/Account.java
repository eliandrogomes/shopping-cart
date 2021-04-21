package cop5339.shoppingcartproject.model;

import java.io.Serializable;
import java.util.ArrayList;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *
 * @author eliandro
 */
public class Account implements Serializable {
    private ArrayList<ChangeListener> listeners;
    
    private User user;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String status;
    private Address address;

    public Account(User user, String firstName, String lastName) {
        this.listeners = new ArrayList<ChangeListener>();
        this.user = user;
        this.firstName = firstName;
        this.lastName = lastName;
        this.status = "logout";
    }

    public Account() {
        this.listeners = new ArrayList<ChangeListener>();
        this.status = "logout";
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    /**
     * Update the user status. It notifies all registered views (change listeners).
     * @param status 
     */
    public void setStatus(String status) {
        this.status = status;
        // notify observers
        ChangeEvent event = new ChangeEvent(this);
        for (ChangeListener e: listeners) {
            e.stateChanged(event);
        }
    }
    
    public String getStatus() {
        return this.status;
    }
    
    public String getAccountType() {
        return this.user.getClass().getTypeName();
    }
    
    /**
     * Add a listener (view -- observer)
     * @param cl
     */
    public void addChangeListener(ChangeListener cl) {
        this.listeners.add(cl);
    }
    
}
