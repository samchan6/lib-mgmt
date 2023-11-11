public class Book {
    public Book(String title, String author, int publishedYear, String isbn) {
        this.title = title;
        this.author = author;
        this.publishedYear = publishedYear;
        this.isbn = isbn;
    }
    private final String title;
    private final String author;
    private final int publishedYear;
    private final String isbn;

    public String getBookInfo() {
        return String.format("Title: %s, Author: %s, Year: %d, ISBN: %s", this.title, this.author, this.publishedYear, this.isbn);
    }

    public String getBookISBN() {
        return this.isbn;
    }

    public int getBookPublishedYear() {
        return this.publishedYear;
    }

    public String getBookAuthor() {
        return this.author;
    }
}
