import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class LoginScreen {

    private JPanel panel;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JComboBox<String> userTypeComboBox; // Added JComboBox for user type
    private JButton loginButton;
    private JButton registerButton;
    private Runnable onRegisterButtonClick;
    private Runnable onLoginButtonClick;

    public LoginScreen(Runnable onRegisterButtonClick, Runnable onLoginButtonClick) {
        this.onRegisterButtonClick = onRegisterButtonClick;
        this.onLoginButtonClick = onLoginButtonClick;

        panel = new JPanel(new GridLayout(4, 2, 10, 10));

        JLabel lblUsername = new JLabel("Username:");
        JLabel lblPassword = new JLabel("Password:");
        JLabel lblUserType = new JLabel("User Type:");

        usernameField = new JTextField();
        passwordField = new JPasswordField();
        userTypeComboBox = new JComboBox<>(new String[]{"Customer", "Seller", "Admin"});

        loginButton = new JButton("Login");
        registerButton = new JButton("Register");

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onLoginButtonClick.run();
            }
        });

        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onRegisterButtonClick.run();
            }
        });

        // Add components to the panel
        panel.add(lblUsername);
        panel.add(usernameField);
        panel.add(lblPassword);
        panel.add(passwordField);
        panel.add(lblUserType);
        panel.add(userTypeComboBox);
        panel.add(loginButton);
        panel.add(registerButton);
    }

    public JPanel getPanel() {
        return panel;
    }

    public String getUsername() {
        return usernameField.getText();
    }

    public String getPassword() {
        // It's recommended to use getPassword() carefully due to security concerns
        // For simplicity in this example, we are directly converting it to a String
        return new String(passwordField.getPassword());
    }

    public String getUserType() {
        return (String) userTypeComboBox.getSelectedItem();
    }
}
