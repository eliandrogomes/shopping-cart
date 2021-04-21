package cop5339.shoppingcartproject.view;

import cop5339.shoppingcartproject.model.InventoryProduct;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.EventListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

/**
 *
 * @author eliandro
 */
public class ProductView extends JPanel implements EventListener {
    private final InventoryProduct model;
    private final JTextField quantity = new JTextField();
    private final JButton addCartButton = new JButton("Add to Cart");
    
    public ProductView(InventoryProduct model) {
        super();
        this.model = model;
        // layout
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));        
        // product name
        this.add(new JLabel(model.getProduct().getName() + " [" + String.valueOf(model.getProduct().getCode()) + "]"));
        // unit price
        this.add(new JLabel("$ " + String.valueOf(model.getProduct().getUnitPrice())));
        // description
        this.add(new JLabel(model.getProduct().getDescription()));
        // In Stock: #, reserved: #
        this.add(new JLabel("In Stock: " + String.valueOf(model.getQuantity()) + " / Reserved: " + String.valueOf(model.getReservedQuantity())));
        // seller
        this.add(new JLabel("Seller: " + model.getSeller().getUsername()));
        // quantity (default 1)
        quantity.setText("1");
        this.add(quantity);
        this.add(addCartButton);
    }
    
}
