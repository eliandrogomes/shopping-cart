package cop5339.shoppingcartproject.controller;

import cop5339.shoppingcartproject.view.View;
import java.awt.Component;

/**
 *
 * @author eliandro
 */
public class History {
    private View before;
    private View current;    
    private View next;
    
    private static final History instance = new History();    
    public static History getInstance() {
        return instance;
    }

    private History() {
    }
    
    public void setCurrentView(View current) {
        this.current = current;
    }
    
    public void goBack() {
        if (before != null) {
            current.setVisible(false);
            before.setVisible(true);
            // repaint components
            ((Component)before).getParent().doLayout();
            next = current;
            current = before;
        }
    }
    /**
     * go forward to new screen and hide the predecessor screen
     * @param s 
     */
    public void goForward(View s) {
        current.setVisible(false);
        s.setVisible(true);
        // repaint components
        ((Component)s).getParent().doLayout();
        before = current;
        current = s;        
    }
    public void goForward() {
        if (next != null) {
            current.setVisible(false);
            next.setVisible(true);
            // repaint components
            ((Component)next).getParent().doLayout();
            before = current;
            current = next;
        }
    }
}
