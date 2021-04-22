package cop5339.shoppingcartproject.view;

import cop5339.shoppingcartproject.model.InventoryProduct;
import cop5339.shoppingcartproject.model.ShoppingCart;
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
public class AvailableProductView extends JPanel implements ChangeListener {
    private final ShoppingCart modelShoppingCart;
    private final InventoryProduct model;
    private final JTextField quantity = new JTextField();
    private final JButton addCartButton = new JButton("Add to Cart");
    
    public AvailableProductView(InventoryProduct model, ShoppingCart modelShoppingCart) {
        super();
        this.model = model;
        this.modelShoppingCart = modelShoppingCart;
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
        quantity.setText("0");
        this.add(quantity);
        addCartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // put the product in the cart
                    int quantityToBuy = Integer.parseInt(quantity.getText());
                    modelShoppingCart.addProduct(model.getProduct(), model.getSeller(), quantityToBuy);
                    //update();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        addCartButton.setEnabled(model.getQuantity() > model.getReservedQuantity());
        this.add(addCartButton);   
        this.doLayout();
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        update();
    }
    
}
