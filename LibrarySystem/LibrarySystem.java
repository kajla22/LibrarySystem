import java.util.ArrayList;
import java.util.Scanner;

public class LibrarySystem {
    private ArrayList<Book> bookCatalog;

    public LibrarySystem() {
        bookCatalog = new ArrayList<>();
    }

    public void addBook(String bookId, String title, String author, String genre, String availabilityStatus) {
        for (Book book : bookCatalog) {
            if (book.getBookId().equals(bookId)) {
                System.out.println("Book ID must be unique!");
                return;
            }
        }
        Book newBook = new Book(bookId, title, author, genre, availabilityStatus);
        bookCatalog.add(newBook);
        System.out.println("Book added successfully!");
    }

    public void viewAllBooks() {
        if (bookCatalog.isEmpty()) {
            System.out.println("No books available in the catalog.");
            return;
        }
        for (Book book : bookCatalog) {
            System.out.println(book);
        }
    }

    
    public void searchBook(String searchQuery) {
        boolean found = false;
        for (Book book : bookCatalog) {
            if (book.getBookId().equals(searchQuery) || book.getTitle().equalsIgnoreCase(searchQuery)) {
                System.out.println(book);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No matching book found.");
        }
    }

    
    public void updateBookDetails(String bookId, String newTitle, String newAuthor, String newGenre, String newAvailabilityStatus) {
        for (Book book : bookCatalog) {
            if (book.getBookId().equals(bookId)) {
                book.setTitle(newTitle);
                book.setAuthor(newAuthor);
                book.setGenre(newGenre);
                book.setAvailabilityStatus(newAvailabilityStatus);
                System.out.println("Book details updated successfully!");
                return;
            }
        }
        System.out.println("Book not found.");
    }

    public void deleteBook(String bookId) {
        for (Book book : bookCatalog) {
            if (book.getBookId().equals(bookId)) {
                bookCatalog.remove(book);
                System.out.println("Book deleted successfully!");
                return;
            }
        }
        System.out.println("Book not found.");
    }

    public void exitSystem() {
        System.out.println("Exiting the system...");
        System.exit(0);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LibrarySystem librarySystem = new LibrarySystem();

        while (true) {
            System.out.println("\n--- Library System Menu ---");
            System.out.println("1. Add a Book");
            System.out.println("2. View All Books");
            System.out.println("3. Search Book by ID or Title");
            System.out.println("4. Update Book Details");
            System.out.println("5. Delete a Book");
            System.out.println("6. Exit");
            System.out.print("Please select an option: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter Book ID: ");
                    String bookId = scanner.nextLine();
                    System.out.print("Enter Title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter Author: ");
                    String author = scanner.nextLine();
                    System.out.print("Enter Genre: ");
                    String genre = scanner.nextLine();
                    System.out.print("Enter Availability Status (Available/Checked Out): ");
                    String availabilityStatus = scanner.nextLine();
                    librarySystem.addBook(bookId, title, author, genre, availabilityStatus);
                    break;

                case 2:
                    librarySystem.viewAllBooks();
                    break;

                case 3:
                    System.out.print("Enter Book ID or Title to search: ");
                    String searchQuery = scanner.nextLine();
                    librarySystem.searchBook(searchQuery);
                    break;

                case 4:
                    System.out.print("Enter Book ID to update: ");
                    String updateId = scanner.nextLine();
                    System.out.print("Enter new Title: ");
                    String newTitle = scanner.nextLine();
                    System.out.print("Enter new Author: ");
                    String newAuthor = scanner.nextLine();
                    System.out.print("Enter new Genre: ");
                    String newGenre = scanner.nextLine();
                    System.out.print("Enter new Availability Status (Available/Checked Out): ");
                    String newAvailabilityStatus = scanner.nextLine();
                    librarySystem.updateBookDetails(updateId, newTitle, newAuthor, newGenre, newAvailabilityStatus);
                    break;

                case 5:
                    System.out.print("Enter Book ID to delete: ");
                    String deleteId = scanner.nextLine();
                    librarySystem.deleteBook(deleteId);
                    break;

                case 6:
                    librarySystem.exitSystem();
                    break;

                default:
                    System.out.println("Invalid option, please try again.");
            }
        }
    }
}
