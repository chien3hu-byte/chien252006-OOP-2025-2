package hust.soict.dsai.aims;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.*;
import hust.soict.dsai.aims.store.Store;

import java.util.Scanner;

public class Aims {

    private static Store store = new Store();
    private static Cart cart = new Cart();
    private static Scanner scanner = new Scanner(System.in);

    // ==================== MENU DISPLAYS ====================

    public static void showMenu() {
        System.out.println("\nAIMS: ");
        System.out.println("--------------------------------");
        System.out.println("1. View store");
        System.out.println("2. Update store");
        System.out.println("3. See current cart");
        System.out.println("0. Exit");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: 0-1-2-3: ");
    }

    public static void storeMenu() {
        System.out.println("\nOptions: ");
        System.out.println("--------------------------------");
        System.out.println("1. See a media's details");
        System.out.println("2. Add a media to cart");
        System.out.println("3. Play a media");
        System.out.println("4. See current cart");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: 0-1-2-3-4: ");
    }

    public static void mediaDetailsMenu() {
        System.out.println("\nOptions: ");
        System.out.println("--------------------------------");
        System.out.println("1. Add to cart");
        System.out.println("2. Play");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: 0-1-2: ");
    }

    public static void cartMenu() {
        System.out.println("\nOptions: ");
        System.out.println("--------------------------------");
        System.out.println("1. Filter medias in cart");
        System.out.println("2. Sort medias in cart");
        System.out.println("3. Remove media from cart");
        System.out.println("4. Play a media");
        System.out.println("5. Place order");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: 0-1-2-3-4-5: ");
    }

    // ==================== HANDLERS ====================

    private static void handleViewStore() {
        store.print();
        boolean back = false;
        while (!back) {
            storeMenu();
            int choice = readInt();
            switch (choice) {
                case 1:
                    handleSeeMediaDetails();
                    break;
                case 2:
                    handleAddMediaToCart();
                    break;
                case 3:
                    handlePlayMediaFromStore();
                    break;
                case 4:
                    cart.print();
                    break;
                case 0:
                    back = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void handleSeeMediaDetails() {
        System.out.print("Enter the title of the media: ");
        String title = scanner.nextLine().trim();
        Media media = store.searchByTitle(title);
        if (media == null) {
            System.out.println("Media \"" + title + "\" not found in the store!");
            return;
        }
        System.out.println("\n--- Media Details ---");
        System.out.println(media.toString());

        boolean back = false;
        while (!back) {
            // Only show Play option for Playable types
            if (media instanceof Playable) {
                mediaDetailsMenu();
            } else {
                System.out.println("\nOptions: ");
                System.out.println("--------------------------------");
                System.out.println("1. Add to cart");
                System.out.println("0. Back");
                System.out.println("--------------------------------");
                System.out.print("Please choose a number: 0-1: ");
            }

            int choice = readInt();
            switch (choice) {
                case 1:
                    cart.addMedia(media);
                    break;
                case 2:
                    if (media instanceof Playable) {
                        ((Playable) media).play();
                    } else {
                        System.out.println("This media cannot be played!");
                    }
                    break;
                case 0:
                    back = true;
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    private static void handleAddMediaToCart() {
        System.out.print("Enter the title of the media to add to cart: ");
        String title = scanner.nextLine().trim();
        Media media = store.searchByTitle(title);
        if (media == null) {
            System.out.println("Media \"" + title + "\" not found in the store!");
        } else {
            cart.addMedia(media);
            System.out.println("Current number of items in cart: "
                    + cart.getItemsOrdered().size());
        }
    }

    private static void handlePlayMediaFromStore() {
        System.out.print("Enter the title of the media to play: ");
        String title = scanner.nextLine().trim();
        Media media = store.searchByTitle(title);
        if (media == null) {
            System.out.println("Media \"" + title + "\" not found in the store!");
        } else if (media instanceof Playable) {
            ((Playable) media).play();
        } else {
            System.out.println("This media cannot be played!");
        }
    }

    private static void handleUpdateStore() {
        System.out.println("\n--- Update Store ---");
        System.out.println("1. Add a media to store");
        System.out.println("2. Remove a media from store");
        System.out.println("0. Back");
        System.out.print("Choose: ");
        int choice = readInt();
        switch (choice) {
            case 1:
                handleAddMediaToStore();
                break;
            case 2:
                handleRemoveMediaFromStore();
                break;
            case 0:
                break;
            default:
                System.out.println("Invalid choice.");
        }
    }

    private static void handleAddMediaToStore() {
        System.out.println("Select type: 1.DVD  2.Book  3.CD");
        System.out.print("Choose: ");
        int type = readInt();
        switch (type) {
            case 1:
                System.out.print("Title: "); String dvdTitle = scanner.nextLine().trim();
                System.out.print("Category: "); String dvdCat = scanner.nextLine().trim();
                System.out.print("Director: "); String dvdDir = scanner.nextLine().trim();
                System.out.print("Length (min): "); int dvdLen = readInt();
                System.out.print("Cost: "); float dvdCost = readFloat();
                store.addMedia(new DigitalVideoDisc(0, dvdTitle, dvdCat, dvdDir, dvdLen, dvdCost));
                break;
            case 2:
                System.out.print("Title: "); String bookTitle = scanner.nextLine().trim();
                System.out.print("Category: "); String bookCat = scanner.nextLine().trim();
                System.out.print("Cost: "); float bookCost = readFloat();
                Book book = new Book(0, bookTitle, bookCat, bookCost);
                System.out.print("Number of authors: "); int numAuthors = readInt();
                for (int i = 0; i < numAuthors; i++) {
                    System.out.print("Author " + (i + 1) + ": ");
                    book.addAuthor(scanner.nextLine().trim());
                }
                store.addMedia(book);
                break;
            case 3:
                System.out.print("Title: "); String cdTitle = scanner.nextLine().trim();
                System.out.print("Category: "); String cdCat = scanner.nextLine().trim();
                System.out.print("Artist: "); String cdArtist = scanner.nextLine().trim();
                System.out.print("Director: "); String cdDir = scanner.nextLine().trim();
                System.out.print("Cost: "); float cdCost = readFloat();
                CompactDisc cd = new CompactDisc(0, cdTitle, cdCat, cdDir, cdArtist, cdCost);
                System.out.print("Number of tracks: "); int numTracks = readInt();
                for (int i = 0; i < numTracks; i++) {
                    System.out.print("Track " + (i + 1) + " title: ");
                    String tTitle = scanner.nextLine().trim();
                    System.out.print("Track " + (i + 1) + " length (min): ");
                    int tLen = readInt();
                    cd.addTrack(new Track(tTitle, tLen));
                }
                store.addMedia(cd);
                break;
            default:
                System.out.println("Invalid type.");
        }
    }

    private static void handleRemoveMediaFromStore() {
        store.print();
        System.out.print("Enter title of media to remove: ");
        String title = scanner.nextLine().trim();
        Media media = store.searchByTitle(title);
        if (media == null) {
            System.out.println("Media \"" + title + "\" not found!");
        } else {
            store.removeMedia(media);
        }
    }

    private static void handleSeeCart() {
        cart.print();
        boolean back = false;
        while (!back) {
            cartMenu();
            int choice = readInt();
            switch (choice) {
                case 1:
                    handleFilterCart();
                    break;
                case 2:
                    handleSortCart();
                    break;
                case 3:
                    handleRemoveFromCart();
                    break;
                case 4:
                    handlePlayMediaFromCart();
                    break;
                case 5:
                    handlePlaceOrder();
                    back = true;
                    break;
                case 0:
                    back = true;
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    private static void handleFilterCart() {
        System.out.println("Filter by: 1. ID   2. Title");
        System.out.print("Choose: ");
        int choice = readInt();
        if (choice == 1) {
            System.out.print("Enter ID: ");
            int id = readInt();
            Media m = cart.searchById(id);
            System.out.println(m != null ? m.toString() : "Not found.");
        } else if (choice == 2) {
            System.out.print("Enter title: ");
            String title = scanner.nextLine().trim();
            Media m = cart.searchByTitle(title);
            System.out.println(m != null ? m.toString() : "Not found.");
        } else {
            System.out.println("Invalid choice.");
        }
    }

    private static void handleSortCart() {
        System.out.println("Sort by: 1. Title (then cost)   2. Cost (then title)");
        System.out.print("Choose: ");
        int choice = readInt();
        if (choice == 1) {
            cart.sortByTitleCost();
            System.out.println("Sorted by title.");
        } else if (choice == 2) {
            cart.sortByCostTitle();
            System.out.println("Sorted by cost.");
        } else {
            System.out.println("Invalid choice.");
        }
        cart.print();
    }

    private static void handleRemoveFromCart() {
        cart.print();
        System.out.print("Enter title of media to remove from cart: ");
        String title = scanner.nextLine().trim();
        Media m = cart.searchByTitle(title);
        if (m == null) {
            System.out.println("Media \"" + title + "\" not found in cart!");
        } else {
            cart.removeMedia(m);
        }
    }

    private static void handlePlayMediaFromCart() {
        System.out.print("Enter title of media to play: ");
        String title = scanner.nextLine().trim();
        Media m = cart.searchByTitle(title);
        if (m == null) {
            System.out.println("Media not found in cart!");
        } else if (m instanceof Playable) {
            ((Playable) m).play();
        } else {
            System.out.println("This media cannot be played!");
        }
    }

    private static void handlePlaceOrder() {
        System.out.println("Order placed successfully! Thank you for your purchase.");
        cart.clear();
        System.out.println("Your cart is now empty.");
    }

    // ==================== HELPERS ====================

    private static int readInt() {
        while (true) {
            try {
                String line = scanner.nextLine().trim();
                return Integer.parseInt(line);
            } catch (NumberFormatException e) {
                System.out.print("Invalid input. Please enter a number: ");
            }
        }
    }

    private static float readFloat() {
        while (true) {
            try {
                String line = scanner.nextLine().trim();
                return Float.parseFloat(line);
            } catch (NumberFormatException e) {
                System.out.print("Invalid input. Please enter a number: ");
            }
        }
    }

    // ==================== SAMPLE DATA ====================

    private static void loadSampleData() {
        // DVDs
        DigitalVideoDisc dvd1 = new DigitalVideoDisc(1, "Inception", "Sci-Fi",
                "Christopher Nolan", 148, 9.99f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc(2, "Interstellar", "Sci-Fi",
                "Christopher Nolan", 169, 10.99f);

        // Books
        Book book1 = new Book(3, "Clean Code", "Technology", 29.99f);
        book1.addAuthor("Robert C. Martin");

        Book book2 = new Book(4, "The Great Gatsby", "Fiction", 14.99f);
        book2.addAuthor("F. Scott Fitzgerald");

        // CDs
        CompactDisc cd1 = new CompactDisc(5, "Thriller", "Pop", "John Landis",
                "Michael Jackson", 19.99f);
        cd1.addTrack(new Track("Wanna Be Startin' Somethin'", 6));
        cd1.addTrack(new Track("Beat It", 4));
        cd1.addTrack(new Track("Thriller", 5));

        store.addMedia(dvd1);
        store.addMedia(dvd2);
        store.addMedia(book1);
        store.addMedia(book2);
        store.addMedia(cd1);
    }

    // ==================== MAIN ====================

    public static void main(String[] args) {
        loadSampleData();

        boolean running = true;
        while (running) {
            showMenu();
            int choice = readInt();
            switch (choice) {
                case 1:
                    handleViewStore();
                    break;
                case 2:
                    handleUpdateStore();
                    break;
                case 3:
                    handleSeeCart();
                    break;
                case 0:
                    running = false;
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        scanner.close();
    }
}
