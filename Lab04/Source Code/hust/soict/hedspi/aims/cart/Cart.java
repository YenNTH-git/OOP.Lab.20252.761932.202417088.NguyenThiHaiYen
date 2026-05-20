package Aims_Project.hust.soict.hedspi.aims.cart;

import Aims_Project.hust.soict.hedspi.aims.media.media;
import java.util.ArrayList;
import java.util.Collections;
public class Cart {

    private ArrayList<media> itemsOrdered = new ArrayList<>();

    public void addMedia(media media) {
        if (itemsOrdered.contains(media)) {
            System.out.println("Item is already in the cart.");
        } else {
            itemsOrdered.add(media);
            System.out.println("Added: " + media.getTitle());
        }
    }

    public void removeMedia(media media) {
        if (itemsOrdered.contains(media)) {
            itemsOrdered.remove(media);
            System.out.println("Removed: " + media.getTitle());
        } else {
            System.out.println("Item not found in the cart.");
        }
    }

    public float totalCost() {
        float total = 0;
        for (media m : itemsOrdered) {
            total += m.getCost();
        }
        return total;
    }

    public void printCart() {
        System.out.println("***********************CART***********************");
        System.out.println("Ordered Items:");

        for (int i = 0; i < itemsOrdered.size(); i++) {
            System.out.println((i + 1) + ". " + itemsOrdered.get(i).toString());
        }

        System.out.println("Total cost: " + totalCost() + " $");
        System.out.println("***************************************************");
    }

    public media findByTitle(String title) {
        for (media m : itemsOrdered) {
            if (m.getTitle().equalsIgnoreCase(title)) {
                return m;
            }
        }
        return null;
    }

    public void filterById(int id) {
        System.out.println("Filter by ID = " + id);
        boolean found = false;

        for (media m : itemsOrdered) {
            if (m.getId() == id) {
                System.out.println(m.toString());
                found = true;
            }
        }

        if (!found) {
            System.out.println("No media with that ID found.");
        }
    }

    public void filterByTitle(String title) {
        System.out.println("Filter by title = " + title);
        boolean found = false;

        for (media m : itemsOrdered) {
            if (m.getTitle().equalsIgnoreCase(title)) {
                System.out.println(m.toString());
                found = true;
            }
        }

        if (!found) {
            System.out.println("No media with that title found.");
        }
    }

    public void sortByTitle() {
        Collections.sort(itemsOrdered, media.COMPARE_BY_TITLE_COST);
        System.out.println("Cart sorted by title.");
    }

    public void sortByCost() {
        Collections.sort(itemsOrdered, media.COMPARE_BY_COST_TITLE);
        System.out.println("Cart sorted by cost.");
    }

    public int getItemCount() {
        return itemsOrdered.size();
    }

    public void clear() {
        itemsOrdered.clear();
    }
}