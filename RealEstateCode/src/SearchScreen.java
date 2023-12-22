
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

class SearchScreen {

    private JPanel panel;
    private JTextField locationField;
    private JButton searchButton;

    public SearchScreen() {
        panel = new JPanel(new GridLayout(2, 1));

        JLabel lblLocation = new JLabel("Enter Location:");
        locationField = new JTextField();
        searchButton = new JButton("Search");

        searchButton.addActionListener(e -> JOptionPane.showMessageDialog(null, "Search button clicked"));

        panel.add(lblLocation);
        panel.add(locationField);
        panel.add(searchButton);
    }

    public JPanel getPanel() {
        return panel;
    }
}
