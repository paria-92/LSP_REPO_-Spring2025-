package org.howard.edu.lsp.midterm.question2;

/**
 * Driver class to test the Book class.
 */
public class BookDriver {
    public static void main(String[] args) {
        // Creating book objects
        Book book1 = new Book("The Great Gatsby", "F. Scott Fitzgerald", "123456789", 1925);
        Book book2 = new Book("The Great Gatsby", "F. Scott Fitzgerald", "123456789", 1925);
        Book book3 = new Book("A Promised Land", "Barack Obama", "9780593239681", 2020);

        // Comparing books using equals() method
        System.out.println(book1.equals(book2)); // Expected Output: true
        System.out.println(book1.equals(book3)); // Expected Output: false

        // Printing book information using toString()
        System.out.println(book1);
    }
}

/**
 * Driver class to test the Book class.
 * 
 * References:
 * - https://www.javatpoint.com/java-object-class  (Java Object Class & Methods)
 * - https://www.geeksforgeeks.org/overriding-equals-method-in-java/  (equals() Example)
 *