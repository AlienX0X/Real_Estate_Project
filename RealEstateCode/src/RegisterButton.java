import javax.swing.*;

public class RegisterButton implements CommandButton {

    private final JButton button;

    public RegisterButton() {
        button = new JButton("Register");
        // Add any specific behavior for RegisterButton if needed
    }

    @Override
    public JButton getButton() {
        return button;
    }
}
