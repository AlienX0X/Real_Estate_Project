
import java.awt.GridLayout;
import java.util.List;
import javax.swing.JPanel;

class ImagePanel implements Displayable {
        private final JPanel panel;

        public ImagePanel(List<ListingPanel> listingPanels) {
            panel = new JPanel(new GridLayout(1, 3, 10, 10));
            for (ListingPanel listingPanel : listingPanels) {
                panel.add(listingPanel.getPanel());
            }
        }

        @Override
        public JPanel getPanel() {
            return panel;
        }
    }