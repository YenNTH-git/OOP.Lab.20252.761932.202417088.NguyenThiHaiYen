package hust.soict.hedspi.aims.cart;

import java.util.ArrayList;
import java.util.Collections;

public class Cart {

    private ArrayList<hust.soict.hedspi.aims.media.Media> itemsOrdered = new ArrayList<>();

    // ===== ADD =====
    public void addMedia(hust.soict.hedspi.aims.media.Media media) {

        if (itemsOrdered.contains(media)) {
            System.out.println("Item is already in the cart.");
            return;
        }

        itemsOrdered.add(media);
        System.out.println("Added: " + media.getTitle());
    }

    // ===== REMOVE =====
    public void removeMedia(hust.soict.hedspi.aims.media.Media media) {

        if (itemsOrdered.contains(media)) {
            itemsOrdered.remove(media);
            System.out.println("Removed: " + media.getTitle());
        } else {
            System.out.println("Item not found in cart.");
        }
    }

    // ===== TOTAL COST =====
    public float totalCost() {

        float total = 0;

        for (hust.soict.hedspi.aims.media.Media m : itemsOrdered) {
            total += m.getCost();
        }

        return total;
    }

    // ===== PRINT CART =====
    public void printCart() {

        System.out.println("*********************** CART ***********************");

        for (int i = 0; i < itemsOrdered.size(); i++) {
            System.out.println((i + 1) + ". " + itemsOrdered.get(i));
        }

        System.out.println("Total cost: " + totalCost() + " $");

        System.out.println("****************************************************");
    }

    // ===== FIND =====
    public hust.soict.hedspi.aims.media.Media findByTitle(String title) {

        for (hust.soict.hedspi.aims.media.Media m : itemsOrdered) {

            if (m.getTitle() != null
                    && m.getTitle().equalsIgnoreCase(title)) {

                return m;
            }
        }

        return null;
    }

    // ===== FILTER BY ID =====
    public void filterById(int id) {

        boolean found = false;

        for (hust.soict.hedspi.aims.media.Media m : itemsOrdered) {

            if (m.getId() == id) {
                System.out.println(m);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No media found.");
        }
    }

    // ===== FILTER BY TITLE =====
    public void filterByTitle(String title) {

        boolean found = false;

        for (hust.soict.hedspi.aims.media.Media m : itemsOrdered) {

            if (m.getTitle() != null
                    && m.getTitle().equalsIgnoreCase(title)) {

                System.out.println(m);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No media found.");
        }
    }

    // ===== SORT =====
    public void sortByTitle() {

        Collections.sort(
                itemsOrdered,
                hust.soict.hedspi.aims.media.Media.COMPARE_BY_TITLE_COST
        );

        System.out.println("Cart sorted by title.");
    }

    public void sortByCost() {

        Collections.sort(
                itemsOrdered,
                hust.soict.hedspi.aims.media.Media.COMPARE_BY_COST_TITLE
        );

        System.out.println("Cart sorted by cost.");
    }

    // ===== COUNT =====
    public int getItemCount() {
        return itemsOrdered.size();
    }

    // ===== CLEAR =====
    public void clear() {
        itemsOrdered.clear();
    }
}