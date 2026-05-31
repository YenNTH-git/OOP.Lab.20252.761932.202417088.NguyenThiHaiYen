package hust.soict.hedspi.test.cart;

import hust.soict.hedspi.aims.cart.Cart;
// SỬA LỖI: Import lớp DigitalVideoDisc từ package media để hết gạch đỏ
import hust.soict.hedspi.aims.media.DigitalVideoDisc;

public class TestCart {

    public static void main(String[] args) {

        Cart cart = new Cart();

        // SỬA LỖI: Đảo vị trí cost (float) lên trước length (int) để khớp 100% với constructor của bạn
        DigitalVideoDisc d1 =
                new DigitalVideoDisc(
                        1,
                        "Lion King",
                        "Animation",
                        19.95f,
                        90,
                        "Roger"
                );

        DigitalVideoDisc d2 =
                new DigitalVideoDisc(
                        2,
                        "Star Wars",
                        "Sci-fi",
                        24.95f,
                        120,
                        "George Lucas"
                );

        DigitalVideoDisc d3 =
                new DigitalVideoDisc(
                        3,
                        "Aladdin",
                        "Animation",
                        18.99f,
                        95,
                        "Disney"
                );

        // ===== ADD =====
        cart.addMedia(d1);
        cart.addMedia(d2);
        cart.addMedia(d3);

        // ===== PRINT =====
        cart.printCart();

        // ===== FILTER =====
        System.out.println("\nSearch by ID (2):");

        cart.filterById(2);

        System.out.println("\nSearch by Title (Lion King):");

        cart.filterByTitle("Lion King");

        System.out.println("\nSearch by Title (abc):");

        cart.filterByTitle("abc");
    }
}