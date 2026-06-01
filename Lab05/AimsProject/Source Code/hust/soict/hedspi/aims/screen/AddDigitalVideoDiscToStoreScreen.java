package hust.soict.hedspi.aims.screen;

import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.store.Store;

import javax.swing.*;

public class AddDigitalVideoDiscToStoreScreen extends AddItemToStoreScreen {

    private JTextField tfDirector = new JTextField(20);
    private JTextField tfLength = new JTextField(20);

    public AddDigitalVideoDiscToStoreScreen(Store store) {
        super(store, "Add DVD");

        formPanel.add(new JLabel("Director:"));
        formPanel.add(tfDirector);

        formPanel.add(new JLabel("Length:"));
        formPanel.add(tfLength);

        revalidate();
        repaint();
    }

    @Override
    protected void addEvent() {
        try {

            float cost = Float.parseFloat(tfCost.getText());
            int length = Integer.parseInt(tfLength.getText());

            DigitalVideoDisc dvd = new DigitalVideoDisc(
                    tfTitle.getText(),
                    tfCategory.getText(),
                    cost,
                    tfDirector.getText(),
                    length
            );

            store.addMedia(dvd);

            JOptionPane.showMessageDialog(
                    this,
                    "DVD added successfully!"
            );

            dispose();

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(
                    this,
                    "Cost and Length must be numbers!",
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }
}