//import jdk.internal.org.objectweb.asm.tree.InsnList;
import java.util.ArrayList;
import java.util.Objects;
import java.util.stream.Collectors;

public class Library {
    private ArrayList<Book> books;

    public Library() {
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) {
        this.books.add(book);
    }

    public void removeBook(String isbn) {
        this.books.removeIf(book -> Objects.equals(book.getBookISBN(), isbn));
    }

    public ArrayList<Book> getBooksPublishedAfterYear(int year) {
        return this.books.stream().filter(book -> book.getBookPublishedYear() > year).collect(Collectors.toCollection(ArrayList::new));
    }

    public ArrayList<String> getAuthorsOfBooksPublishedBeforeYear(int year) {
        return this.books.stream().filter(book -> book.getBookPublishedYear() < year).map(Book::getBookAuthor).distinct().collect(Collectors.toCollection(ArrayList::new));
    }

    public ArrayList<Book> getBooks() {
        return this.books;
    }
}
