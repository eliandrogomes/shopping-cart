package cop5339.shoppingcartproject;

import cop5339.shoppingcartproject.controller.LoginController;
import cop5339.shoppingcartproject.model.Account;
import cop5339.shoppingcartproject.model.Customer;
import cop5339.shoppingcartproject.model.Ecommerce;
import cop5339.shoppingcartproject.model.Inventory;
import cop5339.shoppingcartproject.model.Product;
import cop5339.shoppingcartproject.model.Seller;
import cop5339.shoppingcartproject.model.User;
import cop5339.shoppingcartproject.view.InventoryView;
import cop5339.shoppingcartproject.view.LoginView;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JFrame;

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
        inventory1.addProduct(new Product(3, "MSI Laptop i7 16GB", "MSI GL65 Leopard 10SFK-062 15.6\" FHD 144Hz 3ms Thin Bezel Gaming Laptop Intel Core i7-10750H RTX2070 16GB 512GB NVMe SSD Win 10", 1380), 20);
        inventory1.addProduct(new Product(4, "TV OLED 65-inch", "LG OLED65CXPUA Alexa Built-in CX 65-inch 4K Smart OLED TV (2020 Model)", 1949.99), 2);
        app.addInventory(inventory2);

        // the Model in MVC:
        final Account accountModel = new Account();
        
        // the View in the MVC 
        LoginView loginView = LoginView.getInstance();
        InventoryView inventoryView = InventoryView.getInstance();

        // the Controller in the MVC
        LoginController loginController = new LoginController(loginView, accountModel);
        loginView.getLoginButton().addActionListener(loginController);

        // add view observer to model
//        userModel.addEventListener(loginView);

        // main app frame:
        JFrame jframe = new JFrame("Shopping Cart App");
        jframe.setLayout(new GridLayout(3, 1));
        jframe.add(loginView);

        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setMinimumSize(new Dimension(400,500));
        jframe.pack();
        jframe.setVisible(true);
    }
}
