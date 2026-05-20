package hust.soict.hedspi.aims.cart;

import hust.soict.hedspi.aims.disc.DigitalVideoDisc;

public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;

    private DigitalVideoDisc[] itemsOrdered = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
    private int qtyOrdered = 0;

    // ===== ADD =====
    public void addDigitalVideoDisc(DigitalVideoDisc disc) {
        if (disc == null) {
            System.out.println("Invalid disc");
            return;
        }

        if (qtyOrdered < MAX_NUMBERS_ORDERED) {
            itemsOrdered[qtyOrdered++] = disc;
            System.out.println("The disc has been added");
        } else {
            System.out.println("The cart is almost full");
        }
    }

    // Overloading: 2 DVDs
    public void addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
        addDigitalVideoDisc(dvd1);
        addDigitalVideoDisc(dvd2);
    }
    /*
    // Overloading: ARRAY
    public void addDigitalVideoDisc(DigitalVideoDisc[] dvdList) {
        for (DigitalVideoDisc dvd : dvdList) {
            addDigitalVideoDisc(dvd);
        }
    }
    */
    // Overloading: VARARGS
    public void addDigitalVideoDisc(DigitalVideoDisc... dvds) {
        for (DigitalVideoDisc dvd : dvds) {
            addDigitalVideoDisc(dvd);
        }
    }

    // ===== REMOVE =====
    public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
        for (int i = 0; i < qtyOrdered; i++) {
            if (itemsOrdered[i].getId() == disc.getId()) {
                for (int j = i; j < qtyOrdered - 1; j++) {
                    itemsOrdered[j] = itemsOrdered[j + 1];
                }
                itemsOrdered[--qtyOrdered] = null;
                System.out.println("The disc has been removed");
                return;
            }
        }
        System.out.println("The disc was not found");
    }

    // ===== TOTAL COST =====
    public float totalCost() {
        float total = 0;
        for (int i = 0; i < qtyOrdered; i++) {
            total += itemsOrdered[i].getCost();
        }
        return total;
    }

    // ===== PRINT CART =====
    public void printCart() {
        System.out.println("***********************CART***********************");
        System.out.println("Ordered Items:");

        for (int i = 0; i < qtyOrdered; i++) {
            System.out.println((i + 1) + ". " + itemsOrdered[i]);
        }

        System.out.printf("Total cost: %.2f $\n", totalCost());
        System.out.println("***************************************************");
    }

    // ===== SEARCH BY ID =====
    public void searchById(int id) {
        for (int i = 0; i < qtyOrdered; i++) {
            if (itemsOrdered[i].getId() == id) {
                System.out.println("Found:");
                System.out.println(itemsOrdered[i]);
                return;
            }
        }
        System.out.println("No matching DVD found");
    }

    // ===== SEARCH BY TITLE =====
    public void searchByTitle(String title) {
        boolean found = false;

        for (int i = 0; i < qtyOrdered; i++) {
            if (itemsOrdered[i].isMatch(title)) {
                System.out.println("Found:");
                System.out.println(itemsOrdered[i]);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No matching DVD found");
        }
    }
}