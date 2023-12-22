import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SellerScreen {

    private JPanel panel;
    private JTextArea descriptionTextArea;
    private JTextField priceTextField;

    public SellerScreen() {
        panel = new JPanel(new BorderLayout());

        JLabel lblSeller = new JLabel("Welcome to Seller Page!", SwingConstants.CENTER);
        lblSeller.setFont(new Font("Arial", Font.BOLD, 20));

        // Components for description
        JLabel lblDescription = new JLabel("Description:");
        descriptionTextArea = new JTextArea();
        descriptionTextArea.setLineWrap(true);
        descriptionTextArea.setWrapStyleWord(true);

        // Components for price
        JLabel lblPrice = new JLabel("Price:");
        priceTextField = new JTextField();

        // Button to choose and upload image
        JButton chooseImageButton = new JButton("Choose Image");
        chooseImageButton.addActionListener(e -> chooseImage());

        // Button to upload
        JButton uploadButton = new JButton("Upload");
        uploadButton.addActionListener(e -> uploadImage());

        // Add components to the panel
        JPanel uploadPanel = new JPanel(new GridLayout(4, 1, 10, 10));
        uploadPanel.add(lblDescription);
        uploadPanel.add(new JScrollPane(descriptionTextArea)); // Use JScrollPane for multi-line text areas
        uploadPanel.add(lblPrice);
        uploadPanel.add(priceTextField);
        uploadPanel.add(chooseImageButton);
        uploadPanel.add(uploadButton);

        panel.add(lblSeller, BorderLayout.NORTH);
        panel.add(uploadPanel, BorderLayout.CENTER);
    }

    private void uploadImage() {
        // Implement logic for image upload, description, and price
        // Retrieve the entered values directly
        String description = descriptionTextArea.getText();
        String price = priceTextField.getText();

        // You can add your logic to handle the uploaded information
        System.out.println("Description: " + description);
        System.out.println("Price: " + price);

        // Optionally, you can reset the text fields after uploading
        descriptionTextArea.setText("");
        priceTextField.setText("");
    }

    private void chooseImage() {
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Image files", "jpg", "jpeg", "png", "gif");
        fileChooser.setFileFilter(filter);

        int returnVal = fileChooser.showOpenDialog(panel);

        if (returnVal == JFileChooser.APPROVE_OPTION) {
            // Get the selected file
            java.io.File file = fileChooser.getSelectedFile();
            // You can handle the selected file as needed
            System.out.println("Selected File: " + file.getAbsolutePath());
        }
    }

    public JPanel getPanel() {
        return panel;
    }
}
