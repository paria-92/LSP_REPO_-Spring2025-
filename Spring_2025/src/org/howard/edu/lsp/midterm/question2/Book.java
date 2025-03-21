package org.howard.edu.lsp.midterm.question2;

/**
 * Represents a book in a library.
 */
public class Book {
    private String title;
    private String author;
    private String ISBN;
    private int yearPublished;

    /**
     * Constructor to initialize a book.
     */
    public Book(String title, String author, String ISBN, int yearPublished) {
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.yearPublished = yearPublished;
    }

    // Getters and Setters
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }

    public String getISBN() { return ISBN; }
    public void setISBN(String ISBN) { this.ISBN = ISBN; }

    public int getYearPublished() { return yearPublished; }
    public void setYearPublished(int yearPublished) { this.yearPublished = yearPublished; }

    /**
     * Overrides equals() to compare books by ISBN and author.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true; // Same reference
        if (obj == null || getClass() != obj.getClass()) return false; // Type check

        Book book = (Book) obj;
        return this.ISBN.equals(book.ISBN) && this.author.equals(book.author);
    }

    /**
     * Overrides toString() to provide a meaningful string representation.
     */
    @Override
    public String toString() {
        return "Title: " + title + ", Author: " + author + 
               ", ISBN: " + ISBN + ", Year Published: " + yearPublished;
    }
}
/**
 * Represents a book in a library.
 * 
 * References:
 * - https://docs.oracle.com/javase/tutorial/java/javaOO/index.html  (Java Object-Oriented Basics)
 * - https://www.geeksforgeeks.org/java-getter-and-setter-methods/  (Encapsulation: Getters & Setters)
 * - https://www.baeldung.com/java-equals-hashcode-contract  (Overriding equals() method)
 * - https://www.digitalocean.com/learn/how-to-override-tostring-method-in-java  (Overriding toString() method)
 * - https://www.javatpoint.com/constructors-in-java  (Java Constructors)
 */
