import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LibraryManagerExample {

    public static class Book {
        private String bookId;
        private String title;
        private String author;

        public Book(String bookId, String title, String author) {
            this.bookId = bookId;
            this.title = title;
            this.author = author;
        }

        public String getBookId() { return bookId; }
        public void setBookId(String bookId) { this.bookId = bookId; }
        public String getTitle() { return title; }
        public void setTitle(String title) { this.title = title; }
        public String getAuthor() { return author; }
        public void setAuthor(String author) { this.author = author; }

        @Override
        public String toString() {
            return "Book ID: " + bookId + ", Title: " + title + ", Author: " + author;
        }
    }

    public static class LibraryManager {

        public Book linearSearchByTitle(List<Book> books, String title) {
            for (Book book : books) {
                if (book.getTitle().equalsIgnoreCase(title)) {
                    return book;
                }
            }
            return null;
        }

        public Book binarySearchByTitle(List<Book> books, String title) {
            int low = 0;
            int high = books.size() - 1;
            while (low <= high) {
                int mid = low + (high - low) / 2;
                Book midBook = books.get(mid);
                int comparison = midBook.getTitle().compareToIgnoreCase(title);
                if (comparison == 0) {
                    return midBook;
                } else if (comparison < 0) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
            return null;
        }
    }

    public static void main(String[] args) {
        List<Book> books = new ArrayList<>();
        books.add(new Book("B001", "To Kill a Mockingbird", "Harper Lee"));
        books.add(new Book("B002", "1984", "George Orwell"));
        books.add(new Book("B003", "The Great Gatsby", "F. Scott Fitzgerald"));

        LibraryManager manager = new LibraryManager();

        System.out.println("Original list:");
        for (Book book : books) {
            System.out.println(book);
        }

        System.out.println("\nSearching for '1984' using linear search:");
        Book result = manager.linearSearchByTitle(books, "1984");
        System.out.println(result != null ? result : "Book not found.");

        Collections.sort(books, (a, b) -> a.getTitle().compareToIgnoreCase(b.getTitle()));

        System.out.println("\nSorted list:");
        for (Book book : books) {
            System.out.println(book);
        }

        System.out.println("\nSearching for 'The Great Gatsby' using binary search:");
        result = manager.binarySearchByTitle(books, "The Great Gatsby");
        System.out.println(result != null ? result : "Book not found.");
    }
}
