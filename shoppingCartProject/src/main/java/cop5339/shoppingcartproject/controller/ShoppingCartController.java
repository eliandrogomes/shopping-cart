package cop5339.shoppingcartproject.controller;

import cop5339.shoppingcartproject.model.Account;
import cop5339.shoppingcartproject.model.Ecommerce;
import cop5339.shoppingcartproject.model.InventoryProduct;
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
public class ShoppingCartController implements ActionListener, HistoryController {
    
    private Account model;
    private InventoryView view;
    private View nextView;

    public ShoppingCartController(InventoryView view, Account model) {
        super();
        this.view = view;
        this.model = model;
        // add view observer to model
        this.model.addChangeListener(view);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Ecommerce app = Ecommerce.getInstance();
        try {
            // get user logged
            InventoryProduct inventoryProduct = (InventoryProduct) e.getSource();
            this.model.getShoppingCart().addProduct(inventoryProduct.getProduct(), inventoryProduct.getSeller(), 1);
            // goto next screen
            // History.getInstance().goForward(view.getNextView());
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
