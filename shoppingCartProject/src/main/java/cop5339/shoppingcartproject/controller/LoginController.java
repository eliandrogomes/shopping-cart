package cop5339.shoppingcartproject.controller;

import cop5339.shoppingcartproject.model.Account;
import cop5339.shoppingcartproject.model.CartProduct;
import cop5339.shoppingcartproject.model.Ecommerce;
import cop5339.shoppingcartproject.view.BuyerView;
import cop5339.shoppingcartproject.view.InventoryView;
import cop5339.shoppingcartproject.view.LoginView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import cop5339.shoppingcartproject.view.View;
import javax.swing.event.ChangeListener;

/**
 *
 * @author eliandro
 */
public class LoginController implements ActionListener, HistoryController {
    
    private Account model;
    private LoginView view;
    private View nextView;

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
            // verify if type account is seller or customer
            if (this.model.getAccountType().equals("seller")) {
                // seller
                this.nextView = InventoryView.getInstance();
            } else {
                // customer
                this.nextView = BuyerView.getInstance();
            }
            // add view observer to model
            this.model.addChangeListener((ChangeListener) this.nextView);
            this.model.setStatus("logged");
            // goto next screen
            History.getInstance().goForward(this.nextView);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void setNextView(View view) {
        this.nextView = view;
    }

    @Override
    public void updateUI() {
        view.validate();
    }    
    
}
