
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Image;
import java.net.URL;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

class ListingPanel implements Displayable {
        private final JPanel panel;

        public ListingPanel(String fileName, String description, String price) {
            panel = new JPanel();
            panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

            ImageIcon imageIcon = createImageIcon(fileName);
            JLabel imageLabel = new JLabel(imageIcon);
            imageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

            JTextArea descriptionArea = new JTextArea(description);
            configureTextArea(descriptionArea);

            JLabel priceLabel = new JLabel("Price: " + price);
            priceLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

            JButton buyButton = new JButton("Buy");
            JButton saveButton = new JButton("Save to Favorites");

            buyButton.setAlignmentX(Component.CENTER_ALIGNMENT);
            saveButton.setAlignmentX(Component.CENTER_ALIGNMENT);

            buyButton.addActionListener(e -> handleButtonClick("Buy button clicked"));
            saveButton.addActionListener(e -> handleButtonClick("Save to Favorites button clicked"));

            panel.add(imageLabel);
            panel.add(descriptionArea);
            panel.add(priceLabel);
            panel.add(buyButton);
            panel.add(saveButton);
        }

        @Override
        public JPanel getPanel() {
            return panel;
        }
        private void configureTextArea(JTextArea textArea) {
            textArea.setEditable(false);
            textArea.setLineWrap(true);
            textArea.setWrapStyleWord(true);
            textArea.setAlignmentX(Component.CENTER_ALIGNMENT);
            textArea.setPreferredSize(new Dimension(200, textArea.getPreferredSize().height));
        }

        private void handleButtonClick(String message) {
            System.out.println(message);
        }

        private ImageIcon createImageIcon(String fileName) {
            URL imgUrl = getClass().getResource(fileName);
            if (imgUrl != null) {
                ImageIcon imageIcon = new ImageIcon(imgUrl);
                Image scaledImage = imageIcon.getImage().getScaledInstance(200, 150, Image.SCALE_SMOOTH);
                return new ImageIcon(scaledImage);
            } else {
                System.err.println("Couldn't find file: " + fileName);
                return null;
            }
        }
    }