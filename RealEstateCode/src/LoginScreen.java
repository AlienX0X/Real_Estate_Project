import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

class LoginScreen {

    private JPanel panel;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JButton goToRegisterButton;
    private Runnable onRegisterButtonClick;
    private Runnable onLoginSuccess;

    public LoginScreen(Runnable onRegisterButtonClick, Runnable onLoginSuccess) {
        this.onRegisterButtonClick = onRegisterButtonClick;
        this.onLoginSuccess = onLoginSuccess;

        panel = new JPanel(new GridLayout(3, 2));

        JLabel lblUsername = new JLabel("Username:");
        usernameField = new JTextField();
        JLabel lblPassword = new JLabel("Password:");
        passwordField = new JPasswordField();
        loginButton = new JButton("Login");
        goToRegisterButton = new JButton("Go to Register");

        loginButton.addActionListener(e -> {
            String username = usernameField.getText();
            char[] passwordChars = passwordField.getPassword();
            String password = new String(passwordChars);

            if ("root".equals(username) && "root".equals(password)) {
                JOptionPane.showMessageDialog(null, "Login successful");
                onLoginSuccess.run();
            } else {
                JOptionPane.showMessageDialog(null, "Invalid username or password");
            }

            // Clear fields after login attempt
            usernameField.setText("");
            passwordField.setText("");
        });

        goToRegisterButton.addActionListener(e -> onRegisterButtonClick.run());

        panel.add(lblUsername);
        panel.add(usernameField);
        panel.add(lblPassword);
        panel.add(passwordField);
        panel.add(loginButton);
        panel.add(goToRegisterButton);
    }

    public JPanel getPanel() {
        return panel;
    }
}