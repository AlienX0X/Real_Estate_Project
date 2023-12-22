
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

class SearchScreen {

    private JPanel panel;
    private JButton returnButton;
    private Runnable onReturnButtonClick;

    public SearchScreen(Runnable onReturnButtonClick) {
        this.onReturnButtonClick = onReturnButtonClick;

        panel = new JPanel(new BorderLayout());

        // Create components for the SearchScreen
        JLabel searchLabel = new JLabel("Search Screen", SwingConstants.CENTER);

        // Create a return button
        returnButton = new JButton("Return to Home");
        returnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onReturnButtonClick.run();
            }
        });

        // Add components to the panel
        panel.add(searchLabel, BorderLayout.NORTH);
        panel.add(returnButton, BorderLayout.SOUTH);
    }

    public JPanel getPanel() {
        return panel;
    }
}