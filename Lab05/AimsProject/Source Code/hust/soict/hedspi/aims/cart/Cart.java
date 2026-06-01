package hust.soict.hedspi.aims.cart;

import java.util.Collections;
import hust.soict.hedspi.aims.media.Media;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Cart {

    private final ObservableList<Media> itemsOrdered = FXCollections.observableArrayList();

    public ObservableList<Media> getItemsOrdered() {
        return this.itemsOrdered;
    }

    // ================= ADD =================
    public void addMedia(Media media) {
        if (itemsOrdered.contains(media)) {
            System.out.println("Item is already in the cart.");
            return;
        }
        itemsOrdered.add(media);
        System.out.println("Added: " + media.getTitle());
    }

    // ================= REMOVE =================
    public void removeMedia(Media media) {
        if (itemsOrdered.contains(media)) {
            itemsOrdered.remove(media);
            System.out.println("Removed: " + media.getTitle());
        } else {
            System.out.println("Item not found in cart.");
        }
    }

    // ================= TOTAL COST =================
    public float totalCost() {
        float total = 0;
        for (Media m : itemsOrdered) {
            total += m.getCost();
        }
        return total;
    }

    // ================= PRINT =================
    public void printCart() {
        System.out.println("*********************** CART ***********************");
        for (int i = 0; i < itemsOrdered.size(); i++) {
            System.out.println((i + 1) + ". " + itemsOrdered.get(i));
        }
        System.out.println("Total cost: " + totalCost() + " $");
        System.out.println("****************************************************");
    }

    // ================= FIND =================
    public Media findByTitle(String title) {
        for (Media m : itemsOrdered) {
            if (m.getTitle() != null && m.getTitle().equalsIgnoreCase(title)) {
                return m;
            }
        }
        return null;
    }

    // ================= FILTER =================
    public void filterById(int id) {
        boolean found = false;
        for (Media m : itemsOrdered) {
            if (m.getId() == id) {
                System.out.println(m);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No media found.");
        }
    }

    public void filterByTitle(String title) {
        boolean found = false;
        for (Media m : itemsOrdered) {
            if (m.getTitle() != null && m.getTitle().equalsIgnoreCase(title)) {
                System.out.println(m);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No media found.");
        }
    }

    // ================= SORT (FIX CHO JAVAFX) =================
    public void sortByTitle() {
        FXCollections.sort(itemsOrdered,
                (a, b) -> a.getTitle().compareToIgnoreCase(b.getTitle()));

        System.out.println("Cart sorted by title.");
    }

    public void sortByCost() {
        FXCollections.sort(itemsOrdered,
                (a, b) -> Float.compare(a.getCost(), b.getCost()));

        System.out.println("Cart sorted by cost.");
    }

    // ================= COUNT =================
    public int getItemCount() {
        return itemsOrdered.size();
    }

    // ================= CLEAR =================
    public void clear() {
        itemsOrdered.clear();
    }
}