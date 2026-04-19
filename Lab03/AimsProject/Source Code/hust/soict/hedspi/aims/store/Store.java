package hust.soict.hedspi.aims.store;

import hust.soict.hedspi.aims.disc.DigitalVideoDisc;

public class Store {
    public static final int MAX_ITEMS_IN_STORE = 100;

    private DigitalVideoDisc[] itemsInStore = new DigitalVideoDisc[MAX_ITEMS_IN_STORE];
    private int qtyInStore = 0;

    // ===== ADD =====
    public void addDVD(DigitalVideoDisc disc) {
        if (disc == null) {
            System.out.println("Invalid DVD");
            return;
        }

        if (qtyInStore < MAX_ITEMS_IN_STORE) {
            itemsInStore[qtyInStore++] = disc;
            System.out.println("The DVD has been added to store");
        } else {
            System.out.println("The store is full");
        }
    }

    // ===== REMOVE =====
    public void removeDVD(DigitalVideoDisc disc) {
        for (int i = 0; i < qtyInStore; i++) {
            if (itemsInStore[i].getId() == disc.getId()) {

                // dồn mảng
                for (int j = i; j < qtyInStore - 1; j++) {
                    itemsInStore[j] = itemsInStore[j + 1];
                }

                itemsInStore[--qtyInStore] = null;
                System.out.println("The DVD has been removed from store");
                return;
            }
        }

        System.out.println("The DVD was not found in store");
    }

    // ===== PRINT STORE =====
    public void printStore() {
        System.out.println("***STORE***");

        for (int i = 0; i < qtyInStore; i++) {
            System.out.println((i + 1) + ". " + itemsInStore[i]);
        }

        System.out.println("Total items: " + qtyInStore);
    }
}