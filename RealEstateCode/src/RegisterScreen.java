import javax.swing.*;
import java.awt.*;

public class RegisterScreen {

    private final JPanel panel;
    private final JTextField usernameField;
    private final JPasswordField passwordField;
    private final UserTypeComboBox userTypeComboBox;
    private final RegisterButton registerButton;
    private final BackButton backButton;

    private final Runnable onBackButtonClick;

    public RegisterScreen(Runnable onBackButtonClick) {
        this.onBackButtonClick = onBackButtonClick;

        panel = new JPanel(new GridLayout(5, 2, 10, 10));

        JLabel lblUsername = new JLabel("Username:");
        JLabel lblPassword = new JLabel("Password:");
        JLabel lblUserType = new JLabel("User Type:");

        usernameField = new JTextField();
        passwordField = new JPasswordField();
        userTypeComboBox = new UserTypeComboBox();
        registerButton = new RegisterButton();
        backButton = new BackButton(onBackButtonClick);

        // Add components to the panel
        panel.add(lblUsername);
        panel.add(usernameField);
        panel.add(lblPassword);
        panel.add(passwordField);
        panel.add(lblUserType);
        panel.add(userTypeComboBox.getComboBox());
        panel.add(registerButton.getButton());
        panel.add(backButton.getButton());
    }

    public JPanel getPanel() {
        return panel;
    }
}
