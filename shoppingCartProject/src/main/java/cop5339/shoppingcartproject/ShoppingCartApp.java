package cop5339.shoppingcartproject;

import cop5339.shoppingcartproject.controller.History;
import cop5339.shoppingcartproject.controller.LoginController;
import cop5339.shoppingcartproject.model.Account;
import cop5339.shoppingcartproject.model.Customer;
import cop5339.shoppingcartproject.model.Ecommerce;
import cop5339.shoppingcartproject.model.Inventory;
import cop5339.shoppingcartproject.model.Product;
import cop5339.shoppingcartproject.model.Seller;
import cop5339.shoppingcartproject.view.BuyerView;
import cop5339.shoppingcartproject.view.CartView;
import cop5339.shoppingcartproject.view.InventoryView;
import cop5339.shoppingcartproject.view.LoginView;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 *
 * @author elian
 */
public class ShoppingCartApp {

    private static final int MIN = 0;
    private static final int MAX = 255;

    private static final String[] colorNames = new String[]{"red", "green", "blue"};
    private static final int NCOLORS = colorNames.length;

    /**
     * @param args
     */
    public static void main(String[] args) {
        
        // load initial data
        Ecommerce app = Ecommerce.getInstance();
        Account seller1 = new Account(new Seller("carl", "2"), "Carl", "Matthias");
        Account seller2 = new Account(new Seller("jacob", "2"), "Jacob", "Perrone");
        
        app.createAccount(new Account(new Customer("eliandro", "1"), "Eliandro", "Gomes"));
        app.createAccount(new Account(new Customer("vincent", "1"), "Landarby", "Vincent"));
        app.createAccount(seller1);
        app.createAccount(seller2);
        
        // create inventory
        Inventory inventory1 = new Inventory((Seller) seller1.getUser());
        inventory1.addProduct(new Product(1, "Xbox Gift Card", "Platform : Xbox One, Xbox 360 | DRM: Xbox Live", 100), 5);
        inventory1.addProduct(new Product(2, "PlayStation Store Gift Card", "PlayStation 4 | DRM: PlayStation Network", 50), 8);
        app.addInventory(inventory1);        
        Inventory inventory2 = new Inventory((Seller) seller2.getUser());
        inventory2.addProduct(new Product(3, "MSI Laptop i7 16GB", "MSI GL65 Leopard 10SFK-062 15.6\" FHD 144Hz 3ms RTX2070 16GB", 1380), 20);
        inventory2.addProduct(new Product(4, "TV OLED 65-inch", "LG OLED65CXPUA Alexa Built-in CX 65-inch 4K Smart OLED TV (2020 Model)", 1949.99), 2);
        app.addInventory(inventory2);

        // the Model in MVC:
        final Account accountModel = new Account();
        
        // the View in the MVC 
        LoginView loginView = LoginView.getInstance();
        // view to seller
        InventoryView inventoryView = InventoryView.getInstance();
        // view to buyer
        BuyerView buyerView = BuyerView.getInstance();
        // view to cart
        CartView cartProductView = CartView.getInstance();

        // the Controller in the MVC
        LoginController loginController = new LoginController(loginView, accountModel);
        loginView.getLoginButton().addActionListener(loginController);
        History.getInstance().setCurrentView(loginView);
        //loginView.setNextView(inventoryView);
        
        // main app frame:
        JFrame jframe = new JFrame("Shopping Cart App");
        jframe.setLayout(new GridLayout(1,1));
        // main panel
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
        // scroll
        JScrollPane jScrollPane = new JScrollPane(panel);
        // only a configuration to the jScrollPane...
        jScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        jScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        jScrollPane.setMinimumSize(new Dimension(400,500));
        
        panel.add(loginView);
        panel.add(inventoryView);    
        panel.add(cartProductView); 
        panel.add(buyerView); 
        jframe.getContentPane().add(jScrollPane);
        
        //listen for resizes
        jScrollPane.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                //jScrollPane.setSize(jframe.getSize());
                panel.updateUI();
            }
        });

        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setMinimumSize(new Dimension(500,500));
        jframe.setSize(new Dimension(500,500));
        jframe.pack();
        jframe.setVisible(true);
    }
}
