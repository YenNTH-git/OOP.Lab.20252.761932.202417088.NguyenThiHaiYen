package hust.soict.hedspi.aims.screen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.Playable;
import hust.soict.hedspi.aims.cart.Cart;

public class MediaStore extends JPanel {
    private Media media;
    private Cart cart;

    // --- FIGURE 16 & SECTION 3.2: CONSTRUCTOR CÓ XỬ LÝ SỰ KIỆN ---
    public MediaStore(Media media, Cart cart) {
        this.media = media;
        this.cart = cart;
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        // 1. Hiển thị Tiêu đề (Title)
        JLabel title = new JLabel(media.getTitle());
        title.setFont(new Font(title.getFont().getName(), Font.BOLD, 20));
        title.setForeground(Color.BLUE);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        // 2. Hiển thị Giá (Cost)
        JLabel cost = new JLabel("" + media.getCost() + " $");
        cost.setAlignmentX(Component.CENTER_ALIGNMENT);

        // 3. Vùng chứa các nút bấm hành động
        JPanel container = new JPanel();
        container.setLayout(new FlowLayout(FlowLayout.CENTER));

        // --- Xử lý sự kiện khi nhấn nút "Add to cart" ---
        JButton btnAddToCart = new JButton("Add to cart");
        btnAddToCart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Thêm sản phẩm vào giỏ hàng thực tế của hệ thống
                cart.addMedia(media);
                JOptionPane.showMessageDialog(null,
                        "Added " + media.getTitle() + " to cart successfully!",
                        "Add to Cart",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        });
        container.add(btnAddToCart);

        // Nếu sản phẩm thuộc nhóm nghe nhìn (Playable) thì hiện thêm nút Play kèm sự kiện
        if (media instanceof Playable) {
            JButton btnPlay = new JButton("Play");

            // --- Xử lý sự kiện khi nhấn nút "Play" (Yêu cầu chính của Mục 3.2) ---
            btnPlay.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Tạo một cửa sổ JDialog nhỏ để mô phỏng phát nhạc/phim
                    JDialog dialog = new JDialog();
                    dialog.setTitle("Playing Media");
                    dialog.setSize(350, 150);
                    dialog.setLocationRelativeTo(null); // Đưa cửa sổ ra chính giữa màn hình

                    // Nội dung thông báo hiển thị trên JDialog
                    JLabel label = new JLabel("<html><center>🎬 <b>Now Playing:</b> " + media.getTitle()
                            + "<br>Enjoy your media!</center></html>", SwingConstants.CENTER);
                    dialog.add(label);

                    // Khóa màn hình chính lại cho tới khi người dùng tắt Dialog này đi (Modality)
                    dialog.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
                    dialog.setVisible(true);
                }
            });
            container.add(btnPlay);
        }

        // Căn đều khoảng cách dọc
        this.add(Box.createVerticalGlue());
        this.add(title);
        this.add(cost);
        this.add(Box.createVerticalGlue());
        this.add(container);

        // Tạo viền quanh ô sản phẩm
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }
}