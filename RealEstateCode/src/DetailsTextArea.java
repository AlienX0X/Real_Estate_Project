
import javax.swing.JPanel;
import javax.swing.JTextArea;

 class DetailsTextArea implements Displayable {
        private final JTextArea detailsTextArea;
    private String DETAILS_TEXT;

        public DetailsTextArea() {
            detailsTextArea = new JTextArea(DETAILS_TEXT);
            detailsTextArea.setEditable(false);
            detailsTextArea.setLineWrap(true);
            detailsTextArea.setWrapStyleWord(true);
        }

        @Override
        public JPanel getPanel() {
            JPanel detailsPanel = new JPanel();
            detailsPanel.add(detailsTextArea);
            return detailsPanel;
        }
    }