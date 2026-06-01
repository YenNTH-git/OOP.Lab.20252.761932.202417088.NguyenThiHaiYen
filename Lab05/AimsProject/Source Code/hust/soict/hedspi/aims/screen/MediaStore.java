package hust.soict.hedspi.aims.screen;

import javax.swing.*;
import java.awt.*;

import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.Playable;
import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.store.Store;

public class MediaStore extends JPanel {

    private final Media media;
    private final Cart cart;
    private final Store store;

    public MediaStore(Media media, Cart cart, Store store) {
        this.media = media;
        this.cart = cart;
        this.store = store;

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBorder(BorderFactory.createLineBorder(Color.BLACK));

        // ===== TITLE =====
        JLabel title = new JLabel(media.getTitle());
        title.setFont(new Font("Arial", Font.BOLD, 16));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        // ===== COST =====
        JLabel cost = new JLabel(media.getCost() + " $");
        cost.setAlignmentX(Component.CENTER_ALIGNMENT);

        // ===== BUTTON PANEL =====
        JPanel btnPanel = new JPanel(new FlowLayout());

        // ===== ADD TO CART =====
        JButton btnAdd = new JButton("Add to cart");
        btnAdd.addActionListener(e -> {
            cart.addMedia(media);

            JOptionPane.showMessageDialog(
                    this,
                    "Added " + media.getTitle() + " to cart successfully!"
            );
        });

        btnPanel.add(btnAdd);

        // ===== PLAY =====
        if (media instanceof Playable) {
            JButton btnPlay = new JButton("Play");

            btnPlay.addActionListener(e -> {
                JOptionPane.showMessageDialog(
                        this,
                        "Playing: " + media.getTitle()
                );
            });

            btnPanel.add(btnPlay);
        }

        // ===== REMOVE FROM STORE =====
        JButton btnRemove = new JButton("Remove");

        btnRemove.addActionListener(e -> {
            store.removeMedia(media);

            JOptionPane.showMessageDialog(
                    this,
                    "Removed " + media.getTitle() + " from store"
            );

            // reload UI store
            SwingUtilities.getWindowAncestor(this).dispose();
            new StoreScreen(store, cart);
        });

        btnPanel.add(btnRemove);

        add(title);
        add(cost);
        add(btnPanel);
    }
}