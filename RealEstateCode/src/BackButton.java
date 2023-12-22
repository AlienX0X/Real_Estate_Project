import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BackButton implements CommandButton {

    private final JButton button;

    public BackButton(Runnable onBackButtonClick) {
        button = new JButton("Back");
        button.addActionListener(e -> onBackButtonClick.run());
    }

    @Override
    public JButton getButton() {
        return button;
    }
}
