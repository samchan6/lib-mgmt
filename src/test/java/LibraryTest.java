import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

public class LibraryTest {
    private Library library;
    private Book book1;
    private Book book2;

    @BeforeEach
    public void setUp() {
        library = new Library();
        book1 = new Book("Clean Code", "Robert C. Martin", 2008, "978-7-115");
        book2 = new Book("Effective Java", "Joshua Bloch", 2018, "978-0-134");
    }

    @Test
    public void testAddBook() {
        library.addBook(book1);
        assertEquals(1, library.getBooks().size());
        assertEquals(book1, library.getBooks().get(0));
    }

    @Test
    public void testRemoveBook() {
        library.addBook(book1);
        library.addBook(book2);
        library.removeBook(book1.getBookISBN());
        assertEquals(1, library.getBooks().size());
        assertEquals(book2, library.getBooks().get(0));
    }

    @Test
    public void testGetBooksPublishedAfterYear() {
        library.addBook(book1);
        library.addBook(book2);

        ArrayList<Book> booksPublishedAfter2008 = library.getBooksPublishedAfterYear(2008);

        assertEquals(1, booksPublishedAfter2008.size());
        assertEquals(book2, booksPublishedAfter2008.get(0));
    }

    @Test
    public void testGetAuthorsOfBooksPublishedBeforeYear() {
        library.addBook(book1);
        library.addBook(book2);

        ArrayList<String> authors = library.getAuthorsOfBooksPublishedBeforeYear(2018);

        assertEquals(1, authors.size());
        assertTrue(authors.contains(book1.getBookAuthor()));
    }

    @Test
    public void testGetBookInfo() {
        library.addBook(book1);
        assertEquals(1, library.getBooks().size());
        assertEquals("Title: Clean Code, Author: Robert C. Martin, Year: 2008, ISBN: 978-7-115", library.getBooks().get(0).getBookInfo());
    }
}