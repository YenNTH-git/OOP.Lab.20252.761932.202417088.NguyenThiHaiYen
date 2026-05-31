package hust.soict.hedspi.aims.screen;

import hust.soict.hedspi.aims.store.Store;
import javax.swing.*;
import java.awt.*;

public abstract class AddItemToStoreScreen extends JFrame {
    protected Store store;
    protected JTextField tfTitle = new JTextField(10);
    protected JTextField tfCategory = new JTextField(10);
    protected JTextField tfCost = new JTextField(10);

    public AddItemToStoreScreen(Store store, String title) {
        this.store = store;
        this.setTitle(title);
        this.setLayout(new GridLayout(0, 2, 5, 5));

        add(new JLabel("Title:")); add(tfTitle);
        add(new JLabel("Category:")); add(tfCategory);
        add(new JLabel("Cost:")); add(tfCost);

        JButton btnAdd = new JButton("Add");
        btnAdd.addActionListener(e -> addEvent());
        add(btnAdd);

        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }

    // Hàm này sẽ được các lớp con tự định nghĩa logic thêm riêng
    protected abstract void addEvent();
}