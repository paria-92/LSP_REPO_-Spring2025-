package org.howard.edu.assignment6;

import java.util.ArrayList;
import java.util.List;

/**
 * IntegerSet represents a collection of unique integers with typical set operations.
 */
public class IntegerSet {
    private List<Integer> set = new ArrayList<>();

    /**
     * Clears the internal representation of the set.
     */
    public void clear() {
        set.clear();
    }

    /**
     * Returns the length of the set.
     */
    public int length() {
        return set.size();
    }

    /**
     * Checks if two sets are equal.
     */
    public boolean equals(IntegerSet other) {
        return this.set.containsAll(other.set) && other.set.containsAll(this.set);
    }

    /**
     * Checks if the set contains a particular value.
     */
    public boolean contains(int value) {
        return set.contains(value);
    }

    /**
     * Returns the largest element. Throws exception if set is empty.
     */
    public int largest() throws IntegerSetException {
        if (set.isEmpty()) throw new IntegerSetException("Set is empty");
        int max = set.get(0);
        for (int num : set) {
            if (num > max) max = num;
        }
        return max;
    }

    /**
     * Returns the smallest element. Throws exception if set is empty.
     */
    public int smallest() throws IntegerSetException {
        if (set.isEmpty()) throw new IntegerSetException("Set is empty");
        int min = set.get(0);
        for (int num : set) {
            if (num < min) min = num;
        }
        return min;
    }

    /**
     * Adds an item if not already present.
     */
    public void add(int item) {
        if (!set.contains(item)) set.add(item);
    }

    /**
     * Removes an item if present.
     */
    public void remove(int item) {
        set.remove(Integer.valueOf(item));
    }

    /**
     * Performs union with another set.
     */
    public void union(IntegerSet other) {
        for (int num : other.set) {
            if (!this.set.contains(num)) {
                this.set.add(num);
            }
        }
    }

    /**
     * Performs intersection with another set.
     */
    public void intersect(IntegerSet other) {
        set.removeIf(n -> !other.set.contains(n));
    }

    /**
     * Performs difference with another set.
     */
    public void diff(IntegerSet other) {
        set.removeIf(other.set::contains);
    }

    /**
     * Checks if the set is empty.
     */
    public boolean isEmpty() {
        return set.isEmpty();
    }

    /**
     * Converts the set to string.
     */
    public String toString() {
        return set.toString();
    }
    public void complement(IntegerSet intSetb) {
        List<Integer> result = new ArrayList<Integer>();
        for (int value : intSetb.set) {
            if (!this.set.contains(value)) {
                result.add(value);
            }
        }
        this.set = result;
    }

}



/**
 * References:
 * 
 * Java ArrayList Documentation:
 * https://docs.oracle.com/javase/8/docs/api/java/util/ArrayList.html
 * 
 * Java Custom Exception Guide:
 * https://www.baeldung.com/java-new-custom-exception
 * 
 * Java List.contains() method:
 * https://docs.oracle.com/javase/8/docs/api/java/util/List.html#contains-java.lang.Object-
 * 
 * Java Set operations in Java:
 * https://www.geeksforgeeks.org/set-in-java/
 * 
 * Java equals() and hashCode() best practices:
 * https://www.baeldung.com/java-equals-hashcode-contracts
 */

//Force update to show in Git Staging
