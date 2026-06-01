package hust.soict.hedspi.aims.screen;

import hust.soict.hedspi.aims.store.Store;

import javax.swing.*;
import java.awt.*;

public abstract class AddItemToStoreScreen extends JFrame {

    protected Store store;

    protected JTextField tfTitle = new JTextField(20);
    protected JTextField tfCategory = new JTextField(20);
    protected JTextField tfCost = new JTextField(20);

    protected JPanel formPanel;

    public AddItemToStoreScreen(Store store, String title) {
        this.store = store;

        setTitle(title);
        setSize(500, 350);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        setLayout(new BorderLayout(10, 10));

        formPanel = new JPanel();
        formPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        formPanel.setLayout(new GridLayout(0, 2, 10, 10));

        formPanel.add(new JLabel("Title:"));
        formPanel.add(tfTitle);

        formPanel.add(new JLabel("Category:"));
        formPanel.add(tfCategory);

        formPanel.add(new JLabel("Cost:"));
        formPanel.add(tfCost);

        add(formPanel, BorderLayout.CENTER);

        JButton btnAdd = new JButton("Add");
        btnAdd.addActionListener(e -> addEvent());

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(btnAdd);

        add(buttonPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    protected abstract void addEvent();
}