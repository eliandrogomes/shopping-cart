package cop5339.shoppingcartproject.view;

import cop5339.shoppingcartproject.model.Ecommerce;
import java.util.ArrayList;
import java.util.EventListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author elian
 */
public class LoginView extends JPanel implements EventListener, Screen {

    private final JTextField username = new JTextField();
    private final JTextField password = new JTextField();
    private final JButton loginButton = new JButton("Login");
    
    private static final LoginView instance = new LoginView();    
    public static LoginView getInstance() {
        return instance;
    }
    
    private LoginView() {
        super();
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(new JLabel("Username"));        
        this.add(username);
        this.add(new JLabel("Password"));        
        this.add(password);
        this.add(loginButton);
    }

    public JTextField getUsername() {
        return username;
    }

    public JTextField getPassword() {
        return password;
    }

    public JButton getLoginButton() {
        return loginButton;
    }
    
}
