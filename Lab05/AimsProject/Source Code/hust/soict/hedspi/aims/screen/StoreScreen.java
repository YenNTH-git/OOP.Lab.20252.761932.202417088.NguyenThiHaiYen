package hust.soict.hedspi.aims.screen;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import hust.soict.hedspi.aims.store.Store;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;

public class StoreScreen extends JFrame {
    private Store store;

    // --- FIGURE 10: CONSTRUCTOR ---
    public StoreScreen(Store store) {
        this.store = store;
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
        menuOptions.add(new JMenuItem("View cart"));
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

        JButton cart = new JButton("View cart");
        cart.setPreferredSize(new Dimension(100, 50));
        cart.setMaximumSize(new Dimension(100, 50));

        header.add(Box.createRigidArea(new Dimension(10, 10)));
        header.add(title);
        header.add(Box.createHorizontalGlue());
        header.add(cart);
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
            MediaStore cell = new MediaStore(mediaInStore.get(i));
            center.add(cell);
        }

        return center;
    }

    // Hàm main mẫu chạy hoàn hảo không lo lỗi Constructor gạch đỏ
    public static void main(String[] args) {
        Store mockStore = new Store();

        // Gọi trực tiếp cấu trúc dữ liệu mẫu của bài Lab nhờ constructor 5 tham số vừa bổ sung
        mockStore.addMedia(new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 88, 19.95f));
        mockStore.addMedia(new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 124, 24.95f));
        mockStore.addMedia(new DigitalVideoDisc("Aladdin", "Animation", "John Musker", 90, 18.99f));

        // Bật màn hình lên
        new StoreScreen(mockStore);
    }
}