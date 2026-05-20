package Aims_Project.hust.soict.hedspi.test.cart;

import Aims_Project.hust.soict.hedspi.aims.cart.Cart;
import Aims_Project.hust.soict.hedspi.aims.disc.DigitalVideoDisc;

public class TestCart {

    public static void main(String[] args) {

        Cart cart = new Cart();

        DigitalVideoDisc d1 =
                new DigitalVideoDisc(1, "Lion King", "Animation", 19.95f, 90, "Roger");

        DigitalVideoDisc d2 =
                new DigitalVideoDisc(2, "Star Wars", "Sci-fi", 24.95f, 120, "George Lucas");

        DigitalVideoDisc d3 =
                new DigitalVideoDisc(3, "Aladdin", "Animation", 18.99f, 95, "Disney");

        // ADD (FIX API)
        cart.addMedia(d1);
        cart.addMedia(d2);
        cart.addMedia(d3);

        cart.printCart();

        System.out.println("\nSearch by ID (2):");
        cart.filterById(2);

        System.out.println("\nSearch by Title (lion):");
        cart.filterByTitle("lion");

        System.out.println("\nSearch by Title (abc):");
        cart.filterByTitle("abc");
    }
}