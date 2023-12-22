import javax.swing.*;
import java.awt.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class HomeScreen {

    private static final String WELCOME_MESSAGE = "Welcome to Real Estate Project!";
    private static final String DETAILS_TEXT = """
            Explore our real estate listings and find your dream home!
            
            Our platform offers a wide range of properties in various locations.
            Start your search now!""";

    private JPanel panel;
    private JButton goToSearchButton;
    private Runnable onGoToSearchButtonClick;
    private List<ListingPanel> listingPanels;

    public HomeScreen(Runnable onGoToSearchButtonClick) {
        this.onGoToSearchButtonClick = onGoToSearchButtonClick;
        this.listingPanels = createListingPanels();

        initializePanel();
        setupLayout();
    }

    public JPanel getPanel() {
        return panel;
    }

    private void initializePanel() {
        panel = new JPanel(new BorderLayout());
        JLabel lblWelcome = new JLabel(WELCOME_MESSAGE, SwingConstants.CENTER);
        lblWelcome.setFont(new Font("Arial", Font.BOLD, 20));
        panel.add(lblWelcome, BorderLayout.NORTH);
    }

    private void setupLayout() {
        ImagePanel imagePanel = new ImagePanel(listingPanels);
        DetailsTextArea detailsTextArea = new DetailsTextArea();
        goToSearchButton = new JButton("Go to Search");
        goToSearchButton.addActionListener(e -> onGoToSearchButtonClick.run());

        panel.add(imagePanel.getPanel(), BorderLayout.CENTER);
        panel.add(detailsTextArea.getPanel(), BorderLayout.SOUTH);
        panel.add(goToSearchButton, BorderLayout.PAGE_END);
    }

    private List<ListingPanel> createListingPanels() {
        List<ListingPanel> panels = new ArrayList<>();
        panels.add(new ListingPanel("/images/pexels-binyamin-mellish-186077.jpg", "Home in Newyork City", "1 Million$"));
        panels.add(new ListingPanel("/images/house 1.jpg", "Home in Washington City", "2 Million$"));
        panels.add(new ListingPanel("/images/house 2.jpg", "Home in Cairo City", "3 Million$"));
        return panels;
    }}
