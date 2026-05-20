package Aims_Project.hust.soict.hedspi.aims;

import Aims_Project.hust.soict.hedspi.aims.cart.Cart;
import Aims_Project.hust.soict.hedspi.aims.disc.DigitalVideoDisc;
import Aims_Project.hust.soict.hedspi.aims.store.Store;
import Aims_Project.hust.soict.hedspi.aims.media.*;

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
                case 1 -> viewStore();
                case 2 -> updateStore();
                case 3 -> viewCart();
                case 0 -> System.out.println("Exiting AIMS...");
                default -> System.out.println("Invalid choice!");
            }
        }
    }

    // ===== SAMPLE DATA =====
    private static void initSampleData() {

        book b1 = new book(1, "Sherlock Holmes", "Detective", 15.5f);
        b1.addAuthor("Arthur Conan Doyle");

        DigitalVideoDisc dvd1 = new DigitalVideoDisc(
                2, "The Lion King", "Animation", 19.95f, 87, "Roger Allers"
        );

        CompactDisc cd1 = new CompactDisc(
                3, "Greatest Hits", "Music", 12.99f, 77, "Producer X", "Artist A"
        );

        cd1.addTrack(new Track("Track 1", 4));
        cd1.addTrack(new Track("Track 2", 3));

        store.addMedia(b1);
        store.addMedia(dvd1);
        store.addMedia(cd1);
    }

    // ===== MENU =====
    public static void showMenu() {
        System.out.println("""
                AIMS
                ------------------------------
                1. View store
                2. Update store
                3. See current cart
                0. Exit
                ------------------------------""");
    }

    // ===== STORE =====
    public static void viewStore() {
        int choice = -1;

        while (choice != 0) {
            System.out.println("\n===== STORE =====");
            store.printStore();

            storeMenu();
            choice = readInt("Your choice: ");

            switch (choice) {
                case 1 -> seeMediaDetails();
                case 2 -> addMediaToCart();
                case 3 -> playMediaInStore();
                case 4 -> viewCart();
                case 0 -> {}
                default -> System.out.println("Invalid choice!");
            }
        }
    }

    public static void storeMenu() {
        System.out.println("""
                Store Options:
                ------------------------------
                1. See media details
                2. Add media to cart
                3. Play a media
                4. See current cart
                0. Back
                ------------------------------""");
    }

    // ===== MEDIA DETAILS =====
    public static void seeMediaDetails() {
        String title = readString("Enter media title: ");
        media m = store.findByTitle(title);

        if (m == null) {
            System.out.println("Media not found!");
            return;
        }

        System.out.println("\n=== MEDIA DETAILS ===");
        System.out.println(m);

        mediaDetailsMenu();
        int choice = readInt("Your choice: ");

        switch (choice) {
            case 1 -> cart.addMedia(m);
            case 2 -> {
                if (m instanceof Playable p) p.play();
                else System.out.println("This media cannot be played!");
            }
        }
    }

    public static void mediaDetailsMenu() {
        System.out.println("""
                ------------------------------
                1. Add to cart
                2. Play
                0. Back
                ------------------------------""");
    }

    // ===== CART =====
    public static void viewCart() {
        int choice = -1;

        while (choice != 0) {
            System.out.println("\n===== CART =====");
            cart.printCart();

            cartMenu();
            choice = readInt("Your choice: ");

            switch (choice) {
                case 1 -> filterCart();
                case 2 -> sortCart();
                case 3 -> removeFromCart();
                case 4 -> playFromCart();
                case 5 -> placeOrder();
                case 0 -> {}
                default -> System.out.println("Invalid choice!");
            }
        }
    }

    public static void cartMenu() {
        System.out.println("""
                Cart Options:
                ------------------------------
                1. Filter
                2. Sort
                3. Remove
                4. Play
                5. Place order
                0. Back
                ------------------------------""");
    }

    // ===== FILTER =====
    public static void filterCart() {
        System.out.println("1. Filter by ID\n2. Filter by title");
        int choice = readInt("Your choice: ");

        if (choice == 1) {
            cart.filterById(readInt("Enter ID: "));
        } else if (choice == 2) {
            cart.filterByTitle(readString("Enter title: "));
        }
    }

    // ===== SORT =====
    public static void sortCart() {
        System.out.println("1. Sort by title\n2. Sort by cost");
        int choice = readInt("Your choice: ");

        if (choice == 1) cart.sortByTitle();
        else if (choice == 2) cart.sortByCost();
    }

    // ===== REMOVE =====
    public static void removeFromCart() {
        String title = readString("Enter title: ");
        media m = cart.findByTitle(title);

        if (m != null) cart.removeMedia(m);
        else System.out.println("Not found!");
    }

    // ===== PLAY =====
    public static void playFromCart() {
        String title = readString("Enter title: ");
        media m = cart.findByTitle(title);

        if (m instanceof Playable p) p.play();
        else System.out.println("Cannot play!");
    }

    // ===== ORDER =====
    public static void placeOrder() {
        if (cart.getItemCount() == 0) {
            System.out.println("Cart empty!");
            return;
        }

        System.out.println("Order placed!");
        cart.clear();
    }

    // ===== STORE UPDATE =====
    public static void updateStore() {
        System.out.println("""
                1. Add media
                2. Remove media""");

        int choice = readInt("Your choice: ");

        if (choice == 1) addMediaToStore();
        else if (choice == 2) removeMediaFromStore();
    }

    public static void addMediaToStore() {
        System.out.println("""
                1. Book
                2. DVD
                3. CD""");

        int choice = readInt("Your choice: ");

        if (choice == 1) createBook();
        else if (choice == 2) createDVD();
        else if (choice == 3) createCD();
    }

    // ===== CREATE BOOK =====
    public static void createBook() {
        int id = readInt("ID: ");
        String title = readString("Title: ");
        String category = readString("Category: ");
        float cost = readFloat("Cost: ");

        book b = new book(id, title, category, cost);

        store.addMedia(b);
    }

    // ===== CREATE DVD =====
    public static void createDVD() {
        int id = readInt("ID: ");
        String title = readString("Title: ");
        String category = readString("Category: ");
        String director = readString("Director: ");
        int length = readInt("Length: ");
        float cost = readFloat("Cost: ");

        DigitalVideoDisc dvd =
                new DigitalVideoDisc(id, title, category, cost, length, director);

        store.addMedia(dvd);
    }

    // ===== CREATE CD =====
    public static void createCD() {
        int id = readInt("ID: ");
        String title = readString("Title: ");
        String category = readString("Category: ");
        String director = readString("Director: ");
        String artist = readString("Artist: ");
        float cost = readFloat("Cost: ");
        int len = readInt("Length: ");

        CompactDisc cd =
                new CompactDisc(id, title, category, cost, len, director, artist);

        store.addMedia(cd);
    }

    public static void removeMediaFromStore() {
        String title = readString("Enter title: ");
        media m = store.findByTitle(title);

        if (m != null) store.removeMedia(m);
        else System.out.println("Not found!");
    }

    public static void addMediaToCart() {
        String title = readString("Enter title: ");
        media m = store.findByTitle(title);

        if (m != null) cart.addMedia(m);
        else System.out.println("Not found!");
    }

    public static void playMediaInStore() {
        String title = readString("Enter title: ");
        media m = store.findByTitle(title);

        if (m instanceof Playable p) p.play();
        else System.out.println("Cannot play!");
    }

    // ===== INPUT =====
    private static int readInt(String msg) {
        System.out.print(msg);
        return Integer.parseInt(scanner.nextLine());
    }

    private static float readFloat(String msg) {
        System.out.print(msg);
        return Float.parseFloat(scanner.nextLine());
    }

    private static String readString(String msg) {
        System.out.print(msg);
        return scanner.nextLine();
    }
}