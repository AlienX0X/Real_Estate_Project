import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class RegisterScreen {

    private JPanel panel;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JComboBox<String> userTypeComboBox; // Added JComboBox for user type
    private JButton registerButton;
    private JButton backButton;
    private Runnable onBackButtonClick;

    public RegisterScreen(Runnable onBackButtonClick) {
        this.onBackButtonClick = onBackButtonClick;

        panel = new JPanel(new GridLayout(5, 2, 10, 10));

        JLabel lblUsername = new JLabel("Username:");
        JLabel lblPassword = new JLabel("Password:");
        JLabel lblUserType = new JLabel("User Type:");

        usernameField = new JTextField();
        passwordField = new JPasswordField();
        userTypeComboBox = new JComboBox<>(new String[]{"Customer", "Seller", "Admin"});

        registerButton = new JButton("Register");
        backButton = new JButton("Back");

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onBackButtonClick.run();
            }
        });

        // Add components to the panel
        panel.add(lblUsername);
        panel.add(usernameField);
        panel.add(lblPassword);
        panel.add(passwordField);
        panel.add(lblUserType);
        panel.add(userTypeComboBox);
        panel.add(registerButton);
        panel.add(backButton);
    }

    public JPanel getPanel() {
        return panel;
    }
}
