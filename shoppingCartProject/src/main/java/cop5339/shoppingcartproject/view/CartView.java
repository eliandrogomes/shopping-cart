package cop5339.shoppingcartproject.view;

import cop5339.shoppingcartproject.controller.History;
import cop5339.shoppingcartproject.model.Account;
import cop5339.shoppingcartproject.model.CartProduct;
import cop5339.shoppingcartproject.model.Ecommerce;
import java.awt.Color;
import java.awt.Event;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.event.ChangeListener;
import java.util.Iterator;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.event.ChangeEvent;

/**
 * List of seller's products
 * @author eliandro
 */
public class CartView extends JPanel implements ChangeListener, View {

    private View nextView;
    private Account model;
    
    private static final CartView instance = new CartView();    
    public static CartView getInstance() {
        return instance;
    }
    
    private CartView() {
        super();
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.update();
    }

    public Account getModel() {
        return model;
    }

    public void setModel(Account model) {
        this.model = model;
    }
    
    @Override
    public void setNextView(View v) {
        this.nextView = v;
    }

    @Override
    public View getNextView() {
        return this.nextView;
    }
    
    @Override
    public void update() {
        if (this.model != null && this.model.getStatus().equals("logged")) {
            // add a view for each product in the app
            Ecommerce app = Ecommerce.getInstance();
            this.removeAll();

            // used when the user login in the system
            LoggedView loggedView = LoggedView.getInstance();
            loggedView.setModel(model);
            this.add(loggedView);
            
            JLabel total = new JLabel("TOTAL: " + model.getShoppingCart().calculate());
            this.add(total);
            
            JButton goBackButton = new JButton("Back");
            goBackButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    History.getInstance().goForward(BuyerView.getInstance());
                    BuyerView.getInstance().update();                    
                }
            });
            this.add(goBackButton);
            
            Iterator<CartProduct> it = model.getShoppingCart().getProducts().iterator();
            while (it.hasNext()) {
                CartProduct cartProduct = it.next();
                this.add(new CartProductView(cartProduct));
            }
        }
    }
    
    @Override
    public void stateChanged(ChangeEvent e) {
        setModel((Account) e.getSource());
        update();
    }
    
}
