package Aims_Project.hust.soict.hedspi.aims;

import Aims_Project.hust.soict.hedspi.aims.cart.Cart;
import Aims_Project.hust.soict.hedspi.aims.disc.DigitalVideoDisc;

public class Aims {
    public static void main(String[] args) {

        // Create a new cart
        Cart anOrder = new Cart();

        // Create new dvd and add to the cart
        DigitalVideoDisc dvd1 = new DigitalVideoDisc(
                "DVD One", "Category 1", "Director 1", 120, 10.0f);

        DigitalVideoDisc dvd2 = new DigitalVideoDisc(
                "DVD Two", "Category 2", "Director 2", 90, 15.5f);

        DigitalVideoDisc dvd3 = new DigitalVideoDisc(
                "DVD Three", "Category 3", "Director 3", 100, 20.0f);

        // Add DVDs
        anOrder.addDigitalVideoDisc(dvd1);
        anOrder.addDigitalVideoDisc(dvd2);
        anOrder.addDigitalVideoDisc(dvd3);

        // Print total cost
        System.out.println("Total cost is: " + anOrder.totalCost());

        // Test remove
        anOrder.removeDigitalVideoDisc(dvd2);

        // Print again
        System.out.println("Total cost after remove: " + anOrder.totalCost());
    }
}
