package librarymanagementsystem;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
class Library {
    private ArrayList<Book> books = new ArrayList<>();
    private ArrayList<IssueRecord> issuedBooks = new ArrayList<>();
    class Book {
        private String title;
        private String author;
        private String isbn;
        public Book(String title, String author, String isbn) {
            this.title = title;
            this.author = author;
            this.isbn = isbn;
        }
        public String getTitle() {
            return title;
        }
        public String getIsbn() {
            return isbn;
        }
        public String data() {
            return "Title: " + title + ", Author: " + author + ", ISBN: " + isbn;
        }
    }
    class IssueRecord {
        private String userName;
        private Book book;
        private LocalDate issueDate;
        private LocalDate dueDate;
        public IssueRecord(String userName, Book book, LocalDate issueDate, LocalDate dueDate) {
            this.userName = userName;
            this.book = book;
            this.issueDate = issueDate;
            this.dueDate = dueDate;
    }
        public String data() {
            return "User: " + userName + ", Book: " + book.getTitle() + ", Due Date: " + dueDate;
        }
    }
    public void addBook(String title, String author, String isbn) {
        books.add(new Book(title, author, isbn));
        System.out.println("Book added successfully!");
    }
    public void displayBooks() {
        if (books.isEmpty()) {
            System.out.println("No books available in the library.");
        } else {
            System.out.println("Available Books:");
            for (Book book : books) {
                System.out.println(book);
            }
        }
    }
    public void issueBook(String userName, String isbn) {
        for (Book book : books) {
            if (book.getIsbn().equals(isbn)) {
                LocalDate issueDate = LocalDate.now();
                LocalDate dueDate = issueDate.plusDays(14); 
                issuedBooks.add(new IssueRecord(userName, book, issueDate, dueDate));
                books.remove(book);
                System.out.println("Book issued successfully to " + userName);
                return;
    }
    }
        System.out.println("Book with ISBN " + isbn + " not found or already issued.");
    }
    public void displayIssuedBooks() {
        if (issuedBooks.isEmpty()) {
            System.out.println("No books have been issued.");
        } else {
            System.out.println("Issued Books:");
            for (IssueRecord record : issuedBooks) {
                System.out.println(record);
            }
        }
    }
}
public class LibraryManagementSystem {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nLibrary Management System");
            System.out.println("1. Add Book");
            System.out.println("2. Display Available Books");
            System.out.println("3. Issue Book");
            System.out.println("4. Display Issued Books");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); 
            switch (choice) {
                case 1:
                    System.out.print("Enter book title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter book author: ");
                    String author = scanner.nextLine();
                    System.out.print("Enter book ISBN: ");
                    String isbn = scanner.nextLine();
                    library.addBook(title, author, isbn);
                    break;
                case 2:
                    library.displayBooks();
                    break;
                case 3:
                    System.out.print("Enter your name: ");
                    String userName = scanner.nextLine();
                    System.out.print("Enter book ISBN to issue: ");
                    String issueIsbn = scanner.nextLine();
                    library.issueBook(userName, issueIsbn);
                    break;
                case 4:
                    library.displayIssuedBooks();
                    break;
                case 5:
                    System.out.println("Exiting... Thank you for using the Library Management System!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}