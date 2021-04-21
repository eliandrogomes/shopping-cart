package cop5339.shoppingcartproject.view;

import cop5339.shoppingcartproject.controller.History;
import cop5339.shoppingcartproject.model.Account;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.EventListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *
 * @author elian
 */
public class LoggedView extends JPanel implements ChangeListener, View {
    // debug information
    private final JButton cartButton = new JButton("My Cart");
    private final JButton logoutButton = new JButton("Logout");
    private final JLabel greeting = new JLabel("Hi");
    private View nextView;
    private Account model; 
    
    public LoggedView(Account model) {
        super();
        this.model = model;
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        JPanel panel = new JPanel(new FlowLayout());
        panel.add(greeting);
        panel.add(cartButton);        
        panel.add(logoutButton);
        //cartButton.addActionListener(loginController);
        logoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.setStatus("logout");
                History.getInstance().goBack();
            }
        });
        this.add(panel);
        update();
    }
    
    public void setModel(Account model) {
        this.model = model;
    }
    
    public JButton getCartButton() {
        return this.cartButton;
    }
    public JButton getLogoutButton() {
        return this.logoutButton;
    }
    
    @Override
    public void setNextView(View v) {
        this.nextView = v;
        v.setVisible(false);
    }
    @Override
    public View getNextView() {
        return this.nextView;
    }
    
    @Override
    public void update() {
        if (model != null) {
            greeting.setText("Hi, " + model.getFirstName() + " " + model.getLastName());
        }
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        setModel((Account) e.getSource());
        update();
    }
    
}
