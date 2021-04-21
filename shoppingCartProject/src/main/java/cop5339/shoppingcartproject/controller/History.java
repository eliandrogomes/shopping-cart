package cop5339.shoppingcartproject.controller;

import cop5339.shoppingcartproject.view.Screen;

/**
 *
 * @author eliandro
 */
public class History {
    private Screen before;
    private Screen current;    
    private Screen next;
    
    private static final History instance = new History();    
    public static History getInstance() {
        return instance;
    }

    private History() {
    }
    
    public void setCurrentScreen(Screen current) {
        this.current = current;
    }
    
    public void goBack() {
        if (before != null) {
            current.hide();
            before.show();
            next = current;
            current = before;
        }
    }
    /**
     * go forward to new screen and hide the predecessor screen
     * @param s 
     */
    public void goForward(Screen s) {
        current.hide();
        s.show();
        before = current;
        current = s;        
    }
    public void goForward() {
        if (next != null) {
            current.hide();
            next.show();
            before = current;
            current = next;
        }
    }
}
