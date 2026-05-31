package hust.soict.hedspi.aims.screen;

import hust.soict.hedspi.aims.store.Store;
import hust.soict.hedspi.aims.media.CompactDisc;
import javax.swing.*;

public class AddCompactDiscToStoreScreen extends AddItemToStoreScreen {
    private JTextField tfArtist = new JTextField(10);
    private JTextField tfDirector = new JTextField(10);

    public AddCompactDiscToStoreScreen(Store store) {
        super(store, "Add CD");
        add(new JLabel("Artist:")); add(tfArtist);
        add(new JLabel("Director:")); add(tfDirector);
    }

    @Override
    protected void addEvent() {
        try {
            CompactDisc cd = new CompactDisc(tfTitle.getText(), tfCategory.getText(),
                    Float.parseFloat(tfCost.getText()), tfArtist.getText(), tfDirector.getText());
            store.addMedia(cd);
            JOptionPane.showMessageDialog(this, "CD added to store!");
            this.dispose();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid input!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}