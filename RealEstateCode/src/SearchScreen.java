import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SearchScreen {

    private JPanel panel;
    private JTextField searchField;

    private ActionListener onHome;

    public SearchScreen(ActionListener onHome) {
        this.onHome = onHome;

        panel = new JPanel(new GridLayout(2, 1, 10, 10));

        JLabel lblSearch = new JLabel("Enter search criteria:");
        searchField = new JTextField();

        JButton searchButton = new JButton("Search");
        searchButton.addActionListener(e -> search());

        JButton homeButton = new JButton("Home");
        homeButton.addActionListener(onHome);

        panel.add(lblSearch);
        panel.add(searchField);
        panel.add(searchButton);
        panel.add(homeButton);
    }

    private void search() {
        // Implement logic for searching
        // You may want to display search results or update the HomeScreen
        JOptionPane.showMessageDialog(panel, "Searching for: " + searchField.getText());
    }

    public JPanel getPanel() {
        return panel;
    }
}
