import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginScreen {

    private JPanel panel;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JComboBox<String> userTypeComboBox;

    private ActionListener onRegister;
    private ActionListener onLogin;

    public LoginScreen(ActionListener onRegister, ActionListener onLogin) {
        this.onRegister = onRegister;
        this.onLogin = onLogin;

        panel = new JPanel(new GridLayout(4, 2, 10, 10));

        JLabel lblUsername = new JLabel("Username:");
        usernameField = new JTextField();

        JLabel lblPassword = new JLabel("Password:");
        passwordField = new JPasswordField();

        JLabel lblUserType = new JLabel("User Type:");
        String[] userTypes = {"Customer", "Seller"};
        userTypeComboBox = new JComboBox<>(userTypes);

        JButton registerButton = new JButton("Register");
        registerButton.addActionListener(onRegister);

        JButton loginButton = new JButton("Login");
        loginButton.addActionListener(e -> onLogin.actionPerformed(e));

        panel.add(lblUsername);
        panel.add(usernameField);
        panel.add(lblPassword);
        panel.add(passwordField);
        panel.add(lblUserType);
        panel.add(userTypeComboBox);
        panel.add(registerButton);
        panel.add(loginButton);
    }

    public String getUsername() {
        return usernameField.getText();
    }

    public String getPassword() {
        return new String(passwordField.getPassword());
    }

    public String getUserType() {
        return (String) userTypeComboBox.getSelectedItem();
    }

    public JPanel getPanel() {
        return panel;
    }
}
