
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

class HomeScreen {

    private JPanel panel;
    private JButton goToSearchButton;
    private Runnable onGoToSearchButtonClick;

    public HomeScreen(Runnable onGoToSearchButtonClick) {
        this.onGoToSearchButtonClick = onGoToSearchButtonClick;

        panel = new JPanel(new BorderLayout());

        JLabel lblWelcome = new JLabel("Welcome to Real Estate Project!", SwingConstants.CENTER);
        lblWelcome.setFont(new Font("Arial", Font.BOLD, 20));
        
        // Add an image to the panel
        ImageIcon imageIcon = createImageIcon("pexels-binyamin-mellish-186077.jpg"); // Replace with the actual image file
        if (imageIcon != null) {
            JLabel imageLabel = new JLabel(imageIcon);
            panel.add(imageLabel, BorderLayout.CENTER);
        }

        // Add details text to the panel
        JTextArea detailsTextArea = new JTextArea();
        detailsTextArea.setEditable(false);
        detailsTextArea.setLineWrap(true);
        detailsTextArea.setWrapStyleWord(true);
        detailsTextArea.setText("Explore our real estate listings and find your dream home!\n\n"
                + "Our platform offers a wide range of properties in various locations.\n"
                + "Start your search now!");

        // Add a button to navigate to the search screen
        goToSearchButton = new JButton("Go to Search");
        goToSearchButton.addActionListener(e -> onGoToSearchButtonClick.run());

        // Add components to the panel
        panel.add(lblWelcome, BorderLayout.NORTH);
        panel.add(detailsTextArea, BorderLayout.SOUTH);
        panel.add(goToSearchButton, BorderLayout.PAGE_END);
    }

    public JPanel getPanel() {
        return panel;
    }

    // Method to create an image icon from the file name
    private ImageIcon createImageIcon(String fileName) {
        URL imgUrl = getClass().getResource(fileName);
        if (imgUrl != null) {
            return new ImageIcon(imgUrl);
        } else {
            System.err.println("Couldn't find file: " + fileName);
            return null;
        }
    }}