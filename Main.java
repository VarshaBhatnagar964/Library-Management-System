import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

class Book {
    int id;
    String title;
    String author;
    boolean isIssued;

    Book(int id, String title, String author) {
           this.id = id;
           this.title = title;
           this.author = author;
           this.isIssued = false;
    }

        public String toString() {
        String status = isIssued ? "Issued" : "Available";
        return"Book ID: " + id + " | Title: " + title + " | Author: " + author + " | Status: " + status;
    }
}

    class Library {
        private HashMap<Integer, Book> books = new HashMap<>();
        private Scanner sc = new Scanner(System.in);

        public void addBook() {
            System.out.print("Enter Book ID:");
            int id = sc.nextInt();
            sc.nextLine();

            if (books.containsKey(id)) {
                System.out.println("Book ID already exists!");
                return;

            }
            System.out.print("Enter Book Title: ");
            String title = sc.nextLine();

            System.out.print("Enter Book Author: ");
            String author = sc.nextLine();

            books.put(id, new Book(id, title, author));
            System.out.println("Book Added Successfully!");

        }

        public void issueBook() {
            System.out.print("Enter Book ID to Issue:");
            int id = sc.nextInt();
            if (books.containsKey(id)) {

                Book book = books.get(id);
                if (!book.isIssued) {
                    book.isIssued = true;

                    System.out.println("Book Issued Successfully");
                } else {
                    System.out.println("Book is alredy issued!");
                }
            } else {
                System.out.println("Book not found!");

            }
        }

        public void returnBook() {
            System.out.print("Enter Book ID to Return:");
            int id = sc.nextInt();
            if (books.containsKey(id)) {
                Book book = books.get(id);
                if (book.isIssued) {
                    book.isIssued = false;
                    System.out.println("Book Returned Successfully!");
                } else {
                    System.out.println("This book was not issued!");
                }

            } else {
                System.out.println("Book not found!");
            }
        }

        public void showAllBooks() {
            if (books.isEmpty()) {
                System.out.println("No books in library!");
                return;
            }
            System.out.println("\n--- All Books ---");
            for (Book book : books.values()) {
               System.out.println(book);
            }
        }
    }

               public class Main {
                   public static void main(String[] args) {
                       Library lib = new Library();
                       Scanner sc = new Scanner(System.in);
                       int choice;

                       do {
                           System.out.println("\n--- LIBRARY MANAGEMENT SYSTEM ---");
                           System.out.println("1. Add Book");
                           System.out.println("2. Issue Book");
                           System.out.println("3. Return Book");
                           System.out.println("4. Show All Books");
                           System.out.println("5. Exit");
                           System.out.println("Enter your choice:");
                           choice = sc.nextInt();

                           switch (choice) {
                               case 1:
                                   lib.addBook();
                                   break;
                               case 2:
                                   lib.issueBook();
                                   break;
                               case 3:
                                   lib.returnBook();
                                   break;
                               case 4:
                                   lib.showAllBooks();
                                   break;
                               case 5:
                                   System.out.println("Thank you!");
                                   break;
                               default:
                                   System.out.println("Invalid Choice!");
                           }
                       } while (choice != 5);
                   }
               }

