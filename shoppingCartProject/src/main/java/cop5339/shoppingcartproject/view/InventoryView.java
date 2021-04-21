package cop5339.shoppingcartproject.view;

import cop5339.shoppingcartproject.model.Ecommerce;
import cop5339.shoppingcartproject.model.Inventory;
import cop5339.shoppingcartproject.model.InventoryProduct;
import java.awt.Dimension;
import java.util.EventListener;
import java.util.Iterator;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 * List of seller's products
 * @author eliandro
 */
public class InventoryView extends JPanel implements EventListener, View {

    private View nextView;
    
    private static final InventoryView instance = new InventoryView();    
    public static InventoryView getInstance() {
        return instance;
    }
    
    private InventoryView() {
        super();
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setMinimumSize(new Dimension(400, 100));
        // add a view for each product in the app
        Ecommerce app = Ecommerce.getInstance();
        Iterator<Inventory> it = app.getInventories().iterator();
        while (it.hasNext()) {
            Inventory inventory = it.next();
            Iterator<InventoryProduct> ip = inventory.getProducts().iterator();
            while (ip.hasNext()) {
                InventoryProduct inventoryProduct = ip.next();
                this.add(new ProductView(inventoryProduct));
            }
        }
        this.setSize(500, 500);
    }
    
    @Override
    public void setNextView(View v) {
        this.nextView = v;
    }

    @Override
    public View getNextView() {
        return this.nextView;
    }
    
}
