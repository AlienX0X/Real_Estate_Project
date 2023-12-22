import javax.swing.*;
import java.awt.*;

public class SellerScreen {

    private JPanel panel;
    private JTextField imageTextField;
    private JTextArea descriptionTextArea;
    private JTextField priceTextField;

    public SellerScreen() {
        panel = new JPanel(new BorderLayout());

        JLabel lblSeller = new JLabel("Welcome to Seller Page!", SwingConstants.CENTER);
        lblSeller.setFont(new Font("Arial", Font.BOLD, 20));

        // Components for image upload
        JLabel lblImage = new JLabel("Image URL:");
        imageTextField = new JTextField();

        // Components for description
        JLabel lblDescription = new JLabel("Description:");
        descriptionTextArea = new JTextArea();
        descriptionTextArea.setLineWrap(true);
        descriptionTextArea.setWrapStyleWord(true);

        // Components for price
        JLabel lblPrice = new JLabel("Price:");
        priceTextField = new JTextField();

        // Button to upload
        JButton uploadButton = new JButton("Upload");
        uploadButton.addActionListener(e -> uploadImage());

        // Add components to the panel
        JPanel uploadPanel = new JPanel(new GridLayout(4, 2, 10, 10));
        uploadPanel.add(lblImage);
        uploadPanel.add(imageTextField);
        uploadPanel.add(lblDescription);
        uploadPanel.add(new JScrollPane(descriptionTextArea)); // Use JScrollPane for multi-line text areas
        uploadPanel.add(lblPrice);
        uploadPanel.add(priceTextField);
        uploadPanel.add(uploadButton);

        panel.add(lblSeller, BorderLayout.NORTH);
        panel.add(uploadPanel, BorderLayout.CENTER);
    }

    private void uploadImage() {
        // Implement logic for image upload, description, and price
        String imageUrl = imageTextField.getText();
        String description = descriptionTextArea.getText();
        String price = priceTextField.getText();

        // You can add your logic to handle the uploaded information
        System.out.println("Image URL: " + imageUrl);
        System.out.println("Description: " + description);
        System.out.println("Price: " + price);

        // Optionally, you can reset the text fields after uploading
        imageTextField.setText("");
        descriptionTextArea.setText("");
        priceTextField.setText("");
    }

    public JPanel getPanel() {
        return panel;
    }
}
