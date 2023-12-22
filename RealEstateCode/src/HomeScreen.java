
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import javax.swing.*;

class HomeScreen {

    private JPanel panel;
    private JButton goToSearchButton;
    private Runnable onGoToSearchButtonClick;

    public HomeScreen(Runnable onGoToSearchButtonClick) {
        this.onGoToSearchButtonClick = onGoToSearchButtonClick;

        panel = new JPanel(new BorderLayout());

        JLabel lblWelcome = new JLabel("Welcome to Real Estate Project!", SwingConstants.CENTER);
        lblWelcome.setFont(new Font("Arial", Font.BOLD, 20));

        // Create a panel for images using GridLayout
        JPanel imagePanel = new JPanel(new GridLayout(1, 3, 10, 10));

        // Add images with descriptions to the imagePanel
        imagePanel.add(createImagePanel("/images/pexels-binyamin-mellish-186077.jpg", "Home in Newyork City","1 Million$"));
        imagePanel.add(createImagePanel("/images/house 1.jpg", "Home in Washton City","2 Million$"));
        imagePanel.add(createImagePanel("/images/house 2.jpg", "Home in Cairo City","3 Million$"));

        // Add details text to the panel
        JTextArea detailsTextArea = new JTextArea();
        detailsTextArea.setEditable(false);
        detailsTextArea.setLineWrap(true);
        detailsTextArea.setWrapStyleWord(true);
        detailsTextArea.setText("""
                                Explore our real estate listings and find your dream home!
                                
                                Our platform offers a wide range of properties in various locations.
                                Start your search now!""");

        // Add a button to navigate to the search screen
        goToSearchButton = new JButton("Go to Search");
        goToSearchButton.addActionListener(e -> onGoToSearchButtonClick.run());

        // Add components to the main panel
        panel.add(lblWelcome, BorderLayout.NORTH);
        panel.add(imagePanel, BorderLayout.CENTER);
        panel.add(detailsTextArea, BorderLayout.SOUTH);
        panel.add(goToSearchButton, BorderLayout.PAGE_END);
    }

    public JPanel getPanel() {
        return panel;
    }

    // Method to create an image panel with description and space
    private JPanel createImagePanel(String fileName, String description, String price) {
    JPanel imagePanel = new JPanel();
    imagePanel.setLayout(new BoxLayout(imagePanel, BoxLayout.Y_AXIS));

    ImageIcon imageIcon = createImageIcon(fileName);
    JLabel imageLabel = new JLabel(imageIcon);
    imageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

    JTextArea descriptionArea = new JTextArea(description);
    descriptionArea.setEditable(false);
    descriptionArea.setLineWrap(true);
    descriptionArea.setWrapStyleWord(true);
    descriptionArea.setAlignmentX(Component.CENTER_ALIGNMENT);

    // Set preferred size based on the text content
    descriptionArea.setPreferredSize(new Dimension(200, descriptionArea.getPreferredSize().height));

    JLabel priceLabel = new JLabel("Price: " + price);
    priceLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

    // Create buttons for Buy and Save to Favorites
    JButton buyButton = new JButton("Buy");
    buyButton.setAlignmentX(Component.CENTER_ALIGNMENT);

    JButton saveButton = new JButton("Save to Favorites");
    saveButton.setAlignmentX(Component.CENTER_ALIGNMENT);

    // Add action listeners for the buttons
    buyButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Add your buy button logic here
            System.out.println("Buy button clicked");
        }
    });

    saveButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Add your save to favorites button logic here
            System.out.println("Save to Favorites button clicked");
        }
    });

    imagePanel.add(imageLabel);
    imagePanel.add(descriptionArea);
    imagePanel.add(priceLabel);
    imagePanel.add(buyButton);
    imagePanel.add(saveButton);

    return imagePanel;
}


    // Method to create an image icon from the file name
    private ImageIcon createImageIcon(String fileName) {
        URL imgUrl = getClass().getResource(fileName);
        if (imgUrl != null) {
            ImageIcon imageIcon = new ImageIcon(imgUrl);
            // Resize the image to the specified width and height
            Image scaledImage = imageIcon.getImage().getScaledInstance(200, 150, Image.SCALE_SMOOTH);
            return new ImageIcon(scaledImage);
        } else {
            System.err.println("Couldn't find file: " + fileName);
            return null;
        }
    }
}