package cop5339.shoppingcartproject.view;

import cop5339.shoppingcartproject.model.Account;
import cop5339.shoppingcartproject.model.CartProduct;
import cop5339.shoppingcartproject.model.InventoryProduct;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.EventListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *
 * @author eliandro
 */
public class CartProductView extends JPanel  implements ChangeListener {
    private final CartProduct model;
    private final JTextField quantity = new JTextField();
    
    
    public CartProductView(CartProduct model) {
        super();
        this.model = model;
        // layout
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));    
        update();
    }
    
    public void update() {
        // product name
        this.removeAll();
        this.add(new JLabel(model.getProduct().getName() + " [" + String.valueOf(model.getProduct().getCode()) + "]"));
        // unit price
        this.add(new JLabel("$ " + String.valueOf(model.getProduct().getUnitPrice())));
        // description
        // this.add(new JLabel(model.getProduct().getDescription()));
        // quantity
        quantity.setText(String.valueOf(model.getQuantity()));
        this.add(quantity);
    }
    
    @Override
    public void stateChanged(ChangeEvent e) {
        update();
    }

    
}
