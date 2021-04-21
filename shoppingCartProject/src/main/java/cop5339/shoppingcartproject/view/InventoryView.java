package cop5339.shoppingcartproject.view;

import cop5339.shoppingcartproject.model.Ecommerce;
import cop5339.shoppingcartproject.model.Inventory;
import cop5339.shoppingcartproject.model.InventoryProduct;
import java.util.ArrayList;
import java.util.EventListener;
import java.util.Iterator;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * List of seller's products
 * @author eliandro
 */
public class InventoryView extends JPanel implements EventListener, Screen {

    private static final InventoryView instance = new InventoryView();    
    public static InventoryView getInstance() {
        return instance;
    }
    
    private InventoryView() {
        super();
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        // add a view for each product in the app
        Ecommerce app = Ecommerce.getInstance();
        Iterator<Inventory> it = app.getInventories().iterator();
        while (it.hasNext()) {
            Iterator<InventoryProduct> ip = it.next().getProducts().iterator();
            while (ip.hasNext()) {
                this.add(new ProductView(ip.next()));
            }
        }
    }
    
}
