package hust.soict.hedspi.aims.screen;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

import hust.soict.hedspi.aims.store.Store;
import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.Media;

public class StoreScreen extends JFrame {
    private final Store store;
    private final Cart cart;

    public StoreScreen(Store store, Cart cart) {
        this.store = store;
        this.cart = cart;

        setTitle("Store");
        setSize(1024, 768);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setLayout(new BorderLayout());

        add(createNorth(), BorderLayout.NORTH);
        add(createCenter(), BorderLayout.CENTER);

        setVisible(true);
    }

    // ================= MENU BAR =================
    private JMenuBar createMenuBar() {
        JMenuBar menuBar = new JMenuBar();

        JMenu optionsMenu = new JMenu("Options");

        // ===== Update Store =====
        JMenu updateStore = new JMenu("Update Store");

        JMenuItem addBook = new JMenuItem("Add Book");
        addBook.addActionListener(e -> new AddBookToStoreScreen(store));

        JMenuItem addCD = new JMenuItem("Add CD");
        addCD.addActionListener(e -> new AddCompactDiscToStoreScreen(store));

        JMenuItem addDVD = new JMenuItem("Add DVD");
        addDVD.addActionListener(e -> new AddDigitalVideoDiscToStoreScreen(store));

        updateStore.add(addBook);
        updateStore.add(addCD);
        updateStore.add(addDVD);

        optionsMenu.add(updateStore);

        // ===== View Cart =====
        JMenuItem viewCart = new JMenuItem("View Cart");
        viewCart.addActionListener(e -> new CartScreen(cart));
        optionsMenu.add(viewCart);

        // ===== View Store (FIXED) =====
        JMenuItem viewStore = new JMenuItem("View Store");
        viewStore.addActionListener(e -> {
            dispose();
            SwingUtilities.invokeLater(() -> new StoreScreen(store, cart));
        });
        optionsMenu.add(viewStore);

        menuBar.add(optionsMenu);
        return menuBar;
    }

    // ================= NORTH =================
    private JPanel createNorth() {
        JPanel north = new JPanel();
        north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));

        north.add(createMenuBar());
        north.add(createHeader());

        return north;
    }

    // ================= HEADER =================
    private JPanel createHeader() {
        JPanel header = new JPanel();
        header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));

        JLabel title = new JLabel("AIMS");
        title.setFont(new Font("Arial", Font.BOLD, 48));
        title.setForeground(Color.BLUE);

        JButton btnCart = new JButton("View cart");
        btnCart.addActionListener(e -> new CartScreen(cart));

        header.add(Box.createRigidArea(new Dimension(10, 10)));
        header.add(title);
        header.add(Box.createHorizontalGlue());
        header.add(btnCart);
        header.add(Box.createRigidArea(new Dimension(10, 10)));

        return header;
    }

    // ================= CENTER =================
    private JPanel createCenter() {
        JPanel center = new JPanel();
        center.setLayout(new GridLayout(3, 3, 10, 10));

        ArrayList<Media> list = store.getItemsInStore();

        int limit = Math.min(list.size(), 9);

        for (int i = 0; i < limit; i++) {
            Media media = list.get(i);
            center.add(new MediaStore(media, cart, store));
        }

        return center;
    }
}