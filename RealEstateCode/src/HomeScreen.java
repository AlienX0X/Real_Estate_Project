
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

class HomeScreen {

    private JPanel panel;
    private JButton goToSearchButton;
    private Runnable onGoToSearchButtonClick;

    public HomeScreen(Runnable onGoToSearchButtonClick) {
        this.onGoToSearchButtonClick = onGoToSearchButtonClick;

        panel = new JPanel(new GridLayout(2, 1));

        JLabel lblWelcome = new JLabel("Welcome to Real Estate Project!");
        goToSearchButton = new JButton("Go to Search");

        goToSearchButton.addActionListener(e -> onGoToSearchButtonClick.run());

        panel.add(lblWelcome);
        panel.add(goToSearchButton);
    }

    public JPanel getPanel() {
        return panel;
    }
}