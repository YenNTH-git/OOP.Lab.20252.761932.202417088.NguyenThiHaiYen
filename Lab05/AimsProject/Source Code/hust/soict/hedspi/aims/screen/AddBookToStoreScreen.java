package hust.soict.hedspi.aims.screen;

import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.store.Store;

import javax.swing.*;

public class AddBookToStoreScreen extends AddItemToStoreScreen {

    private JTextField tfAuthors = new JTextField(20);

    public AddBookToStoreScreen(Store store) {
        super(store, "Add Book");

        formPanel.add(new JLabel("Authors:"));
        formPanel.add(tfAuthors);

        revalidate();
        repaint();
    }

    @Override
    protected void addEvent() {
        try {
            Book book = new Book(
                    tfTitle.getText(),
                    tfCategory.getText(),
                    Float.parseFloat(tfCost.getText()),
                    tfAuthors.getText()
            );

            store.addMedia(book);

            JOptionPane.showMessageDialog(
                    this,
                    "Book added successfully!"
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