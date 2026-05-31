package hust.soict.hedspi.aims.screen;

import hust.soict.hedspi.aims.store.Store;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import javax.swing.*;

public class AddDigitalVideoDiscToStoreScreen extends AddItemToStoreScreen {
    private JTextField tfDirector = new JTextField(10);
    private JTextField tfLength = new JTextField(10);

    public AddDigitalVideoDiscToStoreScreen(Store store) {
        super(store, "Add DVD");
        add(new JLabel("Director:")); add(tfDirector);
        add(new JLabel("Length:")); add(tfLength);
    }

    @Override
    protected void addEvent() {
        try {
            // Kiểm tra xem các ô có bị để trống không
            if (tfTitle.getText().isEmpty() || tfCategory.getText().isEmpty() ||
                    tfCost.getText().isEmpty() || tfDirector.getText().isEmpty() || tfLength.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please fill in all fields!");
                return;
            }

            float cost = Float.parseFloat(tfCost.getText());
            int length = Integer.parseInt(tfLength.getText());

            DigitalVideoDisc dvd = new DigitalVideoDisc(tfTitle.getText(), tfCategory.getText(),
                    cost, tfDirector.getText(), length);
            store.addMedia(dvd);
            JOptionPane.showMessageDialog(this, "DVD added!");
            this.dispose();

        } catch (NumberFormatException e) {
            // Lỗi này bắt khi người dùng nhập chữ vào ô số
            JOptionPane.showMessageDialog(this, "Cost and Length must be numbers!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}