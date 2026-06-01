package hust.soict.hedspi.aims.screen;

import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.store.Store;

import javax.swing.*;

public class AddCompactDiscToStoreScreen extends AddItemToStoreScreen {

    private JTextField tfArtist = new JTextField(20);
    private JTextField tfDirector = new JTextField(20);

    public AddCompactDiscToStoreScreen(Store store) {
        super(store, "Add CD");

        formPanel.add(new JLabel("Artist:"));
        formPanel.add(tfArtist);

        formPanel.add(new JLabel("Director:"));
        formPanel.add(tfDirector);

        revalidate();
        repaint();
    }

    @Override
    protected void addEvent() {
        try {
            CompactDisc cd = new CompactDisc(
                    tfTitle.getText(),
                    tfCategory.getText(),
                    Float.parseFloat(tfCost.getText()),
                    tfArtist.getText(),
                    tfDirector.getText()
            );

            store.addMedia(cd);

            JOptionPane.showMessageDialog(
                    this,
                    "CD added successfully!"
            );

            dispose();

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(
                    this,
                    "Cost must be a number!",
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }
}