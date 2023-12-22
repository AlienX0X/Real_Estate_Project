import javax.swing.*;

public class UserTypeComboBox implements CommandButton {

    private final JComboBox<String> comboBox;

    public UserTypeComboBox() {
        comboBox = new JComboBox<>(new String[]{"Customer", "Seller", "Admin"});
    }

    public JComboBox<String> getComboBox() {
        return comboBox;
    }

    @Override
    public JButton getButton() {
        throw new UnsupportedOperationException("UserTypeComboBox does not have a button.");
    }
}
