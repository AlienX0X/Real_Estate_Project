import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RealEstateProjectGUI {

    private JFrame frame;
    private JPanel mainPanel;

    private LoginScreen loginScreen;
    private RegisterScreen registerScreen;
    private HomeScreen homeScreen;
    private SearchScreen searchScreen;

    public RealEstateProjectGUI() {
        frame = new JFrame("Real Estate Project");
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        mainPanel = new JPanel(new CardLayout());

        loginScreen = new LoginScreen(this::showRegisterScreen, this::showHomeScreen);
        registerScreen = new RegisterScreen(this::showLoginScreen);
        homeScreen = new HomeScreen(this::showSearchScreen);
        searchScreen = new SearchScreen();

        mainPanel.add(loginScreen.getPanel(), "Login");
        mainPanel.add(registerScreen.getPanel(), "Register");
        mainPanel.add(homeScreen.getPanel(), "Home");
        mainPanel.add(searchScreen.getPanel(), "Search");

        CardLayout cardLayout = (CardLayout) mainPanel.getLayout();
        cardLayout.show(mainPanel, "Login");

        frame.add(mainPanel);
        frame.setVisible(true);
    } {
        frame = new JFrame("Real Estate Project");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        mainPanel = new JPanel(new CardLayout());

        loginScreen = new LoginScreen(this::showRegisterScreen, this::showHomeScreen);
        registerScreen = new RegisterScreen(this::showLoginScreen);
        homeScreen = new HomeScreen(this::showSearchScreen);
        searchScreen = new SearchScreen();

        mainPanel.add(loginScreen.getPanel(), "Login");
        mainPanel.add(registerScreen.getPanel(), "Register");
        mainPanel.add(homeScreen.getPanel(), "Home");
        mainPanel.add(searchScreen.getPanel(), "Search");

        CardLayout cardLayout = (CardLayout) mainPanel.getLayout();
        cardLayout.show(mainPanel, "Login");

        frame.add(mainPanel);
        frame.setVisible(true);
    }

    private void showRegisterScreen() {
        CardLayout cardLayout = (CardLayout) mainPanel.getLayout();
        cardLayout.show(mainPanel, "Register");
    }

    private void showLoginScreen() {
        CardLayout cardLayout = (CardLayout) mainPanel.getLayout();
        cardLayout.show(mainPanel, "Login");
    }

    private void showHomeScreen() {
        CardLayout cardLayout = (CardLayout) mainPanel.getLayout();
        cardLayout.show(mainPanel, "Home");
    }

    private void showSearchScreen() {
        CardLayout cardLayout = (CardLayout) mainPanel.getLayout();
        cardLayout.show(mainPanel, "Search");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new RealEstateProjectGUI());
    }
}

