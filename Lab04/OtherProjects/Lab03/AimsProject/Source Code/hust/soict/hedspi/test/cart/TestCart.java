package hust.soict.hedspi.test.cart;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.disc.DigitalVideoDisc;

public class TestCart {
    public static void main(String[] args) {

        Cart cart = new Cart();

        DigitalVideoDisc d1 = new DigitalVideoDisc("Lion King", "Animation", "Roger", 90, 19.95f);
        DigitalVideoDisc d2 = new DigitalVideoDisc("Star Wars", "Sci-fi", "George Lucas", 120, 24.95f);
        DigitalVideoDisc d3 = new DigitalVideoDisc("Aladdin", "Animation", "Disney", 95, 18.99f);

        cart.addDigitalVideoDisc(d1, d2, d3);

        cart.printCart();

        System.out.println("\nSearch by ID (2):");
        cart.searchById(2);

        System.out.println("\nSearch by Title (lion):");
        cart.searchByTitle("lion");

        System.out.println("\nSearch by Title (abc):");
        cart.searchByTitle("abc");
    }
}