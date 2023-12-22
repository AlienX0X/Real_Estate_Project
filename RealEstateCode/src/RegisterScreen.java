
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

class RegisterScreen {

    private JPanel panel;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JTextField emailField;
    private JButton registerButton;
    private JButton goToLoginButton;
    private Runnable onLoginButtonClick;

    public RegisterScreen(Runnable onLoginButtonClick) {
        this.onLoginButtonClick = onLoginButtonClick;

        panel = new JPanel(new GridLayout(4, 2));

        JLabel lblUsername = new JLabel("Username:");
        usernameField = new JTextField();
        JLabel lblPassword = new JLabel("Password:");
        passwordField = new JPasswordField();
        JLabel lblEmail = new JLabel("Email:");
        emailField = new JTextField();
        registerButton = new JButton("Register");
        goToLoginButton = new JButton("Go to Login");

        registerButton.addActionListener(e -> JOptionPane.showMessageDialog(null, "Register button clicked"));
        goToLoginButton.addActionListener(e -> onLoginButtonClick.run());

        panel.add(lblUsername);
        panel.add(usernameField);
        panel.add(lblPassword);
        panel.add(passwordField);
        panel.add(lblEmail);
        panel.add(emailField);
        panel.add(registerButton);
        panel.add(goToLoginButton);
    }

    public JPanel getPanel() {
        return panel;
    }
}