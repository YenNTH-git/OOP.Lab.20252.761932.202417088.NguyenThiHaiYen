package hust.soict.hedspi.aims;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.store.Store;
import hust.soict.hedspi.aims.media.*;
import hust.soict.hedspi.aims.exception.PlayerException;

import javax.swing.JOptionPane;
import java.util.Scanner;

public class Aims {

    private static Store store = new Store();
    private static Cart cart = new Cart();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        initSampleData();
        int choice = -1;
        while (choice != 0) {
            showMenu();
            choice = readInt("Your choice: ");
            switch (choice) {
                case 1: viewStore(); break;
                case 2: updateStore(); break;
                case 3: viewCart(); break;
                case 0: System.out.println("Exiting AIMS..."); break;
                default: System.out.println("Invalid choice!");
            }
        }
    }

    // --- HÀM XỬ LÝ PLAY (ĐÃ BẮT LỖI VÀ HIỆN THÔNG BÁO) ---
    private static void playMedia(Media m) {
        if (m instanceof Playable) {
            try {
                ((Playable) m).play();
            } catch (PlayerException e) {
                JOptionPane.showMessageDialog(null,
                        e.getMessage(),
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
                e.printStackTrace();
            }
        } else {
            System.out.println("This media cannot be played!");
        }
    }

    private static void initSampleData() {
        Book b1 = new Book(1, "Sherlock Holmes", "Detective", 15.5f);
        b1.addAuthor("Arthur Conan Doyle");
        DigitalVideoDisc dvd1 = new DigitalVideoDisc(2, "The Lion King", "Animation", 19.95f, 87, "Roger Allers");
        CompactDisc cd1 = new CompactDisc(3, "Greatest Hits", "Music", 12.99f, 77, "Producer X", "Artist A");
        cd1.addTrack(new Track("Track 1", 4));
        cd1.addTrack(new Track("Track 2", 3));
        store.addMedia(b1);
        store.addMedia(dvd1);
        store.addMedia(cd1);
    }

    public static void showMenu() {
        System.out.println("AIMS\n--------------------------------\n1. View store\n2. Update store\n3. See current cart\n0. Exit\n--------------------------------");
    }

    public static void viewStore() {
        int choice = -1;
        while (choice != 0) {
            System.out.println("\n===== STORE =====");
            store.printStore();
            storeMenu();
            choice = readInt("Your choice: ");
            switch (choice) {
                case 1: seeMediaDetails(); break;
                case 2: addMediaToCart(); break;
                case 3: playMediaInStore(); break;
                case 4: viewCart(); break;
                case 0: break;
                default: System.out.println("Invalid choice!");
            }
        }
    }

    public static void storeMenu() {
        System.out.println("Store Options:\n1. See details\n2. Add to cart\n3. Play\n4. See cart\n0. Back");
    }

    public static void seeMediaDetails() {
        String title = readString("Enter media title: ");
        Media m = store.findByTitle(title);
        if (m == null) { System.out.println("Media not found!"); return; }
        System.out.println("\n=== MEDIA DETAILS ===\n" + m);
        mediaDetailsMenu();
        int choice = readInt("Your choice: ");
        if (choice == 1) cart.addMedia(m);
        else if (choice == 2) playMedia(m);
    }

    public static void mediaDetailsMenu() { System.out.println("1. Add to cart\n2. Play\n0. Back"); }

    public static void viewCart() {
        int choice = -1;
        while (choice != 0) {
            System.out.println("\n===== CART =====");
            cart.printCart();
            cartMenu();
            choice = readInt("Your choice: ");
            switch (choice) {
                case 1: filterCart(); break;
                case 2: sortCart(); break;
                case 3: removeFromCart(); break;
                case 4: playFromCart(); break;
                case 5: placeOrder(); break;
                case 0: break;
                default: System.out.println("Invalid choice!");
            }
        }
    }

    public static void cartMenu() {
        System.out.println("Cart Options:\n1. Filter\n2. Sort\n3. Remove\n4. Play\n5. Place order\n0. Back");
    }

    public static void filterCart() {
        System.out.println("1. Filter by ID\n2. Filter by title");
        int choice = readInt("Your choice: ");
        if (choice == 1) cart.filterById(readInt("Enter ID: "));
        else if (choice == 2) cart.filterByTitle(readString("Enter title: "));
    }

    public static void sortCart() {
        System.out.println("1. Sort by title\n2. Sort by cost");
        int choice = readInt("Your choice: ");
        if (choice == 1) cart.sortByTitle();
        else if (choice == 2) cart.sortByCost();
    }

    public static void removeFromCart() {
        String title = readString("Enter title: ");
        Media m = cart.findByTitle(title);
        if (m != null) cart.removeMedia(m); else System.out.println("Not found!");
    }

    public static void playFromCart() {
        playMedia(cart.findByTitle(readString("Enter title: ")));
    }

    public static void placeOrder() {
        if (cart.getItemCount() == 0) System.out.println("Cart empty!");
        else { System.out.println("Order placed!"); cart.clear(); }
    }

    public static void updateStore() {
        System.out.println("1. Add\n2. Remove");
        int choice = readInt("Your choice: ");
        if (choice == 1) addMediaToStore(); else if (choice == 2) removeMediaFromStore();
    }

    public static void addMediaToStore() {
        System.out.println("1. Book\n2. DVD\n3. CD");
        int choice = readInt("Your choice: ");
        if (choice == 1) createBook(); else if (choice == 2) createDVD(); else if (choice == 3) createCD();
    }

    public static void createBook() {
        store.addMedia(new Book(readInt("ID: "), readString("Title: "), readString("Category: "), readFloat("Cost: ")));
    }

    public static void createDVD() {
        store.addMedia(new DigitalVideoDisc(readInt("ID: "), readString("Title: "), readString("Category: "), readFloat("Cost: "), readInt("Length: "), readString("Director: ")));
    }

    public static void createCD() {
        store.addMedia(new CompactDisc(readInt("ID: "), readString("Title: "), readString("Category: "), readFloat("Cost: "), readInt("Length: "), readString("Director: "), readString("Artist: ")));
    }

    public static void removeMediaFromStore() {
        Media m = store.findByTitle(readString("Enter title: "));
        if (m != null) store.removeMedia(m); else System.out.println("Not found!");
    }

    public static void addMediaToCart() {
        Media m = store.findByTitle(readString("Enter title: "));
        if (m != null) cart.addMedia(m); else System.out.println("Not found!");
    }

    public static void playMediaInStore() {
        playMedia(store.findByTitle(readString("Enter title: ")));
    }

    private static int readInt(String msg) { System.out.print(msg); return Integer.parseInt(scanner.nextLine()); }
    private static float readFloat(String msg) { System.out.print(msg); return Float.parseFloat(scanner.nextLine()); }
    private static String readString(String msg) { System.out.print(msg); return scanner.nextLine(); }
}