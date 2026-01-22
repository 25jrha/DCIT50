import java.util.Scanner;

public class Lab1_JavaReview {
    static void main(String[] args) {
        boolean isRunning = true;
        while (isRunning) {
            displayMenu();
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch(choice) {
                case 1:
                    addBook();
                    break;
                case 2:
                    updateBookStatus();
                    break;
                case 3:
                    showBooks();
                    break;
                case 4:
                    generateReport();
                    break;
                case 5:
                    System.out.println("Exiting Program.");
                    isRunning = false;
                    break;
                default:
                    System.out.println("Invalid menu option. Please select a valid option.");
                    break;
            }
        }
    }

    private static final int maxBookLimit = 5;
    private static int bookCount = 0;
    private static final String[] bookTitles = new String[maxBookLimit];
    private static final String[] bookStatus = new String[maxBookLimit];
    static Scanner scanner = new Scanner(System.in);


    public static void displayMenu() {
        System.out.println("Library Book Management System");
        System.out.println("1. Add Book");
        System.out.println("2. Update Book Status");
        System.out.println("3. Show All Books");
        System.out.println("4. Generate Report");
        System.out.println("5. Exit");
    }

    public static void addBook() {
        if (bookCount >= maxBookLimit) {
            System.out.println("Book limit reached. Cannot add more books.");
            return;
        }

        System.out.print("Enter book title: ");
        String title = scanner.nextLine().trim();

        if (title.isEmpty()) {
            System.out.println("Book title cannot be empty.");
            return;
        }

        bookTitles[bookCount] = title;
        bookStatus[bookCount] = "Available";
        bookCount++;
        System.out.println("Book added successfully.");
    }

    public static void updateBookStatus() {
        if (bookCount == 0) {
            System.out.println("There are no books to update.");
            return;
        }

        showBooks();
        System.out.print("Enter book number to update: ");
        int bookNumber = scanner.nextInt();

        if (bookNumber < 1 || bookNumber > bookCount) {
            System.out.println("Invalid book number.");
            return;
        }

        int index = bookNumber - 1;
        if (bookStatus[index].equals("Available")) {
            bookStatus[index] = "Borrowed";
        } else {
            bookStatus[index] = "Available";
        }

        System.out.println("Book status has been updated");
    }

    public static void showBooks() {
        if (bookCount == 0) {
            System.out.println("No books registered.");
            return;
        }

        System.out.println("\n--- Book List ---");
        for (int i = 0; i < bookCount; i++) {
            System.out.println((i + 1) + ". " + bookTitles[i] + " - " + bookStatus[i]);
        }
    }

    public static void generateReport() {
        int availableCount = 0;
        int borrowedCount = 0;

        for (int i = 0; i < bookCount; i++) {
            if (bookStatus[i].equals("Available")) {
                availableCount++;
            } else {
                borrowedCount++;
            }
        }

        System.out.println("\n--- Library Report ---");
        System.out.println("Total books registered: " + bookCount);
        System.out.println("Available books: " + availableCount);
        System.out.println("Borrowed books: " + borrowedCount);
    }


}
