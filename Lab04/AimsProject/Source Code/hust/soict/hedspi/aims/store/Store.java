package Aims_Project.hust.soict.hedspi.aims.store;

import java.util.ArrayList;

public class Store {

    private ArrayList<Aims_Project.hust.soict.hedspi.aims.media.media> itemsInStore = new ArrayList<>();

    public void addMedia(Aims_Project.hust.soict.hedspi.aims.media.media media) {
        if (itemsInStore.contains(media)) {
            System.out.println("Item already exists in the store.");
        } else {
            itemsInStore.add(media);
            System.out.println("Added to store: " + media.getTitle());
        }
    }

    public void removeMedia(Aims_Project.hust.soict.hedspi.aims.media.media media) {
        if (itemsInStore.contains(media)) {
            itemsInStore.remove(media);
            System.out.println("Removed from store: " + media.getTitle());
        } else {
            System.out.println("Item not found in store.");
        }
    }

    public void printStore() {
        System.out.println("***********************STORE***********************");

        for (int i = 0; i < itemsInStore.size(); i++) {
            System.out.println((i + 1) + ". " + itemsInStore.get(i));
        }

        System.out.println("***************************************************");
    }

    public Aims_Project.hust.soict.hedspi.aims.media.media findByTitle(String title) {
        for (Aims_Project.hust.soict.hedspi.aims.media.media m : itemsInStore) {
            if (m.getTitle() != null && m.getTitle().equalsIgnoreCase(title)) {
                return m;
            }
        }
        return null;
    }

    public int getItemCount() {
        return itemsInStore.size();
    }

    public void clear() {
        itemsInStore.clear();
    }
}