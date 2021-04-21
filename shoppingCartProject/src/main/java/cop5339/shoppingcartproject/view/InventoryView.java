package cop5339.shoppingcartproject.view;

import cop5339.shoppingcartproject.model.Account;
import cop5339.shoppingcartproject.model.Ecommerce;
import cop5339.shoppingcartproject.model.Inventory;
import cop5339.shoppingcartproject.model.InventoryProduct;
import javax.swing.event.ChangeListener;
import java.util.Iterator;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.event.ChangeEvent;

/**
 * List of seller's products
 * @author eliandro
 */
public class InventoryView extends JPanel implements ChangeListener, View {

    private View nextView;
    private Account model;
    
    private static final InventoryView instance = new InventoryView();    
    public static InventoryView getInstance() {
        return instance;
    }
    
    private InventoryView() {
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
            this.add(new LoggedView(this.model));

            Iterator<Inventory> it = app.getInventories().iterator();
            while (it.hasNext()) {
                Inventory inventory = it.next();
                Iterator<InventoryProduct> ip = inventory.getProducts().iterator();
                while (ip.hasNext()) {
                    InventoryProduct inventoryProduct = ip.next();
                    this.add(new ProductView(inventoryProduct));
                }
            }
        } else {
            // perform logout
        }
    }
    
    @Override
    public void stateChanged(ChangeEvent e) {
        setModel((Account) e.getSource());
        update();
    }
    
}
