package hust.soict.hedspi.aims;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.store.Store;
import hust.soict.hedspi.aims.media.*;

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

                case 1:
                    viewStore();
                    break;

                case 2:
                    updateStore();
                    break;

                case 3:
                    viewCart();
                    break;

                case 0:
                    System.out.println("Exiting AIMS...");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    // ===== SAMPLE DATA =====
    private static void initSampleData() {

        Book b1 = new Book(
                1,
                "Sherlock Holmes",
                "Detective",
                15.5f
        );

        b1.addAuthor("Arthur Conan Doyle");

        DigitalVideoDisc dvd1 =
                new DigitalVideoDisc(
                        2,
                        "The Lion King",
                        "Animation",
                        19.95f,
                        87,
                        "Roger Allers"
                );

        CompactDisc cd1 =
                new CompactDisc(
                        3,
                        "Greatest Hits",
                        "Music",
                        12.99f,
                        77,
                        "Producer X",
                        "Artist A"
                );

        cd1.addTrack(new Track("Track 1", 4));
        cd1.addTrack(new Track("Track 2", 3));

        store.addMedia(b1);
        store.addMedia(dvd1);
        store.addMedia(cd1);
    }

    // ===== MAIN MENU =====
    public static void showMenu() {

        System.out.println("AIMS");
        System.out.println("--------------------------------");
        System.out.println("1. View store");
        System.out.println("2. Update store");
        System.out.println("3. See current cart");
        System.out.println("0. Exit");
        System.out.println("--------------------------------");
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

                case 1:
                    seeMediaDetails();
                    break;

                case 2:
                    addMediaToCart();
                    break;

                case 3:
                    playMediaInStore();
                    break;

                case 4:
                    viewCart();
                    break;

                case 0:
                    break;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    public static void storeMenu() {

        System.out.println("Store Options:");
        System.out.println("--------------------------------");
        System.out.println("1. See media details");
        System.out.println("2. Add media to cart");
        System.out.println("3. Play a media");
        System.out.println("4. See current cart");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
    }

    // ===== MEDIA DETAILS =====
    public static void seeMediaDetails() {

        String title = readString("Enter media title: ");

        Media m = store.findByTitle(title);

        if (m == null) {
            System.out.println("Media not found!");
            return;
        }

        System.out.println("\n=== MEDIA DETAILS ===");

        System.out.println(m);

        mediaDetailsMenu();

        int choice = readInt("Your choice: ");

        switch (choice) {

            case 1:
                cart.addMedia(m);
                break;

            case 2:

                if (m instanceof Playable) {

                    Playable p = (Playable) m;

                    p.play();

                } else {

                    System.out.println("This media cannot be played!");
                }

                break;

            case 0:
                break;
        }
    }

    public static void mediaDetailsMenu() {

        System.out.println("--------------------------------");
        System.out.println("1. Add to cart");
        System.out.println("2. Play");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
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

                case 1:
                    filterCart();
                    break;

                case 2:
                    sortCart();
                    break;

                case 3:
                    removeFromCart();
                    break;

                case 4:
                    playFromCart();
                    break;

                case 5:
                    placeOrder();
                    break;

                case 0:
                    break;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    public static void cartMenu() {

        System.out.println("Cart Options:");
        System.out.println("--------------------------------");
        System.out.println("1. Filter");
        System.out.println("2. Sort");
        System.out.println("3. Remove");
        System.out.println("4. Play");
        System.out.println("5. Place order");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
    }

    // ===== FILTER =====
    public static void filterCart() {

        System.out.println("1. Filter by ID");
        System.out.println("2. Filter by title");

        int choice = readInt("Your choice: ");

        if (choice == 1) {

            int id = readInt("Enter ID: ");

            cart.filterById(id);

        } else if (choice == 2) {

            String title = readString("Enter title: ");

            cart.filterByTitle(title);
        }
    }

    // ===== SORT =====
    public static void sortCart() {

        System.out.println("1. Sort by title");
        System.out.println("2. Sort by cost");

        int choice = readInt("Your choice: ");

        if (choice == 1) {

            cart.sortByTitle();

        } else if (choice == 2) {

            cart.sortByCost();
        }
    }

    // ===== REMOVE =====
    public static void removeFromCart() {

        String title = readString("Enter title: ");

        Media m = cart.findByTitle(title);

        if (m != null) {

            cart.removeMedia(m);

        } else {

            System.out.println("Not found!");
        }
    }

    // ===== PLAY =====
    public static void playFromCart() {

        String title = readString("Enter title: ");

        Media m = cart.findByTitle(title);

        if (m instanceof Playable) {

            Playable p = (Playable) m;

            p.play();

        } else {

            System.out.println("Cannot play!");
        }
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

        System.out.println("1. Add media");
        System.out.println("2. Remove media");

        int choice = readInt("Your choice: ");

        if (choice == 1) {

            addMediaToStore();

        } else if (choice == 2) {

            removeMediaFromStore();
        }
    }

    public static void addMediaToStore() {

        System.out.println("1. Book");
        System.out.println("2. DVD");
        System.out.println("3. CD");

        int choice = readInt("Your choice: ");

        if (choice == 1) {

            createBook();

        } else if (choice == 2) {

            createDVD();

        } else if (choice == 3) {

            createCD();
        }
    }

    // ===== CREATE BOOK =====
    public static void createBook() {

        int id = readInt("ID: ");

        String title = readString("Title: ");

        String category = readString("Category: ");

        float cost = readFloat("Cost: ");

        Book b = new Book(id, title, category, cost);

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
                new DigitalVideoDisc(
                        id,
                        title,
                        category,
                        cost,
                        length,
                        director
                );

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
                new CompactDisc(
                        id,
                        title,
                        category,
                        cost,
                        len,
                        director,
                        artist
                );

        store.addMedia(cd);
    }

    public static void removeMediaFromStore() {

        String title = readString("Enter title: ");

        Media m = store.findByTitle(title);

        if (m != null) {

            store.removeMedia(m);

        } else {

            System.out.println("Not found!");
        }
    }

    public static void addMediaToCart() {

        String title = readString("Enter title: ");

        Media m = store.findByTitle(title);

        if (m != null) {

            cart.addMedia(m);

        } else {

            System.out.println("Not found!");
        }
    }

    public static void playMediaInStore() {

        String title = readString("Enter title: ");

        Media m = store.findByTitle(title);

        if (m instanceof Playable) {

            Playable p = (Playable) m;

            p.play();

        } else {

            System.out.println("Cannot play!");
        }
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