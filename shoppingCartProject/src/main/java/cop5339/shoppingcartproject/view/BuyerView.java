package cop5339.shoppingcartproject.view;

import cop5339.shoppingcartproject.model.Account;
import cop5339.shoppingcartproject.model.Ecommerce;
import cop5339.shoppingcartproject.model.Inventory;
import cop5339.shoppingcartproject.model.InventoryProduct;
import cop5339.shoppingcartproject.model.ShoppingCart;
import javax.swing.event.ChangeListener;
import java.util.Iterator;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.event.ChangeEvent;

/**
 * List of seller's products
 * @author eliandro
 */
public class BuyerView extends JPanel implements ChangeListener, View {

    private View nextView;
    private Account model;
    private ShoppingCart modelShoppingCart;
    
    private static final BuyerView instance = new BuyerView();    
    public static BuyerView getInstance() {
        return instance;
    }
    
    private BuyerView() {
        super();
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    }

    public Account getModel() {
        return model;
    }

    public void setModel(Account model) {
        this.model = model;
        // initialize shoppping cart
        this.modelShoppingCart = new ShoppingCart(model);
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

            Iterator<Inventory> it = app.getInventories().iterator();
            while (it.hasNext()) {
                Inventory inventory = it.next();
                Iterator<InventoryProduct> ip = inventory.getProducts().iterator();
                while (ip.hasNext()) {
                    InventoryProduct inventoryProduct = ip.next();
                    AvailableProductView availableProductView = new AvailableProductView(inventoryProduct, modelShoppingCart);
                    this.add(availableProductView);
                    inventoryProduct.removeListeners();
                    inventoryProduct.addChangeListener(availableProductView);
                }
            }
        }
    }
    
    @Override
    public void stateChanged(ChangeEvent e) {
        if (Account.class.isInstance(e.getSource())) {
            setModel((Account) e.getSource());
        }
        update();
    }
    
}
