import java.util.Scanner;

public class LibraryBookTracker {

    static final int MAX = 100;
    static String[] titles = new String[MAX];
    static String[] authors = new String[MAX];
    static String[] isbns = new String[MAX];
    static int count = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n=== Library Book Tracker ===");
            System.out.println("1. Add Book");
            System.out.println("2. View All Books");
            System.out.println("3. Search Book by Title");
            System.out.println("4. Delete Book");
            System.out.println("5. Count Books Starting With Letter");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();  

            switch (choice) {
                case 1 -> addBook(sc);
                case 2 -> viewBooks();
                case 3 -> searchBook(sc);
                case 4 -> deleteBook(sc);
                case 5 -> countBooksByLetter(sc);
                case 6 -> System.out.println("Exiting...");
                default -> System.out.println("Invalid choice. Try again.");
            }

        } while (choice != 6);
    }

    static void addBook(Scanner sc) {
        if (count >= MAX) {
            System.out.println("Library is full. Cannot add more books.");
            return;
        }

        System.out.print("Enter book title: ");
        titles[count] = sc.nextLine();

        System.out.print("Enter author name: ");
        authors[count] = sc.nextLine();

        System.out.print("Enter ISBN: ");
        isbns[count] = sc.nextLine();

        count++;
        System.out.println("Book added successfully.");
    }

    static void viewBooks() {
        if (count == 0) {
            System.out.println("No books available.");
            return;
        }

        System.out.println("\n--- Book List ---");
        for (int i = 0; i < count; i++) {
            System.out.println("Title : " + titles[i]);
            System.out.println("Author: " + authors[i]);
            System.out.println("ISBN  : " + isbns[i]);
            System.out.println("----------------------");
        }
    }

    static void searchBook(Scanner sc) {
        System.out.print("Enter book title to search: ");
        String search = sc.nextLine().toLowerCase();
        boolean found = false;

        for (int i = 0; i < count; i++) {
            if (titles[i].toLowerCase().contains(search)) {
                System.out.println("Title : " + titles[i]);
                System.out.println("Author: " + authors[i]);
                System.out.println("ISBN  : " + isbns[i]);
                System.out.println("----------------------");
                found = true;
            }
        }

        if (!found) {
            System.out.println("Book not found.");
        }
    }

    static void deleteBook(Scanner sc) {
        System.out.print("Enter title of book to delete: ");
        String titleToDelete = sc.nextLine().toLowerCase();
        boolean deleted = false;

        for (int i = 0; i < count; i++) {
            if (titles[i].toLowerCase().equals(titleToDelete)) {
                
                for (int j = i; j < count - 1; j++) {
                    titles[j] = titles[j + 1];
                    authors[j] = authors[j + 1];
                    isbns[j] = isbns[j + 1];
                }
                count--;
                deleted = true;
                System.out.println("Book deleted successfully.");
                break;
            }
        }

        if (!deleted) {
            System.out.println("Book not found.");
        }
    }

    static void countBooksByLetter(Scanner sc) {
        System.out.print("Enter starting letter: ");
        char ch = sc.nextLine().toLowerCase().charAt(0);
        int total = 0;

        for (int i = 0; i < count; i++) {
            if (titles[i].toLowerCase().charAt(0) == ch) {
                total++;
            }
        }

        System.out.println("Number of books starting with '" + ch + "' = " + total);
    }
}
