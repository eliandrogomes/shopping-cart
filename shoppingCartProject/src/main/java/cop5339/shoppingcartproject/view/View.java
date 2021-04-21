package cop5339.shoppingcartproject.view;

/**
 *
 * @author eliandro
 */
public interface View {
    void setVisible(boolean flag);
    void setNextView(View v);
    View getNextView();
    void update();
}
