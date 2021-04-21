package cop5339.shoppingcartproject.view;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
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
        JPanel panel = new JPanel(new FlowLayout());
        panel.add(new JLabel("Username"));
        username.setPreferredSize(new Dimension(200, 30));
        password.setPreferredSize(new Dimension(200, 30));
        panel.add(username);
        panel.add(new JLabel("Password"));        
        panel.add(password);
        panel.add(loginButton);        
        this.add(panel);
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

    @Override
    public void update() {
    }
    
}
