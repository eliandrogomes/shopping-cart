package cop5339.shoppingcartproject.controller;

import cop5339.shoppingcartproject.model.Account;
import cop5339.shoppingcartproject.model.Ecommerce;
import cop5339.shoppingcartproject.model.User;
import cop5339.shoppingcartproject.view.LoginView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author eliandro
 */
public class LoginController implements ActionListener {
    
    private Account model;
    private LoginView view;

    public LoginController(LoginView view, Account model) {
        super();
        this.view = view;
        this.model = model;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String username = view.getUsername().getText();
        String password = view.getPassword().getText();
        
        Ecommerce app = Ecommerce.getInstance();
        try {
            // get user logged
            this.model = app.getAccount(username, password);
            // goto next screen
            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
}
