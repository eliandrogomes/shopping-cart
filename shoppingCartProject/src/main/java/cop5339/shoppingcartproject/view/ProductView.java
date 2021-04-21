package cop5339.shoppingcartproject.view;

import cop5339.shoppingcartproject.model.InventoryProduct;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.EventListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
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
        this.setLayout(new GridBagLayout());        
        GridBagConstraints c = new GridBagConstraints();
        // natural height, maximum width
        c.fill = GridBagConstraints.HORIZONTAL;
        // quantity, seller
        c.weightx = 0.2;
        c.gridx = 0;
        c.gridy = 0;
        quantity.setText("1");
        this.add(quantity, c);
        c.gridx = 1;
        c.gridy = 0;
        this.add(new JLabel(model.getSeller().getUsername()), c);
        // second line
        // code, name, price
        c.weightx = 0.2;
        c.gridx = 0;
        c.gridy = 1;
        this.add(new JLabel(String.valueOf(model.getProduct().getCode())), c);
        c.weightx = 0.6;
        c.gridx = 1;
        this.add(new JLabel(model.getProduct().getName()), c);
        c.weightx = 0.2;
        c.gridx = 2;
        this.add(new JLabel(String.valueOf(model.getProduct().getUnitPrice())), c);
        // description
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 2;
        this.add(new JLabel(model.getProduct().getDescription()), c);
        // In Stock: #, reserved: #
        c.gridx = 0;
        c.gridy = 3;
        this.add(new JLabel("In Stock: " + String.valueOf(model.getQuantity())), c);
        c.gridx = 1;
        c.gridy = 3;
        this.add(new JLabel("Reserved: " + String.valueOf(model.getReservedQuantity())), c);
        c.gridx = 0;
        c.gridy = 4;
        this.add(addCartButton, c);
    }
    
}
