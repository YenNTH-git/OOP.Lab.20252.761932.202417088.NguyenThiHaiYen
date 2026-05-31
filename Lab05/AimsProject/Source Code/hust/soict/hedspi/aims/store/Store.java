package hust.soict.hedspi.aims.store;

import java.util.ArrayList;

public class Store {

    private ArrayList<hust.soict.hedspi.aims.media.Media> itemsInStore = new ArrayList<>();

    // Hàm cực kỳ quan trọng để StoreScreen lấy danh sách đĩa hiển thị lên GUI
    public ArrayList<hust.soict.hedspi.aims.media.Media> getItemsInStore() {
        return this.itemsInStore;
    }

    public void addMedia(hust.soict.hedspi.aims.media.Media media) {
        if (itemsInStore.contains(media)) {
            System.out.println("Item already exists in the store.");
        } else {
            itemsInStore.add(media);
            System.out.println("Added to store: " + media.getTitle());
        }
    }

    public void removeMedia(hust.soict.hedspi.aims.media.Media media) {
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

    public hust.soict.hedspi.aims.media.Media findByTitle(String title) {
        for (hust.soict.hedspi.aims.media.Media m : itemsInStore) {
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