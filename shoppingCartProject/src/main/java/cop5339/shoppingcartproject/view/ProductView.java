package cop5339.shoppingcartproject.view;

import cop5339.shoppingcartproject.model.InventoryProduct;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * view of seller
 * @author eliandro
 */
public class ProductView extends JPanel implements ChangeListener {
    private final InventoryProduct model;
    private final JTextField quantity = new JTextField();
//    private final JButton addCartButton = new JButton("Add to Cart");
    private final JButton updateButton = new JButton("Update quantity");
    
    public ProductView(InventoryProduct model) {
        super();
        this.model = model;
        // layout
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS)); 
        update();
    }
    
    public void update() {
        this.removeAll();
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
        quantity.setText(String.valueOf(model.getQuantity()));
        this.add(quantity);
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    model.setQuantity(Integer.parseInt(quantity.getText()));
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        this.add(updateButton);
        this.doLayout();
    }
    
    @Override
    public void stateChanged(ChangeEvent e) {
        update();
    }
    
}
