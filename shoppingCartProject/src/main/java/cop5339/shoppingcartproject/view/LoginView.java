package cop5339.shoppingcartproject.view;

import java.awt.Dimension;
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
public class LoginView extends JPanel implements EventListener, View {
    // debug information
    private final JTextField username = new JTextField("eliandro");
    private final JTextField password = new JTextField("1");
    private final JButton loginButton = new JButton("Login");
    private View nextView;
    
    private static final LoginView instance = new LoginView();    
    public static LoginView getInstance() {
        return instance;
    }
    
    private LoginView() {
        super();
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setMinimumSize(new Dimension(400, 100));
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

    @Override
    public void setNextView(View v) {
        this.nextView = v;
        v.setVisible(false);
    }
    @Override
    public View getNextView() {
        return this.nextView;
    }
    
}
