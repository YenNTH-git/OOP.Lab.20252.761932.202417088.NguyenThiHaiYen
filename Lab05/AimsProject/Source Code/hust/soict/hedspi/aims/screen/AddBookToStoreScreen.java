package hust.soict.hedspi.aims.screen;

import hust.soict.hedspi.aims.store.Store;
import hust.soict.hedspi.aims.media.Book;
import javax.swing.*;

public class AddBookToStoreScreen extends AddItemToStoreScreen {
    private JTextField tfAuthors = new JTextField(10);

    public AddBookToStoreScreen(Store store) {
        super(store, "Add Book");
        add(new JLabel("Authors:")); add(tfAuthors);
    }

    @Override
    protected void addEvent() {
        Book book = new Book(tfTitle.getText(), tfCategory.getText(),
                Float.parseFloat(tfCost.getText()), tfAuthors.getText());
        store.addMedia(book);
        JOptionPane.showMessageDialog(this, "Book added!");
        this.dispose();
    }
}