package org.howard.edu.assignment6;

/**
 * Custom exception for operations that are invalid on an empty IntegerSet.
 */
public class IntegerSetException extends Exception {
    public IntegerSetException(String message) {
        super(message);
    }
}

