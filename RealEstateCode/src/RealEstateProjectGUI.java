import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RealEstateProjectGUI {

    private JFrame frame;
    private JPanel mainPanel;

    private LoginScreen loginScreen;
    private RegisterScreen registerScreen;
    private HomeScreen homeScreen;
    private SearchScreen searchScreen;
    private SellerScreen sellerScreen; // Added SellerScreen reference


    public RealEstateProjectGUI() {
        frame = new JFrame("Real Estate Project");
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        mainPanel = new JPanel(new CardLayout());

         loginScreen = new LoginScreen(this::showRegisterScreen, this::verifyLogin);
        registerScreen = new RegisterScreen(this::showLoginScreen);
        homeScreen = new HomeScreen(this::showSearchScreen);
        searchScreen = new SearchScreen(this::showHomeScreen);
        sellerScreen = new SellerScreen(); // Initialize SellerScreen

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
        searchScreen = new SearchScreen(this::showHomeScreen);

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
    private void verifyLogin() {
    // Retrieve entered credentials from the login screen
    String enteredUsername = loginScreen.getUsername();
    String enteredPassword = loginScreen.getPassword();
    String selectedUserType = loginScreen.getUserType();

    // Check specifically for the credentials "Ahmed" as username, "Ahmed" as password, and user type "Customer"
    if ("Ahmed".equals(enteredUsername) && "Ahmed".equals(enteredPassword) && "Customer".equals(selectedUserType)) {
        showHomeScreen(); // Redirect to the home screen
    } else if ("alaa".equals(enteredUsername) && "alaa".equals(enteredPassword) && "Seller".equals(selectedUserType)) {
        showSellerScreen();
    } else {
        // Failed login
        JOptionPane.showMessageDialog(frame, "Invalid credentials. Please try again.");
    }
}
    private void showSellerScreen() {
        CardLayout cardLayout = (CardLayout) mainPanel.getLayout();
        cardLayout.show(mainPanel, "Seller");
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new RealEstateProjectGUI());
    }
}

