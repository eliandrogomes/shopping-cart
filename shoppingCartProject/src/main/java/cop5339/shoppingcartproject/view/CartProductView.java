package cop5339.shoppingcartproject.view;

import cop5339.shoppingcartproject.model.CartProduct;
import cop5339.shoppingcartproject.model.InventoryProduct;
import java.awt.Color;
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
public class CartProductView extends JPanel implements EventListener {
    private final CartProduct model;
    private final JTextField quantity = new JTextField();
    private final JButton checkoutButton = new JButton("Checkout");
    private final JButton abandonButton = new JButton("Abandon the Cart");
    
    public CartProductView(CartProduct model) {
        super();
        this.model = model;
        // layout
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));        
        // product name
        this.add(new JLabel(model.getProduct().getName() + " [" + String.valueOf(model.getProduct().getCode()) + "]"));
        // unit price
        this.add(new JLabel("$ " + String.valueOf(model.getProduct().getUnitPrice())));
        // description
        // this.add(new JLabel(model.getProduct().getDescription()));
        // quantity
        quantity.setText(String.valueOf(model.getQuantity()));
        this.add(quantity);
        checkoutButton.setBackground(Color.GREEN);
        this.add(checkoutButton);
        this.add(abandonButton);
    }
    
}
