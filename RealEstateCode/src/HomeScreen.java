import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class HomeScreen {

    private JPanel panel;
    private JTextArea listingsTextArea;

    private ActionListener onSearch;

    public HomeScreen(ActionListener onSearch) {
        this.onSearch = onSearch;

        panel = new JPanel(new BorderLayout());

        JLabel lblHome = new JLabel("Welcome to Home Screen!", SwingConstants.CENTER);
        lblHome.setFont(new Font("Arial", Font.BOLD, 20));

        listingsTextArea = new JTextArea();
        listingsTextArea.setEditable(false);

        JButton searchButton = new JButton("Search");
        searchButton.addActionListener(onSearch);

        panel.add(lblHome, BorderLayout.NORTH);
        panel.add(new JScrollPane(listingsTextArea), BorderLayout.CENTER);
        panel.add(searchButton, BorderLayout.SOUTH);
    }

    public void addListing(String description, String price) {
        // Add the details to the listingsTextArea
        listingsTextArea.append("Description: " + description + "\n");
        listingsTextArea.append("Price: $" + price + "\n\n");
    }

    public JPanel getPanel() {
        return panel;
    }
}
