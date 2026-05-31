package hust.soict.hedspi.aims.screen;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import hust.soict.hedspi.aims.store.Store;
import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.Media;

public class StoreScreen extends JFrame {
    private Store store;
    private Cart cart;

    // --- FIGURE 10: CONSTRUCTOR ---
    public StoreScreen(Store store, Cart cart) {
        this.store = store;
        this.cart = cart;
        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());

        cp.add(createNorth(), BorderLayout.NORTH);
        cp.add(createCenter(), BorderLayout.CENTER);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Store");
        setSize(1024, 768);
        setVisible(true);
    }

    // --- FIGURE 11: CREATE NORTH SECTION ---
    JPanel createNorth() {
        JPanel north = new JPanel();
        north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
        north.add(createMenuBar());
        north.add(createHeader());
        return north;
    }

    // --- FIGURE 12: CREATE MENU BAR ---
    JMenuBar createMenuBar() {
        JMenuBar menu = new JMenuBar();

        JMenu smUpdateStore = new JMenu("Update Store");
        smUpdateStore.add(new JMenuItem("Add Book"));
        smUpdateStore.add(new JMenuItem("Add CD"));
        smUpdateStore.add(new JMenuItem("Add DVD"));

        JMenu menuOptions = new JMenu("Options");
        menuOptions.add(smUpdateStore);

        // Sự kiện Menu View cart -> Bật màn hình Giỏ hàng JavaFX
        JMenuItem viewCartMenu = new JMenuItem("View cart");
        viewCartMenu.addActionListener(e -> new CartScreen(cart));
        menuOptions.add(viewCartMenu);

        menuOptions.add(new JMenuItem("View store"));

        menu.add(menuOptions);
        return menu;
    }

    // --- FIGURE 14: CREATE HEADER ---
    JPanel createHeader() {
        JPanel header = new JPanel();
        header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));

        JLabel title = new JLabel("AIMS");
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 50));
        title.setForeground(Color.CYAN);

        JButton btnCart = new JButton("View cart");
        btnCart.setPreferredSize(new Dimension(100, 50));
        btnCart.setMaximumSize(new Dimension(100, 50));

        // Sự kiện nút bấm View cart trên Header -> Bật màn hình Giỏ hàng JavaFX
        btnCart.addActionListener(e -> new CartScreen(cart));

        header.add(Box.createRigidArea(new Dimension(10, 10)));
        header.add(title);
        header.add(Box.createHorizontalGlue());
        header.add(btnCart);
        header.add(Box.createRigidArea(new Dimension(10, 10)));

        return header;
    }

    // --- FIGURE 15: CREATE CENTER (GRID OF ITEMS) ---
    JPanel createCenter() {
        JPanel center = new JPanel();
        center.setLayout(new GridLayout(3, 3, 10, 10)); // Lưới 3 hàng, 3 cột

        ArrayList<Media> mediaInStore = store.getItemsInStore();
        // Lấy tối đa 9 sản phẩm đầu tiên để hiển thị vừa vặn khung lưới 3x3
        int limit = Math.min(mediaInStore.size(), 9);
        for (int i = 0; i < limit; i++) {
            MediaStore cell = new MediaStore(mediaInStore.get(i), cart);
            center.add(cell);
        }

        return center;
    }
}